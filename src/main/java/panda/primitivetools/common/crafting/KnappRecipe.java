package panda.primitivetools.common.crafting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

public class KnappRecipe
{
  private static ArrayList<KnappRecipe> knappRecipes = new ArrayList();
  
  private ItemStack input;
  private ItemStack[] outputs;
  private ItemStack output_failed;
  private float hardness;
  private float failure;
  
  private KnappRecipe(ItemStack input, ItemStack[] output, float hardness, float failure)
  {
    this.input = input;
    this.outputs = output;
    this.hardness = hardness;
    this.failure = failure;
  }

  public static void addRecipe(ItemStack input, ItemStack[] output, float hardness, float failure)
  {
    knappRecipes.add(new KnappRecipe(input, output, hardness, failure));
  }
  
  public static boolean isRecipeItem(ItemStack stack)
  {
    for (KnappRecipe recipe : knappRecipes) {
      if (stack.isItemEqual(recipe.input))
        return true;
    }
    return false;
  }
  
  public static boolean isOutputItem(ItemStack stack)
  {
    for (KnappRecipe recipe : knappRecipes) {
      if (Arrays.asList(recipe.outputs).contains(stack))
        return true;
    }
    return false;
  }
  
  public static KnappRecipe getRecipe(ItemStack stack)
  {
	for (KnappRecipe recipe : knappRecipes) {
      if (stack.isItemEqual(recipe.input))
    	  return recipe;
    }
    return null;
  }
  
  public ItemStack getInput()
  {
    return this.input.copy();
  }
  
  public ItemStack[] getOutputs()
  {
    return this.outputs.clone();
  }
  
  public ItemStack getOutputFailed()
  {
    return this.output_failed.copy();
  }
  
  public float getHardness()
  {
    return this.hardness;
  }
  
  public float getFailure()
  {
    return this.failure;
  }
}
