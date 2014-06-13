package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemC1DiamondAxe extends ItemAxe {

	public ItemC1DiamondAxe(int id, ToolMaterial enumToolMaterial) {
		super(enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName("C1DiamondAxe");

	}
	
		public void updateIcons(IconRegister par1IconRegister)
		{
		    this.iconIndex = par1IconRegister.registerIcon(CCMain.modid + ":" + this.getUnlocalizedName());
		}


}
