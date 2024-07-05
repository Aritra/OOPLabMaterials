import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BasicSwingFrame extends JFrame {
	int selectedCollection = 0;
	int row;
	String selectedVal = "";
	String selectedKey = "";
	JTable jt;
	DefaultTableModel model;

	static void saveOnClose() {
		try {
			FileOutputStream fileOut = new FileOutputStream(Global.masterFileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			objectOut.writeObject(Global.mapdata);
			objectOut.close();
			System.out.println("The data has been saved successfully!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public BasicSwingFrame() {

		this.setTitle("Student Database");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				BasicSwingFrame.saveOnClose();
				System.exit(0);
			}
		});
		this.setLayout(null);

		JButton viewBtn = new JButton("View");
		JButton addBtn = new JButton("add");
		addBtn.setEnabled(false);
		JButton editBtn = new JButton("edit");
		editBtn.setEnabled(false);
		JButton delBtn = new JButton("del");
		delBtn.setEnabled(false);

		JComboBox<String> sel = new JComboBox<String>();
		sel.addItem("Select Student Type");
		sel.addItem("FD Student");
		sel.addItem("HD Student");
		sel.setBounds(30, 30, 240, 30);
		this.add(sel);

		try {
			FileInputStream fileIn = new FileInputStream(Global.masterFileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			try{
				Global.mapdata = (MapData)objectIn.readObject();
				System.out.println("The data has been read from the file");
				objectIn.close();
			}catch(Exception ex){
				System.out.println("Cannot initiate...exiting!");
				ex.printStackTrace();
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("No data file found, creating new data map");
			Global.mapdata.myMap = new HashMap<String, BITSStudent>();
		}

		sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (sel.getSelectedIndex() == 1) {
					addBtn.setEnabled(true);
					editBtn.setEnabled(true);
					delBtn.setEnabled(true);
				}
			}
		});

		viewBtn.setBounds(30, 160, 240, 30);
		addBtn.setBounds(30, 230, 74, 30);
		editBtn.setBounds(113, 230, 74, 30);
		delBtn.setBounds(196, 230, 74, 30);

		this.add(viewBtn);
		this.add(addBtn);
		this.add(editBtn);
		this.add(delBtn);

		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		jt = new JTable(model);

		jt.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				row = jt.rowAtPoint(evt.getPoint());
				if (row >= 0) {
					selectedVal = (String) jt.getValueAt(row, 1);
					selectedKey = (String) jt.getValueAt(row, 0);
				}
			}
		});

		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				row = jt.getSelectedRow();
				if (row >= 0) {
					selectedVal = (String) jt.getValueAt(row, 1);
					selectedKey = (String) jt.getValueAt(row, 0);
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddEditPanel(true, null, model, row);
			}
		});

		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AddEditPanel(false, selectedKey, model, row);
			}
		});

		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(BasicSwingFrame.this,
						"Are you sure you want to delete " + selectedVal + " ?", "Confirm Action",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					Global.mapdata.myMap.remove(selectedKey);
					model.removeRow(row);
				} else if (result == JOptionPane.NO_OPTION) {
					System.out.println("No pressed instead!");
				}

			}
		});

		if(Global.mapdata.myMap.size()>0){
			for (String i : Global.mapdata.myMap.keySet()) {
                model.addRow(new Object[] { i, Global.mapdata.myMap.get(i).name });
            }
		}

		jt.setBounds(20, 20, 300, 2000);
		JScrollPane js = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(300, 30, 340, 370);
		this.add(js);

		this.setBounds(40, 40, 660, 440);
		this.setVisible(true);

	}
}
