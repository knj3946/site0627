package net;

import java.awt.Choice;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	//전역변수
	JTextField jf;
	JTextArea ja;
	JScrollPane jsp;
	JButton bt_connect;
	Choice ch; //ip 선택
	JPanel p_north;
	JTextField t_port; //포트입력
	String[] ip={"51","55","15","60","143","79","41","67"};
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	public ChatClient(){
		super("ChatA");
		jf=new JTextField();
		ja=new JTextArea();
		jsp=new JScrollPane(ja);
		bt_connect=new JButton("B");
		ch=new Choice();
		t_port=new JTextField("7777");
		bt_connect=new JButton("접속");
		p_north=new JPanel();
		
		//아이피 설정
		for(int i=0;i<ip.length;i++) {
			ch.add("192.168.0."+ip[i]);
		}
		
		//패널에 부착
		p_north.add(ch);
		p_north.add(t_port);
		p_north.add(bt_connect);
		p_north.setBounds(10, 10, 365, 50);
		
		
		ja.setEnabled(false);
		ja.setDisabledTextColor(Color.BLACK);
		jsp.setBounds(10,70,365,365);
		//jf.setPreferredSize(new Dimension(305,30));
		jf.setBounds(10,460,365,25);
		
		add(p_north);
		add(jsp);
		add(jf);
		
		setLayout(null);
		setBounds(400,150,400,550);
		setVisible(true);
		
		jf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				send(jf.getText());
				}
			}
		});
		bt_connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void connect() {
		String ip=ch.getSelectedItem();
		int port=Integer.parseInt(t_port.getText());//"7777"-->7777
		//서버에 접속!!
		try {
			client=new Socket(ip,port);
			//소켓으로부터 스트림 얻기!!!
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//서버측으로부터 받기!!
	public void listen() {
		String msg=null;
		try {
			msg=buffr.readLine();
			ja.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {			
			//서버측에 메시지 전송
			try {
				buffw.write("낯선 사람:"+msg+"\n");//문자열의 끝에 줄바꿈 표시가 있어야 한줄의 끝을
				//이해한다!! 따라서 서버측에서는 문자열의 끝이 없기 대문에 계속 대기하고 있음
				buffw.flush();//버퍼처리된 출력스트림 계열에서 이 메서드를 호출하면
				//스트림에 현재 쌓여있는 데이터를 모두 방출!!
				jf.setText("");
				listen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
