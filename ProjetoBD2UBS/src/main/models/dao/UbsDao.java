package main.models.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.models.dao.HibernateUtil;
import main.models.entities.Ubs;


public class UbsDao {

	public static Ubs getUbs ( int id ) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String jpql = "SELECT p FROM Ubs p WHERE p.id = :id";
			Ubs resultado = session.createQuery(jpql,Ubs.class).setParameter("id", id).getSingleResult();
			session.close();
			return resultado;
		}catch(Exception e) {
			System.out.println("Resultado n Encontrado");
		}
		
		return null;
	}
	
	public static Ubs buscarPorCnes(int cnes) {
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
        	String jpql = "SELECT p FROM Ubs p WHERE p.cnes = :cnes";
        	Ubs resultado = session.createQuery(jpql, Ubs.class).setParameter("cnes", cnes).getSingleResult();
        	session.close();
        	return resultado;
        }catch(Exception e) {
			System.out.println("Resultado n Encontrado");
		}
		return null;
    }
	
	public static List<Ubs> listaDeUbs(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String jpql = "SELECT p FROM Ubs p";
		List<Ubs> resultado = session.createQuery(jpql, Ubs.class).getResultList();
		session.close();
		return resultado;
	}
	
	public static List<Ubs> ubsPorEstado(int uf){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String jpql = "SELECT p FROM Ubs p WHERE p.uf = :uf";
		List<Ubs> resultado = session.createQuery(jpql, Ubs.class).setParameter("uf", uf).getResultList();
		session.close();
		return resultado;
	}
	
	public static List<Ubs> ubsPorCidade(int ibge){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String jpql = "SELECT p FROM Ubs p WHERE p.ibge = :ibge";
		List<Ubs> resultado = session.createQuery(jpql, Ubs.class).setParameter("ibge", ibge).getResultList();
		session.close();
		return resultado;
	}
	
}
