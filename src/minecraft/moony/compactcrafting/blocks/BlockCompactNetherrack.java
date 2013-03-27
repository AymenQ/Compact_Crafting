package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCompactNetherrack extends Block{

	public BlockCompactNetherrack(int id, Material material) {
		super(id, material);
		this.setCreativeTab(CCMain.compactTab);
	}

	public int idDropped(int par1, Random rand, int par2)
	{
		return Block.netherrack.blockID;
	}

	public int quantityDropped(Random rand)
	{
		return rand.nextInt(10);
	}

}
