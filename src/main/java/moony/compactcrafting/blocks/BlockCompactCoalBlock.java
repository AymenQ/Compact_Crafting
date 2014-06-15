package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BlockCompactCoalBlock extends Block {

	public BlockCompactCoalBlock(Material material) {
		super(material);
		this.setCreativeTab(CCMain.compactTab);
	}
	
	@Override
	public int quantityDropped(Random rand)
	{
		return rand.nextInt(10);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		
		return CCMain.CompactCoal;
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":"
	    + "CompactCoalBlock");
	}

 

}
