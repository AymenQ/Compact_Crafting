package moony.compactcrafting;

import net.minecraft.stats.Achievement;

import moony.compactcrafting.lib.BlockIDs;

public class CompactAchievement {

    public static Achievement compactBlockAchieve;
    public static Achievement compactGlassAchieve;

    public static void init() {
        declareAchievements();
        RegisterAchievements();
    }

    public static void declareAchievements() {
      final compactBlockAchieve = new Achievement(2200, "compactBlockAchievement", 0, 0, BlockIDs.CompactCobblestone, null);
      final compactGlassAchieve = new Achievement(2201, "compactGlassAchievement", 2, -2, BlockIDs.CompactGlass,            compactBlockAchieve);
    }

    public static void registerAchievements() {
        compactBlockAchieve.registerAchievement();
        compactGlassAchieve.registerAchievement();
    }

}
