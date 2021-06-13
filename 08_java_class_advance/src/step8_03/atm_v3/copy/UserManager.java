package step8_03.atm_v3.copy;

import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	private UserManager() {};
	private static UserManager instance = new UserManager();
	public static UserManager getInstance() {
		return instance;
	}
	
	FileManager fm = FileManager.getInstance();
	AccountManager am = AccountManager.getInstance();
	
	User[] userList;
	int userCount;
	int identifier = -1;
	
	
	void setDummy() {
	
		userCount = 5;
		userList = new User[userCount];
		for (int i=0; i<userCount; i++) {
			userList[i] = new User();
		}
				
		String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
		String[] b = {"l", "b", "c", "m", "e", "f", "g", "n", "i", "p", "k"};
		String[] c = {"s", "t", "u", "w", "v", "o", "x", "n", "q", "p", "r"};
		
		for (int i=0; i<userCount; i++) {
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

	void printAllUserInfo() {
		System.out.println("아이디\t패스워드\t계좌정보");
		for (int i = 0; i < userCount; i++) {
			userList[i].printOneUserAllAccounts();
		}
		System.out.println("--------------------------");
	}
	
	int checkId(String id) {
		int check = -1;
		for (int i = 0; i < userCount; i++) {
			if(id.equals(userList[i].id)) check = i;
		}
		return check;
	}
	
	void joinUser() {
		
		System.out.print("id?");
		String id = scan.next();
		
		int checkId = checkId(id);
		
		if(checkId == -1) {
			System.out.println("id duple");
			return;
		}
		System.out.print("pw?");
		String pw = scan.next();
		
		if(userCount == 0) {
			userList = new User[1];
			userList[userCount] = new User(id,pw);
		}
		else if(userCount > 0) {
			User[] temp = userList;
			userList = new User[userCount+1];
			for (int i = 0; i < userCount; i++) {
				userList[i] = temp[i];
			}
			userList[userCount] = new User(id,pw);
			
			temp = null;
		}
		
		userCount++;
		System.out.println("[메세지]회원가입을 완료하였습니다.\n");
		fm.saveData();
		printAllUserInfo();
		
	}
	
	void leaveUser() {
		if(identifier == -1) {
			System.out.println("로그인이 안되어 있어요");
			return;
		}
		
		if(userCount == 1) {
			userList = null;
		}
		else if (userCount > 1) {
			User[] temp = userList;
			userList = new User[userCount-1];
			
			int j = 0;
			for (int i = 0; i < userCount; i++) {
				
				if(identifier != i) {
					userList[j++] = temp[i];
				}
			}
			
		}
		userCount--;
		System.out.println("탈퇴 완료 ");
		logoutUser();
		fm.saveData();
	}
	
	void loginUser() {
		
		System.out.print("[로그인]아이디를 입력하세요 : ");
		String id = ATM.scan.next();
		
		System.out.print("[로그인]패스워드를 입력하세요 : ");
		String password = ATM.scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(userList[i].id) && password.equals(userList[i].password)) {
				identifier = i;
			}
		}
		
		if(identifier == -1) System.out.println("check your id and pw");
		else {
			System.out.println("[메세지]" + userList[identifier].id + "님, 환영합니다.\n");
			afterloginMenu();
		}
		
		
	}
	
	void logoutUser() {
		identifier = -1;
		System.out.println("logouted");
	}
	
	void afterloginMenu() {
		
		while(true) {
			System.out.println("[" + userList[identifier].id + "님, 로그인]");
			System.out.println("[1]계좌생성 [2]입금하기 [3]출금하기 [4]이체하기 [5]계좌조회 "
					+ "[6]계좌삭제 [7]회원탈퇴 [0]뒤로가기");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = ATM.scan.nextInt();
			
			if (choice == 1)  {
				am.createAccount();
			}
			else if (choice == 2) {
				am.income(); 
			}
			else if (choice == 3) {
				am.outcome();
			}
			else if (choice == 4) {
				am.outcome();
			}
			else if (choice == 5) {
				am.lookupAcc();
			}
			else if (choice == 6) {
				am.deleteAcc();
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




