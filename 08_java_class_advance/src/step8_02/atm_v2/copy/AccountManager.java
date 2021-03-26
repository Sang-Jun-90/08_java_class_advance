package step8_02.atm_v2.copy;

import java.util.Random;
import java.util.Scanner;

public class AccountManager {

	private AccountManager() {}
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	

	void createAcc(int identifier) {	

	}
	
	
	void printAcc(int identifier) {
	
	}
	
}
