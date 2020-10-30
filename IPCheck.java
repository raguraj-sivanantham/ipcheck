//import libraries
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
//start class
class IPCheck{
	//launch the application
	public static void main (String args[]){

		IPCheck window=new IPCheck();
		window.frame.setVisible(true);
		window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//define window elements
	JFrame frame;
	JTextField text;
	JButton button;
	JTextField ipaddress;
	String ip;
	//create the application
	IPCheck(){
		initialize();
	}
	//initialize application
	private void initialize(){
		//frame part
		frame=new JFrame("IP Address Check");
		frame.setSize(550,300);
		frame.setLayout(null);

		//label
		JLabel label=new JLabel("Enter the web Address : ");
		label.setBounds(20,10,500,30);
		frame.add(label);

		//text part
		text=new JTextField();
		text.setBounds(20,50,500,30);
		frame.add(text);

		//ipAddress part
		ipaddress=new JTextField("IP Address : ");
		ipaddress.setBounds(20,90,500,30);
		frame.add(ipaddress);
		ipaddress.setEditable(false);
		//open button
		JButton open=new JButton("Open website");
		open.setBounds(20,170,500,30);
		frame.add(open);
		open.setVisible(false);
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String url=text.getText();
			}
		});
		//button part
		button=new JButton("Check the IP Address");
		button.setBounds(20,130,500,30);
		frame.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String host=text.getText();
					ip=java.net.InetAddress.getByName(host).getHostAddress();  
					ipaddress.setText("IP Address is : "+ip);
					open.setVisible(true);
				}
				catch(Exception error){
					ipaddress.setText("ERROR");
				}
				
			}
		});

		//image label part
		JLabel logo=new JLabel(new ImageIcon("buttom.png"));
		logo.setBounds(20,210,150,200);
		frame.add(logo);
	}
}