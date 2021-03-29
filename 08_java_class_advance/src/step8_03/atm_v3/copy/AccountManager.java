package step8_03.atm_v3.copy;

import java.util.Random;

public class AccountManager {

	Random ran = new Random();
	
	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	UserManager userManager = UserManager.getInstance();	
	
	void createAccount() {
		
		User loginUser = userManager.userList[userManager.identifier];
		
		if (loginUser.accCount == 3) {
			System.out.println("더이상 못만들어요");
		}
		if (loginUser.accCount == 0) {
			loginUser.accList = new Account[1];
		}
		else if (loginUser.accCount > 0) {
			Account[] temp = loginUser.accList;
			loginUser.accList = new Account[loginUser.accCount+1];
			for (int i = 0; i < loginUser.accCount+1; i++) {
				loginUser.accList[i] = temp[i];
			}
			temp = null;
		}
		String makeAccount = ran.nextInt(90000000) + 10000001 + "";
		loginUser.accList[loginUser.accCount].number = makeAccount;
		loginUser.accList[loginUser.accCount].money = 0;
		
		
		
		loginUser.accList[loginUser.accCount] = new Account();
		loginUser.accCount++;
		System.out.println("계좌 생성");
		
		FileManager.getInstance().saveData();
		
	}
	
	
	int showAccList(String msg) {
		
	}
	
	
	void income() {
		
	}
	
	
	void outcome() {
		
		
	}
	
	
	int checkAcc(String transAccount) {
		
	}
	
	
	int getAccIndex(int transUserIndex, String transAccount) {
		
		
	}
	
	
	void transfer() {

	}
	
	
	void lookupAcc() {
	
	}

	
	void deleteAcc() {
		
		
	
	}
	
	
}
