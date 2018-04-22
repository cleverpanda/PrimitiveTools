package panda.primitivetools.init;

import java.util.Iterator;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.common.crafting.FakeRecipe;
import panda.primitivetools.common.crafting.KnappRecipe;
import panda.primitivetools.common.crafting.RecipeKnife;
import panda.primitivetools.common.crafting.RepairRecipe;

@EventBusSubscriber
public class ModRecipes {
	
	private ModRecipes(){
		PrimitiveTools.logger.info("Registering Recipes");
	}
	
	public static void register() {
		removeVanillaRecipes();
		KnappRecipe.addRecipe(new ItemStack(Items.FLINT), new ItemStack[]{new ItemStack(ModItems.FLINT_FLAKE),new ItemStack(ModItems.FLINT_SHARD),new ItemStack(ModItems.FLINT_POINT)}, 1.5F, 0.45F);
		//ForgeRegistries.RECIPES.register(new RepairRecipe(new ItemStack(ModItems.PRIMITIVE_AXE),40, ModItems.FLINT_FLAKE));
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<IRecipe> event) {
		IForgeRegistry<IRecipe> registry = event.getRegistry();
	}

	public static void removeVanillaRecipes()
	  {
		String mc = "minecraft";
	      removeRecipe(new ResourceLocation(mc, "wooden_pickaxe"));
	      removeRecipe(new ResourceLocation(mc, "wooden_axe"));
	      removeRecipe(new ResourceLocation(mc, "wooden_shovel"));
	      removeRecipe(new ResourceLocation(mc, "wooden_hoe"));
	      removeRecipe(new ResourceLocation(mc, "wooden_sword"));
	      
	      removeRecipe(new ResourceLocation(mc, "stone_pickaxe"));
	      removeRecipe(new ResourceLocation(mc, "stone_axe"));
	      removeRecipe(new ResourceLocation(mc, "stone_shovel"));
	      removeRecipe(new ResourceLocation(mc, "stone_hoe"));
	      removeRecipe(new ResourceLocation(mc, "stone_sword"));
	      removeRecipe(new ResourceLocation(mc, "arrow"));
	  }
	
	public static void removeRecipe(ResourceLocation name)
	  {
	    IRecipe recipe = CraftingManager.getRecipe(name);
	    if (recipe != null)
	    {
	    	PrimitiveTools.logger.info("Removing Recipe: " + name);
	        ForgeRegistries.RECIPES.register(new FakeRecipe(recipe));
	    }
	  }
	
	public static void removeFurnaceRecipe(ItemStack resultItem) {
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = recipes.entrySet().iterator(); entries.hasNext();) {
			Map.Entry<ItemStack, ItemStack> entry = entries.next();
			ItemStack result = entry.getValue();
			if (ItemStack.areItemStacksEqual(result, resultItem)) {	
				entries.remove();
			}
		}
	}

	public static void addOredicts(String[] oreDictEntries, Block name) {
		addOredicts(oreDictEntries, new ItemStack(name));
	}

	public static void addOredicts(String[] oreDictEntries, Item name) {
		addOredicts(oreDictEntries, new ItemStack(name));
	}

	public static void addOredicts(String[] oreDictEntries, ItemStack itemStackName) {
		for (final String oreDictEntry : oreDictEntries)
			OreDictionary.registerOre(oreDictEntry, itemStackName);
	}
}