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
		bt = new JButton("오픈");
		p = new JPanel();
		
		p.add(txt);
		p.add(bt);
		
		add(area, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		//상대방 띄우기!!
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openB();
			}
		});
		
		//키보드 이벤트 구현
		txt.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					//나와 너의 창에 문자열 뿌리기
					String msg=txt.getText();
					area.append(msg+"\n");
					if(chatB!=null) {
					chatB.area.append(msg+"\n");
					}
					//입력 데이터 초기화
					txt.setText("");
				}
				
			}
		});
		
		setVisible(true);
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void openB() {
		//대화 상대방인 ChatB를 생성한다!!
		//call by reference:객체자료형 <>call by value:기본자료형
		chatB=new ChatB(this);
	}
	public static void main(String[] args) {
		new ChatA();
	}
}
