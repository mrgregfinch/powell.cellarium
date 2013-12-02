package powell.rasterland.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import powell.rasterland.entity.EntityRasterBike3;
import powell.rasterland.models.ModelRasterBike;

public class RenderRasterBike2 extends Render
{
	private static final ResourceLocation texture = new ResourceLocation("rasterland", "textures/models/RasterBike-1.png");

	protected ModelRasterBike model;
	
	public RenderRasterBike2()
	{
		model = new ModelRasterBike();
	}
	
	public void renderBike(EntityRasterBike3 spaceship, double x, double y, double z, float yaw, float partialTickTime)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);     

        
        bindEntityTexture(spaceship);
        
        model.render(spaceship, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glPopMatrix();
    }

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1)
	{
		renderBike((EntityRasterBike3)entity, d0, d1, d2, f, f1);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
