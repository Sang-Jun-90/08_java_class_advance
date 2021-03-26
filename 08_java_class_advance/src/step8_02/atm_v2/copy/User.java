package step8_02.atm_v2.copy;

public class User {
	
	String id;
	String pw;
	
	int maxNum = UserManager.getInstance().ACC_MAX_CNT;
	
	Account[] acc = new Account[maxNum];
	
	int accCnt;
	
	
}


