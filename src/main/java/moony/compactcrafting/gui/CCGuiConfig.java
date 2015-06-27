package moony.compactcrafting.gui;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import moony.compactcrafting.CCMain;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.List;

public class CCGuiConfig extends GuiConfig {
    public CCGuiConfig(GuiScreen parentScreen) {
        super(parentScreen,
                new ConfigElement(CCMain.cfg.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                "CC", false, false, GuiConfig.getAbridgedConfigPath(CCMain.cfg.toString()));
    }
}
