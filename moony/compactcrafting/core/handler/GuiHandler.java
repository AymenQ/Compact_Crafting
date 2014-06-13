package moony.compactcrafting.core.handler;

import moony.compactcrafting.containers.ContainerPressureMachine;
import moony.compactcrafting.gui.GuiPressureMachine;
import moony.compactcrafting.tileentitys.TilePressureMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		/*if (tileEntity instanceof TileEntityCompactChest)
		{
			return new ContainerCompactChest(player.inventory,
					(TileEntityCompactChest) tileEntity);
		}*/
		if (tileEntity instanceof TilePressureMachine)
		{
			return new ContainerPressureMachine(player.inventory,
					(TilePressureMachine) tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		/*if (tileEntity instanceof TileEntityCompactChest)
		{
			return new GuiCompactChest(player.inventory,
					(TileEntityCompactChest) tileEntity);
		}*/
		if (tileEntity instanceof TilePressureMachine)
		{
			return new GuiPressureMachine(player.inventory,
					(TilePressureMachine) tileEntity);
		}
		return null;

	}
}