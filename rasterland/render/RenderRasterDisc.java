package powell.rasterland.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import powell.rasterland.entity.EntityDisc;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRasterDisc extends Render
{
    private static final ResourceLocation arrowTextures = new ResourceLocation("rasterland","textures/entities/disc_rev02.png");

    public void renderDisc(EntityDisc entityarrow, double par2, double par4, double par6, float par8, float par9)
    {
        this.bindEntityTexture(entityarrow);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(entityarrow.prevRotationYaw + (entityarrow.rotationYaw - entityarrow.prevRotationYaw) * par9, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(entityarrow.prevRotationPitch + (entityarrow.rotationPitch - entityarrow.prevRotationPitch) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        Tessellator tessellator = Tessellator.instance;
        
        
        int mat = 0;//entityarrow.getWeaponMaterialId();
        float[] color = null;//entityarrow.getMaterialColor();
        float ft0 = 0.0F;
        float ft1 = 0.5F;
        float ft2 = 1.0F;

        float fh = 0.08F;
        float f2 = 0.2F;
        float f3 = 0.9F;
        float f4 = 1.0F - f2;

        float ft3 = 0.5F;
        float ft4 = 0.65625F;
        
        
        float t2 = (3.0F/32.0F)/2.0F;//thickness of disc divded in half
        float sv1 = 33.0F/64.0F;//starting V location of side of disc texture
        float sv2 = 35.0F/64.0F;//stopping V location of side of disc texture
        

        GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        
        //top?
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        tessellator.addVertexWithUV(.5F, t2, .5F, .5F,.5F);
        tessellator.addVertexWithUV(.5F, t2, -.5F, .5F,0F);
        tessellator.addVertexWithUV(-.5F, t2, -.5F, 0F,0F);
        tessellator.addVertexWithUV(-.5F, t2, .5F, 0F,.5F);
        tessellator.draw();
        
        //bottom?
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        tessellator.addVertexWithUV(-.5, -t2, .5, 0,.5);
        tessellator.addVertexWithUV(-.5, -t2, -.5, 0,0);
        tessellator.addVertexWithUV(.5, -t2, -.5, .5,0);
        tessellator.addVertexWithUV(.5, -t2, .5, .5,.5);
        tessellator.draw();
        
        
//        tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, ft1, ft0);
//        tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, ft0, ft0);
//        tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, ft0, ft1);
//        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, ft1, ft1);
//        if (mat != 0)
//        {
//                tessellator.setColorOpaque_F(color[0], color[1], color[2]);
//                tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, ft2, ft0);
//                tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, ft1, ft0);
//                tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, ft1, ft1);
//                tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, ft2, ft1);
//        }
       
//        GL11.glNormal3f(0.0F, -1.0F, 0.0F);
//        tessellator.startDrawingQuads();
//        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
//        tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, ft0, ft1);
//        tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, ft1, ft1);
//        tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, ft1, ft0);
//        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, ft0, ft0);
//        if (mat != 0)
//        {
//                tessellator.setColorOpaque_F(color[0], color[1], color[2]);
//                tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, ft1, ft1);
//                tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, ft2, ft1);
//                tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, ft2, ft0);
//                tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, ft1, ft0);
//        }
//        tessellator.draw();
//
//        float sqrt2 = (float)Math.sqrt(2.0D);
//        GL11.glDisable(2884);
//        GL11.glNormal3f(-sqrt2, 0.0F, sqrt2);
//        tessellator.startDrawingQuads();
//        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
//        tessellator.addVertexWithUV(f2, -fh, f4, ft1, ft3);
//        tessellator.addVertexWithUV(f2, fh, f4, ft1, ft4);
//        tessellator.addVertexWithUV(f3, fh, f4, ft0, ft4);
//        tessellator.addVertexWithUV(f3, -fh, f4, ft0, ft3);
//        if (mat != 0)
//        {
//                tessellator.setColorOpaque_F(color[0], color[1], color[2]);
//                tessellator.addVertexWithUV(f2, -fh, f4, ft2, ft3);
//                tessellator.addVertexWithUV(f2, fh, f4, ft2, ft4);
//                tessellator.addVertexWithUV(f3, fh, f4, ft1, ft4);
//                tessellator.addVertexWithUV(f3, -fh, f4, ft1, ft3);
//        }
//        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
//        tessellator.addVertexWithUV(f2, -fh, f4, ft1, ft3);
//        tessellator.addVertexWithUV(f2, fh, f4, ft1, ft4);
//        tessellator.addVertexWithUV(f2, fh, f2, ft0, ft4);
//        tessellator.addVertexWithUV(f2, -fh, f2, ft0, ft3);
//        if (mat != 0)
//        {
//                tessellator.setColorOpaque_F(color[0], color[1], color[2]);
//                tessellator.addVertexWithUV(f2, -fh, f4, ft2, ft3);
//                tessellator.addVertexWithUV(f2, fh, f4, ft2, ft4);
//                tessellator.addVertexWithUV(f2, fh, f2, ft1, ft4);
//                tessellator.addVertexWithUV(f2, -fh, f2, ft1, ft3);
//        }
//        tessellator.draw();
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        byte b0 = 0;
//        float f2 = 0.0F;
//        float f3 = 0.5F;
//        float f4 = (float)(0 + b0 * 10) / 32.0F;
//        float f5 = (float)(5 + b0 * 10) / 32.0F;
//        float f6 = 0.0F;
//        float f7 = 0.15625F;
//        float f8 = (float)(5 + b0 * 10) / 32.0F;
//        float f9 = (float)(10 + b0 * 10) / 32.0F;
//        float f10 = 0.05625F;
//        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
////        float f11 = (float)par1EntityArrow.arrowShake - par9;
////
////        if (f11 > 0.0F)
////        {
////            float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
////            GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
////        }
//
//        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
//        GL11.glScalef(f10, f10, f10);
//        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
//        GL11.glNormal3f(f10, 0.0F, 0.0F);
//        tessellator.startDrawingQuads();
//        tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f8);
//        tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f8);
//        tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f9);
//        tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f9);
//        tessellator.draw();
//        GL11.glNormal3f(-f10, 0.0F, 0.0F);
//        tessellator.startDrawingQuads();
//        tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f8);
//        tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f8);
//        tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f9);
//        tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f9);
//        tessellator.draw();
//
//        for (int i = 0; i < 4; ++i)
//        {
//            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
//            GL11.glNormal3f(0.0F, 0.0F, f10);
//            tessellator.startDrawingQuads();
//            tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)f2, (double)f4);
//            tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)f3, (double)f4);
//            tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)f3, (double)f5);
//            tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)f2, (double)f5);
//            tessellator.draw();
//        }
//
//        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
//        GL11.glPopMatrix();
    }

    protected ResourceLocation getArrowTextures(EntityDisc par1EntityArrow)
    {
        return arrowTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getArrowTextures((EntityDisc)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderDisc((EntityDisc)par1Entity, par2, par4, par6, par8, par9);
    }
}
