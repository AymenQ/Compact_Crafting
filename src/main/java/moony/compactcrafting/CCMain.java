package moony.compactcrafting;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moony.compactcrafting.blocks.BlockCompactCoalBlock;
import moony.compactcrafting.blocks.BlockCompactCobblestone;
import moony.compactcrafting.blocks.BlockCompactDirt;
import moony.compactcrafting.blocks.BlockCompactGlass;
import moony.compactcrafting.blocks.BlockCompactGravel;
import moony.compactcrafting.blocks.BlockCompactNetherrack;
import moony.compactcrafting.blocks.BlockCompactSand;
import moony.compactcrafting.blocks.BlockGlassBrickBlock;
import moony.compactcrafting.core.handler.EventListener;
import moony.compactcrafting.core.handler.GuiHandler;
import moony.compactcrafting.core.proxys.CommonProxy;
import moony.compactcrafting.creativetabs.CompactTab;
import moony.compactcrafting.fuels.CompactFuel;
import moony.compactcrafting.items.ItemC1DiamondAxe;
import moony.compactcrafting.items.ItemC1DiamondPickaxe;
import moony.compactcrafting.items.ItemC1DiamondShovel;
import moony.compactcrafting.items.ItemC1GoldAxe;
import moony.compactcrafting.items.ItemC1GoldPickaxe;
import moony.compactcrafting.items.ItemC1GoldenShovel;
import moony.compactcrafting.items.ItemC1IronAxe;
import moony.compactcrafting.items.ItemC1IronPickaxe;
import moony.compactcrafting.items.ItemC1IronShovel;
import moony.compactcrafting.items.ItemC1StoneAxe;
import moony.compactcrafting.items.ItemC1StonePickaxe;
import moony.compactcrafting.items.ItemC1StoneShovel;
import moony.compactcrafting.items.ItemC1WoodenAxe;
import moony.compactcrafting.items.ItemC1WoodenPickaxe;
import moony.compactcrafting.items.ItemC1WoodenShovel;
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
import moony.compactcrafting.items.ItemCompactRedstoneCrystal;
import moony.compactcrafting.items.ItemGlassBrick;
import moony.compactcrafting.tileentitys.TilePressureMachine;
import moony.compactcrafting.worldgenerators.WorldGeneratorCCB;
import moony.compactcrafting.worldgenerators.WorldGeneratorCNR;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CC", name = "CCMain", version = "5.0.0", guiFactory="moony.compactcrafting.gui.CCGuiFactory")
public class CCMain {

	@Instance("CC")
	public static CCMain instance;

	public static final String modid = "CC";

	private GuiHandler guiHandler = new GuiHandler();

	@SidedProxy(clientSide = "moony.compactcrafting.core.proxys.ClientProxy", serverSide = "moony.compactcrafting.core.proxys.CommonProxy")
	// Tells Forge the location of your proxies
	public static CommonProxy proxy;


	// Blocks
	public static Block CompactDirt;
	public static Block CompactCobblestone;
	public static Block CompactCoalBlock;
	public static Block CompactNetherrack;
	public static Block CompactGlass;
	public static Block CompactSand;
	public static Block CompactGravel;
	public static Block CompactChest;
	public static Block pressureMachineIdle;
	public static Block pressureMachineActive;
	public static Block GlassBrickBlock;

	public static final ToolMaterial C1IRON = EnumHelper.addToolMaterial(
			"C1IRON", 2, 1000, 7.0F, 3, 14);
	public static final ToolMaterial C1DIAMOND = EnumHelper.addToolMaterial(
			"C1DIAMOND", 3, 6244, 9.0F, 4, 10);
	public static final ToolMaterial C1GOLD = EnumHelper.addToolMaterial(
			"C1GOLD", 0, 128, 13.0F, 0, 22);
	public static final ToolMaterial C1STONE = EnumHelper.addToolMaterial(
			"C1STONE", 1, 524, 5.0F, 2, 5);
	public static final ToolMaterial C1WOOD = EnumHelper.addToolMaterial(
			"C1WOOD", 0, 236, 3.0F, 0, 15);
	public static final ToolMaterial C2IRON = EnumHelper.addToolMaterial(
			"C2IRON", 2, 3600, 10.0F, 5, 14);
	public static final ToolMaterial C2DIAMOND = EnumHelper.addToolMaterial(
			"C2DIAMOND", 3, 20000, 15.0F, 7, 10);
	public static final ToolMaterial C2GOLD = EnumHelper.addToolMaterial(
			"C2GOLD", 0, 450, 18.0F, 0, 22);
	public static final ToolMaterial C2STONE = EnumHelper.addToolMaterial(
			"C2STONE", 1, 1950, 8.0F, 3, 5);
	public static final ToolMaterial C2WOOD = EnumHelper.addToolMaterial(
			"C2WOOD", 0, 900, 4.0F, 0, 15);
	// Configurations

	public static boolean BlockOn;
	public static boolean WorldGenOn;
	public static boolean ToolsOn;
	public static boolean ItemsOn;

	// Items
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
	public static Item CompactRedstoneCrystal;
	public static Item GlassBrick;
	public static Item C1IronShovel;
	public static Item C1DiamondShovel;
	public static Item C1GoldenShovel;
	public static Item C1StoneShovel;
	public static Item C1WoodenShovel;

	// Achievements
	public static AchievementPage CompactCraftingPage;

	public static CompactAchievement achievements;

	// Creative Tabs
	public static CreativeTabs compactTab = new CompactTab("compactTab");

	// Methods

    public static Configuration cfg;

	// Before Initialising (What do to before initialisation)
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {

		// Register Rendering
		proxy.registerRenderThings();

		// Configuration Initialising
		cfg = new Configuration(
				evt.getSuggestedConfigurationFile());

		// Load any previous configurations
		syncConfig();


		// Initialise all the Items
		CompactCoal = new ItemCompactCoal().setUnlocalizedName("CompactCoal");
		C1IronPickaxe = new ItemC1IronPickaxe(C1IRON)
				.setUnlocalizedName("C1IronPickaxe");
		C1DiamondPickaxe = new ItemC1DiamondPickaxe(C1DIAMOND)
				.setUnlocalizedName("C1DiamondPickaxe");
		C1GoldPickaxe = new ItemC1GoldPickaxe(C1GOLD)
				.setUnlocalizedName("C1GoldenPickaxe");
		C1StonePickaxe = new ItemC1StonePickaxe(C1STONE)
				.setUnlocalizedName("C1StonePickaxe");
		C1WoodenPickaxe = new ItemC1WoodenPickaxe(C1WOOD)
				.setUnlocalizedName("C1WoodenPickaxe");
		C2IronPickaxe = new ItemC2IronPickaxe(C2IRON)
				.setUnlocalizedName("C2IronPickaxe");
		C2DiamondPickaxe = new ItemC2DiamondPickaxe(C2DIAMOND)
				.setUnlocalizedName("C2DiamondPickaxe");
		C2GoldPickaxe = new ItemC2GoldPickaxe(C2GOLD)
				.setUnlocalizedName("C2GoldenPickaxe");
		C2StonePickaxe = new ItemC2StonePickaxe(C2STONE)
				.setUnlocalizedName("C2StonePickaxe");
		C2WoodenPickaxe = new ItemC2WoodenPickaxe(C2WOOD)
				.setUnlocalizedName("C2WoodenPickaxe");
		C1IronAxe = new ItemC1IronAxe(C1IRON).setUnlocalizedName("C1IronAxe");
		C1DiamondAxe = new ItemC1DiamondAxe(C1DIAMOND);
		C1GoldAxe = new ItemC1GoldAxe(C1GOLD).setUnlocalizedName("C1GoldenAxe");
		C1StoneAxe = new ItemC1StoneAxe(C1STONE)
				.setUnlocalizedName("C1StoneAxe");
		C1WoodenAxe = new ItemC1WoodenAxe(C1WOOD)
				.setUnlocalizedName("C1WoodenAxe");
		C2IronAxe = new ItemC2IronAxe(C2IRON).setUnlocalizedName("C2IronAxe");
		C2DiamondAxe = new ItemC2DiamondAxe(C2DIAMOND)
				.setUnlocalizedName("C2DiamondAxe");
		C2GoldAxe = new ItemC2GoldAxe(C2GOLD).setUnlocalizedName("C2GoldenAxe");
		C2StoneAxe = new ItemC2StoneAxe(C2STONE)
				.setUnlocalizedName("C2StoneAxe");
		C2WoodenAxe = new ItemC2WoodenAxe(C2WOOD)
				.setUnlocalizedName("C2WoodenAxe");
		/*CompactRedstoneCrystal = new ItemCompactRedstoneCrystal()
				.setUnlocalizedName("CompactRedstoneCrystal");*/
		GlassBrick = new ItemGlassBrick().setUnlocalizedName("GlassBrick");
		C1IronShovel = new ItemC1IronShovel(C1IRON)
				.setUnlocalizedName("C1IronShovel");
		C1DiamondShovel = new ItemC1DiamondShovel(C1DIAMOND)
				.setUnlocalizedName("C1DiamondShovel");
		C1GoldenShovel = new ItemC1GoldenShovel(C1GOLD)
				.setUnlocalizedName("C1GoldenShovel");
		C1StoneShovel = new ItemC1StoneShovel(C1STONE)
				.setUnlocalizedName("C1StoneShovel");
		C1WoodenShovel = new ItemC1WoodenShovel(C1WOOD)
				.setUnlocalizedName("C1WoodenShovel");

		// Initialise all the Blocks
		CompactCobblestone = new BlockCompactCobblestone(Material.rock)
				.setHardness(3.2F).setResistance(4.0F)
				.setBlockName("CompactCobblestone");

		CompactCoalBlock = new BlockCompactCoalBlock(Material.rock)
				.setHardness(3.0F).setBlockName("CompactCoalBlock");

		CompactNetherrack = new BlockCompactNetherrack(Material.rock)
				.setHardness(0.44F).setBlockName("CompactNetherrack");

		CompactDirt = new BlockCompactDirt(Material.ground).setHardness(0.6F)
				.setBlockName("CompactDirt");

		CompactGlass = new BlockCompactGlass(Material.glass, false)
				.setHardness(0.3F).setBlockName("CompactGlass");

		CompactSand = new BlockCompactSand().setHardness(0.6F).setBlockName(
				"CompactSand");

		CompactGravel = new BlockCompactGravel().setHardness(0.7F)
				.setBlockName("CompactGravel");

		// CompactChest = new BlockCompactChest(Material.wood).setHardness(
		// 0.7F).setBlockName("CompactChest");

		/*pressureMachineIdle = new BlockPressureMachine(false, Material.iron)
				.setHardness(0.7F).setCreativeTab(this.compactTab)
				.setBlockName("PressureMachineIdle");*/

		GlassBrickBlock = new BlockGlassBrickBlock(Material.glass, false)
				.setHardness(0.3F).setBlockName("GlassBrickBlock");

		// Registering Blocks

		if (BlockOn) {
			GameRegistry
					.registerBlock(CompactCobblestone, "CompactCobblestone");

			//GameRegistry.registerBlock(CompactCoalBlock, "CompactCoalBlock");

			GameRegistry.registerBlock(CompactNetherrack, "CompactNetherrack");

			GameRegistry.registerBlock(CompactDirt, "CompactDirt");

			GameRegistry.registerBlock(CompactGlass, "CompactGlass");

			GameRegistry.registerBlock(CompactSand, "CompactSand");

			GameRegistry.registerBlock(CompactGravel, "CompactGravel");

			GameRegistry.registerBlock(GlassBrickBlock, "GlassBrickBlock");
		}

		if (ItemsOn) {
			// Register Items
			//GameRegistry.registerItem(CompactCoal, "CompactCoal");
			/*GameRegistry.registerItem(CompactRedstoneCrystal,
					"CompactRedstoneCrystal");*/
			GameRegistry.registerItem(GlassBrick, "GlassBrick");
		}
		
		if(ToolsOn)
		{
			GameRegistry.registerItem(C1DiamondAxe, "C1DiamondAxe");
			GameRegistry.registerItem(C1DiamondPickaxe, "C1DiamondPickaxe");
			GameRegistry.registerItem(C1DiamondShovel, "C1DiamondShovel");

			GameRegistry.registerItem(C1GoldAxe, "C1GoldAxe");
			GameRegistry.registerItem(C1GoldPickaxe, "C1GoldPickaxe");
			GameRegistry.registerItem(C1GoldenShovel, "C1GoldenShovel");

			GameRegistry.registerItem(C1IronAxe, "C1IronAxe");
			GameRegistry.registerItem(C1IronPickaxe, "C1IronPickaxe");
			GameRegistry.registerItem(C1IronShovel, "C1IronShovel");

			GameRegistry.registerItem(C1StoneAxe, "C1StoneAxe");
			GameRegistry.registerItem(C1StonePickaxe, "C1StonePickaxe");
			GameRegistry.registerItem(C1StoneShovel, "C1StoneShovel");

			GameRegistry.registerItem(C1WoodenAxe, "C1WoodenAxe");
			GameRegistry.registerItem(C1WoodenPickaxe, "C1WoodenPickaxe");
			GameRegistry.registerItem(C1WoodenShovel, "C1WoodenShovel");

			GameRegistry.registerItem(C2DiamondAxe, "C2DiamondAxe");
			GameRegistry.registerItem(C2DiamondPickaxe, "C2DiamondPickaxe");

			GameRegistry.registerItem(C2GoldAxe, "C2GoldAxe");
			GameRegistry.registerItem(C2GoldPickaxe, "C2GoldPickaxe");

			GameRegistry.registerItem(C2IronAxe, "C2IronAxe");
			GameRegistry.registerItem(C2IronPickaxe, "C2IronPickaxe");

			GameRegistry.registerItem(C2StoneAxe, "C2StoneAxe");
			GameRegistry.registerItem(C2StonePickaxe, "C2StonePickaxe");

			GameRegistry.registerItem(C2WoodenAxe, "C2WoodenAxe");
			GameRegistry.registerItem(C2WoodenPickaxe, "C2WoodenPickaxe");
		}
		// Initialise Achievements
		achievements = new CompactAchievement();

	}

    public static void syncConfig()
    {
        try {

            BlockOn = cfg
                    .get(Configuration.CATEGORY_GENERAL,
                            "Compact Blocks On or Off", true,
                            "Set to false to disable all Compact Blocks, and set to true to enable them")
                    .getBoolean(true);
            ItemsOn = cfg.get(Configuration.CATEGORY_GENERAL, "Compact Items On or Off", true,
                    "Set to false to disable all Compact Items, and set to true to enable them")
                    .getBoolean(true);
            ToolsOn = cfg.get(Configuration.CATEGORY_GENERAL, "Compact Tools On or Off", true,
                    "Set to false to disable all Compact Tools, and set to true to enable them")
                    .getBoolean(true);
            WorldGenOn = cfg
                    .get(Configuration.CATEGORY_GENERAL,
                            "World Generation on or off",
                            true,
                            "Set to 0 to disable Compact Crafting world generation, and set to 1 to enable it")
                    .getBoolean(true);

        } catch (Exception e) {
            // FMLLog.log(Level.SEVERE,
            // "Compact Crafting has trouble loading config", e);
        } finally {

            // Save the Configuration
            if(cfg.hasChanged()) cfg.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.modID.equals("CC"))
            syncConfig();
    }

	// Initialising (What do to during initialisation)
	@EventHandler
	public void load(FMLInitializationEvent evt) {

		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);

		/*GameRegistry.registerTileEntity(TilePressureMachine.class,
				"pressuremachine");*/

		// Handlers
		FMLCommonHandler.instance().bus().register(new EventListener());

		//GameRegistry.registerBlock(pressureMachineIdle, "PressureMachineIdle");

		// Registering Names for Blocks

		//LanguageRegistry.addName(pressureMachineIdle, "Pressure Machine");

		// Registering Names for Items
		//LanguageRegistry.instance().addNameForObject(CompactCoal, "en_US",
		//		"Compact Coal");
		/*LanguageRegistry.addName(CompactRedstoneCrystal,
				"Compact Redstone Crystal");*/
		LanguageRegistry.addName(GlassBrick, "Glass Brick");

		LanguageRegistry.addName(C1IronPickaxe, "|Iron Pickaxe|");
		LanguageRegistry.addName(C1DiamondPickaxe, "|Diamond Pickaxe|");
		LanguageRegistry.instance().addNameForObject(C1GoldPickaxe, "en_US",
				"|Golden Pickaxe|");
		LanguageRegistry.instance().addNameForObject(C1StonePickaxe, "en_US",
				"|Stone Pickaxe|");
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
		LanguageRegistry.addName(C1IronShovel, "|Iron Shovel|");
		LanguageRegistry.addName(C1DiamondShovel, "|Diamond Shovel|");
		LanguageRegistry.addName(C1GoldenShovel, "|Golden Shovel|");
		LanguageRegistry.addName(C1StoneShovel, "|Stone Shovel|");
		LanguageRegistry.addName(C1WoodenShovel, "|Wooden Shovel|");

		// Registering Names for others
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.compactTab", "en_US", "Compact Crafting");

		// Achievement Pages, Names and Descriptions

		this.addAchievementName("compactBlockAchievement", "Compact Something");
		this.addAchievementDesc("compactBlockAchievement",
				"Compact a raw material using the workbench.");

		this.addAchievementName("compactGlassAchievement", "Compact Smelting");
		this.addAchievementDesc("compactGlassAchievement",
				"Smelt Compact Sand to get Compact Glass");

		CompactCraftingPage = new AchievementPage("Compact Crafting",
				achievements.compactBlockAchieve,
				achievements.compactGlassAchieve);
		AchievementPage.registerAchievementPage(CompactCraftingPage);

		// Registering others

		GameRegistry.registerFuelHandler(new CompactFuel());

		if (WorldGenOn) {
			GameRegistry.registerWorldGenerator(new WorldGeneratorCCB(), 1);
			GameRegistry.registerWorldGenerator(new WorldGeneratorCNR(), 2);
		}
		// Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(this.CompactCobblestone, 1),
				new Object[] { "XXX", "XXX", "XXX", 'X', Blocks.cobblestone });
		//GameRegistry.addRecipe(new ItemStack(this.CompactCoal), new Object[] {
		//		"   ", "XX ", "XX ", 'X', Items.coal });
//		GameRegistry.addRecipe(new ItemStack(this.CompactRedstoneCrystal),
//				new Object[] { "   ", "XX ", "XX ", 'X', Items.redstone });
		GameRegistry.addRecipe(new ItemStack(this.GlassBrickBlock),
				new Object[] { "   ", "XX ", "XX ", 'X', this.GlassBrick });
		GameRegistry.addRecipe(new ItemStack(this.CompactCoalBlock),
				new Object[] { "XXX", "XXX", "XXX", 'X', CCMain.CompactCoal });
		GameRegistry.addRecipe(new ItemStack(this.CompactNetherrack),
				new Object[] { "XXX", "XXX", "XXX", 'X', Blocks.netherrack });
		GameRegistry.addRecipe(new ItemStack(this.CompactDirt), new Object[] {
				"XXX", "XXX", "XXX", 'X', Blocks.dirt });
		GameRegistry.addRecipe(new ItemStack(this.CompactSand), new Object[]{
				"XXX", "XXX", "XXX", 'X', Blocks.sand});

		// Shapeless Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 9),
				CCMain.CompactCobblestone);
		//GameRegistry.addShapelessRecipe(new ItemStack(Items.coal, 4),
				//CCMain.CompactCoal);
		//GameRegistry.addShapelessRecipe(new ItemStack(CCMain.CompactCoal, 9),
				//CCMain.CompactCoalBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.netherrack, 9),
				CCMain.CompactNetherrack);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dirt, 9),
				CCMain.CompactDirt);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 9),
				CCMain.CompactSand);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronPickaxe, 1),
				Items.iron_pickaxe, Items.iron_pickaxe, Items.iron_pickaxe,
				Items.iron_pickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondPickaxe,
				1), Items.diamond_pickaxe, Items.diamond_pickaxe,
				Items.diamond_pickaxe, Items.diamond_pickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldPickaxe, 1),
				Items.golden_pickaxe, Items.golden_pickaxe,
				Items.golden_pickaxe, Items.golden_pickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1StonePickaxe, 1), Items.stone_pickaxe,
				Items.stone_pickaxe, Items.stone_pickaxe, Items.stone_pickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1WoodenPickaxe, 1), Items.wooden_pickaxe,
				Items.wooden_pickaxe, Items.wooden_pickaxe,
				Items.wooden_pickaxe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronPickaxe, 1),
				CCMain.C1IronPickaxe, CCMain.C1IronPickaxe,
				CCMain.C1IronPickaxe, CCMain.C1IronPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondPickaxe,
				1), CCMain.C1DiamondPickaxe, CCMain.C1DiamondPickaxe,
				CCMain.C1DiamondPickaxe, CCMain.C1DiamondPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldPickaxe, 1),
				CCMain.C1GoldPickaxe, CCMain.C1GoldPickaxe,
				CCMain.C1GoldPickaxe, CCMain.C1GoldPickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C2StonePickaxe, 1), CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe, CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C2WoodenPickaxe, 1),
				CCMain.C1WoodenPickaxe, CCMain.C1WoodenPickaxe,
				CCMain.C1WoodenPickaxe, CCMain.C1WoodenPickaxe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronAxe, 1),
				Items.iron_axe, Items.iron_axe, Items.iron_axe, Items.iron_axe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondAxe, 1),
				Items.diamond_axe, Items.diamond_axe, Items.diamond_axe,
				Items.diamond_axe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldAxe, 1),
				Items.golden_axe, Items.golden_axe, Items.golden_axe,
				Items.golden_axe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StoneAxe, 1),
				Items.stone_axe, Items.stone_axe, Items.stone_axe,
				Items.stone_axe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1WoodenAxe, 1),
				Items.wooden_axe, Items.wooden_axe, Items.wooden_axe,
				Items.wooden_axe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronAxe, 1),
				CCMain.C1IronAxe, CCMain.C1IronAxe, CCMain.C1IronAxe,
				CCMain.C1IronAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondAxe, 1),
				CCMain.C1DiamondAxe, CCMain.C1DiamondAxe, CCMain.C1DiamondAxe,
				CCMain.C1DiamondAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldAxe, 1),
				CCMain.C1GoldAxe, CCMain.C1GoldAxe, CCMain.C1GoldAxe,
				CCMain.C1GoldAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2StoneAxe, 1),
				CCMain.C1StoneAxe, CCMain.C1StoneAxe, CCMain.C1StoneAxe,
				CCMain.C1StoneAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2WoodenAxe, 1),
				CCMain.C1WoodenAxe, CCMain.C1WoodenAxe, CCMain.C1WoodenAxe,
				CCMain.C1WoodenAxe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronShovel, 1),
				Items.iron_shovel, Items.iron_shovel, Items.iron_shovel,
				Items.iron_shovel);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1DiamondShovel, 1), Items.diamond_shovel,
				Items.diamond_shovel, Items.diamond_shovel,
				Items.diamond_shovel);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1GoldenShovel, 1), Items.golden_shovel,
				Items.golden_shovel, Items.golden_shovel, Items.golden_shovel);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StoneShovel, 1),
				Items.stone_shovel, Items.stone_shovel, Items.stone_shovel,
				Items.stone_shovel);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1WoodenShovel, 1), Items.wooden_shovel,
				Items.wooden_shovel, Items.wooden_shovel, Items.wooden_shovel);

		// Smelting Recipes
		GameRegistry.addSmelting(CCMain.CompactSand, new ItemStack(
				CCMain.CompactGlass), 5);
		GameRegistry.addSmelting(CCMain.CompactGlass, new ItemStack(CCMain.GlassBrick, 4), 5);

	}

	// Method to add an Achievement Name
	private void addAchievementName(String ach, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,
				"en_US", name);
	}

	// Method to add an Achievement Description
	private void addAchievementDesc(String ach, String desc) {
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + ach + ".desc", "en_US", desc);
	}

	// Post Initialising (What do to after initialisation)
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

}
