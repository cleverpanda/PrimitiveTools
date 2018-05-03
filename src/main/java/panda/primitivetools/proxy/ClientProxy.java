package panda.primitivetools.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.client.renderer.RenderSpear;
import panda.primitivetools.common.entity.EntitySpear;
import panda.primitivetools.init.ModItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
		registerItemModel(ModItems.FLINT_FLAKE);
		registerItemModel(ModItems.FLINT_SHARD);
		registerItemModel(ModItems.FLINT_POINT);	
		registerItemModel(ModItems.LEATHER_STRIP);
		registerItemModel(ModItems.CORDAGE_VINE);				
		registerItemModel(ModItems.PLANT_FIBER);	
		registerItemModel(ModItems.CORDAGE_FIBER);
		
		registerItemModel(ModItems.WOODEN_CLUB);	
		registerItemModel(ModItems.BONE_NEEDLE);
		
		registerItemModel(ModItems.CORDAGE_FIBER);
		registerItemModel(ModItems.PRIMITIVE_AXE_WFS);
		registerItemModel(ModItems.PRIMITIVE_AXE_WLS);
		registerItemModel(ModItems.PRIMITIVE_AXE_WVS);
		registerItemModel(ModItems.PRIMITIVE_AXE_BFS);
		registerItemModel(ModItems.PRIMITIVE_AXE_BVS);
		registerItemModel(ModItems.PRIMITIVE_AXE_BLS);
		
		registerItemModel(ModItems.PRIMITIVE_KNIFE_WFS);
		registerItemModel(ModItems.PRIMITIVE_KNIFE_WLS);
		registerItemModel(ModItems.PRIMITIVE_KNIFE_WVS);
		registerItemModel(ModItems.PRIMITIVE_KNIFE_BFS);
		registerItemModel(ModItems.PRIMITIVE_KNIFE_BVS);
		registerItemModel(ModItems.PRIMITIVE_KNIFE_BLS);
		
		registerItemModel(ModItems.PRIMITIVE_PICK_WFS);
		registerItemModel(ModItems.PRIMITIVE_PICK_WLS);
		registerItemModel(ModItems.PRIMITIVE_PICK_WVS);
		registerItemModel(ModItems.PRIMITIVE_PICK_BFS);
		registerItemModel(ModItems.PRIMITIVE_PICK_BVS);
		registerItemModel(ModItems.PRIMITIVE_PICK_BLS);
		
		registerItemModel(ModItems.PRIMITIVE_SPADE_WFS);
		registerItemModel(ModItems.PRIMITIVE_SPADE_WLS);
		registerItemModel(ModItems.PRIMITIVE_SPADE_WVS);
		registerItemModel(ModItems.PRIMITIVE_SPADE_BFS);
		registerItemModel(ModItems.PRIMITIVE_SPADE_BVS);
		registerItemModel(ModItems.PRIMITIVE_SPADE_BLS);
		
		registerItemModel(ModItems.PRIMITIVE_HOE_WFS);
		registerItemModel(ModItems.PRIMITIVE_HOE_WLS);
		registerItemModel(ModItems.PRIMITIVE_HOE_WVS);
		registerItemModel(ModItems.PRIMITIVE_HOE_BFS);
		registerItemModel(ModItems.PRIMITIVE_HOE_BVS);
		registerItemModel(ModItems.PRIMITIVE_HOE_BLS);
		
		registerItemModel(ModItems.PRIMITIVE_HAMMER_SWF);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DWF);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GWF);

		registerItemModel(ModItems.PRIMITIVE_HAMMER_SWV);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DWV);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GWV);

		registerItemModel(ModItems.PRIMITIVE_HAMMER_SWL);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DWL);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GWL);

		registerItemModel(ModItems.PRIMITIVE_HAMMER_SBF);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DBF);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GBF);

		registerItemModel(ModItems.PRIMITIVE_HAMMER_SBV);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DBV);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GBV);

		registerItemModel(ModItems.PRIMITIVE_HAMMER_SBL);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_DBL);
		registerItemModel(ModItems.PRIMITIVE_HAMMER_GBL);
		
		registerItemModel(ModItems.SPEAR_CWF);
		registerItemModel(ModItems.SPEAR_CWV);
		registerItemModel(ModItems.SPEAR_CWL);
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, RenderSpear.FACTORY);
    }

	private static void registerItemModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
