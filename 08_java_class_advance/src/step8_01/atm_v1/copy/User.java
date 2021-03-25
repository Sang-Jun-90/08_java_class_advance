package step8_01.atm_v1.copy;

public class User {
	
	String id;
	int accCount = 0;
	
	Account[] acc = null;
	
	void printAccount() {
		
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}
		
	}
	
}
