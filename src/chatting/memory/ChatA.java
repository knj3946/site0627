package chatting.memory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame {
	//
	JTextArea area;
	JTextField txt;
	JScrollPane scroll;
	JButton bt;
	JPanel p;
	ChatB chatB;

	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		bt = new JButton("����");
		p = new JPanel();
		
		p.add(txt);
		p.add(bt);
		
		add(area, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		//���� ����!!
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openB();
			}
		});
		
		//Ű���� �̺�Ʈ ����
		txt.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					//���� ���� â�� ���ڿ� �Ѹ���
					String msg=txt.getText();
					area.append(msg+"\n");
					if(chatB!=null) {
					chatB.area.append(msg+"\n");
					}
					//�Է� ������ �ʱ�ȭ
					txt.setText("");
				}
				
			}
		});
		
		setVisible(true);
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void openB() {
		//��ȭ ������ ChatB�� �����Ѵ�!!
		//call by reference:��ü�ڷ��� <>call by value:�⺻�ڷ���
		chatB=new ChatB(this);
	}
	public static void main(String[] args) {
		new ChatA();
	}
}
