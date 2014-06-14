package moony.compactcrafting.worldgenerators;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorCNR implements IWorldGenerator 
{
 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
 {
  switch (world.provider.dimensionId)
  {
   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
  }
 }

  

  private void generateSurface(World world, Random random, int blockX, int blockZ) 
 {

 }
 
  	private void generateNether(World world, Random random, int blockX, int blockZ) 
  	{
		
 
	  int Xcoord = blockX + random.nextInt(16);
	  int Ycoord = random.nextInt(60);
	  int Zcoord = blockZ + random.nextInt(16);
	  
	  (new WorldGenMinableNether(CCMain.CompactNetherrack, random.nextInt(20))).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
  	}
