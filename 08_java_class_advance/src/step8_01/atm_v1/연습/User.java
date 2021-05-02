package step8_01.atm_v1.연습;

public class User {
	
	// 변수 - 아이디, 계좌수 
	// 계좌 배열 생성
	// printAccount 메서드로 출력(배열을 순차 출력)
	
	String id = "";
	int accCount = 0;
	
	Account[] accList = new Account[accCount];
	
	void printAccount() {
		for (int i = 0; i < accCount; i++) {
			accList[i].printOwnAccount();
		}
	}
	
}
