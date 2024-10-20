import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class FileDemo extends JFrame {
	public FileDemo() {
		this.setTitle("Text File Demo");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JTextArea panel = new JTextArea();
		panel.setFont(panel.getFont().deriveFont(20f));
		panel.setSize(600, 1800);
		panel.setLineWrap(false);

		JScrollPane js = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(10, 10, 600, 600);

		JButton open = new JButton("open");
		open.setFont(open.getFont().deriveFont(15f));
		open.setBounds(10, 620, 150, 30);

		JButton save = new JButton("save");
		save.setFont(save.getFont().deriveFont(15f));
		save.setBounds(170, 620, 150, 30);

		JButton up = new JButton("font +");
		up.setFont(up.getFont().deriveFont(15f));
		up.setBounds(330, 620, 100, 30);

		JButton down = new JButton("font -");
		down.setFont(down.getFont().deriveFont(15f));
		down.setBounds(440, 620, 100, 30);

		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float fs = panel.getFont().getSize2D();
				if (fs < 30)
					fs += 1;
				panel.setFont(panel.getFont().deriveFont(fs));
			}
		});

		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float fs = panel.getFont().getSize2D();
				if (fs > 10)
					fs -= 1;
				panel.setFont(panel.getFont().deriveFont(fs));
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
				int r = j.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					String fpath = j.getSelectedFile().getAbsolutePath();
					try {
						PrintWriter outputStream = new PrintWriter(new 
						FileOutputStream(fpath + ".txt"));
						outputStream.println(panel.getText().trim());
						outputStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});

		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
				int r = j.showOpenDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					String fpath = j.getSelectedFile().getAbsolutePath();
					try {
						BufferedReader inStream = new BufferedReader(new FileReader(fpath));
						String line = inStream.readLine();
						while (line != null) {
							panel.setText(panel.getText() + line + "\n");
							line = inStream.readLine();
						}
						inStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		this.add(js);
		this.add(open);
		this.add(save);
		this.add(up);
		this.add(down);
		this.setSize(620, 700);
		this.setLayout(null);
		this.setVisible(true);
	}
}
