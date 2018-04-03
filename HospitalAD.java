package bd_hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class HospitalAD
{
    static Date date = new Date();
    
    private Connection      conexion;
    private Statement       statement;
    
    private DoctorDP  doctor = new DoctorDP();
    private PacienteDP  paciente = new PacienteDP();
    private AnalisisDP     analisis = new AnalisisDP();
    
/* Conexion */    
    public HospitalAD()
    {
        try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital?user=root");
            System.out.println("\n\tConexion exitosa a la BD...");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error1: "+cnfe);
        }
        catch(InstantiationException ie){
            System.out.println("Error 2: "+ie);
        }
        catch(IllegalAccessException iae){
            System.out.println("Error 3: "+iae);
        }
        catch(SQLException sqle){
            System.out.println("Error 4: "+sqle);
        }
    }
}