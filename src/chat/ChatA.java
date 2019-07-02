package chat;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame{
	//전역변수
	JTextField jf;
	JTextArea ja_a,ja_b;
	JScrollPane jsp;
	JButton bt;
	
	public ChatA(){
		super("ChatA");
		jf=new JTextField();
		ja_a=new JTextArea();
		jsp=new JScrollPane(ja_a);
		bt=new JButton("B");
		ja_a.setEnabled(false);
		ja_a.setDisabledTextColor(Color.BLACK);
		jsp.setBounds(10,10,365,365);
		//jf.setPreferredSize(new Dimension(305,30));
		jf.setBounds(10,400,305,30);
		bt.setBounds(325,400,50,30);
		add(jsp);
		add(jf);
		add(bt);
		setLayout(null);
		setBounds(400,150,400,500);
		setVisible(true);
		
		jf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				chat(e);
			}
		});
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void addUser(){
		ChatB chat_B=new ChatB(ja_a);
		ja_b=chat_B.ja_b;
	}
	
	public void chat(KeyEvent e){
		//e.getSource();
		//System.out.print(e);
		if(e.getKeyCode()==10){
			ja_a.append("chatA : "+jf.getText()+"\n");
			if(ja_b!=null){
			ja_b.append("chatA : "+jf.getText()+"\n");
			}
			jf.setText("");
		}
	}
	
	public static void main(String[] args) {
		new ChatA();
	}
}
