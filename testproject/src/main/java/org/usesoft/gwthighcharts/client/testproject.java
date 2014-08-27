package org.usesoft.gwthighcharts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class testproject implements EntryPoint {

	public void onModuleLoad() {
		DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);

		SimpleLayoutPanel container = new SimpleLayoutPanel();
		container.getElement().setId("container");

		dlp.addNorth(new Label("North"), 100);
		dlp.addWest(new Label("West"), 100);
		dlp.addSouth(new Label("South"), 100);
		dlp.add(container);
		RootLayoutPanel.get().add(dlp);

		displayChart(TitleJso.create("test ronan"));
	}

	interface Title {
		String getText();
	}

	/** The JSO implementation of Person. */
	public static class TitleJso extends JavaScriptObject implements Title {
		protected TitleJso() {
		}

		public static native TitleJso create(String text) /*-{
			return {
				text : text
			};
		}-*/;

		public final native String getText() /*-{
			return this.text;
		}-*/;
	}

	public static native void displayChart(TitleJso title) /*-{

		var option = {
			subtitle : {
				text : 'Source: WorldClimate.com',
				x : -20
			},
			xAxis : {
				categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul',
						'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ]
			},
			yAxis : {
				title : {
					text : 'Temperature (°C)'
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : '°C'
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			series : [
					{
						name : 'Tokyo',
						data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5,
								23.3, 18.3, 13.9, 9.6 ]
					},
					{
						name : 'New York',
						data : [ -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1,
								20.1, 14.1, 8.6, 2.5 ]
					},
					{
						name : 'Berlin',
						data : [ -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9,
								14.3, 9.0, 3.9, 1.0 ]
					},
					{
						name : 'London',
						data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6,
								14.2, 10.3, 6.6, 4.8 ]
					} ]
		};
		
		option.title = title;

		$wnd.jQuery('#container').highcharts(option);
	}-*/;

}
