package moony.compactcrafting.gui;

import moony.compactcrafting.containers.ContainerCompactChest;
import moony.compactcrafting.tileentitys.TileEntityCompactChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
        //returns an instance of the Container you made earlier
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityCompactChest){
                        return new ContainerCompactChest(player.inventory, (TileEntityCompactChest) tileEntity);
                }
                return null;
        }

        //returns an instance of the Gui you made earlier
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityCompactChest){
                        return new GuiCompactChest(player.inventory, (TileEntityCompactChest) tileEntity);
                }
                return null;

        }
}