package step8_03.atm_v3.copy;

public class AccountManager {

	private AccountManager() {};
	private static AccountManager instance = new AccountManager();
	public static AccountManager getInstance() {
		return instance;
	}
	
	FileManager fm = FileManager.getInstance();
	UserManager um = UserManager.getInstance();

	void createAccount() {
		User loginUser = um.userList[um.identifier];
		int accCount = loginUser.accCnt;
		
		if(accCount== 3) {
			System.out.println("[메세지]더 이상 계좌를 생성할 수 없습니다.\n");
			return;
		}
		
		if(accCount == 0) {
			loginUser.accList = new Account[1];
		}
		else {
			Account[] temp = loginUser.accList;
			loginUser.accList = new Account[accCount+1];
			
			for (int i = 0; i < accCount; i++) {
				loginUser.accList[i]=temp[i];
			}
			temp = null;
		}
		loginUser.accList[accCount] = new Account();
		String makeAccount = ATM.ran.nextInt(90000000) + 10000001 +"";
		
		loginUser.accList[accCount].number = makeAccount;
		loginUser.accList[accCount].money = 0;
		
		loginUser.accCnt++;
		System.out.println("[메세지]계좌가 생성되었습니다.\n");
		
		fm.saveData();
		
	}
	
	void income() {
		
		int loginAccIndex = showAccList("입금");
		if(loginAccIndex == -1) {
			System.out.println("check your account");
			return;
		}
		System.out.print("[입금]금액을 입력하세요 : ");
		int money = ATM.scan.nextInt();
		
		um.userList[um.identifier].accList[loginAccIndex].money += money;
		
		System.out.println("income check");
		fm.saveData();
		
		
	}
	int showAccList(String msg) {
		int loginAccIndex = -1;
		User loginUser = um.userList[um.identifier];
		
		if(loginUser.accCnt > 0) {
			for (int i = 0; i < loginUser.accCnt ; i++) {
				System.out.println("[" + (i+1) + "]" + loginUser.accList[i].number);
			}
			System.out.print("[" + msg + "]내 계좌를 메뉴에서 선택하세요 : ");
			loginAccIndex = ATM.scan.nextInt();
			loginAccIndex--;
		}
		
		
		return loginAccIndex;
	}
	int checkAcc(String transAccount) {
		int check = -1;
		
		for (int i = 0; i < um.userCount; i++) {
			if(um.userList[i].accList != null) {
				for (int j = 0; j < um.userList[i].accCnt; j++) {
					if(transAccount.equals(um.userList[j].accList[j].number)) {
						check = i;
					}
				}
			}
		}
		return check;
	}
	int getAccIndex(int transUserIndex,String transAccount) {
		int accIndex = 0;
		
		for (int i = 0; i < um.userList[um.identifier].accCnt; i++) {
			if(transAccount.equals(um.userList[transUserIndex].accList[i].number)) {
				accIndex = i;
			}
		}
		
		return accIndex;
	}
	void outcome() {
		
		int loginAccIndex = showAccList("출금 ");
		if(loginAccIndex == -1) {
			System.out.println("check your account");
			return;
		}
		System.out.print("[입금]금액을 입력하세요 : ");
		int money = ATM.scan.nextInt();
		
		if(money > um.userList[um.identifier].accList[loginAccIndex].money) {
			System.out.println("[메세지]계좌잔액이 부족합니다.\n");
			return;
		}
		
		
		um.userList[um.identifier].accList[loginAccIndex].money -= money;
		
		System.out.println("outcome check");
		fm.saveData();
		
	}
	void transfer() {
		int loginAccIndex = showAccList("이체");
		if (loginAccIndex == -1) {
			System.out.println("[메세지]계좌를 먼저 생성해주세요.\n");
			return;
		}		
		
		System.out.print("[이체]이체할 '계좌번호'를 입력하세요 : ");
		String transAccount = ATM.scan.next();
		
		int transUserIndex = checkAcc(transAccount);
		if(transUserIndex == -1) {
			System.out.println("[메세지]'계좌번호'를 확인해주세요.\n");
			return;
		}
		
		int transAccIndex = getAccIndex(transUserIndex, transAccount);
		System.out.print("[이체]금액을 입력하세요 : ");
		int money = ATM.scan.nextInt();
		
		if(money > um.userList[um.identifier].accList[loginAccIndex].money) {
			System.out.println("[메세지]계좌잔액이 부족합니다.\n");
			return;
		}
		
		um.userList[um.identifier].accList[loginAccIndex].money -= money;
		um.userList[transUserIndex].accList[transAccIndex].money += money;
		
		
		System.out.println("[메세지]이체를 완료하였습니다.\n");
		fm.saveData();
		
		
	}
	void lookupAcc() {
		um.userList[um.identifier].printOneUserAllAccounts();
	}
	void deleteAcc() {
		int loginAccIndex = showAccList("삭제");
		if (loginAccIndex == -1) {
			System.out.println("[메세지]계좌를 먼저 생성해주세요.\n");
			return;
		}
		
		User user = um.userList[um.identifier];
		
		if (user.accCnt == 1) {
			user.accList = null;
		}
		else if(user.accCnt > 1) {
			Account[] acc = user.accList;
			
			user.accList = new Account[user.accCnt - 1];
			int j = 0;
			for (int i=0; i<user.accCnt; i++) {
				if (i != loginAccIndex) {
					user.accList[j] = acc[i];
					j = j + 1;
				}
			}
			acc = null;
		}
		user.accCnt--;
		
		System.out.println("[메세지]계좌삭제를 완료하였습니다.\n");
		
		FileManager.getInstance().saveData();
	}
	
	
}
