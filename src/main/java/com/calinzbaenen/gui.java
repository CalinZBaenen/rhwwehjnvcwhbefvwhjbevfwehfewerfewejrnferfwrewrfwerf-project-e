package com.calinzbaenen;

import org.jetbrains.annotations.Nullable;

import org.gnome.gtk.FlowBox;
import org.gnome.gtk.Button;
import org.gnome.gtk.Align;
import org.gnome.gtk.Label;





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
		this.documentPropertiesButton.setLabel("Document Properties");
		
		this.previewToolsButton = new Button();
		this.previewToolsButton.setCursorFromName("pointer");
		this.previewToolsButton.setLabel("Preview Tools");
		
		this.closeWindowButton = new Button();
		this.closeWindowButton.setCursorFromName("pointer");
		this.closeWindowButton.onClicked(() -> { if(EnvisionApp.window != null) EnvisionApp.window.close(); });
		this.closeWindowButton.setHalign(Align.END);
		this.closeWindowButton.setLabel("X");
		
		this.fmtMenuButton = new Button();
		this.fmtMenuButton.setCursorFromName("pointer");
		this.fmtMenuButton.setLabel("Formatting");
		
		this.homeButton = new Button();
		this.homeButton.setCursorFromName("pointer");
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