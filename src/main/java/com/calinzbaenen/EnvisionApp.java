package com.calinzbaenen;

import java.io.IOException;

// import org.jsoup.parser.ParseSettings;
// import org.jsoup.parser.Parser;

// import org.gnome.gdk.Display;
// import org.gnome.gdk.Cursor;

import org.gnome.gio.ApplicationFlags;

import org.gnome.gtk.ApplicationWindow;
import org.gnome.gtk.Application;
import org.gnome.gtk.CssProvider;
// import org.gnome.gtk.Button;
// import org.gnome.gtk.Label;





public class EnvisionApp {
	        static       ApplicationWindow window = null;
	        static final EnvisionAppMenus  menus  = new EnvisionAppMenus();
	private static final Application       app    = new Application("com.calinzbaenen.Envision", ApplicationFlags.DEFAULT_FLAGS);
	
	public static void main(String[] args) {
		EnvisionApp.app.onActivate(EnvisionApp::initialize);
		EnvisionApp.app.run(args);
	}
	
	/**
	* Initializes the program and window, loading the headmenu automatically.
	*/
	private static void initialize() {
		var applicationCss = new CssProvider();
		try { applicationCss.loadFromString(new String( EnvisionApp.class.getResourceAsStream("/app.css").readAllBytes() )); }
		catch(IOException e) { System.out.printf("error loading application's stylesheet: %s\n", e); }
		catch(Exception e) { System.out.printf("an unexpected error occurred: %s\n", e); }
		
		EnvisionApp.menus.instantiate();
		
		EnvisionApp.window = new ApplicationWindow(app);
		EnvisionApp.window.setDefaultSize(950, 525);
		EnvisionApp.window.setTitlebar(Titlebar.instance);
		EnvisionApp.window.setChild(EnvisionApp.menus.docView());
		EnvisionApp.window.setTitle("Envision");
		
		Titlebar.instance.refreshSize();
		
		EnvisionApp.window.present();
	}
}