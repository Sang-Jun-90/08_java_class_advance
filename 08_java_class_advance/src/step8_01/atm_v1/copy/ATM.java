package step8_01.atm_v1.copy;
import java.util.Random;
import java.util.Scanner;


public class ATM {
	UserManager userManager = new UserManager();
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int identifier = -1;
	
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
		identifier = userManager.logUser();
		
		if (identifier != 1) {
			printAccountMenu();
		}
		else {
			System.out.println("로그인 실패");
		}
	}
	void logout() {
		if (identifier == -1) {
			System.out.println("로그인안했는데요");
		}
		else {
			System.out.println("로그아웃");
			identifier =  -1;
		}
	}
	void join() {
		userManager.addUser();
	}
	void leave() {
		userManager.leave();
	}
	
	void printAccountMenu() {
		while (true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
			String makeAccount = Integer.toString(ran.nextInt(90001) + 10000);
			
		 		
			if 		(sel == 1) {
				
				if () {
					
				}
				else {
					
				}
				userManager.userCount++;
				
			} 		
			else if (sel == 2) {
				
				
				
			} 	
			else if (sel == 3) {
				userManager.user[identifier].printAccount();
			}  	 
			else if (sel == 0) {
				logout();
				break;
			} 	
		}
	}
	
}