/* ��13�� Programming ���� 5��
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GunGame extends JFrame{
	public GunGame() {
		setTitle("��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel p = new MyPanel();
		setContentPane(p);     // MyPanel ��ü�� ����Ʈ������ ����
		setSize(300,300);
		setResizable(false);		
		setVisible(true);
		p.startGame();
	}
	
	public static void main(String [] args) {
		new GunGame();
	}
}
class MyPanel extends JPanel {
	private TargetThread targetThread=null;
	private JLabel baseLabel = new JLabel();
	private JLabel bulletLabel = new JLabel();
	private JLabel targetLabel;
	
	public MyPanel() {
		setLayout(null);
	
		baseLabel.setSize(40,40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);
		// �̹����� ������ ����
		ImageIcon img = new ImageIcon("C:\\Users\\user\\Desktop\\images\\tiger.png");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(),img.getIconWidth());

		bulletLabel.setSize(10,10);
		bulletLabel.setOpaque(true);     // ������ ���̵��� ����
		bulletLabel.setBackground(Color.RED);
		add(baseLabel);     // baseLabel �߰�
		add(targetLabel);     // targetLabel �߰�
		add(bulletLabel);     // bulletLabel �߰�
		
		// �� �гο� ���콺�� Ŭ���ϸ� baseLabel�� Ű �Է��� ���� �� �ֵ��� ��Ŀ���� ���� ����
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				baseLabel.setFocusable(true);
				baseLabel.requestFocus(); // Ű���� �Է��� �޵��� ��Ŀ�� ���� ����			
			}
		});
	}
	
	public void startGame() {
		baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40);   // �г� ��� ��ġ�ϰ� ����
		bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50);  // baselabel ��� ��ġ�ϰ� ����		
		targetLabel.setLocation(0, 0);
		
		targetThread = new TargetThread(targetLabel);
		targetThread.start();
		
		baseLabel.setFocusable(true);
		baseLabel.requestFocus(); // Ű���� �Է��� �޵��� ��Ŀ�� ���� ����			
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread  bulletThread = null;
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == '\n') {     // Enter Ű�� ���� ��
					// bulletThread�� ���ų� ���� �ǰ� ���� ���� ��
					if(bulletThread==null || !bulletThread.isAlive()) {     
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread.start();     // bulletThread ����
					}
				}
			}
		});
	}
	
	class TargetThread extends Thread {
		private JComponent target;
		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
			target.getParent().repaint();     // target �ٽ� �׸���
		}	
		
		@Override
		public void run() {
			while(true) {
				int x = target.getX()+5;   // target�� ���������� 5�� �̵�
				int y = target.getY();
				if(x > MyPanel.this.getWidth()) 
					target.setLocation(0,0);
				else 
					target.setLocation(x, y);

				target.getParent().repaint();
				try {
					sleep(20);
				}
				catch(InterruptedException e) {
					target.setLocation(0, 0);
					target.getParent().repaint();    // target �ٽ� �׸���
					try {
						sleep(500);   // 0.5�� ��ٸ� �Ŀ� ����Ѵ�.
					}catch(InterruptedException e2) {}					
				}
			}
		}			
	}
	
	class BulletThread extends Thread {
		private JComponent bullet, target;
		private Thread targetThread;
		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;				
		}
		
		@Override
		public void run() {
			while(true) {
				// �����Ͽ����� Ȯ��
				if(hit()) {
					targetThread.interrupt();
					bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);						
					return;
				}
				else {
					int x = bullet.getX() ;
					int y = bullet.getY() - 5;
					if(y < 0) {
						bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50);
						bullet.getParent().repaint();
						return; // ������ ����
					}
					bullet.setLocation(x, y);
					bullet.getParent().repaint();     // bullet �ٽ� �׸���
				}
				try {
					sleep(20);
				}
				catch(InterruptedException e) {}
			}
		}
		
		private boolean hit() {
			if(targetContains(bullet.getX(), bullet.getY()) || 
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()) ||
					targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()+bullet.getHeight() - 1) ||
					targetContains(bullet.getX(), bullet.getY()+bullet.getHeight() - 1))
				return true;
			else
				return false;					
		}
		
		private boolean targetContains(int x, int y) {
			if(((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) &&
					((target.getY() <= y)&& (target.getY() + target.getHeight() - 1 >= y))) {
				return true;
			}
			else
				return false;
		}
	}	
}
