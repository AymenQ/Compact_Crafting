package moony.compactcrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		if(item.itemID == CCMain.CompactCobblestone.blockID
				||item.itemID == CCMain.CompactDirt.blockID
				||item.itemID == CCMain.CompactNetherrack.blockID
				||item.itemID == CCMain.CompactCoalBlock.blockID
				||item.itemID == CCMain.CompactCoal.itemID
				||item.itemID == CCMain.CompactSand.blockID)
		{
			player.addStat(CCMain.achievements.compactBlockAchieve, 1);
		}
		
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		if(item.itemID == CCMain.CompactGlass.blockID)
		{
			player.addStat(CCMain.achievements.compactGlassAchieve, 1);
		}
		

	}

}
