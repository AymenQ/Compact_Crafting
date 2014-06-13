package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemGlassBrick extends Item
{

	public ItemGlassBrick()
	{
		super();
		this.setCreativeTab(CCMain.compactTab);

	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "GlassBrick");
	}
}
