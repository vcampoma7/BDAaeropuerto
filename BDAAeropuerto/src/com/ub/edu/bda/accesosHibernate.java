package com.ub.edu.bda;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;

import Objetos.aeropuerto;
import Objetos.piloto;

public class accesosHibernate {

	public void insertAeropuerto(aeropuerto a){
	
		 Session session = null;
	     Transaction tx = null;
		
	     try {
	            session = ConnectorHB.getSession();
	            tx = session.beginTransaction();
	            session.save(a);
	            //El objecto art esta enlazado
	            
	            tx.commit();
	            
	            System.out.println("Insert realizado correctamente...");
	            
	        } catch (HibernateException e) {
	            if(tx!=null && tx.isActive()) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            if(session!=null) session.close();
	        }
	}
	
	public void updateAeropuerto(aeropuerto a){
		
		 Session session = null;
	     Transaction tx = null;
		
	     try {
	            session = ConnectorHB.getSession();
	            tx = session.beginTransaction();
	            session.update(a);
	            //El objecto art esta enlazado
	            
	            tx.commit();
	            
	            System.out.println("Update realizado correctamente...");
	            
	        } catch (HibernateException e) {
	            if(tx!=null && tx.isActive()) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            if(session!=null) session.close();
	        }
	}
	
	public void insertPiloto(piloto p){
		
		 Session session = null;
	     Transaction tx = null;
		
	     try {
	            session = ConnectorHB.getSession();
	            tx = session.beginTransaction();
	            session.save(p);
	            //El objecto art esta enlazado
	            
	            tx.commit();
	            
	            System.out.println("Insert realizado correctamente...");
	            
	        } catch (HibernateException e) {
	            if(tx!=null && tx.isActive()) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            if(session!=null) session.close();
	        }
	}
	
	public void updatePiloto(piloto p){
		
		 Session session = null;
	     Transaction tx = null;
		
	     try {
	            session = ConnectorHB.getSession();
	            tx = session.beginTransaction();
	            session.update(p);
	            //El objecto art esta enlazado
	            
	            tx.commit();
	            
	            System.out.println("Update realizado correctamente...");
	            
	        } catch (HibernateException e) {
	            if(tx!=null && tx.isActive()) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            if(session!=null) session.close();
	        }
	}
	
	public SQLQuery select(String select){
		 Session session = null;
		 
	     try {
	            session = ConnectorHB.getSession();

	            //US DE QUERY SQL PER TROBAR OBJECTES

	            return session.createSQLQuery(select);/*.addEntity(aeropuerto.class).list();*/
	            /*for(aeropuerto a: aeropuertos)
	                System.out.println(a.getNombre());*/
	            
	            //return result;
	            
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            return null;
	        }

	}
}
