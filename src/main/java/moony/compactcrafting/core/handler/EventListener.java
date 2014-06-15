package moony.compactcrafting.core.handler;

import moony.compactcrafting.CCMain;
import net.minecraft.item.Item;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class EventListener
{
	@SubscribeEvent
	public void onCrafted(ItemCraftedEvent craft)
	{
		if (craft.crafting.getItem() == Item.getItemFromBlock(CCMain.CompactCobblestone)
				|| craft.crafting.getItem() == Item.getItemFromBlock(CCMain.CompactDirt)				
				|| craft.crafting.getItem() == Item.getItemFromBlock(CCMain.CompactNetherrack)
				|| craft.crafting.getItem() == Item.getItemFromBlock(CCMain.CompactCoalBlock)
				|| craft.crafting.getItem() == CCMain.CompactCoal
				|| craft.crafting.getItem() == Item.getItemFromBlock(CCMain.CompactSand))
		{
			craft.player.addStat(CCMain.achievements.compactBlockAchieve, 1);
		}

	}
	
	@SubscribeEvent
	public void onSmelted(ItemSmeltedEvent smelt)
	{
		if(smelt.smelting.getItem() == Item.getItemFromBlock(CCMain.CompactGlass))
			smelt.player.addStat(CCMain.achievements.compactGlassAchieve, 1);
	}

}
