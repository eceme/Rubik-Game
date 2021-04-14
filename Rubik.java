//ceng344-Lab2
//201611018
//Ecem Emiroðlu

import java.awt.Color;
import java.util.Random;

public class Rubik {
	
	
	
	Color[] colors = new Color[5];
	Color[] currentColors = new Color[4];
	public Rubik() {
		
	StdDraw.setCanvasSize(500, 500);
	
	colors[0]=Color.blue;
	colors[1]=Color.green;
	colors[2]=Color.pink;
	colors[3]=Color.yellow;
	colors[4]=Color.orange;
	
	
	// Pick random 4 colors with the method you have written
	// Change the currentColors array accordingly with these colors
	currentColors[0] = randomColor();
	currentColors[1] = randomColor();
	currentColors[2] = randomColor(); 
	currentColors[3] = randomColor();
	
	
	
	// Set the colors for filling the squares and call the filledSquare method
	
	//sol ust 1.kare
	StdDraw.setPenColor(currentColors[0]);
	StdDraw.filledSquare(0.25, 0.75, 0.25);
	StdDraw.show();
	
	//sag ust 2.kare
	StdDraw.setPenColor(currentColors[1]);
	StdDraw.filledSquare(0.75, 0.75, 0.25);
	
	//sol alt 3.kare
	StdDraw.setPenColor(currentColors[2]);
	StdDraw.filledSquare(0.25, 0.25, 0.25);
	//sag alt 4.kare
	StdDraw.setPenColor(currentColors[3]);
	StdDraw.filledSquare(0.75, 0.25, 0.25);
	
	}
	// Main method should exactly be this
	public static void main(String[] args) {
	Rubik r = new Rubik();
	
	
	r.play();
	}
	
	// Randomly chooses and returns a Color from your colors[] array
	public Color randomColor() {
		Random rand=new Random();
		int randomNum=rand.nextInt(((colors.length-1)-0)+1)+0;
		
		return colors[randomNum]; 
	}

	
	// Returns true if all 4 squares have the same color, otherwise false
	public boolean match(Color rand1, Color rand2, Color rand3, Color rand4) {
	
		if(rand1==rand2 && rand1==rand3 && rand1==rand4 &&rand2==rand3&& rand2==rand4 && rand3==rand4) {
			return true;
		}else {
			return false;
		}
	}
	
	// Implements the game mechanism, while all squares do not have the same color lets the
	// user press squares to change their colors.
	// When all the squares have matching colors displays a text that says “You won!”
	public void play() {
		String won="You Won";
		while(!match(currentColors[0],currentColors[1],currentColors[2],currentColors[3])) {
			double[] array=mouseLocation();
			int a=whichSquare(array);
			changeColor(a);
			if(match(currentColors[0],currentColors[1],currentColors[2],currentColors[3])){
				StdDraw.setPenColor(Color.black);
				StdDraw.text(0.5, 0.5,won );
				System.out.println("won");
			}
		}
			
		
	
	}
	// Returns a double array which contains x and y coordinates of the mouse location
	
	public double[] mouseLocation() {
		double mouseLoc[]=new double[2];
		
		
			for(;;) {
			if(StdDraw.isMousePressed()) {
				double x=StdDraw.mouseX();
				double y=StdDraw.mouseY();
				mouseLoc[0]=x;
				mouseLoc[1]=y;
				
				return mouseLoc;
				
			}
			
			}
			
		}
		
	// Finds and returns the square which the mouse location resides in
	public int whichSquare(double[] mouseLoc) {
		
		System.out.println("x:"+ mouseLoc[0] );
		System.out.println("y"+ mouseLoc[1] );
		//1.kare sol ust
		if(mouseLoc[0]<0.5 && mouseLoc[1]>0.5) {
			System.out.println("kare1");
			return 1;
		}
		if(mouseLoc[0]>0.5 && mouseLoc[1]>0.5) {
			return 2;
		}
		if(mouseLoc[0]<0.5 && mouseLoc[1]<0.5) {
			return 3;
		}
		if(mouseLoc[0]>0.5 && mouseLoc[1]<0.5) {
			return 4;
		}
		return 0;
	}
	// Takes the square which the user has clicked and changes the color of that square randomly
	public void changeColor(int whichSquare) {
		if(whichSquare==1) {
			currentColors[0] = randomColor();
			StdDraw.setPenColor(currentColors[0]);
			StdDraw.filledSquare(0.25, 0.75, 0.25);
			StdDraw.show();
		}
		if(whichSquare==2) {
			currentColors[1] = randomColor();
			StdDraw.setPenColor(currentColors[1]);
			StdDraw.filledSquare(0.75, 0.75, 0.25);
			StdDraw.show();
		}
		if(whichSquare==3) {
			currentColors[2] = randomColor();
			StdDraw.setPenColor(currentColors[2]);
			StdDraw.filledSquare(0.25, 0.25, 0.25);
			StdDraw.show();
		}
		if(whichSquare==4) {
			currentColors[3] = randomColor();
			StdDraw.setPenColor(currentColors[3]);
			StdDraw.filledSquare(0.75, 0.25, 0.25);
			StdDraw.show();
		}
		
	StdDraw.pause(200);
	
	}
}
