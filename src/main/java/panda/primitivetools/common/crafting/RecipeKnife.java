package panda.primitivetools.common.crafting;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistryEntry;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.common.item.PrimitiveKnife;

public class RecipeKnife implements IRecipeFactory{

	@Override
	public IRecipe parse(JsonContext context, JsonObject json) {
		ShapelessOreRecipe recipe = ShapelessOreRecipe.factory(context, json);
		
        return new ShapelessKnifeRecipe(recipe.getRecipeOutput(), recipe.getIngredients());
    }

    public static class ShapelessKnifeRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    	/** Is the ItemStack that you get when craft the recipe. */
        private final ItemStack recipeOutput;
        /** Is a List of ItemStack that composes the recipe. */
        public final NonNullList<Ingredient> recipeItems;
        private final String group;

        public ShapelessKnifeRecipe(ItemStack output, NonNullList<Ingredient> nonNullList)
        {
            this.group = PrimitiveTools.MODID;
            this.recipeOutput = output;
            this.recipeItems = nonNullList;
            //this.setRegistryName(new ResourceLocation(PrimitiveTools.MODID,"shapeless_knife_recipe_"+output.getItem().getRegistryName().getResourcePath()));
        }

        @Override
        public String getGroup()
        {
            return this.group;
        }

        public ItemStack getRecipeOutput()
        {
            return this.recipeOutput;
        }
        
        @Override
        public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
        {
            NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

            for (int i = 0; i < nonnulllist.size(); ++i)
            {
                ItemStack itemstack = inv.getStackInSlot(i);
                
                if(!itemstack.isEmpty()){
                	if(OreDictionary.getOres("toolKnife").contains(itemstack) || itemstack.getItem() instanceof PrimitiveKnife){
                    	ItemStack knifecopy = itemstack.copy();
                    	if(knifecopy.attemptDamageItem(1, Minecraft.getMinecraft().world.rand, null)){
                    		ForgeEventFactory.onPlayerDestroyItem(ForgeHooks.getCraftingPlayer(), itemstack, null);
                    		nonnulllist.set(i,ItemStack.EMPTY);
                    	}else{
                    		nonnulllist.set(i, knifecopy);
                    	}
                }
                }else{
                	 nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
                } 
            }

            return nonnulllist;
        }

        @Override
        public NonNullList<Ingredient> getIngredients()
        {
            return this.recipeItems;
        }

        /**
         * Used to check if a recipe matches current crafting inventory
         */
        public boolean matches(InventoryCrafting inv, World worldIn)
        {
        	
            List<Ingredient> list = Lists.newArrayList(this.recipeItems);

            for (int i = 0; i < inv.getHeight(); ++i)
            {
                for (int j = 0; j < inv.getWidth(); ++j)
                {
                    ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                    if (!itemstack.isEmpty())
                    {
                        boolean flag = false;

                        for (Ingredient ingredient : list)
                        {
                            if (ingredient.apply(itemstack))
                            {
                                flag = true;
                                list.remove(ingredient);
                                break;
                            }
                        }
                        //PrimitiveTools.logger.info(flag);
                        if (!flag)
                        {
                        	//PrimitiveTools.logger.info("false");
                            return false;
                        }
                    }
                }
            }
            //PrimitiveTools.logger.info(list.isEmpty());
            return list.isEmpty();
        }

        /**
         * Returns an Item that is the result of this recipe
         */
        public ItemStack getCraftingResult(InventoryCrafting inv)
        {
            return this.recipeOutput.copy();
        }

        public static ShapelessRecipes deserialize(JsonObject json)
        {
            String s = JsonUtils.getString(json, "group", "");
            NonNullList<Ingredient> nonnulllist = deserializeIngredients(JsonUtils.getJsonArray(json, "ingredients"));

            if (nonnulllist.isEmpty())
            {
                throw new JsonParseException("No ingredients for shapeless recipe");
            }
            else if (nonnulllist.size() > 9)
            {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            }
            else
            {
                ItemStack itemstack = ShapedRecipes.deserializeItem(JsonUtils.getJsonObject(json, "result"), true);
                return new ShapelessRecipes(s, itemstack, nonnulllist);
            }
        }

        private static NonNullList<Ingredient> deserializeIngredients(JsonArray array)
        {
            NonNullList<Ingredient> nonnulllist = NonNullList.<Ingredient>create();

            for (int i = 0; i < array.size(); ++i)
            {
                Ingredient ingredient = ShapedRecipes.deserializeIngredient(array.get(i));

                if (ingredient != Ingredient.EMPTY)
                {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        /**
         * Used to determine if this recipe can fit in a grid of the given width/height
         */
        public boolean canFit(int width, int height)
        {
            return width * height >= this.recipeItems.size();
        }
    	

    } 
}