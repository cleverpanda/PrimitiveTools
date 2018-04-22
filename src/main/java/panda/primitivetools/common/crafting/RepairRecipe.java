package panda.primitivetools.common.crafting;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
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
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.registries.IForgeRegistryEntry;
import panda.primitivetools.PrimitiveTools;

public class RepairRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
    	/** Is the ItemStack that you get when craft the recipe. */
        private final ItemStack tool;
        /** Is a List of ItemStack that composes the recipe. */
        public final NonNullList<Ingredient> recipeItems;
        private final String group;
		private final int repairamt;

        public RepairRecipe(ItemStack tool,int repairAmount, NonNullList<Ingredient> nonNullList)
        {
            this.group = PrimitiveTools.MODID;
            this.tool = tool;
            this.repairamt = repairAmount;
            this.recipeItems = nonNullList;
        }
        @Override
        public String getGroup()
        {
            return this.group;
        }

        public ItemStack getRecipeOutput()
        {
        	this.tool.setItemDamage(this.tool.getItemDamage()+this.repairamt);
            return this.tool.copy();
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

                        if (!flag)
                        {
                            return false;
                        }
                    }
                }
            }

            return list.isEmpty();
        }

        /**
         * Returns an Item that is the result of this recipe
         */
        public ItemStack getCraftingResult(InventoryCrafting inv)
        {
        	this.tool.setItemDamage(this.tool.getItemDamage()+this.repairamt);
            return this.tool.copy();
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

        public boolean canFit(int width, int height)
        {
            return width * height >= this.recipeItems.size();
        }
} 

