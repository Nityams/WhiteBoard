import java.awt.*;
import java.awt.Component;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.*;
import java.io.*;
import javax.swing.*;

public class input {

	  public void open() {
          String result = JOptionPane.showInputDialog("File Name", null);
          if (result != null) {
              File f = new File(result);
              open(f);
          }
      }
	   /*
	    Reads in all the dots from the file and set the panel
	    to show them.
	    */
	    public void open(File file) {
	        DShape[] dotArray = null;
	        try {
	            // Create an XMLDecoder around the file
	            XMLDecoder xmlIn = new XMLDecoder(new BufferedInputStream(
	            new FileInputStream(file))); 
	            // Read in the whole array of DotModels
	            dotArray = (DShape[]) xmlIn.readObject();
	            xmlIn.close();
	            // Now we have the data, so go ahead and wipe out the old state
	            // and put in the new. Goes through the same doAdd() bottleneck
	            // used by the UI to add dots.
	            // Note that we do this after the operations that might throw.
	            clear();
	            for(DShape dm:dotArray) {
	                doAdd(dm);
	            }
	            //setDirty(false);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Clears out all the data (used by new docs, and for opening docs)
	    public void clear() {
	        UI.canvas.shapes.clear();
	        boolean dirty = false;
	        UI.canvas.repaint(); 
	    }
	    /*
	    Utility -- given a completed dot model, adds it and sets things up.
	    This is the bottleneck for adding a dot.
	    */
	    public void doAdd(DShape dotModel) {
	        UI.canvas.shapes.add(dotModel);
	        UI.canvas.repaint();
	        //setDirty(true);
	    }

	public void print(){
		System.out.println("success input");
	}
	
}
