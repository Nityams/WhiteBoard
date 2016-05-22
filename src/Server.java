import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
	private String status;
	private ServerAccepter serverAccepter;
	private java.util.List<ObjectOutputStream> outputs = new ArrayList<ObjectOutputStream>();

	public void doServer() {
		status = ("Start server");
		String result = JOptionPane.showInputDialog("Run server on port", "8001");
		if (result != null) {
			System.out.println("server: start");
			serverAccepter = new ServerAccepter(Integer.parseInt(result.trim()));
			serverAccepter.start();
		}
	}

	public synchronized void addOutput(ObjectOutputStream out) {
		outputs.add(out);
	}

	// Server thread accepts incoming client connections
	class ServerAccepter extends Thread {
		private int port;

		ServerAccepter(int port) {
			this.port = port;
		}

		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(port);
				while (true) {
					Socket toClient = null;
					// this blocks, waiting for a Socket to the client
					toClient = serverSocket.accept();
					System.out.println("server: got client");
					// Get an output stream to the client, and add it to
					// the list of outputs
					// (our server only uses the output stream of the
					// connection)
					addOutput(new ObjectOutputStream(toClient.getOutputStream()));
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void print() {
		System.out.println("Start Server");
	}

}
