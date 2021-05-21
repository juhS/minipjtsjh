package miniproject.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import miniproject.model.vo.Player123;
import miniproject.views.nickname.NickName;

public class PlayerDao {
	String nick= NickName.nickname;
	
	public void insertScore(Player123 pl) {
		ObjectOutputStream oos = null; 
		try {
			oos = new ObjectOutputStream(new FileOutputStream(nick+".dat", true));
			oos.writeObject(pl);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList readAll() {
		ArrayList list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(nick+".dat");
			list = new ArrayList();
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fis);
				Player123 pl = (Player123) ois.readObject();
				list.add(pl);
				
			}
		} catch (EOFException e) {
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
