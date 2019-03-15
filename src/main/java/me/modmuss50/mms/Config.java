package me.modmuss50.mms;

import reborncore.common.registration.RebornRegistry;
import reborncore.common.registration.impl.ConfigRegistry;

@RebornRegistry(modID = "mainmenuscale")
public class Config {

	@ConfigRegistry(comment = "The gui scale for the main menu (0 Auto, 1 small, 2 normal, 3 large)")
	public static int GUI_SCALE = 0;

	@ConfigRegistry(comment = "-1 disabled, the min height that should be used to see if the high res scale should be used")
	public static int HIGH_RES_HEIGHT = -1;

	@ConfigRegistry(comment = "The gui scale for the main menu with high res (0 Auto, 1 small, 2 normal, 3 large)")
	public static int HIGH_RES_SCALE = 0;

}
