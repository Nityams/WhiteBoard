import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame {

	// Presenter presenter;
	DShape presenter;
	static Canvas canvas = new Canvas();
	private static int shapeCounter = 0;
	private String[] columnNames = { "X", "Y", "Width", "Height" };

	public UI(DShape presenter) {
		this.presenter = presenter;
		presenter.attachView(this);
		showUI();
	}

	private void showUI() {

		// canvas

		// tablePanel:
		// int numRows = 5 ;
		DefaultTableModel model = new DefaultTableModel(0, columnNames.length);
		model.setColumnIdentifiers(columnNames);

		JTable table = new JTable(model);

		JScrollPane tablePane = new JScrollPane(table);

		// addPanel
		JPanel addPanel = new JPanel(new GridLayout(1, 5));
		addPanel.add(new JLabel("Add"));
		// Btn Rect
		JButton rect = new JButton("Rect");
		rect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				DRect rect = new DRect(50 + rand.nextInt(100), 100 + rand.nextInt(100), 100, 200, Color.gray);
				canvas.addShapes(rect);
				canvas.paintComponent();
				DShape temp = canvas.shapes.get(canvas.shapes.size() - 1);
				model.addRow(new Object[] { Integer.toString(temp.model.x), Integer.toString(temp.model.y),
						Integer.toString(temp.model.height), Integer.toString(temp.model.width) });

				shapeCounter++;

			}

		});
		addPanel.add(rect);
		// Oval
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DOval oval = new DOval(100, 100, 100, 200, Color.red);
				canvas.addShapes(oval);
				canvas.paintComponent();

				DShape temp = canvas.shapes.get(canvas.shapes.size() - 1);
				model.addRow(new Object[] { Integer.toString(temp.model.x), Integer.toString(temp.model.y),
						Integer.toString(temp.model.height), Integer.toString(temp.model.width) });
				shapeCounter++;
			}

		});
		addPanel.add(oval);

		// colorPanel
		JButton setColor = new JButton("Set Color");
		setColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color myColor = JColorChooser.showDialog(((Component) e.getSource()).getParent(), "Choose color",
						Color.gray);
				System.out.println(myColor.toString());
				canvas.ma.colorMe(myColor);

			}

		});
		// textPanel
		// posPanel
		JPanel posPanel = new JPanel();
		posPanel.setLayout(new GridLayout(1, 3));
		// Delete Button
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.ma.thisDelete();

			}

		});
		// Front Button
		JButton front = new JButton("Move to front");
		front.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("please go to front");

				canvas.ma.thisMove(0);

			}

		});
		// Back Button
		JButton back = new JButton("Move to back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("please go to front");

				canvas.ma.thisMove(1);

			}

		});
		posPanel.add(delete);
		posPanel.add(front);
		posPanel.add(back);

		// save/open
		JPanel ioPanel = new JPanel();
		ioPanel.setLayout(new GridLayout(1, 2));
		// save
		JButton output = new JButton("Save");
		output.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				output output = new output();
				output.save();
			}

		});
		// open
		JButton input = new JButton("Open");
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				input input = new input();
				input.open();
			}

		});
		ioPanel.add(input); // open
		ioPanel.add(output);// save

		// serverPanel
//		JPanel connectPane = new JPanel(new GridLayout(1, 2));
//		JButton server = new JButton("Server");
//		server.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Server server = new Server();
//				server.doServer();
//			}
//
//		});
//		JButton client = new JButton("Client");
//		client.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Client client = new Client();
//				client.print();
//			}
//
//		});
//		connectPane.add(server);
//		connectPane.add(client);

		// controls={addPanel, colorPanel,textPanel,posPanel, tablePanel}
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(7, 1));
		controls.add(addPanel);
		controls.add(setColor);
		// controls.add(textPanel)<--------------need add
		controls.add(posPanel);
		controls.add(tablePane);
		controls.add(ioPanel);
		//controls.add(connectPane);

		this.setTitle("WhiteBoard");
		this.setLayout(new BorderLayout());
		this.add(controls, BorderLayout.WEST);
		this.add(canvas, BorderLayout.CENTER);
		// control should use same canvas as WhiteBoard
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static Canvas getCanvas() {
		return canvas;
	}

}
