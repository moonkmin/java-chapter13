/* ��13�� Programming ���� 4�� - (2)
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
public class VibrationEx2 extends JFrame {
	public VibrationEx2() {
		setTitle("�����ϴ� ���̺� �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);     // ����Ʈ���� ��ġ������ ���� 
		
		JLabel la = new JLabel("���� ���̺�");
		la.setLocation(100,100);     // ���̺� �ʱ� ��ġ (100,100)
		la.setSize(100,100);
		c.add(la);
		
		VibrationThread th = new VibrationThread(la);     // ������ ����
		
		setSize(300, 300);
		setVisible(true);
		
		th.start();     // �������� ������ �����ϰ� ��.
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
	// ������ �ڵ�. run()�� �����ϸ� ������ ����
	@Override
	public void run() {
		while(true) {     // ���� ����
				la.setLocation(110,100);     // ���̺� ��ġ (110,100)���� �ű�.
				la.setLocation(100,110);     // ���̺� ��ġ (100,110)���� �ű�.
			}
	}
}