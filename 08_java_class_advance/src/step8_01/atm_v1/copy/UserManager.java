package step8_01.atm_v1.copy;


import java.util.Scanner;

public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	User[] user = null;
	int userCount = 0;
	
	void printAllUser() {
		for (int i = 0; i < userCount; i++) {
			user[i].printAccount();
		}
	}
	

	public int logUser() {
		
		int identifier = -1;
		System.out.print("[입력] 아이디를 입력하세요 : ");
		String id = scan.next();
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				identifier = i;
			}
		}

		return identifier;
	}
	public void addUser() {
		/////////////////
		if(userCount == 0) {
			user = new User[1];
		}
		else {
			User[] temp = user;
			user = new User[userCount+1];
			for (int i = 0; i < userCount; i++) {
				user[i] = temp[i];
			}
			temp = null;
		}
		/////////////////
		
		System.out.print("user id?");
		String id = scan.next();
		
		boolean checkId = false;
		for (int i = 0; i < userCount; i++) {
			if (id.equals(user[i].id)) {
				checkId = true;  
				// 같은게 있을 경우 ture
			}
		}
		if(checkId) {
			System.out.println(id + " is already created!!");
		}
		else {
			user[userCount] = new User();
			user[userCount].id = id;
			System.out.println(id + " - welcome we join out member");
			userCount++;
		}

	}
	public void leave() {
		
		System.out.print("leave id? ");
		String id = scan.next();
		
		int identifier = -1;
		
		for (int i = 0; i < userCount; i++) {
			if (id.equals(user[i].id)) {
				identifier = i;
			}
		}
		if(identifier == -1) {
			System.out.println("there is no id info");
			return;
		}
		else {
			System.out.println(id + " - leave complete!");
			User[] temp = user;
			user = new User[userCount-1];
			
			for (int i = 0; i < identifier; i++) {
				user[i] = temp[i];
			}
			for (int i = identifier; i < userCount-1; i++) {
				user[i] = temp[i+1];
			}
			userCount--;
		}
		

	}

	
	
}
