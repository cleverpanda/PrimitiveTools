package panda.primitivetools.common.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class PrimitiveSpade extends ItemSpade{
	
	public PrimitiveSpade(ToolMaterial material)
	  {
	    super(material);
	    this.attackDamage = 2.5f;
	    this.attackSpeed = -3f;
	  }
	
	@Override
	  public boolean hasContainerItem(ItemStack stack)
	  {
	    return stack.getItemDamage() < getMaxDamage(stack);
	  }
	
	@Override
	  public ItemStack getContainerItem(ItemStack stack)
	  {
	    ItemStack container = stack.copy();
	    container.attemptDamageItem(1, Minecraft.getMinecraft().world.rand, null);
	    return container;
	  }
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(TextFormatting.GOLD+"Durability: "+this.getMaxDamage(stack));
	}
	
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.CLAY && material != Material.CRAFTED_SNOW && material != Material.GRASS && material != Material.GROUND && material != Material.SNOW && material != Material.SAND? 0.2f : 3f;
    }
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }
}