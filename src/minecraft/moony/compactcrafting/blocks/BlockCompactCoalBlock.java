package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockCompactCoalBlock extends Block {

	public BlockCompactCoalBlock(int id, Material material) {
		super(id, material);
		this.setCreativeTab(CCMain.compactTab);
	}
	public int idDropped(int par1, Random rand, int par2)
	{
		return CCMain.CompactCoal.itemID;
	}

	public int quantityDropped(Random rand)
	{
		return rand.nextInt(10);
	}

 

}
