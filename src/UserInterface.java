import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.soap.Text;
import java.util.*;
public class UserInterface {
	JFrame mainFrame;
	JLabel headerLabel;
	JPanel controlPanel;
	JLabel statusLabel; JTextArea text;String number1="0",sample="0",operation;
	public UserInterface(){
		prepareGUI();
	}
	public static void main(String[] args) {
		UserInterface object=new UserInterface();
		object.prepareCalculator();
	}
	public void prepareGUI() {
		mainFrame=new JFrame("CALCULATOR");
		headerLabel=new JLabel("",JLabel.CENTER);
		statusLabel=new JLabel("",JLabel.CENTER);
		mainFrame.setSize(500,500);
		mainFrame.setLayout(new GridLayout(2,1));
		controlPanel=new JPanel(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		
	}
	public void prepareCalculator() {
		JPanel demo=new JPanel();
		demo.setSize(450,450);
		GridBagLayout layout=new GridBagLayout();
		demo.setLayout(layout);
		headerLabel.setText("Normal Calculator in Action:");
		text= new JTextArea();text.setColumns(10);
		JScrollPane scroll=new JScrollPane(text);
		JButton ac=new JButton("AC");ac.setActionCommand("ac");
		JButton del=new JButton("Del");del.setActionCommand("del");
		JButton div=new JButton("/");div.setActionCommand("/");
		JButton mul=new JButton("X");mul.setActionCommand("x");
		JButton seven=new JButton("7");seven.setActionCommand("7");
		JButton eight=new JButton("8");eight.setActionCommand("8");
		JButton nine=new JButton("9");nine.setActionCommand("9");
		JButton minus=new JButton("-");minus.setActionCommand("-");
		JButton four=new JButton("4");four.setActionCommand("4");
		JButton five=new JButton("5");five.setActionCommand("5");
		JButton six=new JButton("6");six.setActionCommand("6");
		JButton plus=new JButton("+");plus.setActionCommand("+");
		JButton one =new JButton("1");one.setActionCommand("1");
		JButton two=new JButton("2");two.setActionCommand("2");
		JButton three=new JButton("3");three.setActionCommand("3");
		JButton equal =new JButton("=");equal.setActionCommand("=");
		JButton zero=new JButton("0");zero.setActionCommand("0");		
		JButton dec=new JButton(".");dec.setActionCommand(".");
		//controlPanel.add(scroll);
		GridBagConstraints gbc1=new GridBagConstraints();
		gbc1.fill=GridBagConstraints.HORIZONTAL;
		gbc1.gridx=0;gbc1.gridy=0;gbc1.gridwidth=8;gbc1.ipady=5;
		demo.add(scroll,gbc1);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=-1;gbc.gridy=1;
		demo.add(ac,gbc);
		gbc.gridx=1;gbc.gridy=1;
		demo.add(del,gbc);
		gbc.gridx=2;gbc.gridy=1;demo.add(div,gbc);
		gbc.gridx=3;gbc.gridy=1;demo.add(mul,gbc);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;gbc.gridy=2;demo.add(seven,gbc);
		gbc.gridx=1;gbc.gridy=2;demo.add(eight,gbc);
		gbc.gridx=2;gbc.gridy=2;demo.add(nine,gbc);
		gbc.gridx=3;gbc.gridy=2;demo.add(minus,gbc);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;gbc.gridy=3;demo.add(four,gbc);
		gbc.gridx=1;gbc.gridy=3;demo.add(five,gbc);
		gbc.gridx=2;gbc.gridy=3;demo.add(six,gbc);
		gbc.gridx=3;gbc.gridy=3;demo.add(plus,gbc);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;gbc.gridy=4;demo.add(one,gbc);
		gbc.gridx=1;gbc.gridy=4;demo.add(two,gbc);
		gbc.gridx=2;gbc.gridy=4;demo.add(three,gbc);
		gbc.gridx=3;gbc.gridy=4;demo.add(dec,gbc);
		//gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=0;gbc.gridy=5;gbc.gridwidth=2;demo.add(zero,gbc);
		gbc.gridx=2;gbc.gridy=5;gbc.gridwidth=2;demo.add(equal,gbc);
		ac.addActionListener(new  ButtonClickListener());
		del.addActionListener(new  ButtonClickListener());
		div.addActionListener(new  ButtonClickListener());
		mul.addActionListener(new  ButtonClickListener());nine.addActionListener(new  ButtonClickListener());
		seven.addActionListener(new  ButtonClickListener());
		eight.addActionListener(new  ButtonClickListener());
		minus.addActionListener(new  ButtonClickListener());four.addActionListener(new  ButtonClickListener());
		five.addActionListener(new  ButtonClickListener());six.addActionListener(new  ButtonClickListener());
		plus.addActionListener(new  ButtonClickListener());three.addActionListener(new  ButtonClickListener());
		one.addActionListener(new  ButtonClickListener());two.addActionListener(new  ButtonClickListener());
		equal.addActionListener(new  ButtonClickListener());zero.addActionListener(new  ButtonClickListener());
		dec.addActionListener(new  ButtonClickListener());
		controlPanel.add(demo);
		
		mainFrame.setVisible(true);
		
	}
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(!((s.equals("ac")||s.equals("del"))||s.equals("="))) {sample=sample+s;
				text.append(s);if(s.equals("+")||s.equals("-")||s.equals("x")||s.equals("/")) {
					if("+-/x".indexOf(sample.charAt(sample.length()-1))!=-1)number1=sample.substring(0,sample.length()-1);
					else number1=sample;
					sample="";operation=s;
				}
				
				
			}
			else if(s.equals("ac")) {text.setText("");sample="";number1="";}
			else if(s.equals("del")) {text.setText(text.getText().substring(0,text.getText().length()-1));
			
			sample=sample.substring(0,sample.length()-1);}
			else {double result=0;
				try {
					
					double num1=Double.parseDouble(number1);
					double num2=Double.parseDouble(sample);
					switch(operation.charAt(0)) {
					case '+':result=num1+num2;break;
					case '-':result=num1-num2;break;
					case '/':result=num1/num2;break;
					case 'x':result=num1*num2;break;
					}
					if(result==(int)result)
					text.setText((result+"").substring(0, (result+"").length()-2));
					else text.setText(result+"");
					
				}
				catch(Exception e1) {
					
					try{text.setText("Wrong Input");Thread.sleep(3000);text.setText("");
					text.setText("");}
					catch(InterruptedException e2) {
						e2.printStackTrace();
					}
					
				}
				finally {
					sample=text.getText();operation="";}
			}
			
		}
		
	}
}
