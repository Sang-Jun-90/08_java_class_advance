package step8_02.atm_v2.copy;

public class User {
	
	String id;
	String pw;
	int accCnt;
	
	Account[] UserAccList = new Account[UserManager.getinstance().MAXACCNUM];
	
}


