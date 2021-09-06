package src;
import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		SortPanel panel = new SortPanel(100);
		
		try {
			if(args[0].equals("bubble")){
				JFrame frame = new JFrame(args[0]+" "+"Sort Visualzation");
				frame.setSize(800,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.add(panel);
				frame.setVisible(true);
				panel.bubbleSort();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("unimplemented sorting algorithm. Rerun the application and pass a string of an implemented sorting algorithm.");
			System.exit(1);
		}
		System.exit(1);
	}
}