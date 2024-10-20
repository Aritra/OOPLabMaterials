import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddEditPanel extends JFrame {
    JTextField nameField;
    JTextField idField;
    JComboBox<Major> majorField;
    JTextField sfField;
    JTextField gradField;
    JTextField stipendField;

    void dismissPanel() {
        this.dispose();
    }

    void addNewStudent(DefaultTableModel model) throws InvalidIDException {
        if (idField.getText().length() < 6) {
            throw new InvalidIDException(this);
        } else {
            FDStudent fdStudent = new FDStudent(nameField.getText(), idField.getText(),
                    (Major) majorField.getSelectedItem(), sfField.getText(), stipendField.getText());
            Global.myMap.put(idField.getText(), fdStudent);
            if (Global.myMap.containsKey(idField.getText())) {
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                for (String i : Global.myMap.keySet()) {
                    model.addRow(new Object[] { i, Global.myMap.get(i).name });
                }
            } else {
                model.addRow(new Object[] { fdStudent.ID, fdStudent.name });
            }
        }
    }

    public AddEditPanel(Boolean addStudent, String key, DefaultTableModel model, int row) {
        if (addStudent) {
            this.setTitle("Add");
        } else {
            this.setTitle("Edit");
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        JLabel nameLabel = new JLabel("Name");
        JLabel idLabel = new JLabel("ID");
        JLabel majorLabel = new JLabel("Major");
        JLabel sfLabel = new JLabel("12th Marks");
        JLabel gradLabel = new JLabel("Graduation Marks");
        JLabel stipendLabel = new JLabel("Stipend");

        nameField = new JTextField();
        idField = new JTextField();
        majorField = new JComboBox<Major>(Major.values());
        sfField = new JTextField();
        gradField = new JTextField();
        stipendField = new JTextField();

        nameLabel.setBounds(20, 20, 200, 30);
        nameField.setBounds(230, 20, 200, 30);
        this.add(nameField);
        this.add(nameLabel);

        idLabel.setBounds(20, 60, 200, 30);
        idField.setBounds(230, 60, 200, 30);
        this.add(idField);
        this.add(idLabel);

        majorLabel.setBounds(20, 100, 200, 30);
        majorField.setBounds(230, 100, 200, 30);
        this.add(majorField);
        this.add(majorLabel);

        sfLabel.setBounds(20, 140, 200, 30);
        sfField.setBounds(230, 140, 200, 30);
        this.add(sfField);
        this.add(sfLabel);

        gradLabel.setBounds(20, 180, 200, 30);
        gradField.setBounds(230, 180, 200, 30);
        this.add(gradField);
        this.add(gradLabel);

        stipendLabel.setBounds(20, 220, 200, 30);
        stipendField.setBounds(230, 220, 200, 30);
        this.add(stipendField);
        this.add(stipendLabel);

        JButton addEditButton = new JButton();
        if (addStudent) {
            addEditButton.setText("Add Student");
            addEditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        addNewStudent(model);
                        dismissPanel();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } else {
            addEditButton.setText("Edit Student");
            BITSStudent student = Global.myMap.get(key);
            nameField.setText(student.name);
            idField.setText(student.ID);
            idField.setEditable(false);
            majorField.setSelectedItem(student.major);
            sfField.setText(student.schoolFinalPercentage + "");
            stipendField.setText(student.stipend + "");
            addEditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FDStudent fdStudent = new FDStudent(nameField.getText(), idField.getText(),
                            (Major) majorField.getSelectedItem(), sfField.getText(), stipendField.getText());
                    Global.myMap.put(idField.getText(), fdStudent);
                    model.setValueAt(fdStudent.ID, row, 0);
                    model.setValueAt(fdStudent.name, row, 1);
                    dismissPanel();
                }
            });

        }
        addEditButton.setBounds(20, 260, 410, 30);
        this.add(addEditButton);

        this.setBounds(40, 40, 460, 400);
        this.setVisible(true);

    }

}
