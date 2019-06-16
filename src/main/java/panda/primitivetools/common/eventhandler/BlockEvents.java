package panda.primitivetools.common.eventhandler;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import panda.primitivetools.ConfigPrimitiveTools;
import panda.primitivetools.MaterialMultiplexer;
import panda.primitivetools.common.crafting.KnappRecipe;
import panda.primitivetools.common.item.PrimitiveKnife;
import panda.primitivetools.common.item.PrimitiveSpade;
import panda.primitivetools.init.ModItems;

@Mod.EventBusSubscriber
public class BlockEvents {
	
	private BlockEvents(){
		throw new IllegalStateException("Utility class");
	}
	
	//Portions of code from Primal Core. Thanks An_sar!
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event)
	{
	  EntityPlayer player = event.getEntityPlayer();
	  World world = player.getEntityWorld();
	  Random rand = world.rand;
	  if (world.isRemote) {
	    return;
	  }
	  	
	    ItemStack heldStack = event.getEntityPlayer().getHeldItemMainhand();
	    if (!heldStack.isEmpty())
	    {
	      IBlockState state = world.getBlockState(event.getPos());
	      Block block = state.getBlock();
	      
	      if (!block.hasTileEntity(state) && MaterialMultiplexer.forMaterial(Material.ROCK, Material.GLASS, Material.IRON, Material.ANVIL ).apply(state))
	        {
	    	  
	          KnappRecipe recipe = KnappRecipe.getRecipe(heldStack);
	          if (recipe != null)
	          {
	            BlockPos pos = event.getPos();
	            
	            float blockHardness = state.getBlockHardness(world, pos);
	            float craftHardness = recipe.getHardness();
	            float failureChance = recipe.getFailure();
	            
	            if (((blockHardness >= craftHardness) || (blockHardness < -0.0F) || state.getMaterial() == Material.ANVIL || state.getMaterial() == Material.IRON || state.getMaterial() == Material.ROCK) && (!player.isSwingInProgress))
	            {
	              
	              player.swingArm(EnumHand.MAIN_HAND);
	              world.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_CHICKEN_STEP, SoundCategory.PLAYERS, 1.0F, 1.0F);
	              ItemStack[] outputs = recipe.getOutputs();
	              if (rand.nextFloat() > failureChance ) {
	            	  for(ItemStack output : outputs){
	            		  spawnAsEntity(event.getFace(),world, pos, new ItemStack(output.getItem(), rand.nextGaussian() > 0.3? rand.nextGaussian() > 0.6? 2:1:0));  
	            	  }
	            	  player.inventory.decrStackSize(player.inventory.currentItem, 1);
	             }
	             
	            }
	          }
	        }
	    }
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onBlockDrops(BlockEvent.HarvestDropsEvent e)
	{
		Block block = e.getState().getBlock();
		EntityPlayer player = e.getHarvester();

		if (player == null)
		{
			return;
		}

		ItemStack held = player.getHeldItemMainhand();
		Random rand = player.world.rand;

		if (block == Blocks.VINE && !e.isSilkTouching() && held != null &&
				held.getItem() instanceof PrimitiveKnife){
			
			if(ConfigPrimitiveTools.vineDropChance != 0 &&  rand.nextInt(ConfigPrimitiveTools.vineDropChance) == 0) {
				e.getDrops().add(new ItemStack(Blocks.VINE));
			}
			return;
		}


		if ((block == Blocks.TALLGRASS || block == Blocks.DOUBLE_PLANT) && !e.isSilkTouching())
		{
			int chance = ConfigPrimitiveTools.fiberDropChance;
			
			if(chance == 0) {
				return;
			}
			
			if (held != null && held.getItem() instanceof PrimitiveKnife)
			{
				chance -= chance*0.4f;
				for (int i = 0; i < 4; i++) {//TODO can be a config value
					java.util.List<ItemStack> items = block.getDrops(e.getWorld(), e.getPos(), e.getState(), e.getFortuneLevel());
					for (ItemStack item : items) {
						e.getDrops().add(item);
					}
				}
			}
			if (rand.nextInt(chance) == 0)
			{
				e.getDrops().add(new ItemStack(ModItems.PLANT_FIBER));
			}
			
			return;
		}
		
		if (block == Blocks.SAND && !e.isSilkTouching())
		{
			int chance = ConfigPrimitiveTools.flintSandDropChance;
			if(chance == 0) {
				return;
			}
			
			if (held != null && (held.getItem() instanceof PrimitiveSpade || held.getItem() instanceof ItemSpade))
			{
				chance -= chance*0.375f;
			}
			
			if (rand.nextInt(chance) == 0)
			{
				e.getDrops().add(new ItemStack(Items.FLINT));
			}
			return;
		}
		
		if (block == Blocks.GRAVEL && !e.isSilkTouching())
		{
			int chance = ConfigPrimitiveTools.flintGravelDropChance;
			
			if(chance == 0) {
				return;
			}
			
			if (held != null && (held.getItem() instanceof PrimitiveSpade || held.getItem() instanceof ItemSpade))
			{
				chance -= chance*0.375f;
			}
			
			if (rand.nextInt(chance) == 0)
			{
				e.getDrops().add(new ItemStack(Items.FLINT));
			}
			return;
		}
	}
	
	@SubscribeEvent
	public static void slaughterEvent(LivingHurtEvent e)
	{
		if (e.getSource() != null && e.getSource().getTrueSource() instanceof EntityPlayer) {
			EntityPlayer player = ((EntityPlayer) e.getSource().getTrueSource());
			if (player != null) {
				ItemStack holding = player.inventory.getStackInSlot(player.inventory.currentItem);
				if (!holding.isEmpty() && holding.getItem() instanceof PrimitiveKnife && e.getEntity() instanceof EntityAnimal) {
					e.getEntityLiving().setHealth((e.getEntityLiving().getHealth()-4)<0?0:e.getEntityLiving().getHealth()-4);
				}
			}
		}
	}
	
	public static void spawnAsEntity(EnumFacing enumFacing, World worldIn, BlockPos pos, ItemStack stack)
    {
        if (!worldIn.isRemote && !stack.isEmpty())
        {
            double d0 = (double)(worldIn.rand.nextFloat() * 0.5F) + 0.25D;
            double d2 = (double)(worldIn.rand.nextFloat() * 0.5F) + 0.25D;
            BlockPos newpos = pos.offset(enumFacing).add(d0, 0, d2 );
            EntityItem entityitem = new EntityItem(worldIn, (double)newpos.getX(), (double)newpos.getY(), (double)newpos.getZ(), stack);
            entityitem.setDefaultPickupDelay();
            worldIn.spawnEntity(entityitem);
        }
    }
}
