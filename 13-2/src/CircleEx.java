/* ��13�� Programming ���� 2��
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import javax.swing.*;
import java.awt.*;
class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.drawOval(20, 20, 50, 50);     // (20,20)�� ��ġ�� ������ 50�� ��
	}
}

public class CircleEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public CircleEx() {
		setTitle("���� 0.5�� �������� �����ϰ� ����ϴ� ���α׷�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);     // MyPanel ��ü�� ����Ʈ������ ����
		panel.setLayout(null);     // ����Ʈ���� ��ġ������ ����
		
		TimerThread th = new TimerThread(panel);     // Ÿ�̸� ������ ����
		
		setSize(300, 300);
		setVisible(true);
		
		th.start();     // Ÿ�̸� �������� ������ �����ϰ� ��.
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
			
			panel.setLocation(x, y);     // ���� ��ġ�� (x,y)�� �̵�
			panel.repaint();     // �г��� �ٽ� �׸��⸦ ��û
			try {
				Thread.sleep(500);     // 0.5�� ���� ���� �ܴ�.
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}


