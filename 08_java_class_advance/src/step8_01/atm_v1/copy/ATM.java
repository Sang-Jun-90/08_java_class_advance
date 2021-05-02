package step8_01.atm_v1.copy;
import java.util.Random;
import java.util.Scanner;


public class ATM {
	
	Scanner scan = new Scanner(System.in);
	
	void printMainMenu() {
		
		while(true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();
			
			if      (sel == 1) 	    login();
			else if (sel == 2) 		logout();
			else if (sel == 3) 		join();
			else if (sel == 4) 		leave();
			else if (sel == 0) 		break;	
			
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
	
	void printAccountMenu() {
		while (true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
					 		
			if 		(sel == 1) {

			} 		
			else if (sel == 2) {
				
			} 	
			else if (sel == 3) {

			}  	 
			else if (sel == 0) {

			} 	
		}
	}
	
}