package powell.rasterland.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import powell.rasterland.block.Blocks;
import powell.rasterland.block.GridGlass;
import powell.rasterland.block.RasterBlock;
import powell.rasterland.network.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderRasterBlock implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		Tessellator tessellator = Tessellator.instance;
		if (modelID == ClientProxy.rasterBlockRenderType) 
		{
			Block base;

			if(block instanceof GridGlass)
				base = Blocks.gridGlassBase;
			else
				base = Block.stone;

			block.setBlockBoundsForItemRender();
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, +1.0F, 0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceYPos(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(1));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, -1.0F, 0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceYNeg(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(0));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1.0F, 0F, 0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceZNeg(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(2));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, 0F, -1.0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceXPos(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(3));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(+1.0F, 0F, 0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceZPos(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(4));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
			tessellator.draw();
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, 0F, +1.0F);
			renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
			renderer.renderFaceXNeg(Block.stone, 0.0D, 0.0D, 0.0D, base.getBlockTextureFromSide(5));
			renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
			tessellator.draw();
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) 
	{
		RasterBlock handlerBlock = (RasterBlock) block;
		ClientProxy.rasterBlockRenderStage = 0;
		renderer.setRenderBounds(0.001, 0.001, 0.001, 0.999, 0.999, 0.999);
		renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxy.rasterBlockRenderStage = 1;
		renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
		renderer.clearOverrideBlockTexture();
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxy.rasterBlockRenderStage = 0;
		renderer.clearOverrideBlockTexture();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() 
	{
		return true;
	}

	@Override
	public int getRenderId() 
	{
		return ClientProxy.rasterBlockRenderType;
	}

}
