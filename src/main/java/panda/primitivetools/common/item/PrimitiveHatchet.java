package panda.primitivetools.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PrimitiveHatchet extends ItemAxe{
	
	public PrimitiveHatchet(ToolMaterial material)
	  {
	    super(material, material.getAttackDamage(), material.getEfficiency());
	    this.attackDamage = 7;
	    this.attackSpeed = -3.2f;
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
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.GOURD && material != Material.PLANTS && material != Material.VINE ? 0.2f : 3f;
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

}
