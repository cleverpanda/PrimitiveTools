package panda.primitivetools.common.item;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import panda.primitivetools.ConfigPrimitiveTools;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class PrimitiveRockHammer extends ItemPickaxe{
	
	public PrimitiveRockHammer(ToolMaterial material)
	{
		super(material);
		this.attackDamage = 5.0f;
	    this.attackSpeed = -3.5f;
	    this.setContainerItem(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(TextFormatting.GOLD+"Durability: "+this.getMaxDamage(stack));
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		itemStack.setItemDamage(itemStack.getItemDamage()+1);
		return itemStack.copy();
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }
	
	@Override
	  public boolean hasContainerItem(ItemStack stack)
	  {
	    return stack.getItemDamage() < getMaxDamage(stack);
	  }
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ICE && material != Material.CIRCUITS && material != Material.CORAL &&  material != Material.ANVIL && material != Material.ROCK && material != Material.GLASS? (float)(0.2f*ConfigPrimitiveTools.toolSpeed.toolSpeedModifier*ConfigPrimitiveTools.toolSpeed.HammerSpeedModifier) : (float)(3.0f*ConfigPrimitiveTools.toolSpeed.toolSpeedModifier*ConfigPrimitiveTools.toolSpeed.HammerSpeedModifier);
    }
	
	//Handle rock crushing
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, entityLiving);
        }

        return true;
    }
	
	@Override
	public boolean isRepairable()
    {
		return false;
    }
}
