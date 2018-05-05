/*package panda.primitivetools.jei;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.util.Log;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.common.crafting.RecipeShapelessKnife.ShapelessKnifeRecipe;

@JEIPlugin
public class PluginJEI implements IModPlugin{

	@Override
	public void register(IModRegistry registry) {

		registry.handleRecipes(ShapelessKnifeRecipe.class,recipe -> new ShapelessKnifeWrapper(recipe), VanillaRecipeCategoryUid.CRAFTING);

		Collection<IRecipe> allRecipes = ForgeRegistries.RECIPES.getValuesCollection();

		Log.get().info(allRecipes);
		allRecipes.removeIf(r -> r != null && r.getGroup() != PrimitiveTools.MODID);
		Log.get().info(allRecipes);
		registry.addRecipes(allRecipes,VanillaRecipeCategoryUid.CRAFTING);
		IModPlugin.super.register(registry);
	}
}
*/