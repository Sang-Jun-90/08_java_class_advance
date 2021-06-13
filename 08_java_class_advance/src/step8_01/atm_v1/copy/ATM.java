package step8_01.atm_v1.copy;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	
	Scanner scan = new Scanner(System.in);
	Random ran   = new Random();
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
		System.out.println("[메시지] 프로그램을 종료합니다.");	
	}
	
	void login() {
		
		identifier = um.logUser();
		
		if (identifier != -1) {
			printAccountMenu();
		}
		else {
			System.out.println("[메세지] 로그인실패.");
		}
		
	}
	void logout() {
		if(identifier == -1) System.out.println("not login state.");
		else {System.out.println("logtout complete!");identifier = -1;}
	}
	void join() {
		um.addUser();
	}
	void leave() {
		um.leave();
		identifier = -1;
	}
	
	void printAccountMenu() {
		
		while(true) {
			
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();
			User userI = um.user[identifier];
			
			String makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			
			if(sel==1) {
				if(userI.accCount == 0) {
					userI.acc = new Account[1];
					userI.acc[0] = new Account();
					userI.acc[0].number = makeAccount;
				}
				else {
					Account[] temp = userI.acc;
					userI.acc = new Account[userI.accCount+1];
					for (int i = 0; i < userI.accCount; i++) {
						userI.acc[i] = temp[i];
					}
					userI.acc[userI.accCount] = new Account();
					userI.acc[userI.accCount].number = makeAccount;
				}
				userI.accCount++;
				System.out.println("[메시지]'"+makeAccount +"'계좌가 생성되었습니다.\n");
			}
			else if(sel==2) {
				if(userI.accCount == 0) {
					System.out.println("[메시지] 더 이상 삭제할 수 없습니다.\n");
					continue;
				}
				if(userI.accCount == 1) {
					System.out.println("[메시지] 계좌번호 :'"+ userI.acc[0].number+"' 삭제 되었습니다.\n");
					userI.acc = null;
				}
				else {
					
					System.out.print("삭제 하고 싶은 계좌 번호를 입력하세요 : ");
					String deleteAccount = scan.next();
					
					int index = -1;
					for (int i = 0; i < userI.accCount; i++) {
						if(deleteAccount.equals(userI.acc[i].number)) index=i;
					}
					if(index == -1) {
						System.out.println("[메시지] 계좌번호를 확인하세요.\n");
						continue;
					}
					else {
						Account[] temp = userI.acc;
						userI.acc = new Account[userI.accCount-1];
						
						for (int i = 0; i < index; i++) {
							userI.acc[i] = temp[i];
						}
						for (int i = index; i < userI.accCount-1; i++) {
							userI.acc[i] = temp[i+1];
						}
						
					}
					
				}
				userI.accCount--;

			}
			else if(sel==3) {
				if(userI.accCount == 0) System.out.println("[메시지] 생성된 계좌가 없습니다.\n");
				else userI.printAccount();
			}
			else if(sel==0) {logout();break;}
			
		}
		
	}
	
	
}
