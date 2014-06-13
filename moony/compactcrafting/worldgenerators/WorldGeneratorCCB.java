package moony.compactcrafting.worldgenerators;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;



public class WorldGeneratorCCB implements IWorldGenerator {

	public int i;

	public int Xcoord;
	public int Ycoord;
	public int Zcoord;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}
	
	private void generateNether(World world, Random random, int blockX, int blockZ)
	{
		
	}
	
	private void generateSurface(World world, Random random, int blockX, int blockZ)
	{
		for (int i = 0; i < 30; i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(15);
			int Zcoord = blockZ + random.nextInt(16);
			
			(new WorldGenMinable(CCMain.CompactCobblestone.blockID, random.nextInt(20))).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}

}
