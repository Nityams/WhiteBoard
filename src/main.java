
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//UI ui = new UI(new DShape());
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (Exception ignored) { 
         } 
         for (int i=0 ;i<2; i++ ) { // for testing, handy to make a few at a time
            new UI(new DShape());

         }

	}
	
}
