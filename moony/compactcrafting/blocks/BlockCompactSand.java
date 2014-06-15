package moony.compactcrafting.blocks;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockCompactSand extends Block{

	public BlockCompactSand() {
		super(Material.sand);
		this.setCreativeTab(CCMain.compactTab);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	    this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "CompactSand");
	}


}
