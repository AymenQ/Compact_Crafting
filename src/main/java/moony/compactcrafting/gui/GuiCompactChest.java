/*package moony.compactcrafting.gui;

import moony.compactcrafting.containers.ContainerCompactChest;
import moony.compactcrafting.tileentitys.TileEntityCompactChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiCompactChest extends GuiContainer
{

	public GuiCompactChest(InventoryPlayer inventoryPlayer,
			TileEntityCompactChest tileEntity)
	{
		super(new ContainerCompactChest(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		fontRenderer.drawString("Compact Chest", 6, 6, 0xffffff);
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 6,
				ySize - 96 + 2, 0xffffff);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3)
	{

		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture("/gui/container.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

	}

}*/
