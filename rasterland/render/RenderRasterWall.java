package powell.rasterland.render;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import powell.rasterland.block.RasterWall;
import powell.rasterland.network.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderRasterWall implements ISimpleBlockRenderingHandler
{

	@Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		
		boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = true;
        boolean flag3 = true;
        float f = 0.25F;
        float f1 = 0.75F;
        float f2 = 0.25F;
        float f3 = 0.75F;
        float f4 = 1.0F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag && flag1 && !flag2 && !flag3)
        {
            f4 = 0.8125F;
            f = 0.3125F;
            f1 = 0.6875F;
        }
        else if (!flag && !flag1 && flag2 && flag3)
        {
            f4 = 0.8125F;
            f2 = 0.3125F;
            f3 = 0.6875F;
        }
		
		
		
            Tessellator tessellator = Tessellator.instance;
            if (modelID == ClientProxy.rasterWallRenderType) {
                    block.setBlockBoundsForItemRender();
                    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0F, +1.0F, 0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceYPos(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(1));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0F, -1.0F, 0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceYNeg(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(0));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(-1.0F, 0F, 0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceZNeg(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(2));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0F, 0F, -1.0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceXPos(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(3));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(+1.0F, 0F, 0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceZPos(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(4));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
                    tessellator.draw();
                    tessellator.startDrawingQuads();
                    tessellator.setNormal(0F, 0F, +1.0F);
                    renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
                    renderer.renderFaceXNeg(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(5));
                    renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
                    renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
                    tessellator.draw();
                    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) 
    {
    	/*
    	 boolean flag = this.canConnectWallTo(world, x, y, z - 1, block);
         boolean flag1 = this.canConnectWallTo(world, x, y, z + 1, block);
         boolean flag2 = this.canConnectWallTo(world, x - 1, y, z, block);
         boolean flag3 = this.canConnectWallTo(world, x + 1, y, z, block);
         float f = 0.25F;
         float f1 = 0.75F;
         float f2 = 0.25F;
         float f3 = 0.75F;
         float f4 = 1.0F;

         if (flag)
         {
             f2 = 0.0F;
         }

         if (flag1)
         {
             f3 = 1.0F;
         }

         if (flag2)
         {
             f = 0.0F;
         }

         if (flag3)
         {
             f1 = 1.0F;
         }

         if (flag && flag1 && !flag2 && !flag3)
         {
             f4 = 0.8125F;
             f = 0.3125F;
             f1 = 0.6875F;
         }
         else if (!flag && !flag1 && flag2 && flag3)
         {
             f4 = 0.8125F;
             f2 = 0.3125F;
             f3 = 0.6875F;
         }
    	
    	
    	
            RasterWall handlerBlock = (RasterWall) block;
            ClientProxy.rasterWallRenderStage = 0;
            renderer.setRenderBounds(f+.001, 0.0F+.001, f2+.001, f1-.001, f4-.001, f3-.001);
            renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
            renderer.renderStandardBlock(block, x, y, z);
            ClientProxy.rasterWallRenderStage = 1;
            renderer.setRenderBounds(f, 0.0F, f2, f1, f4, f3);
            renderer.clearOverrideBlockTexture();
            renderer.renderStandardBlock(block, x, y, z);
            ClientProxy.rasterWallRenderStage = 0;
            renderer.clearOverrideBlockTexture();
            return true;*/
    	
    	boolean flag = this.canConnectWallTo(world, x - 1, y, z, block);
        boolean flag1 = this.canConnectWallTo(world, x + 1, y, z, block);
        boolean flag2 = this.canConnectWallTo(world, x, y, z - 1, block);
        boolean flag3 = this.canConnectWallTo(world, x, y, z + 1, block);
        boolean flag4 = flag2 && flag3 && !flag && !flag1;
        boolean flag5 = !flag2 && !flag3 && flag && flag1;
        boolean flag6 = world.isAirBlock(x, y + 1, z);
        
        
        
      double f;
      double f1;
      double f2;
      double f3;
      double f4;
      double f5;
        
        
        

        if ((flag4 || flag5) && flag6)
        {
            if (flag4)
            {
            	f = .3125;
            	f1 = 0.0;
            	f2 = 0.0;
            	f3 = .6875;
            	f4 = .8125;
            	f5 = 1.0;
            	
            	
            	RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
            	
            	
            	
            	
            	//renderer.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 1.0D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }
            else
            {
            	
            	f = 0.0;
            	f1 = 0.0;
            	f2 = 0.3125;
            	f3 = 1.0;
            	f4 = .8125;
            	f5 = .6875;
            	
            	
            	RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
            	
            	
            	//renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }
        }
        else
        {
        	
        	f = .25;
        	f1 = 0.0;
        	f2 = 0.25;
        	f3 = .75;
        	f4 = 1.0;
        	f5 = .75;
        	
        	
        	RasterWall handlerBlock = (RasterWall) block;
            ClientProxy.rasterWallRenderStage = 0;
            renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
            renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
            renderer.renderStandardBlock(block, x, y, z);
            ClientProxy.rasterWallRenderStage = 1;
            renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
            renderer.clearOverrideBlockTexture();
            renderer.renderStandardBlock(block, x, y, z);
            ClientProxy.rasterWallRenderStage = 0;
            renderer.clearOverrideBlockTexture();
        	
        	
        	
        //	renderer.setRenderBounds(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
        //	renderer.renderStandardBlock(block, x, y, z);

            if (flag)
            {
            	f = 0.0;
            	f1 = 0.0;
            	f2 = .3125;
            	f3 = .25;
            	f4 = .8125;
            	f5 = .6875;
            	
            	
            //	RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
            	
            	
            	//renderer.setRenderBounds(0.0D, 0.0D, 0.3125D, 0.25D, 0.8125D, 0.6875D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }

            if (flag1)
            {
            	f = .75;
            	f1 = 0.0;
            	f2 = 0.3125;
            	f3 = 1.0;
            	f4 = .8125;
            	f5 = .6875;
            	
            	
            	//RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
            	
            	
            	//renderer.setRenderBounds(0.75D, 0.0D, 0.3125D, 1.0D, 0.8125D, 0.6875D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }

            if (flag2)
            {
            	
            	f = .3125;
            	f1 = 0.0;
            	f2 = 0.0;
            	f3 = .6875;
            	f4 = .8125;
            	f5 = .25;
            	
            	
            //	RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
                
                
            	//renderer.setRenderBounds(0.3125D, 0.0D, 0.0D, 0.6875D, 0.8125D, 0.25D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }

            if (flag3)
            {
            	f = .3125;
            	f1 = 0.0;
            	f2 = 0.75;
            	f3 = .6875;
            	f4 = .8125;
            	f5 = 1.0;
            	
            	
            	//RasterWall handlerBlock = (RasterWall) block;
                ClientProxy.rasterWallRenderStage = 0;
                renderer.setRenderBounds(f+.001, f1+.001, f2+.001, f3-.001, f4-.001, f5-.001);
                renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 1;
                renderer.setRenderBounds(f,f1, f2, f3, f4, f5);
                renderer.clearOverrideBlockTexture();
                renderer.renderStandardBlock(block, x, y, z);
                ClientProxy.rasterWallRenderStage = 0;
                renderer.clearOverrideBlockTexture();
            	
            	
            	//renderer.setRenderBounds(0.3125D, 0.0D, 0.75D, 0.6875D, 0.8125D, 1.0D);
            	//renderer.renderStandardBlock(block, x, y, z);
            }
        }
       // par1BlockWall.setBlockBoundsBasedOnState(this.blockAccess, par2, par3, par4);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
            return true;
    }

    @Override
    public int getRenderId() {
            return ClientProxy.rasterWallRenderType;
    }
    
    public boolean canConnectWallTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, Block b)
    {
        int l = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (l != b.blockID )
        {
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }

}
