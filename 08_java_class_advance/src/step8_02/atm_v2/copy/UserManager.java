package step8_02.atm_v2.copy;

import java.util.Random;
import java.util.Scanner;

public class UserManager {
	
	private UserManager() {};
	static private  UserManager instance = new UserManager();
	static public UserManager getinstance() {
		return instance;
	}
	
	Scanner scan = new Scanner(System.in);
	FileManager fm = FileManager.getInstance();
	
	final int MAXACCNUM = 5; 
	User[] userList = null;
	int userCnt = 0;
	
	
	int logUser() {
		
		int identifier = -1;
		
		System.out.print("id?");
		String id = scan.next();
		System.out.print("pw?");
		String pw = scan.next();
		
		for (int i = 0; i < userCnt; i++) {
			if (id.equals(userList[i].id) && pw.equals(userList[i].pw)) identifier = i;
		}
		
		return identifier;
	}
	void joinMember() {
		
		System.out.print("id?");
		String id = scan.next();
		System.out.print("pw?");
		String pw = scan.next();
		if(checkId(id)) {
			System.out.println("id duple!!");
			return;
		}
		
		if(userCnt==0) {
			userList = new User[userCnt+1];
			
		}
		else {
			User[] temp = userList;
			userList = new User[userCnt+1];
			for (int i = 0; i < userCnt; i++) {
				userList[i] = temp[i];
			}
			temp = null;	
		}
		userList[userCnt] = new User();
		userList[userCnt].id = id;
		userList[userCnt].pw = pw;	
		userCnt++;
		System.out.println("[메세지]회원가입을 축하합니다.");
		fm.save();
		
	}
	
	boolean checkId(String id) {
		
		boolean checkId = false;
		
		for (int i = 0; i < userCnt; i++) {
			if(id.equals(userList[i].id)) checkId = true;
		}
		return checkId;
	}
	
	int deleteMember(int identifier){
		
		System.out.print("pw?");
		String pw = scan.next();
		
		if(userList[identifier].pw.equals(pw)) {
			
			User[] temp = userList;
			userList = new User[userCnt-1];
			
			int j = 0;
			for (int i = 0; i < userCnt; i++) {
				if(i != identifier) {
					userList[j++] = temp[i];
				}
			}
			temp = null;
			userCnt--;
			
			System.out.println( "탈퇴되었습니다.");
		}
		fm.save();
		return identifier;
		
	}
	
	void printAllUsers() {
		
		for (int i=0; i<userCnt; i++) {
		System.out.print((i+1) + ".ID(" + userList[i].id + ")\tPW(" + userList[i].pw + ")\t");
		if (userList[i].accCnt != 0) {
			for (int j=0; j<userList[i].accCnt; j++) {
				System.out.print("(" + userList[i].UserAccList[j].accNumber + ":" + userList[i].UserAccList[j].money + ")");
			}
		}
		System.out.println();
	}
		
	}
	
	void setDummy() {
		
	}
	
	boolean getCheckAcc(String makeAccount) {
		boolean checkAcc = false;
		
		for (int i = 0; i < userCnt; i++) {
			for (int j = 0; j < userList[i].accCnt; j++) {
				if(makeAccount.equals(userList[i].UserAccList[j].accNumber)) {
					checkAcc = true;
				}
			}
		}
		
		return checkAcc;
		
	}
	
}
