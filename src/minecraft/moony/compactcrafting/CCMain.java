package moony.compactcrafting;

import java.util.logging.Level;

import moony.compactcrafting.blocks.*;
import moony.compactcrafting.creativetabs.CompactTab;
import moony.compactcrafting.fuels.CompactFuel;
import moony.compactcrafting.items.ItemC1DiamondAxe;
import moony.compactcrafting.items.ItemC1DiamondPickaxe;
import moony.compactcrafting.items.ItemC1GoldAxe;
import moony.compactcrafting.items.ItemC1GoldPickaxe;
import moony.compactcrafting.items.ItemC1IronAxe;
import moony.compactcrafting.items.ItemC1IronPickaxe;
import moony.compactcrafting.items.ItemC1StoneAxe;
import moony.compactcrafting.items.ItemC1StonePickaxe;
import moony.compactcrafting.items.ItemC1WoodenAxe;
import moony.compactcrafting.items.ItemC1WoodenPickaxe;
import moony.compactcrafting.items.ItemC2DiamondAxe;
import moony.compactcrafting.items.ItemC2DiamondPickaxe;
import moony.compactcrafting.items.ItemC2GoldAxe;
import moony.compactcrafting.items.ItemC2GoldPickaxe;
import moony.compactcrafting.items.ItemC2IronAxe;
import moony.compactcrafting.items.ItemC2IronPickaxe;
import moony.compactcrafting.items.ItemC2StoneAxe;
import moony.compactcrafting.items.ItemC2StonePickaxe;
import moony.compactcrafting.items.ItemC2WoodenAxe;
import moony.compactcrafting.items.ItemC2WoodenPickaxe;
import moony.compactcrafting.items.ItemCompactCoal;
import moony.compactcrafting.proxys.CommonProxy;
import moony.compactcrafting.worldgenerators.WorldGeneratorCCB;
import moony.compactcrafting.core.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=false)
@Mod(modid="CC",name="CCMain", version="3.2")



public class CCMain {

	
	
	@Instance ("CC")
	public static CCMain instance;
	
	

	@SidedProxy(clientSide = "moony.compactcrafting.proxys.ClientProxy", serverSide = "moony.compactcrafting.proxys.CommonProxy") //Tells Forge the location of your proxies
	public static CommonProxy proxy;

		

		
		
		//Blocks
		public static Block CompactDirt;
		public static Block CompactCobblestone;
		public static Block CompactCoalBlock;
		public static Block CompactNetherrack;
		public static Block CompactGlass;
		public static Block CompactSand;
		
		
		//EnumThingys
		public static EnumToolMaterial C1IRON = EnumHelper.addToolMaterial("C1IRON", 2, 1000, 7.0F, 3, 14);
		public static EnumToolMaterial C1DIAMOND = EnumHelper.addToolMaterial("C1DIAMOND", 3, 6244, 9.0F, 4, 10);
		public static EnumToolMaterial C1GOLD = EnumHelper.addToolMaterial("C1GOLD", 0, 128, 13.0F, 0, 22);
		public static EnumToolMaterial C1STONE = EnumHelper.addToolMaterial("C1STONE", 1, 524, 5.0F, 2 ,5);
		public static EnumToolMaterial C1WOOD = EnumHelper.addToolMaterial("C1WOOD", 0, 236, 3.0F, 0, 15);
		public static EnumToolMaterial C2IRON = EnumHelper.addToolMaterial("C2IRON", 2, 3600, 10.0F, 5, 14);
		public static EnumToolMaterial C2DIAMOND = EnumHelper.addToolMaterial("C2DIAMOND", 3, 20000, 15.0F, 7, 10);
		public static EnumToolMaterial C2GOLD = EnumHelper.addToolMaterial("C2GOLD", 0, 450, 18.0F, 0, 22);
		public static EnumToolMaterial C2STONE = EnumHelper.addToolMaterial("C2STONE", 1, 1950, 8.0F, 3, 5);
		public static EnumToolMaterial C2WOOD = EnumHelper.addToolMaterial("C2WOOD", 0, 900, 4.0F, 0, 15);
		
		//Items
		public static Item CompactCoal;
		public static Item C1IronPickaxe;
		public static Item C1DiamondPickaxe;
		public static Item C1GoldPickaxe;
		public static Item C1StonePickaxe;
		public static Item C1WoodenPickaxe;
		public static Item C2IronPickaxe;
		public static Item C2DiamondPickaxe;
		public static Item C2GoldPickaxe;
		public static Item C2WoodenPickaxe;
		public static Item C2StonePickaxe;
		public static Item C1IronAxe;
		public static Item C1DiamondAxe;
		public static Item C1GoldAxe;
		public static Item C1StoneAxe;
		public static Item C1WoodenAxe;
		public static Item C2IronAxe;
		public static Item C2DiamondAxe;
		public static Item C2GoldAxe;
		public static Item C2StoneAxe;
		public static Item C2WoodenAxe;
	
		
		//Achievements
		public static AchievementPage CompactCraftingPage;
		
		public static CompactAchievement achievements;
		


		//Creative Tabs
		public static CreativeTabs compactTab = new CompactTab("compactTab");
	
		
		//Methods
		
		
		@PreInit
		public void preInit(FMLPreInitializationEvent evt) {
		//Block Registering
		
		proxy.registerRenderThings();
		
		ConfigurationHandler.init();
		
		CompactCoal = new ItemCompactCoal(7001).setUnlocalizedName("CompactCoal");
		C1IronPickaxe = new ItemC1IronPickaxe(C1IronPickaxeID, C1IRON).setUnlocalizedName("C1IronPickaxe");
		C1DiamondPickaxe = new ItemC1DiamondPickaxe(C1DiamondPickaxeID, C1DIAMOND).setUnlocalizedName("C1DiamondPickaxe");
		C1GoldPickaxe = new ItemC1GoldPickaxe(C1GoldPickaxeID, C1GOLD).setUnlocalizedName("C1GoldenPickaxe");
		C1StonePickaxe = new ItemC1StonePickaxe(C1StonePickaxeID, C1STONE).setUnlocalizedName("C1StonePickaxe");;
		C1WoodenPickaxe = new ItemC1WoodenPickaxe(C1WoodenPickaxeID, C1WOOD).setUnlocalizedName("C1WoodenPickaxe");
		C2IronPickaxe = new ItemC2IronPickaxe(C2IronPickaxeID, C2IRON).setUnlocalizedName("C2IronPickaxe");
		C2DiamondPickaxe = new ItemC2DiamondPickaxe(C2DiamondPickaxeID, C2DIAMOND).setUnlocalizedName("C2DiamondPickaxe");
		C2GoldPickaxe = new ItemC2GoldPickaxe(C2GoldenPickaxeID, C2GOLD).setUnlocalizedName("C2GoldenPickaxe");
		C2StonePickaxe = new ItemC2StonePickaxe(C2StonePickaxeID, C2STONE).setUnlocalizedName("C2StonePickaxe");
		C2WoodenPickaxe = new ItemC2WoodenPickaxe(C2WoodenPickaxeID, C2WOOD).setUnlocalizedName("C2WoodenPickaxe");
		C1IronAxe = new ItemC1IronAxe(C1IronAxeID, C1IRON).setUnlocalizedName("C1IronAxe");
		C1DiamondAxe = new ItemC1DiamondAxe(C1DiamondAxeID, C1DIAMOND).setUnlocalizedName("C1DiamondAxe");
		C1GoldAxe = new ItemC1GoldAxe(C1GoldAxeID, C1GOLD).setUnlocalizedName("C1GoldenAxe");
		C1StoneAxe = new ItemC1StoneAxe(C1StoneAxeID, C1STONE).setUnlocalizedName("C1StoneAxe");
		C1WoodenAxe = new ItemC1WoodenAxe(C1WoodenAxeID, C1WOOD).setUnlocalizedName("C1WoodenAxe");
		C2IronAxe = new ItemC2IronAxe(C2IronAxeID, C2IRON).setUnlocalizedName("C2IronAxe");
		C2DiamondAxe = new ItemC2DiamondAxe(C2DiamondAxeID, C2DIAMOND).setUnlocalizedName("C2DiamondAxe");
		C2GoldAxe = new ItemC2GoldAxe(C2GoldAxeID, C2GOLD).setUnlocalizedName("C2GoldenAxe");
		C2StoneAxe = new ItemC2StoneAxe(C2StoneAxeID, C2STONE).setUnlocalizedName("C2StoneAxe");
		C2WoodenAxe = new ItemC2WoodenAxe(C2WoodenAxeID, C2WOOD).setUnlocalizedName("C2WoodenAxe");
		//Block Settings
		
		CompactCobblestone = new BlockCompactCobblestone(711, Material.rock).setHardness(3.2F).setResistance(4.0F).setUnlocalizedName("CompactCobblestone");
		CompactCoalBlock = new BlockCompactCoalBlock(712, Material.rock).setHardness(3.0F).setUnlocalizedName("CompactCoalBlock");
		CompactNetherrack = new BlockCompactNetherrack(713, Material.rock).setHardness(0.44F).setUnlocalizedName("CompactNetherrack");
		CompactDirt = new BlockCompactDirt(714, Material.ground).setHardness(0.6F).setUnlocalizedName("CompactDirt");
		CompactGlass = new BlockCompactGlass(715, Material.glass).setHardness(0.3F).setUnlocalizedName("CompactGlass");
		CompactSand = new BlockCompactSand(716, Material.sand).setHardness(0.6F).setUnlocalizedName("CompactSand");
				
		achievements = new CompactAchievement();
		
	}

		@Init
		public void load(FMLInitializationEvent evt) {
		
		

	
			
		//Item Settings
			


		
	

			
		GameRegistry.registerBlock(CompactCobblestone, "CompactCobblestone");
		GameRegistry.registerBlock(CompactCoalBlock, "CompactCoalBlock");
		GameRegistry.registerBlock(CompactNetherrack, "CompactNetherrack");
		GameRegistry.registerBlock(CompactDirt, "CompactDirt");
		GameRegistry.registerBlock(CompactGlass, "CompactGlass");
		GameRegistry.registerBlock(CompactSand, "CompactSand");
		
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		
LanguageRegistry.instance().addNameForObject(CompactCoal, "en_US", "Compact Coal");
LanguageRegistry.addName(CompactCobblestone, "Compact Cobblestone");
LanguageRegistry.addName(CompactCoalBlock, "Compact Coal Block");
LanguageRegistry.addName(CompactNetherrack, "Compact Netherrack");
LanguageRegistry.addName(CompactDirt, "Compact Dirt");
LanguageRegistry.addName(CompactGlass, "Compact Glass");
LanguageRegistry.addName(CompactSand, "Compact Sand");

LanguageRegistry.addName(C1IronPickaxe, "|Iron Pickaxe|");
LanguageRegistry.addName(C1DiamondPickaxe, "|Diamond Pickaxe|");
LanguageRegistry.instance().addNameForObject(C1GoldPickaxe, "en_US", "|Golden Pickaxe|");
LanguageRegistry.instance().addNameForObject(C1StonePickaxe, "en_US", "|Stone Pickaxe|");
LanguageRegistry.addName(C1WoodenPickaxe, "|Wooden Pickaxe|");

LanguageRegistry.addName(C2IronPickaxe, "||Iron Pickaxe||");
LanguageRegistry.addName(C2DiamondPickaxe, "||Diamond Pickaxe||");
LanguageRegistry.addName(C2GoldPickaxe, "||Golden Pickaxe||");
LanguageRegistry.addName(C2StonePickaxe, "||Stone Pickaxe||");
LanguageRegistry.addName(C2WoodenPickaxe, "||Wooden Pickaxe||");

LanguageRegistry.addName(C1IronAxe, "|Iron Axe|");
LanguageRegistry.addName(C1DiamondAxe, "|Diamond Axe|");
LanguageRegistry.addName(C1GoldAxe, "|Golden Axe|");
LanguageRegistry.addName(C1StoneAxe, "|Stone Axe|");
LanguageRegistry.addName(C1WoodenAxe, "|Wooden Axe|");

LanguageRegistry.addName(C2IronAxe, "||Iron Axe||");
LanguageRegistry.addName(C2DiamondAxe, "||Diamond Axe||");
LanguageRegistry.addName(C2GoldAxe, "||Golden Axe||");
LanguageRegistry.addName(C2StoneAxe, "||Stone Axe||");
LanguageRegistry.addName(C2WoodenAxe, "||Wooden Axe||");

LanguageRegistry.instance().addStringLocalization("itemGroup.compactTab", "en_US", "Compact Crafting");




	this.addAchievementName("compactBlockAchievement", "Compact Something");
	this.addAchievementDesc("compactBlockAchievement", "Compact a raw material using the workbench.");
	
	this.addAchievementName("compactGlassAchievement", "Compact Smelting");
	this.addAchievementDesc("compactGlassAchievement", "Smelt Compact Sand to get Compact Glass");
	
	CompactCraftingPage = new AchievementPage("Compact Crafting", achievements.compactBlockAchieve, achievements.compactGlassAchieve);
	AchievementPage.registerAchievementPage(CompactCraftingPage);


GameRegistry.registerFuelHandler(new CompactFuel());
GameRegistry.registerWorldGenerator(new WorldGeneratorCCB());
		//Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactCobblestone), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",	
					'X', Block.cobblestone
				});
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactCoal), new Object[]
				{
					"   ",
					"XX ",
					"XX ",
					'X', Item.coal
				});
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactCoalBlock), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', CCMain.CompactCoal
				});
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactNetherrack), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', Block.netherrack
				});
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactDirt), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",	
					'X', Block.dirt
				});
		GameRegistry.addRecipe(new ItemStack(CCMain.CompactSand), new Object[]
				{
					"XXX",
					"XXX",
					"XXX",
					'X', Block.sand
				});
		

		//Shapeless Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone,9), CCMain.CompactCobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal,4), CCMain.CompactCoal);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.CompactCoal,9), CCMain.CompactCoalBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.netherrack,9), CCMain.CompactNetherrack);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt , 9), CCMain.CompactDirt);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.sand, 9), CCMain.CompactSand);
		
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronPickaxe, 1), Item.pickaxeSteel, Item.pickaxeSteel, Item.pickaxeSteel,
				Item.pickaxeSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondPickaxe, 1), Item.pickaxeDiamond, Item.pickaxeDiamond, Item.pickaxeDiamond,
				Item.pickaxeDiamond);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldPickaxe, 1), Item.pickaxeGold, Item.pickaxeGold, Item.pickaxeGold,
				Item.pickaxeGold);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StonePickaxe, 1), Item.pickaxeStone, Item.pickaxeStone, Item.pickaxeStone,
				Item.pickaxeStone);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1WoodenPickaxe, 1), Item.pickaxeWood, Item.pickaxeWood, Item.pickaxeWood,
				Item.pickaxeWood);
		
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronPickaxe, 1), CCMain.C1IronPickaxe, 
				CCMain.C1IronPickaxe,
				CCMain.C1IronPickaxe,
				CCMain.C1IronPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondPickaxe, 1),
				CCMain.C1DiamondPickaxe,
				CCMain.C1DiamondPickaxe,
				CCMain.C1DiamondPickaxe,
				CCMain.C1DiamondPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldPickaxe, 1),
				CCMain.C1GoldPickaxe,
				CCMain.C1GoldPickaxe,
				CCMain.C1GoldPickaxe,
				CCMain.C1GoldPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2StonePickaxe, 1),
				CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2WoodenPickaxe, 1),
				CCMain.C1WoodenPickaxe,
				CCMain.C1WoodenPickaxe,
				CCMain.C1WoodenPickaxe,
				CCMain.C1WoodenPickaxe);
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronAxe, 1), Item.axeSteel, Item.axeSteel, Item.axeSteel,
				Item.axeSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondAxe, 1), Item.axeDiamond, Item.axeDiamond, Item.axeDiamond,
				Item.axeDiamond);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldAxe, 1), Item.axeGold, Item.axeGold, Item.axeGold,
				Item.axeGold);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StoneAxe, 1), Item.axeStone, Item.axeStone, Item.axeStone,
				Item.axeStone);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1WoodenAxe, 1), Item.axeWood, Item.axeWood, Item.axeWood,
				Item.axeWood);
		
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronAxe, 1), CCMain.C1IronAxe, 
				CCMain.C1IronAxe,
				CCMain.C1IronAxe,
				CCMain.C1IronAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondAxe, 1),
				CCMain.C1DiamondAxe,
				CCMain.C1DiamondAxe,
				CCMain.C1DiamondAxe,
				CCMain.C1DiamondAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldAxe, 1),
				CCMain.C1GoldAxe,
				CCMain.C1GoldAxe,
				CCMain.C1GoldAxe,
				CCMain.C1GoldAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2StoneAxe, 1),
				CCMain.C1StoneAxe,
				CCMain.C1StoneAxe,
				CCMain.C1StoneAxe,
				CCMain.C1StoneAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2WoodenAxe, 1),
				CCMain.C1WoodenAxe,
				CCMain.C1WoodenAxe,
				CCMain.C1WoodenAxe,
				CCMain.C1WoodenAxe);
		
		//Smelting Recipes
		GameRegistry.addSmelting(CCMain.CompactSand.blockID, new ItemStack(CCMain.CompactGlass), 5);
		

	}
		
		
		private void addAchievementName(String ach, String name)
		{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
		}

		private void addAchievementDesc(String ach, String desc)
		{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
		}
	

	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {

	}

	
}
