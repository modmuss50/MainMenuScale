package me.modmuss50.mms;

import reborncore.common.registration.RebornRegistry;
import reborncore.common.registration.impl.ConfigRegistry;

@RebornRegistry(modID = "mainmenuscale")
public class Config {

	@ConfigRegistry(comment = "The gui scale for the main menu (0 Auto, 1 small, 2 normal, 3 large)")
	public static int GUI_SCALE = 0;


}
