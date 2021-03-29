package step8_03.atm_v3.copy;

import java.util.Scanner;

import step8_02.atm_v2.FileManager;
import step8_03.atm_v3.ATM;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	private UserManager() {}
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	User[] userList;
	int userCount;
	int identifier = -1;
	
	void printAllUserInfo() {
		System.out.println("아이디\t패스워드\t계좌정보");
		for (int i = 0; i < userCount; i++) {
			userList[i].printOneUserAllAccounts();
		}
		System.out.println("------------------------");
		
	}
	
	
	void setDummy() {
		userCount = 5;
		userList = new User[userCount];
		for (int i = 0; i < userCount; i++) {
			userList[i] = new User();
		}
		String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		String[] b = {"l", "b", "c", "m", "e", "f", "g", "n", "i", "p", "k"};
		String[] c = {"s", "t", "u", "w", "v", "o", "x", "n", "q", "p", "r"};
		
		for (int i = 0; i < userCount; i++) {
			String id = "";
			int rNum = ATM.ran.nextInt(a.length);
			id += a[rNum];
			rNum = ATM.ran.nextInt(b.length);
			id += b[rNum];
			rNum = ATM.ran.nextInt(c.length);
			id += c[rNum];
			userList[i].id = id;
		}

		String[] d = {"1", "8", "9", "4"};
		String[] e = {"2", "7", "0", "6"};
		String[] f = {"5", "3", "2", "7"};
		
		for (int i=0; i<userCount; i++) {
			String pw = "";
			int rNum = ATM.ran.nextInt(d.length);
			pw += d[rNum];
			rNum = ATM.ran.nextInt(e.length);
			pw += d[rNum];
			rNum = ATM.ran.nextInt(f.length);
			pw += d[rNum];
			
			userList[i].password = pw;
		}
		System.out.println("[메세지]더미 파일이 추가되었습니다.\n");
		
	}

	
	int checkId(String id) {

		int indentifier = -1;
		
		for (int i = 0; i < userCount; i++) {
			if (id.equals(userList[i].id)) {
				indentifier= i;
			}
		}
		
		return identifier;
		
	}
	
	
	void joinUser() {
		
		System.out.print("아이디 입력 : ");
		String id  = scan.next();
		
		int checkId = checkId(id);
		
		if (checkId == -1) {
			System.out.println("아이디 중복");
			return;
		}
		
		System.out.print("비번 입력 : ");
		String password  = scan.next();
		
		if (userCount == 0) {
			userList = new User[1];
			userList[0] = new User(id,password);
		}
		else if (userCount > 0) {
			User[] temp = userList;
			userList = new User[userCount + 1];
			
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];	
			}
			userList[userCount] = new User(id,password);
			temp = null;
			
		}
		userCount++;
		System.out.println(id+"회원가입 축하");
		
		FileManager.getInstance().saveData();
		
		printAllUserInfo();
		
	}
	
	
	void leaveUser() {
		
		if (userCount == 1) {
			userList = null;
		}
		else if (userCount > 1) {
			User[] temp = userList;
			userList = new User[userCount-1];
			
			int j = 0;
			for (int i = 0; i < userCount; i++) {
				if (i != identifier) {
					userList[j++] = temp[i];
				}
			}
			
		}
		userCount--;
		System.out.println("탈퇴완료");
				
		logoutUser();
		FileManager.getInstance().saveData();
		
	}
	
	
	void loginUser() {

		System.out.print("[로그인]아이디를 입력하세요 : ");
		String id = scan.next();
		
		System.out.print("[로그인]패스워드를 입력하세요 : ");
		String password = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if (userList[i].id.equals(id) && userList[i].password.equals(password)) {
				identifier = i;
			}
		}
		if (identifier == -1) System.out.println("틀렸는걸");
		else {
			System.out.println("로그인성공");
			afterloginMenu();
		}
		
	}
	
	
	void logoutUser() {
		identifier = -1;
		System.out.println("로그아웃");
	}
	
	
	void afterloginMenu() {

		while (true) {
			System.out.println("[" + userList[identifier].id + "님, 로그인]");
			System.out.println("[1]계좌생성 [2]입금하기 [3]출금하기 [4]이체하기 [5]계좌조회 "
					+ "[6]계좌삭제 [7]회원탈퇴 [0]뒤로가기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = scan.nextInt();
			
			if (choice == 1)  {
				AccountManager.getInstance().createAccount(); 
			}
			else if (choice == 2) {
				AccountManager.getInstance().income(); 
			}
			else if (choice == 3) {
				AccountManager.getInstance().outcome();
			}
			else if (choice == 4) {
				AccountManager.getInstance().transfer(); 
			}
			else if (choice == 5) {
				AccountManager.getInstance().lookupAcc(); 
			}
			else if (choice == 6) {
				AccountManager.getInstance().deleteAcc(); 
			}
			else if (choice == 7) {
				leaveUser();
				break;
			}
			else if (choice == 0) {
				logoutUser();
				break; 
			}
			
			
		}
		
		
	}
}









