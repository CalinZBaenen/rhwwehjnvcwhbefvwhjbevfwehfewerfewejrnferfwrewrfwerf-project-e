package com.calinzbaenen;





final class EnvisionAppMenus {
	private DocumentPropertiesUI documentPropertiesUi = null;
	private DocumentViewUI       documentViewUi       = null;
	private boolean              instantiated         = false;
	
	void instantiate() {
		if(this.instantiated) return;
		
		this.documentPropertiesUi = new DocumentPropertiesUI();
		this.documentViewUi       = new DocumentViewUI();
		this.instantiated         = true;
	}
	
	DocumentPropertiesUI propsView() { return this.documentPropertiesUi; }
	
	DocumentViewUI docView() { return this.documentViewUi; }
}