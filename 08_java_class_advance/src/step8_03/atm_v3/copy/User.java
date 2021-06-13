package step8_03.atm_v3.copy;

public class User {

	String id;
	String password;
	Account[] accList = null;
	int accCnt;
	
	User(){};



	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}



	public User(String id, String password, Account[] accList, int accCnt) {
		super();
		this.id = id;
		this.password = password;
		this.accList = accList;
		this.accCnt = accCnt;
	}
	
	void printOneUserAllAccounts() {
		
		if(accCnt == 0) {
			System.out.println(id + "\t"+password+"\t"+"\t계좌를 개설해주세요.");
		}
		else {
			System.out.println(id + "\t"+password+"\t");
			for (int i = 0; i < accCnt; i++) {
				System.out.println(accList[i].number + "/" + accList[i].money + "원 ");
			}
			System.out.println();
		}
		
	}
	
}
