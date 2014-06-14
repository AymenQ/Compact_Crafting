package moony.compactcrafting.blocks;

import moony.compactcrafting.CCMain;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockCompactSand extends BlockSand{

	public BlockCompactSand() {
		super();
		this.setCreativeTab(CCMain.compactTab);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "CompactSand");
	}


}
