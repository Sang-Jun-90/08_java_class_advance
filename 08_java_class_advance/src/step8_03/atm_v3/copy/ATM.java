package step8_03.atm_v3.copy;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	FileManager fm = FileManager.getInstance();
	UserManager um = UserManager.getInstance();
	AccountManager am = AccountManager.getInstance();
	
	
	ATM(){
		boolean isLoad = fm.loadData();
		if(!isLoad) {
			um.setDummy();
			fm.saveData();
		}
	}
	
	void showMenu() {
		
		while(true) {
			printAllDataByAllUser();
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입\n[2]로그인\n[0]종료");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = scan.nextInt();
			
			if		(choice == 1) 	join(); 
			else if (choice == 2) 	login(); 
			else if (choice == 0) 	break;
			
		}
		
	}
	
	void printAllDataByAllUser() {
		um.printAllUserInfo();
	}
	
	void login() {
		um.loginUser();
	}
	
	void join() {
		um.joinUser();
	}
	
	
}







