package chatting.memory;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame {
	//
	JTextArea area;
	JTextField txt;
	JScrollPane scroll;
	JPanel p;
	ChatA chatA; //필요하면 보유하자

	public ChatB(ChatA chatA) {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		txt = new JTextField(15);
		p = new JPanel();
		this.chatA=chatA;
		p.add(txt);
		
		add(area, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		//키보드 이벤트 구현
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String msg=txt.getText();
					area.append(msg+"\n");
					chatA.area.append(msg+"\n");
					txt.setText("");
				}
			}
		});
		
		setVisible(true);
		setSize(300, 400);
		

	}

}
