/* ��13�� Programming ���� 6��
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Bubble extends JFrame{
	public Bubble() {
		setTitle("���� ����");
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
		setLayout(null);     // ��ġ������ ����
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {     // ���콺�� Ŭ���� �� ������ ��ü ����
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();     // ������ ����
			}
		});
	}
	
	class BubbleThread extends Thread {
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			// �̹����� ������ ����
			ImageIcon img = new ImageIcon("C:\\Users\\user\\Desktop\\images\\bubble.png");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());   // ���� ���̺� ũ�� = �̹��� ũ��
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);    // MyPanel�� �߰�
			repaint();      // ���� �ٽ� �׸���
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX() ;
				int y = bubble.getY() - 5;
				if(y < 0) {
					remove(bubble);    // ���� ����
					repaint();
					return; // ������ ����
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
