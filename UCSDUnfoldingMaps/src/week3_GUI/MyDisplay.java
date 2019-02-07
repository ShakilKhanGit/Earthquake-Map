package week3_GUI;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet {
	
	private String url = "http://cseweb.ucsd.edu/~minnes/palmTrees.jpg";
	private PImage backgroundImage;
	
	public void setup() {

		backgroundImage = loadImage(url, "jpg");
		backgroundImage.resize(600,0);
		
		size (backgroundImage.width, backgroundImage.height);
		background(200,200,200);

	}
	
	public void draw() {
		image(backgroundImage, 0 , 0);
		
		int brightness = brightnessController(second());
			
		fill(brightness,brightness,0);
		ellipse(width/7,height/6, width/9, height/6);
		
	}
	
	public int brightnessController(float second) {
		
		float diff = Math.round(Math.abs(second-30));
		int num = (int) (diff*255/30);
		
		return num;
	}

}
