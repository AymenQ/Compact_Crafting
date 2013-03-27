package moony.compactcrafting.blocks;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompactSand extends Block{

	public BlockCompactSand(int id, Material material) {
		super(id, material);
		this.setCreativeTab(CCMain.compactTab);
	}

}
