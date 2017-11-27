/* 제13장 Programming 문제 4번 - (2)
 * 이름 : 문경민
 * 학번 : 20163014
 * 제출일 : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
public class VibrationEx2 extends JFrame {
	public VibrationEx2() {
		setTitle("진동하는 레이블 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);     // 컨텐트팬의 배치관리자 제거 
		
		JLabel la = new JLabel("진동 레이블");
		la.setLocation(100,100);     // 레이블 초기 위치 (100,100)
		la.setSize(100,100);
		c.add(la);
		
		VibrationThread th = new VibrationThread(la);     // 스레드 생성
		
		setSize(300, 300);
		setVisible(true);
		
		th.start();     // 스레드의 실행을 시작하게 함.
	}
	public static void main(String[] args) {
		new VibrationEx2();
	}
}
class VibrationThread extends Thread {
	private JLabel la;
	public VibrationThread(JLabel la) {
		this.la = la;
	}
	// 스레드 코드. run()이 종료하면 스레드 종료
	@Override
	public void run() {
		while(true) {     // 무한 루프
				la.setLocation(110,100);     // 레이블 위치 (110,100)으로 옮김.
				la.setLocation(100,110);     // 레이블 위치 (100,110)으로 옮김.
			}
	}
}