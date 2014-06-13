package moony.compactcrafting.creativetabs;

import moony.compactcrafting.CCMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CompactTab extends CreativeTabs
{

	public CompactTab(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		if (CCMain.BlockOn == 1)
		{
			return new ItemStack(CCMain.CompactCobblestone);
		} else
		{
			return new ItemStack(CCMain.CompactCoal);
		}
	}

	@Override
	public Item getTabIconItem() {
		if (CCMain.BlockOn == 1)
		{
			return Item.getItemFromBlock(CCMain.CompactCobblestone);
		}
		else
		{
			return CCMain.CompactCoal;
		}
	}

}
