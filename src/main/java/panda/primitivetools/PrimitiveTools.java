package panda.primitivetools;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import panda.primitivetools.init.ModRecipes;
import panda.primitivetools.common.entity.EntitySpear;
import panda.primitivetools.init.ModItems;
import panda.primitivetools.proxy.CommonProxy;

@Mod(modid = PrimitiveTools.MODID, name = PrimitiveTools.NAME, version = PrimitiveTools.VERSION)
public class PrimitiveTools {
	public static final String MODID = "primitivetools";
	public static final String VERSION = "0.22.0";
	public static final String NAME = "Primitive Tools";
	

	@Mod.Instance(MODID)
	public static PrimitiveTools instance;

	@SidedProxy(clientSide = "panda.primitivetools.proxy.ClientProxy",serverSide = "panda.primitivetools.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		Materials.init();
		logger = event.getModLog();
		ModRecipes.register();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		EntityRegistry.registerModEntity(new ResourceLocation("primitivetools:spear"), EntitySpear.class, "spear", 1, instance, 120, 1, true);
		proxy.registerOreDicts();
	}

	public static final CreativeTabs Tab = new CreativeTabs(MODID) {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.PRIMITIVE_PICK_WVS);
		}
		
		@Override
		@SideOnly(Side.CLIENT)
	    public void displayAllRelevantItems(NonNullList<ItemStack> list)
	    {
	        for (Item item : Item.REGISTRY)
	        {
	            item.getSubItems(this, list);
	            if(list.size() > 9 && list.size() % 9 == 8 && list.size() < 73){
	            	list.add(new ItemStack(Blocks.STAINED_GLASS_PANE,1,8));
	            }
	        }
	    }
	};
}