package step8_01.atm_v1.copy;
import java.util.Random;
import java.util.Scanner;


public class ATM {
	
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	UserManager userManager = new UserManager();
	int identifier = -1;
	
	void printMainMenu() {
		
		while (true) {
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();
			
			if (sel == 1) login();
			else if (sel == 2) logout();
			else if (sel == 3) join();
			else if (sel == 4) leave();
			else if (sel == 0) break;		
		}
		
		
	}
	
	void login() {
		
	}
	void logout() {
		
	}
	void join() {
		
		
		
	}
	void leave() {
		
	}
	
}