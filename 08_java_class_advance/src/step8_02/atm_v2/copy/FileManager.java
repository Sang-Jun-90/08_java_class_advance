package step8_02.atm_v2.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	
	private FileManager() {}
	private static FileManager instance = new FileManager();
	public static FileManager getInstance() {
		return instance;
	}
	
	String filename = "ATM.txt";
	String data = "";
	
	UserManager um = UserManager.getinstance();
	
	void setData() {
		
		// 총 가입자 수 
		data += um.userCnt;
		data += "\n";
		
		for (int i = 0; i < um.userCnt; i++) {
			data += um.userList[i].id;
			data += "\n";
			data += um.userList[i].pw;
			data += "\n";
			data += um.userList[i].accCnt;
			data += "\n";
			
			if(um.userList[i].accCnt == 0) {
				data += "0\n";
			}
			else {
				for (int j = 0; j < um.userList[i].accCnt; j++) {
					data += um.userList[i].UserAccList[j].accNumber;
					data += "/";
					data += um.userList[i].UserAccList[j].money;

					if(um.userList[i].accCnt != j) {
						data += ",";
					}
				}
				data += "\n";
			}
		}
	}
	
	void save() {
		setData();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(filename);
			fw.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
		
	}
	
	void load() {
		
		File file = new File(filename);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if(file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				
				String[] temp = data.split("\n");
				um.userCnt = Integer.parseInt(temp[0]);
				um.userList = new User[um.userCnt];
				for (int i = 0; i < um.userCnt; i++) {
					um.userList[i] = new User();
				}
				
				int j = 0;
				
				for (int i = 1; i < temp.length; i+=4) {
					String id = temp[i];
					String pw = temp[i+1];
					int accCnt = Integer.parseInt(temp[i+2]);
					
					um.userList[j].id = id;
					um.userList[j].pw = pw;
					um.userList[j].accCnt = accCnt;
					
					String accInfo = temp[i+3];
					
					if(accCnt == 1) {
						String[] tempAcc = accInfo.split("/");
						String acc = tempAcc[0];
						int money = Integer.parseInt(tempAcc[1]);
						um.userList[j].UserAccList[0] = new Account();
						um.userList[j].UserAccList[0].accNumber = acc;
						um.userList[j].UserAccList[0].money = money;
						
					}
					
					else if(accCnt > 1) {
						String[] tempAcc = accInfo.split(",");
						
						for (int k = 0; k < tempAcc.length; k++) {
							String[] tempAcc1 = accInfo.split("/");
							String acc = tempAcc1[0];
							int money = Integer.parseInt(tempAcc1[1]);
							um.userList[j].UserAccList[k] = new Account();
							um.userList[j].UserAccList[k].accNumber = acc;
							um.userList[j].UserAccList[k].money = money;
						}
						
					}
					j++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();} catch (Exception e) {e.printStackTrace();}
			if(fr != null) try {fr.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		
		
	}
	
	
	
}





