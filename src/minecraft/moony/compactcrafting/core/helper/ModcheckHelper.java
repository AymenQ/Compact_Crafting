package moony22.compactcrafting.core.helper;

/**
  * Modcheck Helper class for checking mods if they're loaded solely for addon purposes
  * note: imports need to be done...
  *
  * @author Astorian
  */

public class ModcheckHelper {

    public static boolean isExtraneousCraftLoaded() {
        if(Loader.isModLoaded("ExtraneousCraft")) {
            return true;
        } else
        return false;
    }

}
