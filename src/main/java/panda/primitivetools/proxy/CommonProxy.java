package panda.primitivetools.proxy;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;
import panda.primitivetools.init.ModItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class CommonProxy {
	
	
    public void registerOreDicts() {
    	registerKnife(ModItems.PRIMITIVE_KNIFE_BFS);
    	registerKnife(ModItems.PRIMITIVE_KNIFE_BLS);
    	registerKnife(ModItems.PRIMITIVE_KNIFE_BVS);
    	registerKnife(ModItems.PRIMITIVE_KNIFE_WFS);
    	registerKnife(ModItems.PRIMITIVE_KNIFE_WLS);
    	registerKnife(ModItems.PRIMITIVE_KNIFE_WVS);
    	OreDictionary.registerOre("leatherStrip",ModItems.LEATHER_STRIP);
    	OreDictionary.registerOre("toolNeedle",ModItems.BONE_NEEDLE);
    	OreDictionary.registerOre("toolShears",new ItemStack(Items.SHEARS,1,OreDictionary.WILDCARD_VALUE));
    	OreDictionary.registerOre("materialFiber",ModItems.PLANT_FIBER);
    	OreDictionary.registerOre("pointFlint",ModItems.FLINT_POINT);
    	OreDictionary.registerOre("flakeFlint",ModItems.FLINT_FLAKE);
    	OreDictionary.registerOre("shardFlint",ModItems.FLINT_SHARD);
    	
    	OreDictionary.registerOre("cordagePlant",ModItems.CORDAGE_FIBER);
    	OreDictionary.registerOre("cordageGeneral",ModItems.CORDAGE_FIBER);
    	OreDictionary.registerOre("cordagePlant",ModItems.CORDAGE_VINE);
    	OreDictionary.registerOre("cordageGeneral",ModItems.CORDAGE_VINE);
    	OreDictionary.registerOre("cordageGeneral",ModItems.LEATHER_STRIP);
    	
    	registerHatchet(ModItems.PRIMITIVE_AXE_BFS);
    	registerHatchet(ModItems.PRIMITIVE_AXE_BLS);
    	registerHatchet(ModItems.PRIMITIVE_AXE_BVS);
    	registerHatchet(ModItems.PRIMITIVE_AXE_WFS);
    	registerHatchet(ModItems.PRIMITIVE_AXE_WLS);
    	registerHatchet(ModItems.PRIMITIVE_AXE_WVS);
    	
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SWF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SWV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SWL);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SBF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SBV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_SBL);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DWF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DWV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DWL);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DBF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DBV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_DBL);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GWF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GWV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GWL);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GBF);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GBV);
    	registerHammer(ModItems.PRIMITIVE_HAMMER_GBL);
	}
    
    
    private void registerHatchet(Item item){
    	OreDictionary.registerOre("toolHatchet",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    }

    private void registerHammer(Item item){
    	OreDictionary.registerOre("toolMallet",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    	OreDictionary.registerOre("toolMalletStone",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    	OreDictionary.registerOre("toolSledgeHammer",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    }
    
    private void registerKnife(Item item){
    	OreDictionary.registerOre("toolKnife",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    	OreDictionary.registerOre("toolWorkBlade",new ItemStack(item,1,OreDictionary.WILDCARD_VALUE));
    }

}
