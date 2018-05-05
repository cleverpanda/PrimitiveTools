/*package panda.primitivetools.jei;

import java.util.List;

import javax.annotation.Nullable;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import mezz.jei.recipes.BrokenCraftingRecipeException;
import mezz.jei.util.ErrorUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

public class ShapelessKnifeWrapper <T extends IRecipe> implements ICraftingRecipeWrapper  {

	protected final T recipe;

	public ShapelessKnifeWrapper(T recipe) {
		this.recipe = recipe;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {

			ingredients.setInputs(ItemStack.class, (List)recipe.getIngredients());
			ingredients.setOutput(ItemStack.class, recipe.getRecipeOutput());
	}

	@Nullable
	@Override
	public ResourceLocation getRegistryName() {
		return recipe.getRegistryName();
	}
}
*/