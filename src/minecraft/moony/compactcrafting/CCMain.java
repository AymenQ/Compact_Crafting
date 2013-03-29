package moony.compactcrafting;

import java.util.logging.Level;

import moony.compactcrafting.blocks.BlockCompactCoalBlock;
import moony.compactcrafting.blocks.BlockCompactCobblestone;
import moony.compactcrafting.blocks.BlockCompactDirt;
import moony.compactcrafting.blocks.BlockCompactGlass;
import moony.compactcrafting.blocks.BlockCompactGravel;
import moony.compactcrafting.blocks.BlockCompactNetherrack;
import moony.compactcrafting.blocks.BlockCompactSand;
import moony.compactcrafting.creativetabs.CompactTab;
import moony.compactcrafting.fuels.CompactFuel;
import moony.compactcrafting.gui.GuiHandler;
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
import moony.compactcrafting.tileentitys.TileEntityCompactChest;
import moony.compactcrafting.worldgenerators.WorldGeneratorCCB;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true,serverSideRequired=false)
@Mod(modid="CC",name="CCMain", version="3.3")



public class CCMain {

	
	
	@Instance ("CC")
	public static CCMain instance;

	private GuiHandler guiHandler = new GuiHandler();
	

	@SidedProxy(clientSide = "moony.compactcrafting.proxys.ClientProxy", serverSide = "moony.compactcrafting.proxys.CommonProxy") //Tells Forge the location of your proxies
	public static CommonProxy proxy;

		


		
	
		//Blocks
		public static Block CompactDirt;
		public static Block CompactCobblestone;
		public static Block CompactCoalBlock;
		public static Block CompactNetherrack;
		public static Block CompactGlass;
		public static Block CompactSand;
		public static Block CompactGravel;
		public static Block CompactChest;
		
		
		//EnumThingys
		public static final EnumToolMaterial C1IRON = EnumHelper.addToolMaterial("C1IRON", 2, 1000, 7.0F, 3, 14);
		public static final EnumToolMaterial C1DIAMOND = EnumHelper.addToolMaterial("C1DIAMOND", 3, 6244, 9.0F, 4, 10);
		public static final EnumToolMaterial C1GOLD = EnumHelper.addToolMaterial("C1GOLD", 0, 128, 13.0F, 0, 22);
		public static final EnumToolMaterial C1STONE = EnumHelper.addToolMaterial("C1STONE", 1, 524, 5.0F, 2 ,5);
		public static final EnumToolMaterial C1WOOD = EnumHelper.addToolMaterial("C1WOOD", 0, 236, 3.0F, 0, 15);
		public static final EnumToolMaterial C2IRON = EnumHelper.addToolMaterial("C2IRON", 2, 3600, 10.0F, 5, 14);
		public static final EnumToolMaterial C2DIAMOND = EnumHelper.addToolMaterial("C2DIAMOND", 3, 20000, 15.0F, 7, 10);
		public static final EnumToolMaterial C2GOLD = EnumHelper.addToolMaterial("C2GOLD", 0, 450, 18.0F, 0, 22);
		public static final EnumToolMaterial C2STONE = EnumHelper.addToolMaterial("C2STONE", 1, 1950, 8.0F, 3, 5);
		public static final EnumToolMaterial C2WOOD = EnumHelper.addToolMaterial("C2WOOD", 0, 900, 4.0F, 0, 15);
		//Configurations
		int CompactCobblestoneID;
		int CompactCoalBlockID;
		int CompactNetherrackID;
		int CompactCoalID;
		int CompactDirtID;
		int C1IronPickaxeID;
		int C1DiamondPickaxeID;
		int C1GoldPickaxeID;
		int C1StonePickaxeID;
		int C1WoodenPickaxeID;
		int C2IronPickaxeID;
		int C2DiamondPickaxeID;
		int C2GoldenPickaxeID;
		int C2StonePickaxeID;
		int C2WoodenPickaxeID;
		int C1IronAxeID;
		int C1DiamondAxeID;
		int C1GoldAxeID;
		int C1StoneAxeID;
		int C1WoodenAxeID;
		int C2IronAxeID;
		int C2DiamondAxeID;
		int C2GoldAxeID;
		int C2StoneAxeID;
		int C2WoodenAxeID;

		
		
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
		
		
		//Before Initialising (What do to before initialisation)
		@PreInit
		public void preInit(FMLPreInitializationEvent evt) {
		
		//Register Rendering
		proxy.registerRenderThings();
		
		//Configuration Initialising
		Configuration cfg = new Configuration(evt.getSuggestedConfigurationFile());
		
		//Load any previous configurations
		cfg.load();
		
		//Get Blocks, Items and others, and put them into the Configuration
		try
		{
		CompactCobblestoneID = cfg.getBlock("Compact Cobblestone", 711).getInt();
		C1WoodenPickaxeID = cfg.getItem("|Wooden Pickaxe|", 7006).getInt();
		CompactCoalBlockID = cfg.getBlock("Compact Coal Block", 712).getInt();
		CompactNetherrackID = cfg.getBlock("Compact Netherrack", 713).getInt();
		CompactDirtID = cfg.getBlock("Compact Dirt", 714).getInt();
		CompactCoalID = cfg.getItem("Compact Coal", 7001).getInt();
		C1IronPickaxeID = cfg.getItem("|Iron Pickaxe|", 7002).getInt();
		C1DiamondPickaxeID = cfg.getItem("|Diamond Pickaxe|", 7003).getInt();
		C1GoldPickaxeID = cfg.getItem("|Gold Pickaxe|", 7004).getInt();
		C1StonePickaxeID = cfg.getItem("|Stone Pickaxe|", 7005).getInt();
		C2IronPickaxeID = cfg.getItem("||Iron Pickaxe||",7006).getInt();
		C2DiamondPickaxeID = cfg.getItem("||Diamond Pickaxe||", 7007).getInt();
		C2GoldenPickaxeID = cfg.getItem("||Golden Pickaxe||", 7008).getInt();
		C2StonePickaxeID = cfg.getItem("||Stone Pickaxe||", 7009).getInt();
		C2WoodenPickaxeID = cfg.getItem("||Wooden Pickaxe||", 7010).getInt();
		C1IronAxeID = cfg.getItem("|Iron Axe|", 7011).getInt();
		C1DiamondAxeID = cfg.getItem("|Diamond Axe|", 7012).getInt();
		C1GoldAxeID = cfg.getItem("|Golden Axe|", 7013).getInt();
		C1StoneAxeID = cfg.getItem("|Stone Axe|", 7014).getInt();
		C1WoodenAxeID = cfg.getItem("|Wooden Axe|", 7015).getInt();
		C2IronAxeID = cfg.getItem("||Iron Axe||", 7016).getInt();
		C2DiamondAxeID = cfg.getItem("||Diamond Axe||", 7017).getInt();
		C2GoldAxeID = cfg.getItem("||Golden Axe||", 7018).getInt();
		C2StoneAxeID = cfg.getItem("||Stone Axe||", 7019).getInt();
		C2WoodenAxeID = cfg.getItem("||Wooden Axe||", 7020).getInt();
		} catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Compact Crafting has problems loading configs");
		} finally {
			
			//Save the Configuration
			cfg.save();
		}
		
		//Initialise all the Items
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
		
		//Initialise all the Blocks
		CompactCobblestone = new BlockCompactCobblestone(711, Material.rock).setHardness(3.2F).setResistance(4.0F).setUnlocalizedName("CompactCobblestone");
		CompactCoalBlock = new BlockCompactCoalBlock(712, Material.rock).setHardness(3.0F).setUnlocalizedName("CompactCoalBlock");
		CompactNetherrack = new BlockCompactNetherrack(713, Material.rock).setHardness(0.44F).setUnlocalizedName("CompactNetherrack");
		CompactDirt = new BlockCompactDirt(714, Material.ground).setHardness(0.6F).setUnlocalizedName("CompactDirt");
		CompactGlass = new BlockCompactGlass(715, Material.glass).setHardness(0.3F).setUnlocalizedName("CompactGlass");
		CompactSand = new BlockCompactSand(716, Material.sand).setHardness(0.6F).setUnlocalizedName("CompactSand");
		CompactGravel = new BlockCompactGravel(717).setHardness(0.7F).setUnlocalizedName("CompactGravel");
		CompactChest = new BlockCompactChest(718, Material.wood).setHardness(0.7F).setUnlocalizedName("CompactChest");

		//Initialise Achievements 
		achievements = new CompactAchievement();
		
		
	}
		
		
		//Initialising (What do to during initialisation)
		@Init
		public void load(FMLInitializationEvent evt) {
			
		
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
		
		GameRegistry.registerTileEntity(TileEntityCompactChest.class, "tecompactchest");

			
			
		//Registering Blocks
			
		GameRegistry.registerBlock(CompactCobblestone, "CompactCobblestone");
		GameRegistry.registerBlock(CompactCoalBlock, "CompactCoalBlock");
		GameRegistry.registerBlock(CompactNetherrack, "CompactNetherrack");
		GameRegistry.registerBlock(CompactDirt, "CompactDirt");
		GameRegistry.registerBlock(CompactGlass, "CompactGlass");
		GameRegistry.registerBlock(CompactSand, "CompactSand");
		GameRegistry.registerBlock(CompactChest, "CompactChest");
		//Handlers
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		
		
		//Registering Names for Blocks
		LanguageRegistry.addName(CompactCobblestone, "Compact Cobblestone");
		LanguageRegistry.addName(CompactCoalBlock, "Compact Coal Block");
		LanguageRegistry.addName(CompactNetherrack, "Compact Netherrack");
		LanguageRegistry.addName(CompactDirt, "Compact Dirt");
		LanguageRegistry.addName(CompactGlass, "Compact Glass");
		LanguageRegistry.addName(CompactSand, "Compact Sand");
		
		//Registering Names for Items
		LanguageRegistry.instance().addNameForObject(CompactCoal, "en_US", "Compact Coal");
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
		
		//Registering Names for others
		LanguageRegistry.instance().addStringLocalization("itemGroup.compactTab", "en_US", "Compact Crafting");


		//Achievement Pages, Names and Descriptions

		this.addAchievementName("compactBlockAchievement", "Compact Something");
		this.addAchievementDesc("compactBlockAchievement", "Compact a raw material using the workbench.");
		
		this.addAchievementName("compactGlassAchievement", "Compact Smelting");
		this.addAchievementDesc("compactGlassAchievement", "Smelt Compact Sand to get Compact Glass");
		
		CompactCraftingPage = new AchievementPage("Compact Crafting", achievements.compactBlockAchieve, achievements.compactGlassAchieve);
		AchievementPage.registerAchievementPage(CompactCraftingPage);

		//Registering others

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
		
		//Method to add an Achievement Name
		private void addAchievementName(String ach, String name)
		{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
		}
		
		//Method to add an Achievement Description
		private void addAchievementDesc(String ach, String desc)
		{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
		}
	
	//Post Initialising (What do to after initialisation)
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {

	}

	
}
