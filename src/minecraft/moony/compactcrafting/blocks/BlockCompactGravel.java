package moony.compactcrafting.blocks;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.item.Item;

public class BlockCompactGravel extends BlockSand {
    public BlockCompactGravel(int id)
    {
        super(id);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (par3 > 3)
        {
            par3 = 3;
        }

        return par2Random.nextInt(10 - par3 * 3) == 0 ? Item.flint.itemID : this.blockID;
    }
}

