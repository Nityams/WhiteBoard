import java.awt.Color;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Client {
	 private String field; 
	    private JTextArea textArea;
	    private String status;
	    private java.util.List<ObjectOutputStream> outputs =
	            new ArrayList<ObjectOutputStream>();
	 // Initiate message send -- send both local annd remote (must be on swing thread)
    // Wired to text field.
    public void doSend() {
        DShapeModel message = new DShapeModel();
        message.setX(message.getX());
        message.setY(message.getY());
        message.setHeight(message.getHeight());
        message.setWidth(message.getWidth());
        message.setColor(message.getColor());
        sendLocal(message);
        sendRemote(message);
        field=("");
    }
    // Appends a message to the local GUI (must be on swing thread)
    public void sendLocal(DShapeModel message) {
        message = new DShapeModel(message.getX(),message. getY(), message.getHeight(),message.getWidth(), message.getColor());
    }
    // Sends a message to all of the outgoing streams.
    // Writing rarely blocks, so doing this on the swing thread is ok,
    // although could fork off a worker to do it.
    public synchronized void sendRemote(DShapeModel message) {
        status=("Server send");
        System.out.println("server: send " + message);

        // Convert the message object into an xml string.
        OutputStream memStream = new ByteArrayOutputStream();
        XMLEncoder encoder = new XMLEncoder(memStream);
        encoder.writeObject(message);
        encoder.close();
        String xmlString = memStream.toString();
        // Now write that xml string to all the clients.
        Iterator<ObjectOutputStream> it = outputs.iterator();
        while (it.hasNext()) {
            ObjectOutputStream out = it.next();
            try {
                out.writeObject(xmlString);
                out.flush();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                it.remove();
                // Cute use of iterator and exceptions --
                // drop that socket from list if have probs with it
            }
        }
    }
    
    public static class Message {
        public String text;
        public Date date;

        public Message() {
            text = null;
            date = null;
        }

        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }

        public Date getDate() { 
            return date;
        }
        public void setDate(Date date) {
            this.date = date;
        }
        public String toString() {
            return "message: " + text;
        }
    }
	
	public void print(){
		System.out.println("Start Client");
	}
}
