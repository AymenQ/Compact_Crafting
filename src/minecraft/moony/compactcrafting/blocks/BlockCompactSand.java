package moony.compactcrafting.blocks;

import moony.compactcrafting.CCMain;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;

public class BlockCompactSand extends BlockSand{

	public BlockCompactSand(int id, Material material) {
		super(id, material);
		this.setCreativeTab(CCMain.compactTab);
	}

}
