package panda.primitivetools.proxy;

import net.minecraft.item.Item;
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
	}
    
    private void registerKnife(Item item){
    	OreDictionary.registerOre("toolKnife", item);
    }

}
