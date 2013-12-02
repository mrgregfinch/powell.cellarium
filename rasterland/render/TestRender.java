package powell.rasterland.render;

import org.lwjgl.opengl.GL11;

import powell.rasterland.network.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TestRender implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer)
	{
		
		 Icon icon = block.getBlockTextureFromSide(2);

		// this.bindEntityTexture();
	     //   GL11.glPushMatrix();
	        GL11.glTranslatef((float)x, (float)y, (float)z);
//	        GL11.glRotatef(entityarrow.prevRotationYaw + (entityarrow.rotationYaw - entityarrow.prevRotationYaw) * par9, 0.0F, 0.0F, 1.0F);
//	        GL11.glRotatef(entityarrow.prevRotationPitch + (entityarrow.rotationPitch - entityarrow.prevRotationPitch) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
	        Tessellator tessellator = Tessellator.instance;
	        int lightValue = block.getMixedBrightnessForBlock(world, x, y, z);
	        tessellator.setBrightness(lightValue);
	        
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
	        

	       // GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
	   //     GL11.glColor3f(1.0F, 1.0F, 1.0F);
	        
	        //top?
	     //   GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	    //   tessellator.startDrawingQuads();
	        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
	        tessellator.addVertexWithUV(.5F, t2, .5F, icon.getMinU()/2,icon.getMinV()/2);
	        tessellator.addVertexWithUV(.5F, t2, -.5F, icon.getMinU()/2,icon.getMinV());
	        tessellator.addVertexWithUV(-.5F, t2, -.5F, icon.getMinU(),icon.getMinV());
	        tessellator.addVertexWithUV(-.5F, t2, .5F,icon.getMinU(),icon.getMinV()/2);
	     //   tessellator.draw();
	        
	        //bottom?
	 //       GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	   //     tessellator.startDrawingQuads();
	        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
	        tessellator.addVertexWithUV(-.5, -t2, .5, 0,.5);
	        tessellator.addVertexWithUV(-.5, -t2, -.5, 0,0);
	        tessellator.addVertexWithUV(.5, -t2, -.5, .5,0);
	        tessellator.addVertexWithUV(.5, -t2, .5, .5,.5);
	     //   tessellator.draw();
	        
	        

	 //       GL11.glEnable(2884);
	      //  GL11.glPopMatrix();
	        
	        return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId()
	{
		// TODO Auto-generated method stub
		return ClientProxy.renderTestType;
	}

}
