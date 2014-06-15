package moony.compactcrafting;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotCompactChest extends Slot
{

	public SlotCompactChest(IInventory inventory, int par2, int par3, int par4)
	{
		super(inventory, par2, par3, par4);
		
	}
	
	@Override
	public int getSlotStackLimit()
	{
		return 256;
	}
	

}
