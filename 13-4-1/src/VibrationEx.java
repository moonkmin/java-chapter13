/* ��13�� Programming ���� 4�� - (1)
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
public class VibrationEx extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	public VibrationEx() {
		frame.setTitle("�����ϴ� ������ �����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100,100);     // ������ �ʱ� ��ġ (100,100)
		frame.add(panel);
		
		VibrationThread th = new VibrationThread(frame);     // ������ ����
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		th.start();     // �������� ������ �����ϰ� ��.
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
	// ������ �ڵ�. run()�� �����ϸ� ������ ����
	@Override
	public void run() {
		while(true) {     // ���� ����
			try {
				f.setLocation(110,100);     // ������ ��ġ (110,100)���� �ű�.
				Thread.sleep(1);
				f.setLocation(100,110);     // ������ ��ġ (100,110)���� �ű�.
			}
			catch(InterruptedException e) {
				return;
			}}}}