// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	private String[] Entries = {"Sprint", "Swim", "Cycle"};
	
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField add1 = new JTextField(6);
    private JTextField add2 = new JTextField(6);
    private JComboBox<String> entry = new JComboBox<>(Entries);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labe = new JLabel(" Entry Type:");
    private JLabel labad1 = new JLabel(" Quantity:");
    private JLabel labad2 = new JLabel(" Recovery:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All");
    private JButton remove = new JButton("Remove");
    

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labe);
        add(entry);
        entry.addActionListener(this);
        add(labad1);
        add(add1);
        add1.setEditable(true);
        add(labad2);
        add(add2);
        add2.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            if (entry.getSelectedItem() == "Sprint") {
            	message = addSprintEntry();
            }
            if (entry.getSelectedItem() == "Swim") {
            	message = addSwimEntry();
            }
            if (entry.getSelectedItem() == "Cycle") {
            	message = addCycleEntry();
            }
            blankDisplay();
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
            blankDisplay();
        }
        if (event.getSource() == findAllByDate) {
            message = findallEntry();
            blankDisplay();
        }
        if (event.getSource() == remove) {
        	message = removeEntry();
        	blankDisplay();
        }
        if (event.getSource() == entry) {
        	if (entry.getSelectedItem() == "Sprint") {
        			labad1.setText(" Quantity:");
        			labad2.setText(" Recovery:");
        	}
        	if (entry.getSelectedItem() == "Swim") {
    			labad1.setText(" Locale:");
    			labad2.setText(" N/A:");
        	}
        	if (entry.getSelectedItem() == "Cycle") {
    			labad1.setText(" Terrain:");
    			labad2.setText(" Tempo:");
        	}
        }
        outputArea.setText(message);
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }
    
    public String addSprintEntry() {
        String message = "Record added\n";
        if(name.getText().isEmpty() ||
        		month.getText().isEmpty() || 
        		day.getText().isEmpty() || 
        		year.getText().isEmpty() ||
        		dist.getText().isEmpty() || 
        		hours.getText().isEmpty() || 
        		mins.getText().isEmpty() || 
        		secs.getText().isEmpty() || 
        		add1.getText().isEmpty() || 
        		add2.getText().isEmpty()  
        		) {
        	message = "Error, Please fill all fields";
        } else if(Integer.parseInt(day.getText()) < 1 || Integer.parseInt(day.getText()) > 31 ||
        		Integer.parseInt(month.getText()) < 1 || Integer.parseInt(month.getText()) > 12 ||
        		year.getText().length() != 4
        		){
        	message = "Error, Please enter a valid date";
        } else {
        System.out.println("Adding Sprint entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        int q = Integer.parseInt(add1.getText());
        int r = Integer.parseInt(add2.getText());
        SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, q, r);
        String unique = uniqueValidate(e);
        if(unique == "") {
        	myAthletes.addEntry(e);
        } else {
        	message = unique;
        }}
        
        return message;
    }
    
    public String addSwimEntry() {
        String message = "Record added\n";
        if(name.getText().isEmpty() ||
        		month.getText().isEmpty() || 
        		day.getText().isEmpty() || 
        		year.getText().isEmpty() ||
        		dist.getText().isEmpty() || 
        		hours.getText().isEmpty() || 
        		mins.getText().isEmpty() || 
        		secs.getText().isEmpty() || 
        		add1.getText().isEmpty()
        		) {
        	message = "Error, Please fill all fields";
        } else if(Integer.parseInt(day.getText()) < 1 || Integer.parseInt(day.getText()) > 31 ||
        		Integer.parseInt(month.getText()) < 1 || Integer.parseInt(month.getText()) > 12 ||
        		year.getText().length() != 4
        		){
        	message = "Error, Please enter a valid date";
        } else {
        System.out.println("Adding Swim entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String l = add1.getText();
        SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, l);
        String valid = swimValidate(e);
        String unique = uniqueValidate(e);
        if(valid == "" && unique == "") {
        	myAthletes.addEntry(e);
        } else {
        	if(!unique.equalsIgnoreCase("")) {
        		message = unique;
        	} else {
        		message = valid;
        	}
        }}
        
        return message;
    }
    
    public String addCycleEntry() {
        String message = "Record added\n";
        if(name.getText().isEmpty() ||
        		month.getText().isEmpty() || 
        		day.getText().isEmpty() || 
        		year.getText().isEmpty() ||
        		dist.getText().isEmpty() || 
        		hours.getText().isEmpty() || 
        		mins.getText().isEmpty() || 
        		secs.getText().isEmpty() || 
        		add1.getText().isEmpty() || 
        		add2.getText().isEmpty()  
        		) {
        	message = "Error, Please fill all fields";
        } else if(Integer.parseInt(day.getText()) < 1 || Integer.parseInt(day.getText()) > 31 ||
        		Integer.parseInt(month.getText()) < 1 || Integer.parseInt(month.getText()) > 12 ||
        		year.getText().length() != 4
        		){
        	message = "Error, Please enter a valid date";
        } else {
        
        System.out.println("Adding Cycle entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String t = add1.getText();
        String tt = add2.getText();
        CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, t, tt);
        String unique = uniqueValidate(e);
        if(unique == "") {
        	myAthletes.addEntry(e);
        } else {
        	message = unique;
        }}
        
        return message;
    }
    
    public String lookupEntry() {
    	String message = "";
        
        if(month.getText().isEmpty() || day.getText().isEmpty() || year.getText().isEmpty()) {
        	message = "Error, Please fill all Date fields";
        } else {
        	int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        message = myAthletes.lookupEntry(d, m, y);
        }
        return message;
    }
    
    public String findallEntry() {
    	String message = "";
    	
        if(month.getText().isEmpty() || day.getText().isEmpty() || year.getText().isEmpty()) {
        	message = "Error, Please fill all Date fields";
        } else {
        	int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            
        	outputArea.setText("looking up record ...");
        	message = myAthletes.findallEntry(d, m, y);
        }
        return message;
    }
    
    public String removeEntry() {
    	
    	String message = "";
    	
        if(name.getText().isEmpty() || month.getText().isEmpty() || day.getText().isEmpty() || year.getText().isEmpty()) {
        	message = "Error, Please fill Name and all Date fields";
        } else {
        	String n = name.getText();
        	int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
        	
        	outputArea.setText("removing record ...");
        message = myAthletes.removeEntry(n, d, m, y);
        }
        
    	return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        add1.setText("");
        add2.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

    
    public String uniqueValidate(Entry e) {
    	String unique = "";
    	
    	String n = e.getName();
    	int m = e.getMonth();
        int d = e.getDay();
        int y = e.getYear();
        
        unique = myAthletes.uniqueValidate(n, m, d, y);
        
    	return unique;
    }
    
    
    public String swimValidate(SwimEntry e) {
 	   String valid = "";
 	   
 	   if(!e.getLocale().equalsIgnoreCase("outside") && !e.getLocale().equalsIgnoreCase("in a pool")) {
 		   valid = "Error, Locale not valid.";
 	   }  	   
 	   
 	   return valid;
    }
    
    
    
    
} // TrainingRecordGUI

