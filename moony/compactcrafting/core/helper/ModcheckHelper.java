package moony.compactcrafting.core.helper;

import net.minecraft.src.ModLoader;

/**
  * Modcheck Helper class for checking mods if they're loaded solely for addon purposes
  * note: imports need to be done...
  *
  * @author Astorian
  */

public class ModcheckHelper {

    public static boolean isExtraneousCraftLoaded() {
        if(ModLoader.isModLoaded("ExtraneousCraft")) {
            return true;
        } else
        return false;
    }

}
