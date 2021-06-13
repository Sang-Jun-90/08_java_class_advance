package step8_02.atm_v2.copy;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	private AccountManager() {}
	static private AccountManager instance = new AccountManager();
	static public AccountManager getInstance() {
		return instance;
	}
	
	UserManager um = UserManager.getinstance();
	FileManager fm = FileManager.getInstance();
	
	void createAcc(int identifier) {
		User selUser = um.userList[identifier];
		
		
		if(selUser.accCnt >= 3) {
			System.out.println("[메세지]계좌개설은 3개까지만 가능합니다.");
			return;
		}
		
		selUser.UserAccList[selUser.accCnt] = new Account();
		String makeAccount = "";
		
		while(true) {
			makeAccount = ran.nextInt(9000000) + 1000001 + "";
			if(!um.getCheckAcc(makeAccount)) {
				break;
			}
		}
		selUser.UserAccList[selUser.accCnt].accNumber = makeAccount;
		selUser.UserAccList[selUser.accCnt].money = 0;
		selUser.accCnt++;
		
		System.out.println("[메세지]'" + makeAccount + "'계좌가 생성되었습니다.\n");
		fm.save();
		
	}
	
	void printAcc(int identifier) {
		User selUser = um.userList[identifier];
		System.out.println("====================");
		System.out.println("ID : " + selUser.id);
		System.out.println("====================");
		for (int i=0; i<selUser.accCnt; i++) {
			System.out.println("[" + i +"] "+"accNumber:" +selUser.UserAccList[i].accNumber + " / money: " + selUser.UserAccList[i].money);
		}
		System.out.println("=============================\n");
	}
	
	void deleteAcc(int delNum,int identifier) {
		
		User selUser = um.userList[identifier];
		
		if(delNum < 0 || delNum > selUser.accCnt) return;
		
		selUser.UserAccList[delNum] = null;
		selUser.accCnt--;
		fm.save();
		
//		Account[] temp = selUser.UserAccList;
//		selUser.UserAccList = new Account[selUser.accCnt-1];
//		
//		int j = 0 ;
//		for (int i = 0; i < selUser.accCnt; i++) {
//			if(delNum != i) {
//				selUser.UserAccList[j++] = temp[i];
//			}
//		}
//		selUser.accCnt--;
		
		
	}
	
}
