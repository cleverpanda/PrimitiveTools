package panda.primitivetools.common.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import panda.primitivetools.ConfigPrimitiveTools;

public class PrimitivePick extends ItemPickaxe{
	
	public PrimitivePick(ToolMaterial material)
	  {
	    super(material);
	    this.attackDamage = 2.0f;
	    this.attackSpeed = -2.8f;
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
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.CIRCUITS && material != Material.CORAL &&  material != Material.ANVIL && material != Material.ROCK ? 0.2f*ConfigPrimitiveTools.toolSpeedModifier*ConfigPrimitiveTools.PickSpeedModifier : 3.0f*ConfigPrimitiveTools.toolSpeedModifier*ConfigPrimitiveTools.PickSpeedModifier;
    }
	
	@Override
	public boolean isRepairable()
    {
		return false;
    }
}
