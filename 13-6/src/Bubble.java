/* 제13장 Programming 문제 6번
 * 이름 : 문경민
 * 학번 : 20163014
 * 제출일 : 2017.11.28 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Bubble extends JFrame{
	public Bubble() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel p = new MyPanel();
		setContentPane(p);
		setSize(500,500);	
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Bubble();
	}
}
class MyPanel extends JPanel {
	public MyPanel() {
		setLayout(null);     // 배치관리자 제거
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {     // 마우스를 클릭할 때 스레드 객체 생성
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();     // 스레드 실행
			}
		});
	}
	
	class BubbleThread extends Thread {
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			// 이미지로 아이콘 생성
			ImageIcon img = new ImageIcon("C:\\Users\\user\\Desktop\\images\\bubble.png");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());   // 버블 레이블 크기 = 이미지 크기
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);    // MyPanel에 추가
			repaint();      // 버블 다시 그리기
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX() ;
				int y = bubble.getY() - 5;
				if(y < 0) {
					remove(bubble);    // 버블 제거
					repaint();
					return; // 스레드 종료
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}
