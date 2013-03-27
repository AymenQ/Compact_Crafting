package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompactDirt extends Block {

public BlockCompactDirt(int id, Material material) {

super(id, Material.ground);
this.setCreativeTab(CCMain.compactTab);
}

public int idDropped(int par1, Random rand, int par2)
{
	return Block.dirt.blockID;
}

public int quantityDropped(Random rand)
{
	return rand.nextInt(10);
}

}