package moony.compactcrafting;

import net.minecraft.stats.Achievement;

public class CompactAchievement {

	final Achievement compactBlockAchieve = new Achievement(2200, "compactBlockAchievement", 
			0, 0, CCMain.CompactCobblestone, null).registerAchievement();
	final Achievement compactGlassAchieve = new Achievement(2201, "compactGlassAchievement",
			2, -2, CCMain.CompactGlass, compactBlockAchieve).registerAchievement();

}
