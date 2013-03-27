package moony.compactcrafting.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemC1DiamondPickaxe extends ItemPickaxe{

	public ItemC1DiamondPickaxe(int id, EnumToolMaterial enumToolMaterial) {
		super(id, enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);		
	}
	
	public String getTextureFile()
	{
		return "/textures/Items.png";
	}
	


}
