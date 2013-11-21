package powell.rasterland.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import powell.rasterland.Rasterland;
import powell.rasterland.properties.RasterizedPlayer;

public class EnergyBarGui extends Gui
{
	private Minecraft mc;
	//texture file must be 256x256 (or a multiple of)
	private static final ResourceLocation texturepath = new ResourceLocation("rasterland","textures/gui/mana_bar2.png");

	public EnergyBarGui(Minecraft mc)
	{
		super();
		this.mc = mc;
	}



	// This event is called by GuiIngameForge during each frame by
	// GuiIngameForge.pre() and GuiIngameForce.post().
	//
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		// We draw after the ExperienceBar has drawn. The event raised by GuiIngameForge.pre()
		// will return true from isCancelable. If you call event.setCanceled(true) in
		// that case, the portion of rendering which this event represents will be canceled.
		// We want to draw *after* the experience bar is drawn, so we make sure isCancelable() returns
		// false and that the eventType represents the ExperienceBar event.
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		if(mc.thePlayer.dimension != Rasterland.DIMENSIONID)
		{
			return;
		}

		//get player properties
		RasterizedPlayer props = RasterizedPlayer.get(this.mc.thePlayer);

		// If for some reason these properties don't exist (perhaps in multiplayer?)
		// or the player doesn't have mana, return. Note that I added a new method
		// 'getMaxMana()' to ExtendedPlayer for this purpose
		if (props == null || props.getMaxEnergy() == 0)
		{
			return;
		}

		// Starting position for the mana bar - 2 pixels from the top left corner.
		int xPos = 2;
		int yPos = 2;

		// The center of the screen can be gotten like this during this event:
		// int xPos = event.resolution.getScaledWidth() / 2;
		// int yPos = event.resolution.getScaledHeight() / 2;

		// Be sure to offset based on your texture size or your texture will not be truly centered:
		// int xPos = (event.resolution.getScaledWidth() + textureWidth) / 2;
		// int yPos = (event.resolution.getScaledHeight() + textureHeight) / 2;

		// setting all color values to 1.0F will render the texture as it looks in your texture file
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// Somewhere in Minecraft vanilla code it says to do this because of a lighting bug
		GL11.glDisable(GL11.GL_LIGHTING);

		// Bind your texture to the render engine
		this.mc.getTextureManager().bindTexture(texturepath);

		
		
		//requires mana_bar2.png instead of mana_bar.png
		// Add this block of code before you draw the section of your texture containing transparency
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		// Here we draw the background bar which contains a transparent section; note the new size
		// You can keep drawing without changing anything
		int manabarwidth = (int)(((float) props.getEnergy() / props.getMaxEnergy()) * 49);
		//for(int xx = 0; xx < manabarwidth; xx++)
		drawTexturedModalRect(xPos + 3, yPos + 3, 0, 9, manabarwidth, 3);
		
		drawTexturedModalRect(xPos, yPos, 0, 0, 56, 9);
		
		// NOTE: be sure to reset the openGL settings after you're done or your character model will be messed up
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		
		/*
		 * perhaps if you add a switch based off a player variable
		 * you can have color coded energy bars that relate to color
		 * of disc and certain powerups		
		*/
		
		
		
		
		
		
		/*
		The parameters for drawTexturedModalRect are as follows:

		drawTexturedModalRect(int x, int y, int u, int v, int width, int height);

		x and y are the on-screen position at which to render.
		u and v are the coordinates of the most upper-left pixel in your texture file from which to start drawing.
		width and height are how many pixels to render from the start point (u, v)
		 */
		// First draw the background layer. In my texture file, it starts at the upper-
		// left corner (x=0, y=0), ends at 50 pixels (so it's 51 pixels long) and is 4 pixels thick (y value)
		
		//uncomment the two lines below to change back to mana_bar.png and lose transparency in bar.
//		this.drawTexturedModalRect(xPos, yPos, 0, 0, 51, 4);
		// Then draw the foreground; it's located just below the background in my
		// texture file, so it starts at x=0, y=4, is only 2 pixels thick and 49 length
		// Why y=4 and not y=5? Y starts at 0, so 0,1,2,3 = 4 pixels for the background

		// However, we want the length to be based on current mana, so we need a new variable:
		
		
//		int manabarwidth = (int)(((float) props.getEnergy() / props.getMaxEnergy()) * 49);
	//	System.out.println("[GUI MANA] Current mana bar width: " + manabarwidth);
		// Now we can draw our mana bar at yPos+1 so it centers in the background:
		this.drawTexturedModalRect(xPos, yPos + 1, 0, 4, manabarwidth, 2);
	}



}


