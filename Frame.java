package scjp;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Frame extends JFrame implements ActionListener{
	private JFrame frame = new JFrame();
	private JPanel panel1 = new JPanel();
	
	private JLabel nameLbl = new JLabel("NAME: ");
	private JLabel idLbl = new JLabel("I'D: ");
	private JRadioButton malerb = new JRadioButton("MALE");
	private JRadioButton femalerb = new JRadioButton("FEMALE");
	private ButtonGroup bg = new ButtonGroup();
	private JLabel ageLbl = new JLabel("AGE(years): ");
	
	private JTextField nameTxt = new JTextField(10);
	private JTextField idTxt = new JTextField(10);
	private JTextField ageTxt = new JTextField(10);
	
	private JPanel panel2 = new JPanel();
	
	private JLabel cityLbl = new JLabel("CITY: ");
	private JLabel stateLbl = new JLabel("STATE: ");
	private JLabel zipLbl = new JLabel("ZIP: ");
	
	private JTextField cityTxt = new JTextField(10);
	private JTextField stateTxt = new JTextField(10);
	private JTextField zipTxt = new JTextField(10);
	
	private JPanel panel3 = new JPanel();
	
	private JLabel professionLbl = new JLabel("PROFESSION: ");
	private JComboBox<String> professionTxt = new JComboBox<String>();
	
	private JPanel pan = new JPanel();
	private JLabel gpaLbl = new JLabel("GPA: ");
	private JTextField gpaTxt = new JTextField(10);
		
	private JLabel salaryLbl = new JLabel("SALARY: ");
	private JTextField salaryTxt = new JTextField(10);
	
	
	
	private JPanel panel4 = new JPanel();
	
	private JButton save = new JButton("SAVE");
	private JButton cancel = new JButton("CANCEL");
	private JButton reset = new JButton("RESET");
	
	
	Frame(){
		setTitle("REGISTRATION FORM");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 2));
		
		panel1.setLayout(new GridLayout(4, 2));
		panel1.add(nameLbl);
		
		panel1.add(nameTxt);
		nameTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!(Character.isAlphabetic(ch) || ch == ' '|| ch == '\b'|| (ch == KeyEvent.VK_DELETE))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only [A-Z,a-z,space character]!");
				}
			}
		});
		panel1.add(idLbl);
		panel1.add(idTxt);
		idTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!((ch >= '1') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE)||Character.isAlphabetic(ch))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only Numbers & Alphabetics...!");
				}
			}
		});
		bg.add(malerb);
		bg.add(femalerb);
		panel1.add(ageLbl);
		panel1.add(ageTxt);
		ageTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!((ch >= '0') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only Numbers...!");
				}
			}
		});
		panel1.add(malerb);
		panel1.add(femalerb);
		
		panel2.setLayout(new GridLayout(3, 2));
		panel2.add(cityLbl);
		panel2.add(cityTxt);
		cityTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!((ch >= '0') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE)||Character.isAlphabetic(ch))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only Numbers & Alphabetics...!");
				}
			}
		});
		
		panel2.add(stateLbl);
		panel2.add(stateTxt);
		stateTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!((ch >= '1') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE)||Character.isAlphabetic(ch))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only Numbers & Alphabetics...!");
				}
			}
		});
		
		panel2.add(zipLbl);
		panel2.add(zipTxt);
		zipTxt.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char ch = e.getKeyChar();
				if (!((ch >= '1') && (ch <= '9') || (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE)||Character.isAlphabetic(ch))){
					e.consume();
					JOptionPane.showMessageDialog(null, "Only Numbers & Alphabetics...!");
				}
			}
		});
		zipTxt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					
					e.consume();
					JOptionPane.showMessageDialog(null, "Only NUMBERS!...");
				}
			}
		});
		
		panel3.setLayout(new FlowLayout());
		panel3.add(professionLbl);
		professionTxt.addItem("STUDENT");
		professionTxt.addItem("EMPLOYEE");
		panel3.add(professionTxt);
		
		
		
		
		
		panel4.setLayout(new FlowLayout());
		panel4.add(save);
		panel4.add(cancel);
		panel4.add(reset);
		save.addActionListener(this);
		cancel.addActionListener(this);
		reset.addActionListener(this);
		
		
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		
		pan.setVisible(true);
		    	
    	 professionTxt.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	                	               
	                if(((String)professionTxt.getSelectedItem()).equals("STUDENT")){
	                    
	                	
	                	pan.add(gpaLbl);
	                 	pan.add(gpaTxt);
	                 	pan.remove(salaryLbl);
	                	pan.remove(salaryTxt);
	                	
	                 	
	                	
	    		      
	                }
	                else if(((String)professionTxt.getSelectedItem()).equals("EMPLOYEE")){
	                	
	                	
	            		pan.add(salaryLbl);
	                	pan.add(salaryTxt);
	                	pan.remove(gpaLbl);
	                 	pan.remove(gpaTxt);
	                 	
	            	   
	      		  }

	            }
	        });
    	 gpaTxt.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')|| (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)||(c == '.'))) {
					
						e.consume();
						JOptionPane.showMessageDialog(null, "Only NUMBERS!...");
					}
				}
    	 });
    	 salaryTxt.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
						
						e.consume();
						JOptionPane.showMessageDialog(null, "Only NUMBERS!...");
					}
				}
			});
	
    	add(pan);
    	
    	
		add(panel4);
			
	
	}
	
	public static void main(String[] args) {
		Frame f=new Frame();
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("SAVE")){
		if (((((( ((((nameTxt.getText().trim().length() == 0 )|| (idTxt.getText().trim().length() == 0) )|| (ageTxt.getText().trim().length() == 0))|| 
				(bg.isSelected(null))
				|| (cityTxt.getText().trim().length() == 0 ))|| (stateTxt.getText().trim().length() == 0) )||
				((gpaTxt.getText().trim().length() == 0 )&& (salaryTxt.getText().trim().length() == 0) )))||
				(zipTxt.getText().trim().length() == 0 )))){
			
			JOptionPane.showMessageDialog(null, "Fill all fields....");
			
							}
	
		else {
			
			
		try {
				
				
		        String str = idTxt.getText();
		        idTxt.requestFocusInWindow();
		        if(str.length()<1){
		        	
		        	JOptionPane.showMessageDialog(null, "I'd have at least 1 Character length!...");
		        	idTxt.setText("");
		        	idTxt.requestFocusInWindow();
	                return;
	                }
		        } catch (Exception z) { 
		           
		   }
			
			try {
		        int int2 = Integer.parseInt(ageTxt.getText());
		        ageTxt.requestFocusInWindow();
		        if(int2>100||int2<1){
		       
		        	JOptionPane.showMessageDialog(null, "Age is greater than 100!");
		            ageTxt.setText("");
	                ageTxt.requestFocusInWindow();
	                return;
	            }
		        
		        } catch (Exception z) { 
		            
		   }
			
		try {
		        String str1 = zipTxt.getText();
		        zipTxt.requestFocusInWindow();
		        if(str1.length()<4){
		        	
		        	 JOptionPane.showMessageDialog(this, "Zip requires min 4 Character length!...");
		        	 zipTxt.setText("");
			         zipTxt.requestFocusInWindow();
			         return;		        	
		        }
		        } catch (Exception z) { 
		           
		   }
		
		try {
	        double d = Double.parseDouble(gpaTxt.getText());
	        gpaTxt.requestFocusInWindow();
	        if((d<=0)||(d > 4)){
	        	
	        	 JOptionPane.showMessageDialog(this, "GPA shold be in between 0 to 4!...");
	        	 gpaTxt.setText("");
		         gpaTxt.requestFocusInWindow();
		         return;		        	
	        }
	        } catch (Exception z) { 
	           
	   }
		
		
		
			String name = nameTxt.getText();
			String id = idTxt.getText();
			String gender= null;
			if((malerb.isSelected())){
			gender = malerb.getText().toString();}
			else if((femalerb.isSelected())){
			gender = femalerb.getText().toString();}
			String age = ageTxt.getText();
			
			String city = cityTxt.getText();
			String state = stateTxt.getText();
			String zip = zipTxt.getText();
			String  gpa=null, salary=null;
			String profession=(String)professionTxt.getSelectedItem();
			   if(((String)professionTxt.getSelectedItem()).equals("STUDENT")){
                   
				   gpa= gpaTxt.getText();
   		      
               }
               else if(((String)professionTxt.getSelectedItem()).equals("EMPLOYEE")){
               	
            	   salary= salaryTxt.getText();
           	    
     		  }
			   
			   
			
			try {
				 FileWriter fileOutStrm = new FileWriter("RegistrationFormDetails.txt");
				 BufferedWriter bufWriter = new BufferedWriter(fileOutStrm);
				 PrintWriter outWriter = new PrintWriter(bufWriter,true);

				 outWriter.println(nameLbl.getText()+"= "+name);
				 outWriter.println(idLbl.getText()+"= "+id);
				 outWriter.println(ageLbl.getText()+"= "+age);
				 outWriter.println("GENDER: = "+ gender);
				 outWriter.println(cityLbl.getText()+"= "+city);
				 outWriter.println(stateLbl.getText()+"= "+state);
				 outWriter.println(zipLbl.getText()+"= "+zip);
				 outWriter.println(professionLbl.getText()+"= "+profession);
				 if(((String)professionTxt.getSelectedItem()).equals("STUDENT")){
	                   
					 
					  outWriter.println(gpaLbl.getText()+"= "+gpa);
	               }
	               else if(((String)professionTxt.getSelectedItem()).equals("EMPLOYEE")){
	               	
	            	   outWriter.println(salaryLbl.getText()+"= "+salary);
	               }
				 
				
				 outWriter.close();
				 
			 } catch (Exception ex) {
			 	System.out.println("Exception: " + ex);
			 }

			JOptionPane.showMessageDialog(null, "SAVED SUCCESSFULLY....");
		}
		}
			else if(e.getActionCommand().equals("CANCEL")){
				
				int result = JOptionPane.showConfirmDialog(null, "Are you sure to close this window?");

					       if(result == JOptionPane.YES_OPTION){
					               System.exit(0);
					       }else{
					               //Do nothing
					       }
			}
			else if(e.getActionCommand().equals("RESET")){
				
				nameTxt.setText("");
				idTxt.setText("");
				ageTxt.setText("");
				cityTxt.setText("");
				stateTxt.setText("");
				zipTxt.setText("");
				if(((String)professionTxt.getSelectedItem()).equals("STUDENT")){
	                   
					   gpaTxt.setText("");
	   		      
	               }
	               else if(((String)professionTxt.getSelectedItem()).equals("EMPLOYEE")){
	               	
	            	   salaryTxt.setText("");
	           	    
	     		  }
				
				JOptionPane.showMessageDialog(null, "RESET SUCCESSFULLY....");
			}
		}
	
	
	
	}




