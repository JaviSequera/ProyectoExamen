package Clases_predefinidas;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class MetodosHibernate {
    //Método que inserta en la base de dato un objeto de la entidad que se reciba.
    public static void insertarObjeto(Object objeto){
        Session session = Conexión.ObtenerSesion();
        Transaction transaction =  session.beginTransaction();
        try{
            session.save(objeto);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
    }

    //Método que obtiene una lista de objetos de la BBDD.
    public static List listar(){
        Session session = Conexión.ObtenerSesion();
        List lista = null;
        Transaction transaction =  session.beginTransaction();
        try{
            lista = session.createQuery("select a from Alumnos a").getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
        return lista;
    }

    //Método que obtiene un objeto de una tabla de la BBDD
    public static Object ObtenerObjeto(int id){
        Session session = Conexión.ObtenerSesion();
        Object objeto = null;
        Transaction transaction =  session.beginTransaction();
        try{
            objeto = session.load("clase", id);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
        return objeto;
    }

    //Método que elimina de la BBDD la fila correspondiente al objeto recibido.
    public static void Eliminar(Object objeto){
        Session session = Conexión.ObtenerSesion();
        Transaction transaction =  session.beginTransaction();
        try{
            session.delete(objeto);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
    }

    //Método que actualiza de la base de datos la fila correspondiente al objeto recibido
    public static void Actualizar(Object objeto){
        Session session = Conexión.ObtenerSesion();
        Transaction transaction =  session.beginTransaction();
        try{
            session.update(objeto);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
    }

    public static List listarNamedQuery(String namedQuery) {
        Session session = Conexión.ObtenerSesion();
        TypedQuery lista = null;
        try{
            lista = session.getNamedQuery(namedQuery);
        }catch (Exception e){
            System.out.println(e);
        }
        return lista.getResultList();
    }

    public static List listarNamedQueryParámetros(String namedQuery, String param, String valor) {
        Session session = Conexión.ObtenerSesion();
        TypedQuery lista = null;
        try{
            lista = session.getNamedQuery(namedQuery).setParameter(param, valor);
        }catch (Exception e){
            System.out.println(e);
        }
        return lista.getResultList();
    }

    public static double resultadoCálculo(String namedQuery) {
        Session session = Conexión.ObtenerSesion();
        Query resultado = null;
        try{
           resultado = session.getNamedQuery(namedQuery);
        }catch (Exception e){
            System.out.println(e);
        }
        return(double) resultado.uniqueResult();
    }
}
