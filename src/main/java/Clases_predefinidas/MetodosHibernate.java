package Clases_predefinidas;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class MetodosHibernate {
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

    public static List listar(String tabla){
        Session session = Conexión.ObtenerSesion();
        List lista = null;
        Transaction transaction =  session.beginTransaction();
        try{
            lista = session.createQuery("from "+tabla).getResultList();
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
        session.close();
        return lista;
    }

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
}
