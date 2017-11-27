/* 제13장 Programming 문제 1번
 * 이름 : 문경민
 * 학번 : 20163014
 * 제출일 : 2017.11.28 */
import java.util.Scanner;
class CountRunnable implements Runnable {
	// 스레드 코드. run()이 종료하면 스레드 종료
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)     // 1부터 10까지 카운트
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
public class ThreadEx {
	public static void main(String[] args) {
		System.out.print("아무 키나 입력 >> ");
		Scanner scanner = new Scanner(System.in);
		String st = scanner.next();
		scanner.close();	
		
		CountRunnable runnable = new CountRunnable();     // Runnable 객체 생성
		Thread th = new Thread(runnable);     // 스레드 객체 생성
		
		th.start();     // 스레드가 실행을 시작하게 함.
	}
}
