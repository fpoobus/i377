package com.homework.model;

import java.util.List;

import javax.persistence.*;


public class DbAccess {

	
	public static List<DbItem> getAll() {
		EntityManager em = null;
    	try {
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	
	    	TypedQuery<DbItem> query = em.createQuery( "SELECT e FROM DbItem e", DbItem.class);
	        List<DbItem> result = query.getResultList();
	        return result;
    	}
    	finally {
    		em.close();
    	}
    }
	
	public static List<DbItem> getByLike(String filter) {
		EntityManager em = null;
    	try {
    		filter = filter.toUpperCase();
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	
	    	TypedQuery<DbItem> query = em.createQuery("SELECT e FROM DbItem e WHERE UPPER(e.name) LIKE :searchstring", DbItem.class);
	    	query.setParameter("searchstring", "%" + filter + "%");
	        List<DbItem> result = query.getResultList();
	        return result;
    	}
    	finally {
    		em.close();
    	}
    }
	
	public static void clearTable() {
		EntityManager em = null;
    	try {
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	em.createNativeQuery("truncate table DbItem").executeUpdate();
	    	em.getTransaction().commit();
    	}
    	finally {
    		em.close();
    	}
    }
	
	
	public static List<DbItem> getByCode(String code) {
		EntityManager em = null;
    	try {
    		code = code.toUpperCase();
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	
	    	TypedQuery<DbItem> query = em.createQuery("SELECT e FROM DbItem e WHERE UPPER(e.code) LIKE :searchstring", DbItem.class);
	    	query.setParameter("searchstring", "%" + code + "%");
	        List<DbItem> result = query.getResultList();
	        return result;
    	}
    	finally {
    		em.close();
    	}
    }
	
    public static List<DbItem> getById(Long id) {
    	EntityManager em = null;
    	try {
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	
	    	TypedQuery<DbItem> query = em.createQuery("SELECT e FROM DbItem e WHERE e.id = :id", DbItem.class);
	    	query.setParameter("id", id);
	        List<DbItem> result = query.getResultList();
	        for(int i=0; i<result.size(); i++) {
	        	System.out.println(result.get(i));
	        }
	        return result;
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static List<DbItem> getChildren(Long id) {
    	EntityManager em = null;
    	try {
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	
	    	TypedQuery<DbItem> query = em.createQuery("SELECT e FROM DbItem e WHERE e.super_unit_id = :id", DbItem.class);
	    	query.setParameter("id", id);
	        List<DbItem> result = query.getResultList();
	        for(int i=0; i<result.size(); i++) {
	        	System.out.println("Children: "+result.get(i));
	        }
	        return result;
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void delete(Long id) {
    	EntityManager em = null;
    	try {
	    	em = JpaUtil.getFactory().createEntityManager();
	    	em.getTransaction().begin();
	    	DbItem unit = em.find(DbItem.class, id);
    	if (unit != null) em.remove(unit);
    		em.getTransaction().commit();
    	} 
    	finally {
    		em.close();
    	}
	}
    
    public static void save(DbItem item) {
    	EntityManager em = JpaUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }

        em.getTransaction().commit();
    }
    
}

