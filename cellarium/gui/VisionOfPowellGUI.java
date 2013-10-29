package powell.cellarium.gui;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.mcf.davidee.guilib.basic.BasicScreen;
import com.mcf.davidee.guilib.basic.Label;
import com.mcf.davidee.guilib.basic.BasicScreen.CloseHandler;
import com.mcf.davidee.guilib.core.Button;
import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Button.ButtonHandler;
import com.mcf.davidee.guilib.vanilla.ButtonVanilla;
import com.mcf.davidee.guilib.vanilla.ScrollbarVanilla;
import com.mcf.davidee.paintinggui.PaintingSelectionMod;
import com.mcf.davidee.paintinggui.gui.PaintingButton;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.EnumArt;

public class VisionOfPowellGUI extends BasicScreen implements ButtonHandler
{
	
	private Container container;
	private Container visionContainer;
	private Scrollbar scrollbar;
	private Label title;
	private Button back;
	//private PaintingButton[] buttons;
	private final int visionID;
	
	public VisionOfPowellGUI(int id)
	{
		super(null);
		visionID = id;
	}

	@Override
	protected void reopenedGui() { }
	
	@Override
	protected void unhandledKeyTyped(char c, int code) {
		if (code == Keyboard.KEY_ESCAPE)
			close();
	}

	public void updateScreen() {
		super.updateScreen();
		if (mc.thePlayer == null || !mc.thePlayer.isEntityAlive())
			close();
	}

	@Override
	protected void revalidateGui() {
		final int START_X = 10, START_Y = 30;
		final int END_X = width - 10;
		final int GAP = 5;
		
		title.setPosition(width/2, 10);
		back.setPosition(width/2 - 100, height - 25);
		scrollbar.setPosition(width - 10, START_Y - 2);
		
		int x = START_X;
		int y = START_Y;//, prevHeight = buttons[0].getHeight();
		int rowStartIndex = 0;
		
		/*for (int index = 0; index < buttons.length; ++index) 
		{
			PaintingButton cur = buttons[index];
			
			if (x + cur.getWidth() > END_X || prevHeight > cur.getHeight()) {
				centerRow(rowStartIndex, index - 1);
				rowStartIndex = index;
				x = START_X;
				y += GAP + prevHeight;
				prevHeight = cur.getHeight();
			}
			
			cur.setPosition(x, y);
			x += cur.getWidth() + GAP;
		}
		
		centerRow(rowStartIndex, buttons.length - 1);*/
		
		visionContainer.revalidate(START_X, START_Y - 2, width - 10, height - 55);
		container.revalidate(0, 0, width, height);
	}
	
	private void centerRow(int start, int end) {
		//int left = buttons[start].getX();
		//int right = buttons[end].getX() + buttons[end].getWidth();

		//We're 10 pixels away from each edge
		//int correction = (width - 20 - (right - left)) / 2;
		//for (int i = start; i <= end; ++i) 
		//	buttons[i].shiftX(correction);
	}

	@Override
	protected void createGui() {
		scrollbar = new ScrollbarVanilla(10);
		visionContainer = new Container(scrollbar, 0, 4);
		container = new Container();
		title = new Label("Vision of Powell");
		back = new ButtonVanilla("Cancel", new CloseHandler());
		
		EnumArt[] enumArts = EnumArt.values();
		ArrayList<EnumArt> validArts = new ArrayList<EnumArt>();
//		for (String s : art)
//			for (EnumArt enumArt : enumArts)
//				if (enumArt.title.equals(s)){
//					validArts.add(enumArt);
//					break;
//				}
		
//		EnumArt[] validArtsArray = validArts.toArray(new EnumArt[0]);
//		buttons = new PaintingButton[validArtsArray.length];
//		for (int i = 0; i < validArtsArray.length; ++i)
//			buttons[i] = new PaintingButton(validArtsArray[i], this);
		
		container.addWidgets(title, back);
		//visionContainer.addWidgets(buttons);
		
		containers.add(visionContainer);
		containers.add(container);
		selectedContainer = visionContainer;
	}
	
	@Override
	public void buttonClicked(Button button) {
		//String artTitle = ((PaintingButton)button).art.title;
		//Packet250CustomPayload packet = PaintingSelectionMod.createPacket(visionID, new String[] {artTitle});
		//if (packet != null)
			//PacketDispatcher.sendPacketToServer(packet);
		mc.displayGuiScreen(null);
	}

	
	@Override
	public void drawBackground() 
	{
		super.drawBackground();
		drawRect(visionContainer.left(), visionContainer.top(), visionContainer.right()-10, visionContainer.bottom(), 0x44444444);
	}
}
