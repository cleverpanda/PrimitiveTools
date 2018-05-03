package panda.primitivetools.init;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import panda.primitivetools.Materials;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.common.item.ItemClub;
import panda.primitivetools.common.item.PrimitiveHatchet;
import panda.primitivetools.common.item.PrimitiveHoe;
import panda.primitivetools.common.item.PrimitiveKnife;
import panda.primitivetools.common.item.PrimitivePick;
import panda.primitivetools.common.item.PrimitiveRockHammer;
import panda.primitivetools.common.item.PrimitiveSpade;
import panda.primitivetools.common.item.Spear;

@EventBusSubscriber
public final class ModItems {

	 private ModItems(){
		PrimitiveTools.logger.info("Registering Items");
	}
	
	public static final ToolMaterial FLINT = EnumHelper.addToolMaterial("flint", 1, 59, 2.0F, 0.0F, 0).setRepairItem(new ItemStack(ModItems.FLINT_FLAKE));
		public static final Item FLINT_FLAKE = simply(new Item(){@Override
			public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			tooltip.add(TextFormatting.GOLD+"Right click flint on something hard");
		}},"flint_flake");
		public static final Item FLINT_SHARD = simply(new Item(){@Override
			public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			tooltip.add(TextFormatting.GOLD+"Right click flint on something hard");
		}},"flint_shard");
		public static final Item FLINT_POINT = simply(new Item(){@Override
			public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			tooltip.add(TextFormatting.GOLD+"Right click flint on something hard");
		}},"flint_point");
		public static final Item LEATHER_STRIP = simply(new Item(),"leather_strip");
		public static final Item CORDAGE_VINE = simply(new Item(),"cordage_vine");
		public static final Item PLANT_FIBER = simply(new Item(),"plant_fiber");
		public static final Item CORDAGE_FIBER = simply(new Item(),"cordage_fiber");
		
		public static final Item WOODEN_CLUB = simply(new ItemClub(FLINT),"wooden_club");
		public static final Item BONE_NEEDLE = simply(new Item(),"bone_needle");
		

		public static final Item PRIMITIVE_AXE_WFS = makeHatchet("cwf");
		public static final Item PRIMITIVE_AXE_WVS = makeHatchet("cwv");
		public static final Item PRIMITIVE_AXE_WLS = makeHatchet("cwl");
		public static final Item PRIMITIVE_AXE_BFS = makeHatchet("cbf");
		public static final Item PRIMITIVE_AXE_BVS = makeHatchet("cbv");
		public static final Item PRIMITIVE_AXE_BLS = makeHatchet("cbl");
		                                                          
		public static final Item PRIMITIVE_KNIFE_WFS = makeKnife("cwf");
		public static final Item PRIMITIVE_KNIFE_WVS = makeKnife("cwv");
		public static final Item PRIMITIVE_KNIFE_WLS = makeKnife("cwl");
		public static final Item PRIMITIVE_KNIFE_BFS = makeKnife("cbf");
		public static final Item PRIMITIVE_KNIFE_BVS = makeKnife("cbv");
		public static final Item PRIMITIVE_KNIFE_BLS = makeKnife("cbl");
		
		public static final Item PRIMITIVE_PICK_WFS = makePick("cwf");
		public static final Item PRIMITIVE_PICK_WVS = makePick("cwv");
		public static final Item PRIMITIVE_PICK_WLS = makePick("cwl");
		public static final Item PRIMITIVE_PICK_BFS = makePick("cbf");
		public static final Item PRIMITIVE_PICK_BVS = makePick("cbv");
		public static final Item PRIMITIVE_PICK_BLS = makePick("cbl");
		
		public static final Item PRIMITIVE_SPADE_WFS = makeSpade("cwf");
		public static final Item PRIMITIVE_SPADE_WVS = makeSpade("cwv");
		public static final Item PRIMITIVE_SPADE_WLS = makeSpade("cwl");
		public static final Item PRIMITIVE_SPADE_BFS = makeSpade("cbf");
		public static final Item PRIMITIVE_SPADE_BVS = makeSpade("cbv");
		public static final Item PRIMITIVE_SPADE_BLS = makeSpade("cbl");
		
		public static final Item PRIMITIVE_HOE_WFS = makeHoe("cwf");
		public static final Item PRIMITIVE_HOE_WVS = makeHoe("cwv");
		public static final Item PRIMITIVE_HOE_WLS = makeHoe("cwl");
		public static final Item PRIMITIVE_HOE_BFS = makeHoe("cbf");
		public static final Item PRIMITIVE_HOE_BVS = makeHoe("cbv");
		public static final Item PRIMITIVE_HOE_BLS = makeHoe("cbl");
		
		public static final Item PRIMITIVE_HAMMER_SWF = makeHammer("swf");
		public static final Item PRIMITIVE_HAMMER_SWV = makeHammer("swv");
		public static final Item PRIMITIVE_HAMMER_SWL = makeHammer("swl");
		public static final Item PRIMITIVE_HAMMER_SBF = makeHammer("sbf");
		public static final Item PRIMITIVE_HAMMER_SBV = makeHammer("sbv");
		public static final Item PRIMITIVE_HAMMER_SBL = makeHammer("sbl");

		public static final Item PRIMITIVE_HAMMER_DWF = makeHammer("dwf");
		public static final Item PRIMITIVE_HAMMER_DWV = makeHammer("dwv");
		public static final Item PRIMITIVE_HAMMER_DWL = makeHammer("dwl");
		public static final Item PRIMITIVE_HAMMER_DBF = makeHammer("dbf");
		public static final Item PRIMITIVE_HAMMER_DBV = makeHammer("dbv");
		public static final Item PRIMITIVE_HAMMER_DBL = makeHammer("dbl");

		public static final Item PRIMITIVE_HAMMER_GWF = makeHammer("gwf");
		public static final Item PRIMITIVE_HAMMER_GWV = makeHammer("gwv");
		public static final Item PRIMITIVE_HAMMER_GWL = makeHammer("gwl");
		public static final Item PRIMITIVE_HAMMER_GBF = makeHammer("gbf");
		public static final Item PRIMITIVE_HAMMER_GBV = makeHammer("gbv");
		public static final Item PRIMITIVE_HAMMER_GBL = makeHammer("gbl");
		
		public static final Item SPEAR_CWL = makeSpear("cwl");
		public static final Item SPEAR_CWF = makeSpear("cwf");
		public static final Item SPEAR_CWV = makeSpear("cwv");
		
		private static Item makeHoe(String key){
			return makeTool(new PrimitiveHoe(FLINT), "primitive_hoe_",key);
		}
		
		private static Item makeSpear(String key){
			return simply(new Spear(key), "primitive_spear_"+key);
		}
		
		private static Item makeHammer(String key){
			return makeTool(new PrimitiveRockHammer(FLINT), "primitive_hammer_",key);
		}
		
		private static Item makeSpade(String key){
			return makeTool(new PrimitiveSpade(FLINT), "primitive_spade_",key);
		}
		
		private static Item makePick(String key){
			return makeTool(new PrimitivePick(FLINT), "primitive_pick_",key);
		}
		
		private static Item makeKnife(String key){
			return makeTool(new PrimitiveKnife(FLINT), "primitive_knife_",key);
		}
		
		private static Item makeHatchet(String key){
			return makeTool(new PrimitiveHatchet(FLINT), "primitive_hatchet_",key);
		}
		
		private static Item makeTool(Item item,String name, String key){
			return simply(item, name+key).setMaxDamage(Materials.getDurabForParts(key));
		}
		
		private static Item simply(Item item, String name) { 
			return item.setRegistryName(PrimitiveTools.MODID, name).setUnlocalizedName(PrimitiveTools.MODID + "." + name).setCreativeTab(PrimitiveTools.Tab);
		}


		@SubscribeEvent
		public static void register(RegistryEvent.Register<Item> event) {
			IForgeRegistry<Item> registry = event.getRegistry();
			registry.register(FLINT_SHARD);
			registry.register(FLINT_FLAKE);				
			registry.register(FLINT_POINT);	
			registry.register(PLANT_FIBER);	
			registry.register(CORDAGE_FIBER);
			registry.register(CORDAGE_VINE);				
			registry.register(LEATHER_STRIP);
			
			registry.register(WOODEN_CLUB);	
			registry.register(BONE_NEEDLE);	
			
			registry.register(PRIMITIVE_KNIFE_WFS);
			registry.register(PRIMITIVE_AXE_WFS);
			registry.register(PRIMITIVE_PICK_WFS);
			registry.register(PRIMITIVE_SPADE_WFS);
			registry.register(PRIMITIVE_HOE_WFS);
			registry.register(PRIMITIVE_HAMMER_SWF);
			registry.register(PRIMITIVE_HAMMER_DWF);
			registry.register(PRIMITIVE_HAMMER_GWF);
			
			registry.register(PRIMITIVE_KNIFE_WVS);
			registry.register(PRIMITIVE_AXE_WVS);
			registry.register(PRIMITIVE_PICK_WVS);
			registry.register(PRIMITIVE_SPADE_WVS);
			registry.register(PRIMITIVE_HOE_WVS);
			registry.register(PRIMITIVE_HAMMER_SWV);
			registry.register(PRIMITIVE_HAMMER_DWV);
			registry.register(PRIMITIVE_HAMMER_GWV);
			
			registry.register(PRIMITIVE_KNIFE_WLS);
			registry.register(PRIMITIVE_AXE_WLS);
			registry.register(PRIMITIVE_PICK_WLS);
			registry.register(PRIMITIVE_SPADE_WLS);
			registry.register(PRIMITIVE_HOE_WLS);
			registry.register(PRIMITIVE_HAMMER_SWL);
			registry.register(PRIMITIVE_HAMMER_DWL);
			registry.register(PRIMITIVE_HAMMER_GWL);
			
			registry.register(PRIMITIVE_KNIFE_BFS);
			registry.register(PRIMITIVE_AXE_BFS);
			registry.register(PRIMITIVE_PICK_BFS);
			registry.register(PRIMITIVE_SPADE_BFS);
			registry.register(PRIMITIVE_HOE_BFS);
			registry.register(PRIMITIVE_HAMMER_SBF);
			registry.register(PRIMITIVE_HAMMER_DBF);
			registry.register(PRIMITIVE_HAMMER_GBF);
			
			registry.register(PRIMITIVE_KNIFE_BVS);
			registry.register(PRIMITIVE_AXE_BVS);
			registry.register(PRIMITIVE_PICK_BVS);
			registry.register(PRIMITIVE_SPADE_BVS);
			registry.register(PRIMITIVE_HOE_BVS);
			registry.register(PRIMITIVE_HAMMER_SBV);
			registry.register(PRIMITIVE_HAMMER_DBV);
			registry.register(PRIMITIVE_HAMMER_GBV);
			
			registry.register(PRIMITIVE_KNIFE_BLS);
			registry.register(PRIMITIVE_AXE_BLS);
			registry.register(PRIMITIVE_PICK_BLS);
			registry.register(PRIMITIVE_SPADE_BLS);
			registry.register(PRIMITIVE_HOE_BLS);
			registry.register(PRIMITIVE_HAMMER_SBL);

			registry.register(PRIMITIVE_HAMMER_DBL);
			registry.register(PRIMITIVE_HAMMER_GBL);
			
			registry.register(SPEAR_CWF);
			registry.register(SPEAR_CWV);
			registry.register(SPEAR_CWL);
			

			
			
		}
}
