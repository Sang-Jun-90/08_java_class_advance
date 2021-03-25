package step8_01.atm_v1.copy;

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
		System.out.print("아이디는 ? ");
		String id = scan.next();
		
		Boolean isDuple = false;
		
		for (int i = 0; i < userCount; i++) {
			if (id.equals(user[i].id)) {
				isDuple = true;
			}
		}
		if (!isDuple) {
			user[userCount] = new User();
			user[userCount].id = id;
			System.out.println(id +"가입을 축하해요");
			
			userCount++;
		}
		else {
			System.out.println("아이디 중복");			
		}
		
	}
	int logUser() {
		
		int identifier = -1;
		System.out.println("아이디는 : ");
		String id = scan.next();	
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				identifier = i;
				System.out.println(id + "님 로그인 성공");
			}
		}
	
		
		return identifier;
	}
	
	void leave() {
		
		System.out.println("아이디는 : ");
		String id = scan.next();
		int identifier = -1;
		
		for (int i = 0; i < userCount; i++) {
			if(id.equals(user[i].id)) {
				identifier = i;
			}
		}
		
		if (identifier == -1) {
			System.out.println("아이디가 없는데요");
			return;
		}
		System.out.println(id + "님 탈퇴");
		
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