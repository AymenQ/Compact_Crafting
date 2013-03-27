package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCompactCobblestone extends Block {


public BlockCompactCobblestone(int id, Material material) {
		super(id, material);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(CCMain.compactTab);
	}

public int idDropped(int par1, Random rand, int par2)
{
	return Block.cobblestone.blockID;
}

public int quantityDropped(Random rand)
{
	return rand.nextInt(10);
}
	

}