package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockCompactGravel extends BlockSand {
    public BlockCompactGravel()
    {
        super();
        this.setCreativeTab(CCMain.compactTab);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        if (par3 > 3)
        {
            par3 = 3;
        }

        return par2Random.nextInt(10 - par3 * 3) == 0 ? Items.flint : 
        	Item.getItemFromBlock(CCMain.CompactGravel);
    }
    
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "CompactGravel");
    }

}


