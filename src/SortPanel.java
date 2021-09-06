package src;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SortPanel extends JPanel {
	private static final int maxPixelHeightOfEllipse = 375;
	private int[] array;

	public SortPanel(int arrSize) {
		this.array = new int[arrSize];
		this.fill();
	}
	
	//make sure that this is okay
	public SortPanel(int[] input) {
		this.array = input;
	}

	private void fill() {
		for(int i=0; i<this.array.length; i++) {
			this.array[i] = randIntZeroToInclusiveUpper(maxPixelHeightOfEllipse);
		}
	}

	private int randIntZeroToInclusiveUpper(int upperLimit) {
		int x = (int)(Math.random()*upperLimit)+1;
		return x>=6 ? x : 6;  //Any number less than 6 will be changed to a 6 because it is almost too small to see.
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	 
		g.setColor(Color.DARK_GRAY);
		int barWidth = getWidth()/array.length;
		for(int i=0; i<this.array.length; i++) {
			int xInit = i*barWidth;
			int yInit = getHeight()-this.array[i]; 
			g.fillOval(xInit, yInit, 5, 5);
		}
	}

	public void bubbleSort() {
		int left, right;

		for(right=this.array.length-1; right>1; right--){ 
			for(left=0; left<right; left++){
				if(array[left] > array[left+1]){
					swap(left, left+1);
					repaint();
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}       
		}   
	} 

	private void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/*
	More sorting algorithms can be added here and called from the Driver. After each update of the sequence, repaint the sequence and sleep with a thread for 2 milliseconds.
	*/

}