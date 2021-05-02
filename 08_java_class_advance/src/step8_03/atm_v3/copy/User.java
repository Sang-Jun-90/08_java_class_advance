package step8_03.atm_v3.copy;

public class User {
	
	String id;
	String password;
	Account[] accList;
	int accCount;
	
	
	User() {}
	
	User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	User(String id, String password, Account[] accList, int accCount) {
		this.id = id;
		this.password = password;
		this.accList = accList;
		this.accCount = accCount;
	}
	
	void printOneUserAllAccounts() {


		
	}
	
	
}
