/* 제13장 Programming 문제 2번
 * 이름 : 문경민
 * 학번 : 20163014
 * 제출일 : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.drawOval(20, 20, 50, 50);     // (20,20)에 위치한 지름이 50인 원
	}
}

public class CircleEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public CircleEx() {
		setTitle("원을 0.5초 간격으로 랜덤하게 출력하는 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);     // MyPanel 객체를 컨텐트팬으로 설정
		panel.setLayout(null);     // 컨텐트팬의 배치관리자 제거
		
		TimerThread th = new TimerThread(panel);     // 타이머 스레드 생성
		
		setSize(300, 300);
		setVisible(true);
		
		th.start();     // 타이머 스레드의 실행을 시작하게 함.
	}
	
	public static void main(String[] args) {
		new CircleEx();
	}
}

class TimerThread extends Thread {
	private MyPanel panel;
	public TimerThread(MyPanel panel) {
		this.panel = panel;
	}
	public void run() {
		while(true) {
			int x = (int)(Math.random()*200);     // 0 ~ 200
			int y = (int)(Math.random()*200);     // 0 ~ 200
			
			panel.setLocation(x, y);     // 원의 위치를 (x,y)로 이동
			panel.repaint();     // 패널의 다시 그리기를 요청
			try {
				Thread.sleep(500);     // 0.5초 동안 잠을 잔다.
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}


