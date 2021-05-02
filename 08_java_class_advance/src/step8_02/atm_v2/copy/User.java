package step8_02.atm_v2.copy;

public class User {
	
	// 변수 : 아이디 , 비번 , maxNum, 계좌수
	// acc 매서드 배열 
	
	String id;
	String pw;
	
	int maxNum = UserManager.getInstance().ACC_MAX_CNT;
	
	Account[] acc = new Account[maxNum];
	
	int accCnt;
	
	
}


