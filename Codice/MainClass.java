package it.univr.lavoratoriStagionali;

import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String arg[])  
	{  
	    try  
	    {  
	        //create instance of the CreateLoginForm  
	        LoginPage form = new LoginPage();
	        form.setSize(265,180);  //set size of the frame  
	        form.setVisible(true);  //make form visible to the user  
	        form.setAlwaysOnTop(true);
	        form.setLocationRelativeTo(null);
	    }  
	    catch(Exception e)  
	    {     
	        //handle exception   
	        JOptionPane.showMessageDialog(null, e.getMessage());  
	    }  
	} 
}
