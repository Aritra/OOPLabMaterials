import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.LinkedList;



public class BasicSwingFrame extends JFrame{
   int selectedCollection=0;
   int row;
   String selectedVal = "";
   String selectedKey = "";
   JTable jt;
   DefaultTableModel model;
   ArrayList<String> myList;
   HashMap<String,String> myMap;
   Map<String, String> treeMap;
   PriorityQueue<String> pq;
   LinkedList<String> ll;
   
   
   public BasicSwingFrame(){
      
      this.setTitle("Java Collections");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      
      JTextField valTF = new JTextField();
      valTF.setEnabled(false);
      JTextField keyTF = new JTextField();
      keyTF.setEnabled(false);
      
      JButton addBtn = new JButton("add");
      addBtn.setEnabled(false);
      JButton editBtn = new JButton("edit");
      editBtn.setEnabled(false);
      JButton delBtn = new JButton("del");
      delBtn.setEnabled(false);
      
      JComboBox sel = new JComboBox();
      sel.addItem("Select a collection");
      sel.addItem("ArrayList");
      sel.addItem("HashMap");
      sel.addItem("TreeMap");
      sel.addItem("PriorityQueue");
      sel.addItem("LinkedList");
      sel.setBounds(30, 30, 240, 30);
      this.add(sel);

      sel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0){
            selectedCollection = sel.getSelectedIndex();
         }
      });
      
      JButton freezeOption = new JButton("Freeze Collection");
      freezeOption.setBounds(30,80,240,30);
      this.add(freezeOption);
      
      freezeOption.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		      if(selectedCollection==1){
            		   myList = new ArrayList<String>();
            	      }
            	      else if(selectedCollection==2){
                	   myMap = new HashMap<String,String>();
            	      }
            	      else if(selectedCollection==3){
                	   treeMap = new TreeMap<String,String>();
            	      }
            	      else if(selectedCollection==4){
                	   pq = new PriorityQueue<String>();
            	      }
            	      else if(selectedCollection==5){
                	   ll = new LinkedList<String>();;
            	      }
		      sel.setEnabled(false);
		      valTF.setEnabled(true);
		      if((selectedCollection==2)||(selectedCollection==3)){
		          keyTF.setEnabled(true);
		      }
		      addBtn.setEnabled(true);
		      editBtn.setEnabled(true);
		      delBtn.setEnabled(true);
		   }
	   });
	
      JLabel keyLbl = new JLabel("Key: ");
      JLabel valLbl = new JLabel("Val: ");
      keyLbl.setBounds(30,130,50,30);
      keyTF.setBounds(90,130,180,30);
      valLbl.setBounds(30,180,50,30);
      valTF.setBounds(90,180,180,30);
      
      addBtn.setBounds(30,230,74,30);
      editBtn.setBounds(113,230,74,30);
      delBtn.setBounds(196,230,74,30);
      
      this.add(keyLbl);
      this.add(keyTF);
      this.add(valLbl);
      this.add(valTF);
      this.add(addBtn);
      this.add(editBtn);
      this.add(delBtn);
      
      model = new DefaultTableModel();
      model.addColumn("Key");
      model.addColumn("Value");
      jt = new JTable(model);
      
      jt.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        row = jt.rowAtPoint(evt.getPoint());
		        
		        if (row >= 0) {
		           selectedVal = (String)jt.getValueAt(row, 1);
		           selectedKey = (String)jt.getValueAt(row, 0);
		           keyTF.setText(selectedKey);
		           valTF.setText(selectedVal);
		        }
		    }
		});

      jt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				row = jt.getSelectedRow();
		        if (row >= 0) {
		           selectedVal = (String)jt.getValueAt(row, 1);
		           selectedKey = (String)jt.getValueAt(row, 0);
		           keyTF.setText(selectedKey);
		           valTF.setText(selectedVal);
		        }
			}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
      
      addBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    if(selectedCollection==1){
		        myList.add(valTF.getText());
		        model.addRow(new Object[]{(myList.size()-1) +"",valTF.getText()});
		    }
		    else if(selectedCollection==2){
		    	myMap.put(keyTF.getText(),valTF.getText());
		    	if(myMap.containsKey(keyTF.getText())){
		    		model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				for (String i : myMap.keySet()) {
  				   model.addRow(new Object[]{i, myMap.get(i)});
				}
		    	}
		    	else{
		    	model.addRow(new Object[]{keyTF.getText(), valTF.getText()});
		    	}
		    }
			else if(selectedCollection==3){
		    	treeMap.put(keyTF.getText(),valTF.getText());
		    	if(treeMap.containsKey(keyTF.getText())){
		    		model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				for (String i : treeMap.keySet()) {
  				   model.addRow(new Object[]{i, treeMap.get(i)});
				}
		    	}
		    	else{
		    	model.addRow(new Object[]{keyTF.getText(), valTF.getText()});
		    	}
		    }
			else if(selectedCollection==4){
		        pq.add(valTF.getText());
		        model.addRow(new Object[]{(pq.size()-1) +"",valTF.getText()});
		    }
			else if(selectedCollection==5){
		        ll.add(valTF.getText());
		        model.addRow(new Object[]{(ll.size()-1) +"",valTF.getText()});
		    }

		}
	});

      editBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    if(selectedCollection==1){
		    	myList.set(row,valTF.getText());
		    	model.setValueAt(keyTF.getText(), row, 0);
		    	model.setValueAt(valTF.getText(), row, 1);
		    }
		    else if(selectedCollection==2){
		    	myMap.put(keyTF.getText(),valTF.getText());
		    	model.setValueAt(keyTF.getText(), row, 0);
		    	model.setValueAt(valTF.getText(), row, 1);
		    }
			else if(selectedCollection==3){
		    	treeMap.put(keyTF.getText(),valTF.getText());
		    	model.setValueAt(keyTF.getText(), row, 0);
		    	model.setValueAt(valTF.getText(), row, 1);
		    }
			else if(selectedCollection==4){
		    	pq.add(valTF.getText());
		    	model.setValueAt(keyTF.getText(), row, 0);
		    	model.setValueAt(valTF.getText(), row, 1);
		    }
			else if(selectedCollection==5){
		    	ll.set(row,valTF.getText());
		    	model.setValueAt(keyTF.getText(), row, 0);
		    	model.setValueAt(valTF.getText(), row, 1);
		    }

		}
	});
      
      
      delBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    if(selectedCollection==1){
		    	myList.remove(row);
		    	model.removeRow(row);
		    	keyTF.setText("");
		    	valTF.setText("");
		    }
		    else if(selectedCollection==2){
		        myMap.remove(keyTF.getText());
		        model.removeRow(row);
		        keyTF.setText("");
		    	valTF.setText("");
		    }
			else if(selectedCollection==3){
		        treeMap.remove(keyTF.getText());
		        model.removeRow(row);
		        keyTF.setText("");
		    	valTF.setText("");
		    }
			else if(selectedCollection==4){
		    	pq.remove(row);
		    	model.removeRow(row);
		    	keyTF.setText("");
		    	valTF.setText("");
		    }
			else if(selectedCollection==5){
		    	ll.remove(row);
		    	model.removeRow(row);
		    	keyTF.setText("");
		    	valTF.setText("");
		    }
		}
	});
      
      
      
      
      jt.setBounds(20,20,300,2000);
		JScrollPane js = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(300,30,340,370);
      this.add(js);
      
      
      this.setBounds(40,40,660,440);
      this.setVisible(true);
      
   }
}
