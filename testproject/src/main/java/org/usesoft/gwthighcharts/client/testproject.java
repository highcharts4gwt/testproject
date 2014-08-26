package org.usesoft.gwthighcharts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class testproject implements EntryPoint {

	public void onModuleLoad() {
		SimpleLayoutPanel simpleLayoutPanel = new SimpleLayoutPanel();
		simpleLayoutPanel.setWidget(new Label("Hello World"));
		RootLayoutPanel.get().add(simpleLayoutPanel);
	}
}
