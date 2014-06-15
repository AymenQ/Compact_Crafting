package moony.compactcrafting;

import net.minecraft.stats.Achievement;

public class CompactAchievement {

	public final Achievement compactBlockAchieve = new Achievement
			("compactcrafting.compactBlockAchieve",
			"compactBlockAchievement",
			0, 0, CCMain.CompactCobblestone, (Achievement)null).registerStat();
	public final Achievement compactGlassAchieve = new Achievement
			("compactcrafting.compactGlassAchieve",
			"compactGlassAchievement",
			2, -2, CCMain.CompactGlass, compactBlockAchieve).registerStat();

}
