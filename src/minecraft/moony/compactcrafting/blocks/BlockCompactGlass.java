package moony.compactcrafting.blocks;

import java.util.ArrayList;
import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCompactGlass extends Block {
	public BlockCompactGlass(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CCMain.compactTab);
	}

	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isOpaqueCube() {
		return false;
	}


	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
    public int getRenderBlockPass()
	{
            return 1;
	}
	protected boolean canSilkHarvest() {
		return true;
	}

	

}
