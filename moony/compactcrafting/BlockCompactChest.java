/*package moony.compactcrafting;

import java.util.Random;

import moony.compactcrafting.tileentitys.TileEntityCompactChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCompactChest extends BlockContainer
{

	protected BlockCompactChest(Material material)
	{
		super(material);
		setCreativeTab(CCMain.compactTab);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "CompactChest");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer entityplayer, int a, float b, float c, float d)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity == null || entityplayer.isSneaking())
		{
			return false;
		}

		entityplayer.openGui(CCMain.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int a, int b)
	{
		dropItems(world, x, y, z);
		super.breakBlock(world, x, y, z, a, b);
	}

	private void dropItems(World world, int x, int y, int z)
	{
		Random rand = new Random();

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if (!(tile_entity instanceof IInventory))
		{
			return;
		}

		IInventory inventory = (IInventory) tile_entity;

		for (int i = 0; i < inventory.getSizeInventory(); i++)
		{
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0)
			{
				float rx = rand.nextFloat() * 0.6F + 0.1F;
				float ry = rand.nextFloat() * 0.6F + 0.1F;
				float rz = rand.nextFloat() * 0.6F + 0.1F;

				EntityItem entity_item = new EntityItem(world, x + rx, y + ry,
						z + rz, new ItemStack(item.itemID, item.stackSize,
								item.getItemDamage()));

				if (item.hasTagCompound())
				{
					item.setTagCompound((NBTTagCompound) item.getTagCompound()
							.copy());
				}

				float factor = 0.5F;

				entity_item.motionX = rand.nextGaussian() * factor;
				entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
				entity_item.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entity_item);
				item.stackSize = 0;
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityCompactChest();
	}

}*/
