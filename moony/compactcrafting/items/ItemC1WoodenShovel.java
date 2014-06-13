package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemC1WoodenShovel extends ItemSpade
{

	public ItemC1WoodenShovel(int id, EnumToolMaterial enumToolMaterial)
	{
		super(id, enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	public void updateIcons(IconRegister par1IconRegister)
	{
		this.iconIndex = par1IconRegister.registerIcon(CCMain.modid + ":"
				+ this.getUnlocalizedName());

	}
}
