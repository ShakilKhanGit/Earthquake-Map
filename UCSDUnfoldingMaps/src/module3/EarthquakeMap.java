package module3;

import processing.core.PApplet;

import java.util.List;
import java.util.ArrayList;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;


public class EarthquakeMap extends PApplet{
	
	private UnfoldingMap map;
	private AbstractMapProvider microsoft = new Microsoft.RoadProvider(); 
	
	public void setup() {
		size(1100, 600, OPENGL);
		map = new UnfoldingMap(this,50,50,800,450, microsoft);
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		Location l1 = new Location(34.645, 46.179);
		Feature f1 = new PointFeature(l1);
		f1.addProperty("Title", "Bahdad, Iraq");
		f1.addProperty("Magnitude", "7.5");
		f1.addProperty("Date", "03/21");
		f1.addProperty("Year", "2018");
		
		Location l2 = new Location(42.957565, -78.823426);
		Feature f2 = new PointFeature(l2);
		f2.addProperty("Title", "Buffalo, NY, USA");
		f2.addProperty("Magnitude", "11.2");
		f2.addProperty("Date", "03/31");
		f2.addProperty("Year", "2010");

		List <PointFeature> features = new ArrayList<PointFeature>();
		features.add((PointFeature) f1);
		features.add((PointFeature) f2);

		List<Marker> markers = new ArrayList<Marker>();
		
		for (PointFeature eq: features) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}			
		
		map.addMarkers(markers);
		
		int red = color(255,0,0);
		int green = color(0,255,0);
	
		for(Marker mk:markers) {
			if((int) mk.getProperty("Magnitude")>=10.0) mk.setColor(red);	
			else mk.setColor(green);	
		}
		
	}
	
	public void draw() {
		background(175);
		map.draw();
		addKey();
	}
	
	public void addKey() {
		fill(150);
		rect(875, 300, 150, 200, 8);
		
		fill(255,255,255);
		text("word", 885, 320); 

	}
	
}
