package main.models.dao;

import java.util.List;

import org.hibernate.Session;

import main.models.entities.EnderecoUbs;
import main.models.entities.Ubs;
import main.models.services.UserServices;


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
	
	public static List<EnderecoUbs> ubsPorEstado(int uf){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String jpql = "SELECT p FROM EnderecoUbs p WHERE p.uf = :uf";
		List<EnderecoUbs> resultado = session.createQuery(jpql, EnderecoUbs.class).setParameter("uf", uf).getResultList();
		session.close();
		return resultado;
	}
	
	public static List<EnderecoUbs> ubsPorCidade(int ibge){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String jpql = "SELECT p FROM EnderecoUbs p WHERE p.ibge = :ibge";
		List<EnderecoUbs> resultado = session.createQuery(jpql, EnderecoUbs.class).setParameter("ibge", ibge).getResultList();
		session.close();
		return resultado;
	}
	
	public static List<EnderecoUbs> ubsPorBairro(String bairro){
		Session session = HibernateUtil.getSessionFactory().openSession();
		int ibge = UserServices.codigoIbgeDaCidade();
		String jpql = "SELECT p FROM EnderecoUbs p WHERE p.bairro = :bairro AND p.ibge = :ibge";
		List<EnderecoUbs> resultado = session.createQuery(jpql, EnderecoUbs.class).setParameter("bairro", bairro).setParameter("ibge", ibge).getResultList();
		session.close();
		return resultado;
	}
	
	public static List<String> bairrosQueTemUbs(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		int ibge = UserServices.codigoIbgeDaCidade();
		String jpql = "SELECT DISTINCT u.bairro FROM EnderecoUbs u WHERE u.ibge = :ibge";
		List<String> resultado = session.createQuery(jpql, String.class).setParameter("ibge", ibge).getResultList();
		session.close();
		return resultado;
	}
}
