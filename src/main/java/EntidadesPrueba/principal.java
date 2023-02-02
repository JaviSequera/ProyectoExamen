package EntidadesPrueba;

import Clases_predefinidas.Conexión;
import Clases_predefinidas.MetodosHibernate;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class principal {
    public static void main(String[] args) throws Exception {
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
        Conexión.IniciarConexión();
        Double cantidad = MetodosHibernate.resultadoCálculo("listaAlumnosMediaAntiguedad");
        System.out.println(cantidad);
        Conexión.CerrarConexión();
    }
}
