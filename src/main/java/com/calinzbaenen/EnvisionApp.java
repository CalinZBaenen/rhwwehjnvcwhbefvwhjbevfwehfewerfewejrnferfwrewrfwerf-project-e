package com.calinzbaenen;

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
	private static final Application       app    = new Application("com.calinzbaenen.Envision", ApplicationFlags.DEFAULT_FLAGS);
	
	public static void main(String[] args) {
		EnvisionApp.app.onActivate(EnvisionApp::initialize);
		EnvisionApp.app.run(args);
		
		try {
			var stream = EnvisionApp.class.getResourceAsStream("app.css");
			if(stream != null) System.out.println( new String(stream.readAllBytes()) );
			else System.out.println("The resource app.css does not exist(?).");
		} catch(Exception e) {
			System.out.println("An error occurred.");
			System.out.println(e);
		}
	}
	
	/**
	* Initializes the program and window, loading the headmenu automatically.
	*/
	private static void initialize() {
		var applicationCss = new CssProvider();
		applicationCss.loadFromResource("app.css");
		
		EnvisionApp.window = new ApplicationWindow(app);
		EnvisionApp.window.setDefaultSize(950, 525);
		EnvisionApp.window.setTitlebar(Titlebar.instance);
		EnvisionApp.window.setTitle("Envision");
		
		Titlebar.instance.refreshSize();
		
		EnvisionApp.window.present();
	}
}