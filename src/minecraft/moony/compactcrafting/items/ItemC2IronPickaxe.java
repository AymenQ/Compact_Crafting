package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemC2IronPickaxe extends ItemPickaxe {

	public ItemC2IronPickaxe(int id, EnumToolMaterial enumToolMaterial) {
		super(id, enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

}
