import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BaseFrame extends JFrame{
    JTextField tf1;
    JTextArea ta1;
    JScrollPane sp1;
    JPasswordField pf1;
    JLabel lb1;
    JButton b1;
    JComboBox<String> cb1;
    JCheckBox chb1;
    JCheckBox chb2;
    JRadioButton rb1;
    JRadioButton rb2;
    JSlider sl1;

    public BaseFrame(){
        this.setTitle("Java Swing Playground");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        tf1 = new JTextField();
        tf1.setBounds(20, 20, 250, 30);
        this.add(tf1);

        pf1 = new JPasswordField();
        pf1.setBounds(20, 60, 250, 30);
        this.add(pf1);

        ta1 = new JTextArea();
        ta1.setBounds(0, 0, 250, 500);
        sp1 = new JScrollPane(ta1);
        sp1.setBounds(280, 20, 250, 100);
        this.add(sp1);

        b1 = new JButton("Show pass");
        b1.setBounds(20, 100, 250, 30);
        this.add(b1);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf1.setText(pf1.getText());
            }
        });

        lb1 = new JLabel("Intial text");
        lb1.setBounds(280, 130, 250, 50);
        this.add(lb1);

        cb1 = new JComboBox<String>();
        cb1.setBounds(280, 190, 250, 30);
        cb1.addItem("Hyderabad");
        cb1.addItem("Pilani");
        cb1.addItem("Goa");
        this.add(cb1);

        chb1 = new JCheckBox("Has car");
        chb2 = new JCheckBox("Has scooty");
        chb1.setBounds(20,150,250,30);
        chb2.setBounds(20,190,250,30);
        this.add(chb1);
        this.add(chb2);

        rb1 = new JRadioButton("Residential");
        rb2 = new JRadioButton("Non Residential");
        rb1.setBounds(20,230,250,30);
        rb2.setBounds(20,270,250,30);
        ButtonGroup G1 = new ButtonGroup();
        G1.add(rb1);
        G1.add(rb2);
        this.add(rb1);
        this.add(rb2);

        sl1 = new JSlider(1,100);
        sl1.setMajorTickSpacing(5);
        sl1.setBounds(20,310,250,30);
        sl1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                lb1.setText(cb1.getSelectedItem().toString()+" value :" + sl1.getValue()); 
            }
        });
        this.add(sl1);
        
        this.setBounds(40,40,660,440);
        this.setVisible(true);
    }
}
