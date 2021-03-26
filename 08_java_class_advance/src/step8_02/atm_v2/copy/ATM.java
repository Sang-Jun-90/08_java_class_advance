package step8_02.atm_v2.copy;

import java.util.Scanner;

import step8_02.atm_v2.AccountManager;
import step8_02.atm_v2.FileManager;

public class ATM {
	
	Scanner scan = new Scanner(System.in);
	int identifier = -1;
	
	UserManager um = UserManager.getInstance();
	
	void play() {
		UserManager.getInstance().printAllUser();
		
		while(true) {
			System.out.println("[ATM]");
			System.out.println("[1.회원가입]\n[2.로그인]\n[0.종료]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) join();
			else if (sel == 2) login();
			else if (sel == 0) break;
			
		}
		
		
	}
	
	void join() {
		um.joinMember();
	}
	
	void login() {
		identifier = um.logUser();
		if (identifier != 1) loginMenu();
		else System.out.println("아이디또는 패스워드 확인");
	}
	
	
	void loginMenu() {
		
		while (true) {
			
			System.out.println("[" + um.userList[identifier].id + "님, 환영합니다.]");
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조    회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			if (selectMenu == 1) {

			}
			else if (selectMenu == 2) {

			}
			else if (selectMenu == 3) {
				AccountManager.getInstance().printAcc(identifier);
			}
			else if (selectMenu == 4) {
				um.deleteMember(identifier);
			}
			else if (selectMenu == 0) {
				identifier = -1;
				System.out.println("로그아웃 되었습니다.");
				break;
			}
			
			
		}
		
	}
	
	
	

	
}
