package com.cyanwarriorswords.cyanwarriorswordsmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringTranslate;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;

import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceBeast;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceDark;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceEarth;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceEnder;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceFire;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceLight;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceMixed;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceThunder;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceWater;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Essences.ItemEssenceWind;
import com.cyanwarriorswords.cyanwarriorswordsmod.Items.Other.ItemSwordHandle;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.BeastType.ItembeastSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.BeastType.ItemwolfSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.CyanType.ItemcyanSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.DarkType.ItemdarkNetherSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.DarkType.ItemdarkSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.EarthType.ItemearthSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.EarthType.ItempeacefulNatureSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.EarthType.ItemwildNatureSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.EnderType.ItemenderPortalSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.EnderType.ItemenderSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.FireType.ItemfireSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.FireType.ItemmeteorSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.LightType.ItemlightNetherSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.LightType.ItemlightSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemenderFireSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemenderThunderSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemenderWindSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemmeteoricthunderstormSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemsteamSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemthunderstormSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemtimeSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing.ItemtrienderSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.ThunderType.ItemthunderShockSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.ThunderType.ItemthunderSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WaterType.ItemblizzardSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WaterType.ItemiceSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WaterType.ItemwaterSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WindType.ItemwindBlastSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WindType.ItemwindSword;
import com.cyanwarriorswords.cyanwarriorswordsmod.Swords.WindType.ItemwindWhirlSword;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = CyanWarriorSwordMod.MODID, version = CyanWarriorSwordMod.VERSION)
public class CyanWarriorSwordMod
{
    public static final String MODID = "Cyan Warrior Swords Mod";
    public static final String VERSION = "2.0.3";
    
    @Metadata
    public static ModMetadata meta;
    
    public static Item fireSword;
    public int fireSwordID = 5240;
    public static Item darkSword;
    public int darkSwordID = 5241;
    public static Item earthSword;
    public int earthSwordID = 5242;
    public static Item enderSword;
    public int enderSwordID = 5243;
    public static Item lightSword;
    public int lightSwordID = 5244;
    public static Item meteorSword;
    public int meteorSwordID = 5245;
    public static Item peacefulNatureSword;
    public int peacefulNatureSwordID = 5246;
    public static Item thunderSword;
    public int thunderSwordID = 5247;
    public static Item waterSword;
    public int waterSwordID = 5248;
    public static Item wildNatureSword;
    public int wildNatureSwordID = 5249;
    public static Item windSword;
    public int windSwordID = 5250;
    public static Item thunderstormSword;
    public int thunderstormSwordID = 5251;
    public static Item iceSword;
    public int iceSwordID = 5252;
    public static Item meteoricthunderstormSword;
    public int meteoricthunderstormSwordID = 5253;
    public static Item enderFireSword;
    public int enderFireSwordID = 5254;
    public static Item enderThunderSword;
    public int enderThunderSwordID = 5255;
    public static Item enderWindSword;
    public int enderWindSwordID = 5256;
    public static Item thunderShockSword;
    public int thunderShockSwordID = 5257;
    public static Item timeSword;
    public int timeSwordID = 5258;
    public static Item beastSword;
    public int beastSwordID = 5261;
    public static Item windBlastSword;
    public int windBlastSwordID = 5259;
    public static Item darkNetherSword;
    public int darkNetherSwordID = 5262;
    public static Item lightNetherSword;
    public int lightNetherSwordID = 5263;
    public static Item enderPortalSword;
    public int enderPortalSwordID = 5264;
    public static Item trienderSword;
    public int trienderSwordID = 5265;
    public static Item steamSword;
    public int steamSwordID = 5266;
    public static Item blizzardSword;
    public int blizzardSwordID = 5267;
    public static Item windWhirlSword;
    public int windWhirlSwordID = 5260;
    public static Item wolfSword;
    public int wolfSwordID = 5268;
    public static Item cyanSword;
    public int cyanSwordID = 5269;
    public static Item EssenceFire;
    public int EssenceFireID = 5270;
    public static Item EssenceBeast;
    public int EssenceBeastID = 5271;
    public static Item EssenceDark;
    public int EssenceDarkID = 5272;
    public static Item EssenceEarth;
    public int EssenceEarthID = 5273;
    public static Item EssenceEnder;
    public int EssenceEnderID = 5274;
    public static Item EssenceLight;
    public int EssenceLightID = 5275;
    public static Item EssenceThunder;
    public int EssenceThunderID = 5276;
    public static Item EssenceWater;
    public int EssenceWaterID = 5277;
    public static Item EssenceWind;
    public int EssenceWindID = 5278;
    public static Item EssenceMixed;
    public int EssenceMixedID = 5279;
    public static Item SwordHandle;
    public int SwordHandleID = 5280;
    
    public static CreativeTabs CyanSwordTab = new CreativeTabs("Cyan_Warrior_Swords")
    {
      public Item getTabIconItem()
      {
        return cyanSword;
      }
    };
    
	/*Materials*/
	
	public static ToolMaterial Dam5 = EnumHelper.addToolMaterial("Dam5", 1, 3000, 10.0F, 1, 20);
	public static ToolMaterial Dam6 = EnumHelper.addToolMaterial("Dam6", 1, 3000, 10.0F, 2, 20);
	public static ToolMaterial Dam7 = EnumHelper.addToolMaterial("Dam7", 1, 3000, 10.0F, 3, 20);
	public static ToolMaterial Dam8 = EnumHelper.addToolMaterial("Dam8", 1, 3000, 10.0F, 4, 20);
	public static ToolMaterial Dam9 = EnumHelper.addToolMaterial("Dam9", 1, 3000, 10.0F, 5, 20);
	public static ToolMaterial Dam10 = EnumHelper.addToolMaterial("Dam10", 1, 3000, 10.0F, 6.0F, 20);
	public static ToolMaterial Dam11 = EnumHelper.addToolMaterial("Dam11", 1, 3000, 10.0F, 7.0F, 20);
	public static ToolMaterial Dam12 = EnumHelper.addToolMaterial("Dam12", 1, 3000, 10.0F, 8.0F, 20);
	public static ToolMaterial Dam20 = EnumHelper.addToolMaterial("Dam20", 1, 3000, 10.0F, 16.0F, 20);
	public static ToolMaterial Dam23 = EnumHelper.addToolMaterial("Dam23", 1, 3000, 10.0F, 19.0F, 20);
	public static ToolMaterial Bow = EnumHelper.addToolMaterial("Bow", 1, 1500, 10.0F, 0, 10);
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	fireSword = new ItemfireSword(fireSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("FireSword").setCreativeTab(CyanSwordTab);
    	darkSword = new ItemdarkSword(darkSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("DarkSword").setCreativeTab(CyanSwordTab);
    	earthSword = new ItemearthSword(earthSwordID, CyanWarriorSwordMod.Dam7).setUnlocalizedName("EarthSword").setCreativeTab(CyanSwordTab);
		enderSword = new ItemenderSword(enderSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("EnderSword").setCreativeTab(CyanSwordTab);
		lightSword = new ItemlightSword(lightSwordID, CyanWarriorSwordMod.Dam7).setUnlocalizedName("LightSword").setCreativeTab(CyanSwordTab);
		meteorSword = new ItemmeteorSword(meteorSwordID, CyanWarriorSwordMod.Dam10).setUnlocalizedName("MeteorSword").setCreativeTab(CyanSwordTab);
		peacefulNatureSword = new ItempeacefulNatureSword(peacefulNatureSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("PeacefulNatureSword").setCreativeTab(CyanSwordTab);
		thunderSword = new ItemthunderSword(thunderSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("ThunderSword").setCreativeTab(CyanSwordTab);
		waterSword = new ItemwaterSword(waterSwordID, CyanWarriorSwordMod.Dam7).setUnlocalizedName("WaterSword").setCreativeTab(CyanSwordTab);
		wildNatureSword = new ItemwildNatureSword(wildNatureSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("WildNatureSword").setCreativeTab(CyanSwordTab);
		windSword = new ItemwindSword(windSwordID, CyanWarriorSwordMod.Dam7).setUnlocalizedName("WindSword").setCreativeTab(CyanSwordTab);
		thunderstormSword = new ItemthunderstormSword(thunderstormSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("ThunderStormSword").setCreativeTab(CyanSwordTab);
		iceSword = new ItemiceSword(iceSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("IceSword").setCreativeTab(CyanSwordTab);
		meteoricthunderstormSword = new ItemmeteoricthunderstormSword(meteoricthunderstormSwordID, CyanWarriorSwordMod.Dam11).setUnlocalizedName("MeteoricThunderStormSword").setCreativeTab(CyanSwordTab);
		enderFireSword = new ItemenderFireSword(enderFireSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("EnderFireSword").setCreativeTab(CyanSwordTab);
		enderThunderSword = new ItemenderThunderSword(enderThunderSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("EnderThunderSword").setCreativeTab(CyanSwordTab);
		enderWindSword = new ItemenderWindSword(enderWindSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("EnderWindSword").setCreativeTab(CyanSwordTab);
		thunderShockSword = new ItemthunderShockSword(thunderShockSwordID, CyanWarriorSwordMod.Dam10).setUnlocalizedName("ThunderShockSword").setCreativeTab(CyanSwordTab);
		timeSword = new ItemtimeSword(timeSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("TimeSword").setCreativeTab(CyanSwordTab);
		beastSword = new ItembeastSword(beastSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("BeastSword").setCreativeTab(CyanSwordTab);
		windBlastSword = new ItemwindBlastSword(windBlastSwordID, CyanWarriorSwordMod.Dam8).setUnlocalizedName("WindBlastSword").setCreativeTab(CyanSwordTab);
		darkNetherSword = new ItemdarkNetherSword(darkNetherSwordID, CyanWarriorSwordMod.Dam10).setUnlocalizedName("DarkNetherSword").setCreativeTab(CyanSwordTab);
		lightNetherSword = new ItemlightNetherSword(lightNetherSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("LightNetherSword").setCreativeTab(CyanSwordTab);
		enderPortalSword = new ItemenderPortalSword(enderPortalSwordID, CyanWarriorSwordMod.Dam10).setUnlocalizedName("EnderPortalSword").setCreativeTab(CyanSwordTab);
		trienderSword = new ItemtrienderSword(trienderSwordID, CyanWarriorSwordMod.Dam11).setUnlocalizedName("TriEnderSword").setCreativeTab(CyanSwordTab);
		steamSword = new ItemsteamSword(steamSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("SteamSword").setCreativeTab(CyanSwordTab);
		blizzardSword = new ItemblizzardSword(blizzardSwordID, CyanWarriorSwordMod.Dam11).setUnlocalizedName("BlizzardSword").setCreativeTab(CyanSwordTab);
		windWhirlSword = new ItemwindWhirlSword(windWhirlSwordID, CyanWarriorSwordMod.Dam9).setUnlocalizedName("WindWhirlSword").setCreativeTab(CyanSwordTab);
		wolfSword = new ItemwolfSword(wolfSwordID, CyanWarriorSwordMod.Dam10).setUnlocalizedName("WolfSword").setCreativeTab(CyanSwordTab);
		cyanSword = new ItemcyanSword(cyanSwordID, Dam23).setUnlocalizedName("CyanSword").setCreativeTab(CyanSwordTab);
		
		EssenceFire = new ItemEssenceFire(EssenceFireID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceFire").setCreativeTab(CyanSwordTab);
		EssenceBeast = new ItemEssenceBeast(EssenceBeastID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceBeast").setCreativeTab(CyanSwordTab);
		EssenceDark = new ItemEssenceDark(EssenceDarkID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceDark").setCreativeTab(CyanSwordTab);
		EssenceEarth = new ItemEssenceEarth(EssenceEarthID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceEarth").setCreativeTab(CyanSwordTab);
		EssenceEnder = new ItemEssenceEnder(EssenceEnderID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceEnder").setCreativeTab(CyanSwordTab);
		EssenceLight = new ItemEssenceLight(EssenceLightID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceLight").setCreativeTab(CyanSwordTab);
		EssenceThunder = new ItemEssenceThunder(EssenceThunderID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceThunder").setCreativeTab(CyanSwordTab);
		EssenceWater = new ItemEssenceWater(EssenceWaterID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceWater").setCreativeTab(CyanSwordTab);
		EssenceWind = new ItemEssenceWind(EssenceWindID, CyanWarriorSwordMod.Bow).setUnlocalizedName("EssenceWind").setCreativeTab(CyanSwordTab);
		
		SwordHandle = new ItemSwordHandle(SwordHandleID, CyanWarriorSwordMod.Bow).setUnlocalizedName("SwordHandle").setCreativeTab(CyanSwordTab);
		EssenceMixed = new ItemEssenceMixed(this.EssenceMixedID, Bow).setUnlocalizedName("EssenceMixed").setCreativeTab(CyanSwordTab);
		
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(EssenceFire), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(EssenceThunder), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceEarth), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(EssenceLight), 1, 1, 2));		
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceDark), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceWater), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceBeast), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER, new WeightedRandomChestContent(new ItemStack(EssenceWind), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(EssenceEnder), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(EssenceEnder), 1, 1, 2));
		
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceFire), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceThunder), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceLight), 1, 1, 2));		
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceDark), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceWater), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceBeast), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceWind), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceEnder), 1, 1, 2));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(EssenceEnder), 1, 1, 2));
		
        gameRegisters();
		
		languageRegisters();
    }
    
    private static void gameRegisters(){
		/*Item Registring*/
    	GameRegistry.registerItem(fireSword, "FireSword");
    	GameRegistry.registerItem(darkSword, "DarkSword");
    	GameRegistry.registerItem(earthSword, "EarthSword");
    	GameRegistry.registerItem(enderSword, "EnderSword");
    	GameRegistry.registerItem(lightSword, "LightSword");
    	GameRegistry.registerItem(meteorSword, "MeteorSword");
		GameRegistry.registerItem(peacefulNatureSword, "PeacefulNatureSword");
		GameRegistry.registerItem(thunderSword, "ThunderSword");
		GameRegistry.registerItem(waterSword, "WaterSword");
		GameRegistry.registerItem(wildNatureSword, "WildNatureSword");
		GameRegistry.registerItem(windSword, "WindSword");
		GameRegistry.registerItem(thunderstormSword, "ThunderStormSword");
		GameRegistry.registerItem(meteoricthunderstormSword, "MeteoricThunderstormSword");
		GameRegistry.registerItem(enderFireSword, "EnderFireSword");
		GameRegistry.registerItem(iceSword, "IceSword");
		GameRegistry.registerItem(enderWindSword, "EnderWindSword");
		GameRegistry.registerItem(enderThunderSword, "EnderThunderSword");
		GameRegistry.registerItem(thunderShockSword, "ThunderShockSword");
		GameRegistry.registerItem(timeSword, "TimeSword");
		GameRegistry.registerItem(beastSword, "BeastSword");
		GameRegistry.registerItem(windBlastSword, "WindBlastSword");
		GameRegistry.registerItem(darkNetherSword, "DarkNetherSword");
		GameRegistry.registerItem(lightNetherSword, "LightNetherSword");
		GameRegistry.registerItem(enderPortalSword, "EnderPortalSword");
		GameRegistry.registerItem(trienderSword, "TriEnderSword");
		GameRegistry.registerItem(steamSword, "SteamSword");
		GameRegistry.registerItem(windWhirlSword, "WindWhirlSword");
		GameRegistry.registerItem(wolfSword, "WolfSword");
		GameRegistry.registerItem(cyanSword, "CyanSword");
		GameRegistry.registerItem(EssenceFire, "EssenceFire");
		GameRegistry.registerItem(EssenceBeast, "EssenceBeast");
		GameRegistry.registerItem(EssenceDark, "EssenceDark");
		GameRegistry.registerItem(EssenceEarth, "EssenceEarth");
		GameRegistry.registerItem(EssenceEnder, "EssenceEnder");
		GameRegistry.registerItem(EssenceLight, "EssenceLight");
		GameRegistry.registerItem(EssenceThunder, "EssenceThunder");
		GameRegistry.registerItem(EssenceWater, "EssenceWater");
		GameRegistry.registerItem(EssenceWind, "EssenceWind");
		GameRegistry.registerItem(EssenceMixed, "EssenceMixed");
		GameRegistry.registerItem(SwordHandle, "SwordHandle");
		
    	/*Recipes*/
		
        GameRegistry.addRecipe(new ItemStack(fireSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.blaze_powder, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });  
		GameRegistry.addRecipe(new ItemStack(darkSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Blocks.obsidian, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(earthSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Blocks.dirt, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(enderSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.ender_pearl, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(lightSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.glowstone_dust, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(meteorSword, 1),
				new Object[] { " C ", "BPB", "BFB", Character.valueOf('B'), Items.blaze_powder, Character.valueOf('P'), Items.blaze_rod, Character.valueOf('F'), new ItemStack(fireSword), Character.valueOf('C'), Items.fire_charge });
		GameRegistry.addRecipe(new ItemStack(peacefulNatureSword, 1),
				new Object[] { " S ", " C ", "SAS", Character.valueOf('S'), Blocks.sapling, Character.valueOf('C'), Items.reeds, Character.valueOf('A'), new ItemStack(earthSword) });
		GameRegistry.addRecipe(new ItemStack(thunderSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.redstone, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(waterSword, 1),
				new Object[] { "GBG", "GBG", " P ", Character.valueOf('B'), Items.water_bucket, Character.valueOf('P'), Items.stick, Character.valueOf('G'), Blocks.glass });
		GameRegistry.addRecipe(new ItemStack(wildNatureSword, 1),
				new Object[] { " S ", " C ", "SAS", Character.valueOf('S'), Blocks.cactus, Character.valueOf('C'), Items.reeds, Character.valueOf('A'), new ItemStack(peacefulNatureSword) });
		GameRegistry.addRecipe(new ItemStack(windSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.feather, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(thunderstormSword, 1),
				new Object[] { " I ", "TIW", " S ", Character.valueOf('W'), new ItemStack(windSword), Character.valueOf('T'), new ItemStack(thunderSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(meteoricthunderstormSword, 1),
				new Object[] { " I ", "TIW", " S ", Character.valueOf('W'), new ItemStack(thunderstormSword), Character.valueOf('T'), new ItemStack(meteorSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderFireSword, 1),
				new Object[] { " I ", "AIB", " S ", Character.valueOf('A'), new ItemStack(enderSword), Character.valueOf('B'), new ItemStack(fireSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(iceSword, 1),
				new Object[] { " B ", "B B", "BFB", Character.valueOf('B'), Items.snowball, Character.valueOf('F'), new ItemStack(waterSword) });
		GameRegistry.addRecipe(new ItemStack(enderWindSword, 1),
				new Object[] { " I ", "AIB", " S ", Character.valueOf('A'), new ItemStack(enderSword), Character.valueOf('B'), new ItemStack(windSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(enderThunderSword, 1),
				new Object[] { " I ", "AIB", " S ", Character.valueOf('A'), new ItemStack(enderSword), Character.valueOf('B'), new ItemStack(thunderSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(thunderShockSword, 1),
				new Object[] { "BBB", "BAB", "BBB", Character.valueOf('A'), new ItemStack(thunderSword), Character.valueOf('B'), Items.redstone });
		GameRegistry.addRecipe(new ItemStack(timeSword, 1),
				new Object[] { " I ", "AIB", " S ", Character.valueOf('A'), new ItemStack(darkSword), Character.valueOf('B'), new ItemStack(lightSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick });
		GameRegistry.addRecipe(new ItemStack(beastSword, 1),
				new Object[] { "BIB", "BIB", " P ", Character.valueOf('B'), Items.bone, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('P'), new ItemStack(SwordHandle) });
		GameRegistry.addRecipe(new ItemStack(windBlastSword, 1),
				new Object[] { "PBF", "PEF", "PBF", Character.valueOf('E'), new ItemStack(windSword), Character.valueOf('P'), Items.gunpowder, Character.valueOf('F'), Items.feather, Character.valueOf('B'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(darkNetherSword, 1),
				new Object[] { " B ", "OSO", " O ", Character.valueOf('S'), new ItemStack(darkSword), Character.valueOf('O'), Blocks.obsidian, Character.valueOf('B'), new ItemStack(Items.skull, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(lightNetherSword, 1),
				new Object[] { " B ", "OSO", " O ", Character.valueOf('S'), new ItemStack(lightSword), Character.valueOf('O'), Blocks.glowstone, Character.valueOf('B'), Items.golden_apple });
		GameRegistry.addRecipe(new ItemStack(enderPortalSword, 1),
				new Object[] { "EBE", "BSB", "EBE", Character.valueOf('S'), new ItemStack(enderSword), Character.valueOf('E'), Items.ender_eye, Character.valueOf('B'), Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(blizzardSword, 1),
				new Object[] { "IBI", "BFB", "IBI", Character.valueOf('F'), new ItemStack(iceSword), Character.valueOf('I'), Blocks.ice, Character.valueOf('B'), Items.ghast_tear });
		GameRegistry.addRecipe(new ItemStack(windWhirlSword, 1),
				new Object[] { "IBI", "BFB", "IBI", Character.valueOf('F'), new ItemStack(windBlastSword), Character.valueOf('I'), Items.feather, Character.valueOf('B'), Items.ghast_tear });   
		GameRegistry.addRecipe(new ItemStack(steamSword, 1),
				new Object[] { " I ", "AIB", " S ", Character.valueOf('A'), new ItemStack(fireSword), Character.valueOf('B'), new ItemStack(waterSword), Character.valueOf('I'), Items.iron_ingot, Character.valueOf('S'), Items.stick }); 
		GameRegistry.addRecipe(new ItemStack(wolfSword, 1),
				new Object[] { "IBI", "BFB", "IBI", Character.valueOf('F'), new ItemStack(beastSword), Character.valueOf('I'), Items.bone, Character.valueOf('B'), Items.blaze_powder });
		
		/* Essence Recipes */
		
		/* Smeltings */
		GameRegistry.addSmelting(fireSword, new ItemStack(EssenceFire, 1), 10F);
		GameRegistry.addSmelting(meteorSword, new ItemStack(EssenceFire, 2), 15F);
		GameRegistry.addSmelting(beastSword, new ItemStack(EssenceBeast, 1), 10F);
		GameRegistry.addSmelting(wolfSword, new ItemStack(EssenceBeast, 2), 15F);
		GameRegistry.addSmelting(darkSword, new ItemStack(EssenceDark, 1), 10F);
		GameRegistry.addSmelting(darkNetherSword, new ItemStack(EssenceDark, 2), 15F);
		GameRegistry.addSmelting(earthSword, new ItemStack(EssenceEarth, 1), 10F);
		GameRegistry.addSmelting(peacefulNatureSword, new ItemStack(EssenceEarth, 2), 15F);
		GameRegistry.addSmelting(wildNatureSword, new ItemStack(EssenceEarth, 3), 20F);
		GameRegistry.addSmelting(enderSword, new ItemStack(EssenceEnder, 1), 10F);
		GameRegistry.addSmelting(enderPortalSword, new ItemStack(EssenceEnder, 2), 15F);
		GameRegistry.addSmelting(lightSword, new ItemStack(EssenceLight, 1), 10F);
		GameRegistry.addSmelting(lightNetherSword, new ItemStack(EssenceLight, 2), 15F);
		GameRegistry.addSmelting(thunderSword, new ItemStack(EssenceThunder, 1), 10F);
		GameRegistry.addSmelting(thunderShockSword, new ItemStack(EssenceThunder, 2), 15F);
		GameRegistry.addSmelting(waterSword, new ItemStack(EssenceWater, 1), 10F);
		GameRegistry.addSmelting(iceSword, new ItemStack(EssenceWater, 2), 15F);
		GameRegistry.addSmelting(blizzardSword, new ItemStack(EssenceWater, 3), 20F);
		GameRegistry.addSmelting(windSword, new ItemStack(EssenceWind, 1), 10F);
		GameRegistry.addSmelting(windBlastSword, new ItemStack(EssenceWind, 2), 15F);
		GameRegistry.addSmelting(windWhirlSword, new ItemStack(EssenceWind, 3), 20F);
		
		/* Upgrading Recipes Lvl 0-1 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(beastSword, 1), 
				new Object[]{ new ItemStack(EssenceBeast),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(darkSword, 1), 
				new Object[]{ new ItemStack(EssenceDark),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(earthSword, 1), 
				new Object[]{ new ItemStack(EssenceEarth),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(enderSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(fireSword, 1), 
				new Object[]{ new ItemStack(EssenceFire),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(lightSword, 1), 
				new Object[]{ new ItemStack(EssenceLight),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(thunderSword, 1), 
				new Object[]{ new ItemStack(EssenceThunder),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(waterSword, 1), 
				new Object[]{ new ItemStack(EssenceWater),  Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(windSword, 1), 
				new Object[]{ new ItemStack(EssenceWind),  Items.iron_sword});
		
/* Upgrading Recipes Lvl 0-2 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(darkNetherSword, 1), 
				new Object[]{ new ItemStack(EssenceDark), new ItemStack(EssenceDark), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(peacefulNatureSword, 1), 
				new Object[]{ new ItemStack(EssenceEarth), new ItemStack(EssenceEarth), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(enderPortalSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder), new ItemStack(EssenceEnder), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(meteorSword, 1), 
				new Object[]{ new ItemStack(EssenceFire), new ItemStack(EssenceFire), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(lightNetherSword, 1), 
				new Object[]{ new ItemStack(EssenceLight), new ItemStack(EssenceLight), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(thunderShockSword, 1), 
				new Object[]{ new ItemStack(EssenceThunder), new ItemStack(EssenceThunder), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(iceSword, 1), 
				new Object[]{ new ItemStack(EssenceWater), new ItemStack(EssenceWater), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(windBlastSword, 1), 
				new Object[]{ new ItemStack(EssenceWind), new ItemStack(EssenceWind), Items.iron_sword});
		
		
/* Upgrading Recipes Lvl 0-3 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(wildNatureSword, 1), 
				new Object[]{ new ItemStack(EssenceEarth),  new ItemStack(EssenceEarth), new ItemStack(EssenceEarth), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(blizzardSword, 1), 
				new Object[]{ new ItemStack(EssenceWater), new ItemStack(EssenceWater), new ItemStack(EssenceWater), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(windWhirlSword, 1), 
				new Object[]{ new ItemStack(EssenceWind), new ItemStack(EssenceWind), new ItemStack(EssenceWind), Items.iron_sword});
		
/* Upgrading Recipes Lvl 1-2 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(darkNetherSword, 1), 
				new Object[]{ new ItemStack(EssenceDark), new ItemStack(darkSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(peacefulNatureSword, 1), 
				new Object[]{ new ItemStack(EssenceEarth), new ItemStack(earthSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(enderPortalSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder), new ItemStack(enderSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(meteorSword, 1), 
				new Object[]{ new ItemStack(EssenceFire), new ItemStack(fireSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(lightNetherSword, 1), 
				new Object[]{ new ItemStack(EssenceLight), new ItemStack(lightSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(thunderShockSword, 1), 
				new Object[]{ new ItemStack(EssenceThunder), new ItemStack(thunderSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(iceSword, 1), 
				new Object[]{ new ItemStack(EssenceWater), new ItemStack(waterSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(windBlastSword, 1), 
				new Object[]{ new ItemStack(EssenceWind), new ItemStack(windSword)});
		
/* Upgrading Recipes Lvl 2-3 */
		
		GameRegistry.addShapelessRecipe(new ItemStack(wildNatureSword, 1), 
				new Object[]{ new ItemStack(EssenceEarth),  new ItemStack(peacefulNatureSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(blizzardSword, 1), 
				new Object[]{ new ItemStack(EssenceWater), new ItemStack(iceSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(windWhirlSword, 1), 
				new Object[]{ new ItemStack(EssenceWind), new ItemStack(windBlastSword)});
		
		/* Mixing Recipes*/
		
		GameRegistry.addShapelessRecipe(new ItemStack(enderFireSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder), new ItemStack(EssenceFire), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(enderThunderSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder), new ItemStack(EssenceThunder), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(enderWindSword, 1), 
				new Object[]{ new ItemStack(EssenceEnder), new ItemStack(EssenceWind), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(meteoricthunderstormSword, 1), 
				new Object[]{ new ItemStack(EssenceFire), new ItemStack(EssenceFire), new ItemStack(thunderstormSword)});
		GameRegistry.addShapelessRecipe(new ItemStack(steamSword, 1), 
				new Object[]{ new ItemStack(EssenceFire), new ItemStack(EssenceWater), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(thunderstormSword, 1), 
				new Object[]{ new ItemStack(EssenceThunder), new ItemStack(EssenceWind), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(timeSword, 1), 
				new Object[]{ new ItemStack(EssenceDark), new ItemStack(EssenceLight), Items.iron_sword});
		GameRegistry.addShapelessRecipe(new ItemStack(trienderSword, 1), 
				new Object[]{ new ItemStack(enderFireSword), new ItemStack(enderWindSword), new ItemStack(enderThunderSword), Items.ender_pearl});
		
		/*Items & Cyan Sword Recipes*/
		
		GameRegistry.addRecipe(new ItemStack(SwordHandle, 3), 
				new Object[]{"   ", "PDP", " B ", 'P', Items.blaze_powder, 'D', Items.diamond, 'B', Items.blaze_rod});
	    GameRegistry.addShapelessRecipe(new ItemStack(EssenceMixed, 4), 
	    		new Object[]{ new ItemStack(EssenceEnder), new ItemStack(EssenceThunder), new ItemStack(EssenceFire), new ItemStack(EssenceWater), new ItemStack(EssenceBeast), new ItemStack(EssenceLight), new ItemStack(EssenceDark), new ItemStack(EssenceEarth), new ItemStack(EssenceWind) });
	    GameRegistry.addRecipe(new ItemStack(cyanSword, 1), 
	    		new Object[] { "BIB", "BIB", " P ", 'B', new ItemStack(EssenceMixed), 'I', Items.diamond, 'P', new ItemStack(SwordHandle) });
	
	}
	
	private static void languageRegisters(){
		
		
		LanguageRegistry.addName(fireSword, "Fire Sword");
		LanguageRegistry.addName(darkSword, "Dark Sword");
		LanguageRegistry.addName(earthSword, "Earth Sword");
		LanguageRegistry.addName(enderSword, "Ender Sword");
		LanguageRegistry.addName(lightSword, "Light Sword");
		LanguageRegistry.addName(meteorSword, "Meteor Sword");
		LanguageRegistry.addName(peacefulNatureSword, "Peaceful Nature Sword");
		LanguageRegistry.addName(thunderSword, "Thunder Sword");
		LanguageRegistry.addName(waterSword, "Water Sword");
		LanguageRegistry.addName(wildNatureSword, "Wild Nature Sword");
		LanguageRegistry.addName(windSword, "Wind Sword");
		LanguageRegistry.addName(thunderstormSword, "Thunderstorm Sword");
		LanguageRegistry.addName(iceSword, "Ice Sword");
		LanguageRegistry.addName(meteoricthunderstormSword, "Meteoric Thunderstorm Sword");
		LanguageRegistry.addName(enderFireSword, "Ender Fire Sword");
		LanguageRegistry.addName(enderThunderSword, "Ender Thunder Sword");
		LanguageRegistry.addName(enderWindSword, "Ender Wind Sword");
		LanguageRegistry.addName(thunderShockSword, "ThunderShock Sword");
		LanguageRegistry.addName(timeSword, "Time Sword");
		LanguageRegistry.addName(beastSword, "Beast Sword");
		LanguageRegistry.addName(windBlastSword, "WindBlast Sword");
		LanguageRegistry.addName(darkNetherSword, "Dark Nether Sword");
		LanguageRegistry.addName(lightNetherSword, "Light Nether Sword");
		LanguageRegistry.addName(enderPortalSword, "Ender Portal Sword");
		LanguageRegistry.addName(trienderSword, "Tri-Ender Sword");
		LanguageRegistry.addName(steamSword, "Steam Sword");
		LanguageRegistry.addName(windWhirlSword, "WindWhirl Sword");
		LanguageRegistry.addName(blizzardSword, "Blizzard Sword");
		LanguageRegistry.addName(wolfSword, "Wolf Sword");
		/* Essences */
		LanguageRegistry.addName(EssenceFire, "Fire Essence");
		LanguageRegistry.addName(EssenceBeast, "Beast Essence");
		LanguageRegistry.addName(EssenceDark, "Dark Essence");
		LanguageRegistry.addName(EssenceEarth, "Earth Essence");
		LanguageRegistry.addName(EssenceEnder, "Ender Essence");
		LanguageRegistry.addName(EssenceLight, "Light Essence");
		LanguageRegistry.addName(EssenceThunder, "Thunder Essence");
		LanguageRegistry.addName(EssenceWater, "Water Essence");
		LanguageRegistry.addName(EssenceWind, "Wind Essence");
		/* Items */
		LanguageRegistry.addName(SwordHandle, "Sword Handle");
		/*CreativeTab*/
		LanguageRegistry.instance().addStringLocalization("itemGroup.Cyan_Warrior_Swords", "Cyan Warrior Swords");
		
	}
    
}
    

