package panda.primitivetools.client.renderer;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import panda.primitivetools.PrimitiveTools;
import panda.primitivetools.common.entity.EntitySpear;
import panda.primitivetools.init.ModItems;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpear extends Render<EntitySpear>
{

	public static final Factory FACTORY = new Factory();

	public RenderSpear(RenderManager renderManagerIn)
	{
		super(renderManagerIn);
	}

	@Override
	public void doRender(EntitySpear entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		this.bindEntityTexture(entity);
		
		
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GlStateManager.translate(0.0F, 0.125F, 0.0F);
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();
		GlStateManager.enableRescaleNormal();


		//GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
		//GlStateManager.rotate(45.0F, 0.0F, 01.0F, 0.0F);
		
		GlStateManager.rotate(-45.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.scale(1F, 1F, 1F);
		

		if(this.renderOutlines)
		{
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
		}
		
		GlStateManager.glNormal3f(1F, 0.0F, 0.0F);
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexbuffer.pos(-0.5D, -0.5D, -0.5D).tex(0.0D, 0.15625D).endVertex();
		vertexbuffer.pos(-0.5D, -0.5D, 0.5D).tex(0.15625D, 0.15625D).endVertex();
		vertexbuffer.pos(-0.5D, 0.5D, 0.5D).tex(0.15625D, 0.3125D).endVertex();
		vertexbuffer.pos(-0.5D, 0.5D, -0.5D).tex(0.0D, 0.3125D).endVertex();
		tessellator.draw();
		GlStateManager.glNormal3f(-1F, 0.0F, 0.0F);
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
		vertexbuffer.pos(-0.5D, 0.5D, -0.5D).tex(0.0D, 0.15625D).endVertex();
		vertexbuffer.pos(-0.5D, 0.5D, 0.5D).tex(0.15625D, 0.15625D).endVertex();
		vertexbuffer.pos(-0.5D, -0.5D, 0.5D).tex(0.15625D, 0.3125D).endVertex();
		vertexbuffer.pos(-0.5D, -0.5D, -0.5D).tex(0.0D, 0.3125D).endVertex();
		tessellator.draw();
	
		
			//GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.glNormal3f(0.0F, 1.0F, 0F);
			vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
			vertexbuffer.pos(-0.5D, -0.5D, 0.0D).tex(0.0D, 1.0D).endVertex();
			vertexbuffer.pos(0.5D, -0.5D, 0.0D).tex(1D, 1D).endVertex();
			vertexbuffer.pos(0.5D, 0.5D, 0.0D).tex(1D, 0D).endVertex();
			vertexbuffer.pos(-0.5D, 0.5D, 0.0D).tex(0.0D, 0D).endVertex();
			tessellator.draw();
			
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.glNormal3f(0.0F, 1.0F, 0F);
			vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
			vertexbuffer.pos(-0.5D, -0.5D, 0.0D).tex(0.0D, 1.0D).endVertex();
			vertexbuffer.pos(0.5D, -0.5D, 0.0D).tex(1D, 1D).endVertex();
			vertexbuffer.pos(0.5D, 0.5D, 0.0D).tex(1D, 0D).endVertex();
			vertexbuffer.pos(-0.5D, 0.5D, 0.0D).tex(0.0D, 0D).endVertex();
			tessellator.draw();
			
			GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(-45.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.glNormal3f(0.0F, 1.0F, 0F);
			vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
			vertexbuffer.pos(-0.5D, -0.5D, 0.0D).tex(0.0D, 1.0D).endVertex();
			vertexbuffer.pos(0.5D, -0.5D, 0.0D).tex(1D, 1D).endVertex();
			vertexbuffer.pos(0.5D, 0.5D, 0.0D).tex(1D, 0D).endVertex();
			vertexbuffer.pos(-0.5D, 0.5D, 0.0D).tex(0.0D, 0D).endVertex();
			tessellator.draw();
			
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.glNormal3f(0.0F, 1.0F, 0F);
			vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
			vertexbuffer.pos(-0.5D, -0.5D, 0.0D).tex(0.0D, 1.0D).endVertex();
			vertexbuffer.pos(0.5D, -0.5D, 0.0D).tex(1D, 1D).endVertex();
			vertexbuffer.pos(0.5D, 0.5D, 0.0D).tex(1D, 0D).endVertex();
			vertexbuffer.pos(-0.5D, 0.5D, 0.0D).tex(0.0D, 0D).endVertex();
			tessellator.draw();
		

		if(this.renderOutlines)
		{
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySpear entity){
		String name = entity.getItem().getItem().getRegistryName().getPath();
		String key = name.substring(Math.max(name.length() - 3, 0));
		//if
		return new ResourceLocation(PrimitiveTools.MODID, "textures/items/spears/primitive_spear_"+key+"_large.png");
	}
	
	public static class Factory implements IRenderFactory<EntitySpear> {

        @Override
        public Render<? super EntitySpear> createRenderFor(RenderManager manager) {
            return new RenderSpear(manager);
        }

    }
}