/* 제13장 Programming 문제 4번 - (1)
 * 이름 : 문경민
 * 학번 : 20163014
 * 제출일 : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
public class VibrationEx extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	public VibrationEx() {
		frame.setTitle("진동하는 프레임 만들기");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100,100);     // 프레임 초기 위치 (100,100)
		frame.add(panel);
		
		VibrationThread th = new VibrationThread(frame);     // 스레드 생성
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		th.start();     // 스레드의 실행을 시작하게 함.
	}
	public static void main(String[] args) {
		new VibrationEx();
	}
}
class VibrationThread extends Thread {
	private JFrame f;
	public VibrationThread(JFrame f) {
		this.f = f;
	}
	// 스레드 코드. run()이 종료하면 스레드 종료
	@Override
	public void run() {
		while(true) {     // 무한 루프
			try {
				f.setLocation(110,100);     // 프레임 위치 (110,100)으로 옮김.
				Thread.sleep(1);
				f.setLocation(100,110);     // 프레임 위치 (100,110)으로 옮김.
			}
			catch(InterruptedException e) {
				return;
			}}}}