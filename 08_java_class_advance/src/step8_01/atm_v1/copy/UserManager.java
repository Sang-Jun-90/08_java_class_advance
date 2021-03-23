package step8_01.atm_v1.copy;

import java.util.Scanner;

import step8_01.atm_v1.User;

public class UserManager {
	Scanner scan = new Scanner(System.in);
	
	User[] user = null;
	int userCount = 0;
	
	void printAllUser(){
		
	}
	
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
		
		
		
		
		
		userCount++;
	}
	int logUser() {
		
	}
	
	void leave() {
		
	}
	
}