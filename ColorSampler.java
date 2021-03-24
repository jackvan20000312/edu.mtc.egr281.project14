package project14;
//****************************************************************************************
//Author: Jacob Vaught       Modified: 12/01/20
//
//EGR-281  Project 14			  Due: 12/02/20 6:00PM
//****************************************************************************************
//finished coding 12-01-2020  4:15PM

//Please let me know if I will lose points for the button changing colors and for 
//making the program read hexadecimal color codes

import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ColorSampler extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField inputTextBox;
    JButton goButton;
    JFrame frame= new JFrame("Color Sampler also uses hexadecimal");
    Color previousColor = Color.WHITE; //just a fun addition(wasting my time) adjusts button color
    									//if i get penalized for this extra feature, I will remove it. 
    
    public ColorSampler(){

    	
        
    	inputTextBox=new JTextField("Enter Color Here!");  
        inputTextBox.setBounds(100, 20, 200, 30 );  
        frame.add(inputTextBox);
        inputTextBox.setVisible(true);
        inputTextBox.setEditable(true);          
        
        goButton=new JButton("Show Me the Color");  
        goButton.setBounds(100,60,200,30); 
        frame.add(goButton); 
        goButton.setBackground(Color.WHITE);  
        goButton.setVisible(true);
        goButton.addActionListener(this);

        frame.setSize(400,400);  
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//ending bracket of Constructor ColorSampler

    public void actionPerformed(ActionEvent ae)  {
       	try {
       		Color currentColor = getColor();
       		frame.getContentPane().setBackground(currentColor);
       		//frame.setVisible(true);
       		goButton.setBackground(previousColor);
       		previousColor = currentColor;
		} catch (UnknownColorException unknowncolorexception) {
			frame.getContentPane().setBackground(Color.BLACK);
			inputTextBox.setText(unknowncolorexception.getMessage());
			previousColor = Color.WHITE;
			goButton.setBackground(previousColor);
		}
    }//ending bracket of method actionPerformed
    
    public Color getColor() throws UnknownColorException {
    	String inputText = inputTextBox.getText();
    	    try {
    	    // get color if user enters hexadecimal value- 
    	    //if i get penalized for this extra feature, I will remove it. 
    	      return Color.decode(inputText);
    	    } catch (NumberFormatException numberformatexception) {
    	      // if we can't decode, try to get it by name of color (i.e. "BLACK")    
    	try {	    
    		Field field = Class.forName("java.awt.Color").getField(inputText);
    	    	    return (Color)field.get(null);   	
    	} catch (Exception exception) {
    		throw new UnknownColorException();
    	    	}
    	    }	
    }//ending bracket of method getColor

}//ending bracket of class
