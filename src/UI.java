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



public class UI extends JFrame{

	// Presenter presenter;
	DShape presenter;
	static Canvas canvas = new Canvas();
	private static int shapeCounter = 0;
	private String[] columnNames={"X","Y","Width","Height"};
	
	
	public UI(DShape presenter) {
		this.presenter = presenter;
		presenter.attachView(this);
		showUI();
	}

	private void showUI() {

		// canvas

		// tablePanel: doesn't update unless u click on the entry
	//	int numRows = 5 ;
	    DefaultTableModel model = new DefaultTableModel(0, columnNames.length) ;
		model.setColumnIdentifiers(columnNames);
		
		//model.addRow(canvas.shapes.toArray());//<-------------------------------------------------
		JTable table = new JTable(model);
			
//		JTable table = new JTable(data, columnNames);
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
				DRect rect = new DRect(50+rand.nextInt(100), 100+rand.nextInt(100), 100, 200, Color.gray);
				canvas.addShapes(rect);
				canvas.paintComponent();
				DShape temp = canvas.shapes.get(canvas.shapes.size()-1);
				model.addRow(new Object[] {Integer.toString(temp.model.x),Integer.toString(temp.model.y),Integer.toString(temp.model.height),Integer.toString(temp.model.width)});
//				System.out.println(canvas.shapes.toArray());
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
		//		data[shapeCounter] = oval.getArray();
				DShape temp = canvas.shapes.get(canvas.shapes.size()-1);
				model.addRow(new Object[] {Integer.toString(temp.model.x),Integer.toString(temp.model.y),Integer.toString(temp.model.height),Integer.toString(temp.model.width)});
				shapeCounter++;
			}

		});
		addPanel.add(oval);

		// colorPanel
		// textPanel
		// posPanel

		// controls={addPanel, colorPanel,textPanel,posPanel, tablePanel}
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(6, 1));
		controls.add(addPanel);
		
		JButton update = new JButton("Update table");
		update.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("clicked");
				model.fireTableDataChanged();
				table.repaint();
			}
			
		});
		controls.add(update);
		
		JButton setColor = new JButton("Set Color");
		setColor.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Color myColor = JColorChooser.showDialog(((Component) e.getSource())
			            .getParent(), "Choose color", Color.gray);
				System.out.println(myColor.toString());
				canvas.ma.colorMe(myColor);
				
//				canvas.move.model.setColor(myColor);
//				canvas.paintComponent();
				}
			
		});
		controls.add(setColor);
		controls.add(new JButton("xxx"));
		controls.add(new JButton("ggg"));
		
		controls.add(tablePane);
	

		this.setTitle("WhiteBoard test");
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
