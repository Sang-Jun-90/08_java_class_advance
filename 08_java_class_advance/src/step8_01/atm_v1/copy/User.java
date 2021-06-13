package step8_01.atm_v1.copy;


public class User {
	
	public String id;
	public int accCount;
	public Account[] acc = null;
	
	public void printAccount() {
		for (int i = 0; i < accCount; i++) {
			acc[i].printOwnAccount();
		}
	}
	
}
