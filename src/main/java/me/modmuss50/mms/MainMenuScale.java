package me.modmuss50.mms;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "mainmenuscale", name = "Main Menu Scale", clientSideOnly = true)
public class MainMenuScale {

	@Mod.EventHandler
	public void init(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(this);
	}

	private boolean isMenuOpen = false;
	private int guiScale = -1;

	@SubscribeEvent
	public void initGuiPre(GuiScreenEvent.InitGuiEvent.Pre event){
		if(event.getGui() instanceof GuiMainMenu || event.getGui().getClass().getName().equals("lumien.custommainmenu.gui.GuiCustom")){
			openMainMenu();
		} else {
			closeMainMenu();
		}
	}

	public void openMainMenu(){
		if(isMenuOpen){
			return;
		}
		isMenuOpen = true;
		guiScale = Minecraft.getMinecraft().gameSettings.guiScale;
		Minecraft.getMinecraft().gameSettings.guiScale = 0;
		updateRes();
	}

	public void closeMainMenu(){
		if(!isMenuOpen){
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
