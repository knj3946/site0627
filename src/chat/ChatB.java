package chat;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame{
	//전역변수
	JTextField jf;
	JTextArea ja_a,ja_b;
	JScrollPane jsp;
	
	public ChatB(JTextArea ja_a){
		super("ChatB");
		this.ja_a=ja_a;
		jf=new JTextField();
		ja_b=new JTextArea();
		jsp=new JScrollPane(ja_b);
		
		ja_b.setEnabled(false);
		ja_b.setDisabledTextColor(Color.BLACK);
		
		jsp.setBounds(10,10,365,365);
		jf.setBounds(10,400,305,30);
		
		add(jsp);
		add(jf);
		
		setLayout(null);
		setBounds(800,150,400,500);
		setVisible(true);
		
		jf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				chat(e);
			}
		});
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		
	}
	
	public void chat(KeyEvent e){
		//e.getSource();
		//System.out.print(e);
		if(e.getKeyCode()==10){
			ja_b.append("chatB : "+jf.getText()+"\n");
			if(ja_b!=null){
			ja_a.append("chatB : "+jf.getText()+"\n");
			}
			jf.setText("");
		}
	}
}
