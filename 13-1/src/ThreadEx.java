/* ��13�� Programming ���� 1��
 * �̸� : �����
 * �й� : 20163014
 * ������ : 2017.11.28 */
import java.util.Scanner;
class CountRunnable implements Runnable {
	// ������ �ڵ�. run()�� �����ϸ� ������ ����
	@Override
	public void run() {
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++)     // 1���� 10���� ī��Ʈ
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}
public class ThreadEx {
	public static void main(String[] args) {
		System.out.print("�ƹ� Ű�� �Է� >> ");
		Scanner scanner = new Scanner(System.in);
		String st = scanner.next();
		scanner.close();	
		
		CountRunnable runnable = new CountRunnable();     // Runnable ��ü ����
		Thread th = new Thread(runnable);     // ������ ��ü ����
		
		th.start();     // �����尡 ������ �����ϰ� ��.
	}
}
