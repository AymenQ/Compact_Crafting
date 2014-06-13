package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlassBrickBlock extends BlockBreakable
{

	public BlockGlassBrickBlock(Material material, boolean par3)
	{
		super("GlassBrickBlock", material, par3);
		this.setCreativeTab(CCMain.compactTab);
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	protected boolean canSilkHarvest()
	{
		return true;
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":"
				+ this.getUnlocalizedName2());
	}
}
