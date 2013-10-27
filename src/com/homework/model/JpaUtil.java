package com.homework.model;

import javax.persistence.*;

public class JpaUtil {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getFactory() {
		return emf;
	}
	
	public static void initFactory() {
		emf = Persistence.createEntityManagerFactory("model");
	}

	public static void closeFactory() {
		emf.close();
	}
			
}
