package moony.compactcrafting.fuels;

import moony.compactcrafting.CCMain;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class CompactFuel implements IFuelHandler {

	public int getBurnTime(ItemStack compactfuel)
	{
		if(compactfuel.getItem() == CCMain.CompactCoal)
			return 6400;
		if(compactfuel.getItem() == Item.getItemFromBlock(CCMain.CompactCoalBlock))
			return 57600;
		else
			return 0;
		
		
	}
	
	
	
}
	