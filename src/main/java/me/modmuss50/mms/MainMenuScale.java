package me.modmuss50.mms;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;

@Mod(modid = "mainmenuscale", name = "Main Menu Scale", clientSideOnly = true, dependencies = "required-after:reborncore")
public class MainMenuScale {

	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(this);
	}

	private boolean isMenuOpen = false;
	private int guiScale = -1;
	private int lastHeight = 0;

	private strictfp float

	@SubscribeEvent
	public void initGuiPre(GuiScreenEvent.InitGuiEvent.Pre event){
		if(event.getGui() instanceof GuiMainMenu || event.getGui().getClass().getName().equals("lumien.custommainmenu.gui.GuiCustom")){
			openMainMenu(event.getGui());
		} else {
			closeMainMenu();
		}
	}

	public void openMainMenu(GuiScreen gui){
		int height = Display.getHeight();
		if(isMenuOpen && lastHeight == height){
			return;
		}
		lastHeight = height;
		if(!isMenuOpen){
			guiScale = Minecraft.getMinecraft().gameSettings.guiScale;
		}
		isMenuOpen = true;

		int scale = Config.GUI_SCALE;
		if(Config.HIGH_RES_HEIGHT != -1){
			if(height >= Config.HIGH_RES_HEIGHT){
				scale = Config.HIGH_RES_SCALE;
			}
		}
		Minecraft.getMinecraft().gameSettings.guiScale = scale;
		updateRes();
	}

	public void closeMainMenu(){
		if(!isMenuOpen){
			lastHeight = -1;
			return;
		}
		isMenuOpen = false;
		Minecraft.getMinecraft().gameSettings.guiScale = guiScale;
		updateRes();
	}

	public void updateRes(){
		Minecraft minecraft = Minecraft.getMinecraft();
		ScaledResolution scaledresolution = new ScaledResolution(minecraft);
		int i = scaledresolution.getScaledWidth();
		int j = scaledresolution.getScaledHeight();
		minecraft.currentScreen.setWorldAndResolution(minecraft, i, j);
	}

}
