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
	//��������
	JTextField jf;
	JTextArea ja;
	JScrollPane jsp;
	JButton bt_connect;
	Choice ch; //ip ����
	JPanel p_north;
	JTextField t_port; //��Ʈ�Է�
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
		bt_connect=new JButton("����");
		p_north=new JPanel();
		
		//������ ����
		for(int i=0;i<ip.length;i++) {
			ch.add("192.168.0."+ip[i]);
		}
		
		//�гο� ����
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
		//������ ����!!
		try {
			client=new Socket(ip,port);
			//�������κ��� ��Ʈ�� ���!!!
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���������κ��� �ޱ�!!
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
			//�������� �޽��� ����
			try {
				buffw.write("���� ���:"+msg+"\n");//���ڿ��� ���� �ٹٲ� ǥ�ð� �־�� ������ ����
				//�����Ѵ�!! ���� ������������ ���ڿ��� ���� ���� �빮�� ��� ����ϰ� ����
				buffw.flush();//����ó���� ��½�Ʈ�� �迭���� �� �޼��带 ȣ���ϸ�
				//��Ʈ���� ���� �׿��ִ� �����͸� ��� ����!!
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
