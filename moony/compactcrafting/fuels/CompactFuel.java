package moony.compactcrafting.fuels;

import moony.compactcrafting.CCMain;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class CompactFuel implements IFuelHandler {

	public int getBurnTime(ItemStack compactfuel)
	{
		if(compactfuel.itemID == CCMain.CompactCoal.itemID)
			return 6400;
		if(compactfuel.itemID == CCMain.CompactCoalBlock.blockID)
			return 57600;
		else
			return 0;
		
		
	}
	
	
	
}
	