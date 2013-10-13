package com.homework.hw3.hsql;

import java.sql.SQLException;
import java.util.ArrayList;

public class DbItemlist {

	public ArrayList<DbItem> itemList;
	
	public ArrayList getAllItems() {
		try {
			DbAccess db = new DbAccess();
			itemList = db.getAll();
			return itemList;
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	public ArrayList getLike(String key) {
		try {
			DbAccess db = new DbAccess();
			itemList = db.getByLike(key);
			return itemList;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
