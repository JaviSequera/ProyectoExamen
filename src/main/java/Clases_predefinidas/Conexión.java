package Clases_predefinidas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conexión {
    private static SessionFactory Sesion;

    public static void IniciarConexión() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            Sesion = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Session ObtenerSesion(){
        return Sesion.openSession();
    }

    public static void CerrarConexión(){
        Sesion.close();
    }
}
