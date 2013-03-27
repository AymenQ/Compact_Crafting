package moony.compactcrafting.creativetabs;

import moony.compactcrafting.CCMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CompactTab extends CreativeTabs{

	public CompactTab(String label) {
		super(label);
	}
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(CCMain.CompactCobblestone);
	}

}
