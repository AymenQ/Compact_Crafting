package moony.compactcrafting;

import java.util.Random;

import javax.swing.Icon;

import moony.compactcrafting.core.misc.BlockNotifyType;
import moony.compactcrafting.core.proxys.CommonProxy;
import moony.compactcrafting.tileentitys.TilePressureMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPressureMachine extends BlockContainer
{

	private Random furnaceRand = new Random();

	private final boolean isActive;

	private IIcon icoFurnaceTop;
	private IIcon icoFurnaceBottom;
	private IIcon icoFurnaceSide;
	private IIcon icoFurnaceFrontInactive;
	private IIcon icoFurnaceFrontActive;

	private static boolean keepInventory = false;

	public boolean eggPlayed = false;

	private static final int METADATA_BITMASK = 0x7;
	private static final int METADATA_ACTIVEBIT = 0x8;
	private static final int METADATA_CLEARACTIVEBIT = -METADATA_ACTIVEBIT - 1;

	public static int clearActiveOnMetadata(int metadata)
	{
		return metadata & METADATA_CLEARACTIVEBIT;
	}

	public static boolean isActiveSet(int metadata)
	{
		return (metadata & METADATA_ACTIVEBIT) != 0;
	}

	public static int setActiveOnMetadata(int metadata)
	{
		return metadata | METADATA_ACTIVEBIT;
	}

	public static int unmarkedMetadata(int metadata)
	{
		return metadata & METADATA_BITMASK;
	}

	private static boolean keepFurnaceInventory = false;

	protected BlockPressureMachine(boolean par2, Material material)
	{
		super(material);
		this.isActive = par2;
		this.setStepSound(soundTypeStone);
		this.setTickRandomly(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "PressureMachine";
		return getUnlocalizedName() + "." + name;
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(CCMain.pressureMachineIdle);
	}

	public static void updateFurnaceBlockState(boolean par0, World par1World,
			int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;

		if (par0)
		{
			par1World.setBlock(par2, par3, par4,
					CCMain.pressureMachineActive);
		} else
		{
			par1World.setBlock(par2, par3, par4,
					CCMain.pressureMachineIdle);
		}

		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setTileEntity(par2, par3, par4, tileentity);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		icoFurnaceTop = par1IconRegister.registerIcon(CommonProxy
				.getIconLocation("PressureMachineTop"));
		icoFurnaceBottom = par1IconRegister.registerIcon(CommonProxy
				.getIconLocation("PressureMachineBottom"));
		icoFurnaceSide = par1IconRegister.registerIcon(CommonProxy
				.getIconLocation("PressureMachineSide"));
		icoFurnaceFrontInactive = par1IconRegister.registerIcon(CommonProxy
				.getIconLocation("PressureMachineFrontInactive"));
		icoFurnaceFrontActive = par1IconRegister.registerIcon(CommonProxy
				.getIconLocation("PressureMachineFrontActive"));

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int x, int y,
			int z, int side)
	{
		int meta = par1IBlockAccess.getBlockMetadata(x, y, z);
		switch (side)
		{
		case CCMain.sideBottom:
			return icoFurnaceBottom;
		case CCMain.sideTop:
			return icoFurnaceTop;
		default:
		{
			if (side == unmarkedMetadata(meta))
			{
				if (this.isActiveSet(meta))
					return icoFurnaceFrontActive;
				else
					return icoFurnaceFrontInactive;
			} else
				return icoFurnaceSide;
		}
		}
	};


	public int nEggPlayed = 0;

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int i, float f, float g, float t)
	{

		world.playSoundEffect(x, y, z, "CC.PMOpen", 0.5F, 1.0F);

		if (CCMain.EasterEggOn == 1)
		{
			if (eggPlayed == false && nEggPlayed < 2)
			{
				System.out.println("Eggy Egg egg");
				world.playSoundEffect(x, y, z, "CC.egg", 0.1F, 1.0F);
				nEggPlayed++;
			} else
			{
				eggPlayed = true;
			}
		}

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if (tile_entity == null || player.isSneaking())
		{
			return false;
		}

		player.openGui(CCMain.instance, 0, world, x, y, z);
		return true;
	}


	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			TilePressureMachine var7 = (TilePressureMachine) par1World
					.getTileEntity(par2, par3, par4);

			if (var7 != null)
			{
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
				{
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null)
					{
						float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0)
						{
							int var13 = this.furnaceRand.nextInt(21) + 10;

							if (var13 > var9.stackSize)
							{
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World,
									(double) ((float) par2 + var10),
									(double) ((float) par3 + var11),
									(double) ((float) par4 + var12),
									new ItemStack(var9.getItem(), var13,
											var9.getItemDamage()));

							if (var9.hasTagCompound())
							{
								// func_92014_d() gets back an Item
								var14.getEntityItem().setTagCompound(
										(NBTTagCompound) var9.getTagCompound()
												.copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							var14.motionY = (double) ((float) this.furnaceRand
									.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);

	}

	@SideOnly(Side.CLIENT)
	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random)
	{
		if (this.isActive(par1World, par2, par3, par4))
		{
			int var6 = unmarkedMetadata(par1World.getBlockMetadata(par2, par3,
					par4));
			float var7 = (float) par2 + 0.5F;
			float var8 = (float) par3 + 0.0F + par5Random.nextFloat() * 6.0F
					/ 16.0F;
			float var9 = (float) par4 + 0.5F;
			float var10 = 0.52F;
			float var11 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (var6 == 4)
			{
				par1World.spawnParticle("smoke", (double) (var7 - var10),
						(double) var8, (double) (var9 + var11), 0.0D, 0.0D,
						0.0D);

			} else if (var6 == 5)
			{
				par1World.spawnParticle("smoke", (double) (var7 + var10),
						(double) var8, (double) (var9 + var11), 0.0D, 0.0D,
						0.0D);

			} else if (var6 == 2)
			{
				par1World.spawnParticle("smoke", (double) (var7 + var11),
						(double) var8, (double) (var9 - var10), 0.0D, 0.0D,
						0.0D);

			} else if (var6 == 3)
			{
				par1World.spawnParticle("smoke", (double) (var7 + var11),
						(double) var8, (double) (var9 + var10), 0.0D, 0.0D,
						0.0D);

			}
		}
	}

	private boolean isActive(World par1World, int par2, int par3, int par4)
	{
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		if (isActiveSet(meta))
			return true;
		else
			return false;
	}

	private boolean isActive(IBlockAccess par1IBlockAccess, int par2, int par3,
			int par4)
	{
		int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		if (isActiveSet(meta))
			return true;
		else
			return false;
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
		par1World.markBlockForUpdate(par2, par3, par4);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
	{
		int var6 = MathHelper
				.floor_double((double) (par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if (var6 == 0)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
		}

		if (var6 == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
		}

		if (var6 == 2)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
		}

		if (var6 == 3)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
		}
	}

	private void setDefaultDirection(World par1World, int par2, int par3,
			int par4)
	{
		if (!par1World.isRemote)
		{
			Block block = par1World.getBlock(par2, par3, par4 - 1);
			Block block1 = par1World.getBlock(par2, par3, par4 + 1);
			Block block2 = par1World.getBlock(par2 - 1, par3, par4);
			Block block3 = par1World.getBlock(par2 + 1, par3, par4);
			byte var9 = 3;

			if (block.func_149730_j() && !block1.func_149730_j())
			{
				var9 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j())
			{
				var9 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j())
			{
				var9 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j())
			{
				var9 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9,
					BlockNotifyType.ALL);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int noidea)
	{
		return new TilePressureMachine();
	}

}
