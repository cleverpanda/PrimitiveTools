package panda.primitivetools.common.item;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import panda.primitivetools.ConfigPrimitiveTools;

public class PrimitiveKnife extends ItemTool{


	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.LEAVES, Blocks.LEAVES2,
			Blocks.RED_MUSHROOM_BLOCK, Blocks.BROWN_MUSHROOM_BLOCK,Blocks.PUMPKIN,
			Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.CACTUS, Blocks.TALLGRASS, Blocks.WHEAT,Blocks.HAY_BLOCK);
	
	public PrimitiveKnife(ToolMaterial material)
	{
		super(material, EFFECTIVE_ON);
		this.attackDamage = 4f;
        this.attackSpeed = -1.5f;
        this.setContainerItem(this);
	}
	
	//extra damage to animals.
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(TextFormatting.GOLD+"Durability: "+this.getMaxDamage(stack));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
	
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		itemStack.setItemDamage(itemStack.getItemDamage()+1);
		if(itemStack.getItemDamage() < getMaxDamage(itemStack)){
		return itemStack.copy();
		}
		return ItemStack.EMPTY;
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn)
    {
        return EFFECTIVE_ON.contains(blockIn.getBlock());
    }
	
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();

        return EFFECTIVE_ON.contains(block)? 1.0F*ConfigPrimitiveTools.toolSpeedModifier*ConfigPrimitiveTools.KnifeSpeedModifier:0.2F*ConfigPrimitiveTools.toolSpeedModifier*ConfigPrimitiveTools.KnifeSpeedModifier;
    }
	
	@Override
	  public boolean hasContainerItem(ItemStack stack)
	  {
	    return stack.getItemDamage() < getMaxDamage(stack);
	  }
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && (state.getBlockHardness(worldIn, pos) != 0.0D || !(state.getBlock() instanceof BlockBush)))
        {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }
	
	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }
	
	@Override
	public boolean isRepairable()
    {
		return false;
    }
}
