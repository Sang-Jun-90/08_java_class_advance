package step8_01.atm_v1.연습;

import java.util.Scanner;


public class UserManager {
	
	Scanner scan = new Scanner(System.in);
	
	User[] user = null;
	int userCount = 0;
	
	void addUser() {
		
		if (userCount == 0) {
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
		System.out.print("id는 : ");
		String id = scan.next();
		
		Boolean isCheck = false;
		for (int i = 0; i < userCount; i++) {
			if(user[i].id.equals(id)) isCheck=true;
		}
		if (isCheck) System.out.println("아이디가 중복");
		else {
			user[userCount] = new User();
			user[userCount].id = id;
			userCount++;
		}
		
		
		
	}
	
	int logUser() {
		
		System.out.print("id는 : ");
		String id = scan.next();
		
		int identifier = -1;
		for (int i = 0; i < userCount; i++) {
			if(user[i].id.equals(id)) {
				identifier = i;
			}
		}
		
		return identifier;
	}
	
	void leave() {
		
		System.out.println("탈퇴할 아이디는 ?");
		String id = scan.next();
		int identifier = -1;
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) identifier = i;
		}
		
		if(identifier == -1) System.out.println("아이디가 없는데요");
		else {
			User[] temp = user;
			user = new User[userCount-1];
			for (int i = 0; i < identifier; i++) {
				user[i] = temp[i];
			}
			for (int i = identifier; i < userCount-1; i++) {
				user[i] = temp[i+1];
			}
			temp = null;
			userCount--;
		}
		
		
	}
}