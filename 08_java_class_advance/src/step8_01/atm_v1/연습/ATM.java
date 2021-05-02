package step8_01.atm_v1.연습;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class ATM {
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	UserManager um = new UserManager();
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
		
		System.out.println("프로그램 종료");
		
	}
	
	void login() {
		
		if(identifier != -1) {System.out.println("이미 로그인되어 있어요.");return;}
		identifier = um.logUser();		
		
		if (identifier == -1) System.out.println("로그인 실패");
		else {
			System.out.println(um.user[identifier].id + "님 안녕하세요.");
			printAccountMenu();
		}
		
		
	}
	void logout() {
		
		if(identifier == -1) {System.out.println("이미 로그아웃되어 있어요.");return;}
		identifier = -1;
		
	}
	void join() {
		
		if(identifier != -1) {System.out.println("이미 가입되어 있어요.");return;}
		um.addUser();
		
	}
	
	void leave() {
		
		if(identifier == -1) {System.out.println("로그인이 안되어 있어요.");return;}
		um.leave();
		
	}
	
	void printAccountMenu() {
		while (true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
			User nowUser = 	um.user[identifier];	 		
			if 		(sel == 1) {
				
				int acountNum = ran.nextInt(100000) + 100000;
				
				if(nowUser.accCount == 0) {
					nowUser.accList = new Account[1];
				}
				else {
					Account[] temp = nowUser.accList;
					nowUser.accList = new Account[nowUser.accCount+1];
					for (int i = 0; i < nowUser.accCount; i++) {
						nowUser.accList[i] = temp[i];
					}
				}
				
				nowUser.accList[nowUser.accCount] = new Account();
				nowUser.accList[nowUser.accCount].account = acountNum+"";
				
				nowUser.accCount++;
				
				System.out.println(nowUser.id + "님"+ "\t" + acountNum + "계좌가 생성되었어요.");
				
			} 		
			else if (sel == 2) {
				System.out.print("삭제하고 싶은 계좌는 : ");
				String account = scan.next();
				
				if(nowUser.accCount == 0) {System.out.println("계좌가 없어요"); break;};
				
				int delcount = -1;
				for (int i = 0; i < nowUser.accCount; i++) {
					if (account.equals(nowUser.accList[i].account)) delcount = i;
				}
				
				if(delcount == -1) System.out.println("그런계좌없어요.");
				else {
					Account[] temp = nowUser.accList;
					nowUser.accList = new Account[nowUser.accCount-1];
					
					for (int i = 0; i < delcount; i++) {
						nowUser.accList[i] = temp[i];
					}
					for (int i = delcount; i < nowUser.accCount-1; i++) {
						nowUser.accList[i] = temp[i+1];
					}
					
					nowUser.accCount--;
				}
				
			} 	
			else if (sel == 3) {
				if(nowUser.accCount == 0) System.out.println("계좌가 없어요.");
				else nowUser.printAccount();
			}  	 
			else if (sel == 0) {
				logout();
				break;
			} 	
		}
	}
	
}