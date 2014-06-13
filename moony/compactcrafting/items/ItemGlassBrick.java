package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGlassBrick extends Item
{

	public ItemGlassBrick(int id)
	{
		super(id);
		this.setCreativeTab(CCMain.compactTab);

	}

	public void updateIcons(IconRegister par1IconRegister)
	{
		this.iconIndex = par1IconRegister.registerIcon(CCMain.modid + ":"
				+ this.getUnlocalizedName());

	}
}
