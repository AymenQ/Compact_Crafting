package moony.compactcrafting.core.handler;

import net.minecraftforge.common.Configuration;

import moony.compactcrafting.lib.ItemIDs;
import moony.compactcrafting.lib.BlockIDs;

public class ConfigurationHandler {

    public static Configuration config;

    public static void init(File configFile) {

        config = new Configuration(configFile);

        try {
            
            config.load();
            
            ItemIDs.C1IronPickaxeID = config.getItem("C1IronPickaxe", ItemIDs.C1IronPickaxeID_Default).getInt(ItemIDs.C1IronPickaxeID_Default);
            ItemIDs.C1DiamondPickaxeID = config.getItem("C1DiamondPickaxe", ItemIDs.C1DiamondPickaxeID_Default).getInt(ItemIDs.C1DiamondPickaxeID_Default);
            ItemIDs.C1GoldPickaxeID = config.getItem("C1GoldPickaxe", ItemIDs.C1GoldPickaxeID_Default).getInt(ItemIDs.C1GoldDiamondPickaxeID_Default);
            ItemIDs.C1StonePickaxeID = config.getItem("C1StonePickaxe", ItemIDs.C1StonePickaxeID_Default).getInt(ItemIDs.C1StonePickaxeID_Default);
            ItemIDs.C1WoodenPickaxeID = config.getItem("C1WoodenPickaxe", ItemIDs.C1WoodenPickaxeID_Default).getInt(ItemIDs.C1WoodenPickaxeID_Default);
            
            ItemIDs.C2IronPickaxeID = config.getItem("C2IronPickaxe", ItemIDs.C2IronPickaxeID_Default).getInt(ItemIDs.C2IronPickaxeID_Default);
            ItemIDs.C2DiamondPickaxeID = config.getItem("C2DiamondPickaxe", ItemIDs.C2DiamondPickaxeID_Default).getInt(ItemIDs.C2DiamondPickaxeID_Default);
            ItemIDs.C2GoldPickaxeID = config.getItem("C2GoldPickaxe", ItemIDs.C2GoldPickaxeID_Default).getInt(ItemIDs.C2GoldDiamondPickaxeID_Default);
            ItemIDs.C2StonePickaxeID = config.getItem("C2StonePickaxe", ItemIDs.C2StonePickaxeID_Default).getInt(ItemIDs.C2StonePickaxeID_Default);
            ItemIDs.C2WoodenPickaxeID = config.getItem("C2WoodenPickaxe", ItemIDs.C2WoodenPickaxeID_Default).getInt(ItemIDs.C2WoodenPickaxeID_Default);
            
            ItemIDs.C1IronAxeID = config.getItem("C1IronAxe", ItemIDs.C1IronAxeID_Default).getInt(ItemIDs.C1IronAxeID_Default);
            ItemIDs.C1DiamondAxeID = config.getItem("C1DiamondAxe", ItemIDs.C1DiamondAxeID_Default).getInt(ItemIDs.C1DiamondAxeID_Default);
            ItemIDs.C1GoldAxeID = config.getItem("C1GoldAxe", ItemIDs.C1GoldAxeID_Default).getInt(ItemIDs.C1GoldDiamondAxeID_Default);
            ItemIDs.C1StoneAxeID = config.getItem("C1StoneAxe", ItemIDs.C1StoneAxeID_Default).getInt(ItemIDs.C1StoneAxeID_Default);
            ItemIDs.C1WoodenAxeID = config.getItem("C1WoodenAxe", ItemIDs.C1WoodenAxeID_Default).getInt(ItemIDs.C1WoodenAxeID_Default);
            
            ItemIDs.C2IronAxeID = config.getItem("C2IronAxe", ItemIDs.C2IronAxeID_Default).getInt(ItemIDs.C2IronAxeID_Default);
            ItemIDs.C2DiamondAxeID = config.getItem("C2DiamondAxe", ItemIDs.C2DiamondAxeID_Default).getInt(ItemIDs.C2DiamondAxeID_Default);
            ItemIDs.C2GoldAxeID = config.getItem("C2GoldAxe", ItemIDs.C2GoldAxeID_Default).getInt(ItemIDs.C2GoldDiamondAxeID_Default);
            ItemIDs.C2StoneAxeID = config.getItem("C2StoneAxe", ItemIDs.C2StoneAxeID_Default).getInt(ItemIDs.C2StoneAxeID_Default);
            ItemIDs.C2WoodenAxeID = config.getItem("C2WoodenAxe", ItemIDs.C2WoodenAxeID_Default).getInt(ItemIDs.C2WoodenAxeID_Default);
            
            BlockIDs.CompactCobblestoneID = config.getBlock("CompactCobblestone", BlockIDs.CompactCobblestoneID_Default).getInt(BlockIDs.CompactCobblestoneID_Default);
            BlockIDs.CompactCoalBlockID = config.getBlock("CompactCoalBlock", BlockIDs.CompactCoalBlockID_Default).getInt(BlockIDs.CompactCoalBlockID_Default);
            BlockIDs.CompactNetherrackID = config.getBlock("CompactNetherrack", BlockIDs.CompactNetherrackID_Default).getInt(BlockIDs.CompactNetherrackID_Default);
            BlockIDs.CompactDirtID = config.getBlock("CompactDirt", BlockIDs.CompactDirtID_Default).getInt(BlockIDs.CompactDirtID_Default);
            BlockIDs.CompactSandID = config.getBlock("CompactSand", BlockIDs.CompactSandID_Default).getInt(BlockIDs.CompactSandID_Default);
            BlockIDs.CompactGlassID = config.getBlock("CompactGlass", BlockIDs.CompactGlassID_Default).getInt(BlockIDs.CompactGlassID_Default);
            
        } catch(Exception e) {
            //TODO Do stuff here
        } finally {
            config.save();
        }

    }

}
