import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.*;
import java.io.*;

import javax.swing.JOptionPane;

public class output {

	public void save(){
		String result = JOptionPane.showInputDialog("File Name", null);
        if (result != null) {
            File f = new File(result);
            save(f);
        }
	}
	/*
    Saves out our state (all the dot models) to the given file.
    Uses Java built-in XMLEncoder.
    */
    public void save(File file) {
        try {
        XMLEncoder xmlOut = new XMLEncoder(
        		new BufferedOutputStream(
        				new FileOutputStream(file)));
            // Could do something like this to control which
            // properties are sent. By default, it just sends
            // all of them with getters/setters, which is fine in this case.
            // xmlOut.setPersistenceDelegate(DotModel.class,
            // new DefaultPersistenceDelegate(
            // new String[]{ "x", "y", "color" }) );
            // Make a DotModel array of everything
            DShapeModel[] modelArray = UI.canvas.shapes.toArray(new DShapeModel[0]);
            // Dump that whole array
            xmlOut.writeObject(modelArray);
            // And we're done!
            xmlOut.close();
           // setDirty(false);
            // Tip: only clear dirty bit *after* all the things that
            // could fail/throw an exception
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	public void print(){
		System.out.println("success output");
		
		
	}

	
}
