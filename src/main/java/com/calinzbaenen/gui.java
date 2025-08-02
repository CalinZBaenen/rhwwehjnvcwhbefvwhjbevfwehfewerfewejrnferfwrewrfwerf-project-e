package com.calinzbaenen;

import org.jetbrains.annotations.Nullable;

import org.gnome.gtk.FlowBox;
import org.gnome.gtk.Button;
import org.gnome.gtk.Align;
import org.gnome.gtk.Label;
import org.gnome.gtk.Box;





/**
* (A copy of) The document properties user-interface.
*/
final class DocumentPropertiesUI extends Box {
	final Button backButton;
	
	DocumentPropertiesUI() {
		this.backButton = new Button();
		this.backButton.onClicked(() -> {
			final var menu = EnvisionApp.menus.docView();
			if(EnvisionApp.window != null && menu != null) {
				EnvisionApp.window.setDecorated(true);
				EnvisionApp.window.setChild(menu);
			}
		});
		this.backButton.setLabel("Back");
		
		this.append(this.backButton);
		this.append(new Label("Project name:"));
		this.append(new Label("<PROJECT NAME PLACEHOLDER>"));
		this.append(new Label("Location:"));
		this.append(new Label("<PROJECT LOCATION PLACEHOLDER>"));
		this.append(new Label("Authors:"));
		this.append(new Label("<PROJECT AUTHOR(S) PLACEHOLDER>"));
		this.append(new Label("Keywords:"));
		this.append(new Label("<PROJECT KEYWORDS PLACEHOLDER>"));
	}
}



/**
* The base UI for the area with the toolbar and HTML canvas.
*/
final class DocumentViewUI extends Box {
	final Toolbar toolbar;
	final Box     canvas;
	
	DocumentViewUI() {
		this.toolbar = new Toolbar();
		this.canvas  = new Box();
		
		this.append(new Label("DocView Test"));
		this.append(this.toolbar);
		this.append(this.canvas);
	}
}



/**
* The program's titlebar.
*/
final class Titlebar extends FlowBox {
	static final Titlebar instance = new Titlebar();
	
	          private final Button  documentPropertiesButton;
	          private final Button  previewToolsButton;
	          private final Button  closeWindowButton;
	          private final Button  fmtMenuButton;
	          private final Button  homeButton;
	                        int     height;
	@Nullable               Integer width;
	
	private Titlebar() {
		this.documentPropertiesButton = new Button();
		this.documentPropertiesButton.setCursorFromName("pointer");
		this.documentPropertiesButton.setCssClasses(new String[] {"button"});
		this.documentPropertiesButton.onClicked(() -> {
			final var menu = EnvisionApp.menus.propsView();
			if(EnvisionApp.window != null && menu != null) {
				EnvisionApp.window.setDecorated(false);
				EnvisionApp.window.setChild(menu);
			}
		});
		this.documentPropertiesButton.setLabel("Document Properties");
		
		this.previewToolsButton = new Button();
		this.previewToolsButton.setCursorFromName("pointer");
		this.previewToolsButton.setCssClasses(new String[] {"button"});
		this.previewToolsButton.setLabel("Preview Tools");
		
		this.closeWindowButton = new Button();
		this.closeWindowButton.setCursorFromName("pointer");
		this.closeWindowButton.setCssClasses(new String[] {"button"});
		this.closeWindowButton.onClicked(() -> { if(EnvisionApp.window != null) EnvisionApp.window.close(); });
		this.closeWindowButton.setHalign(Align.END);
		this.closeWindowButton.setLabel("X");
		this.closeWindowButton.setName("exit-button");
		
		this.fmtMenuButton = new Button();
		this.fmtMenuButton.setCursorFromName("pointer");
		this.fmtMenuButton.setCssClasses(new String[] {"button"});
		this.fmtMenuButton.setLabel("Formatting");
		
		this.homeButton = new Button();
		this.homeButton.setCursorFromName("pointer");
		this.homeButton.setCssClasses(new String[] {"button"});
		this.homeButton.setLabel("Home");
		
		this.height = 30;
		this.width  = null;
		
		this.setMinChildrenPerLine(5);
		
		this.setCanFocus(false);
		this.setName("envisionapp-titlebar");
		this.append(new Label("Envision"));
		this.append(this.homeButton);
		this.append(this.fmtMenuButton);
		this.append(this.previewToolsButton);
		this.append(this.documentPropertiesButton);
		this.append(this.closeWindowButton);
	}
	
	void refreshSize() {
		Integer width = EnvisionApp.window != null ? EnvisionApp.window.getWidth() : this.width;
		if(width == null) return;
		
		this.setSizeRequest(width.intValue(), this.height);
	}
}



final class Toolbar extends Box {
	//
}