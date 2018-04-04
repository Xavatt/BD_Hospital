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

    private DoctorDP   doctordp = new DoctorDP();
    private PacienteDP pacientedp = new PacienteDP();
    private AnalisisDP analisisdp = new AnalisisDP();
    private AtiendeDP  atiendedp = new AtiendeDP();

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

      public String capturarDoctor(String datos)
      {
        //System.out.println("\nAD: "+datos);
        doctordp = new DoctorDP(datos);
        String query = "INSERT INTO DOCTOR VALUES("+doctordp.toStringSql()+")";

        try {
            statement = conexion.createStatement();
            statement.executeUpdate(query);
            statement.close();
            datos = "Datos capturados: "+query;
            System.out.println(query);
        }
        catch (SQLException sqle) {
            datos ="Error capturar datos " + sqle;
        }
        return datos;
      }

      public String capturarPaciente(String datos)
      {
        //System.out.println("\nAD: "+datos);
        pacientedp = new PacienteDP(datos);
        String query = "INSERT INTO PACIENTE VALUES("+pacientedp.toStringSql()+")";

        try {
            statement = conexion.createStatement();
            statement.executeUpdate(query);
            statement.close();
            datos = "Datos capturados: "+query;
            System.out.println(query);
        }
        catch (SQLException sqle) {
            datos ="Error capturar datos " + sqle;
        }
        return datos;
      }


    public String consultarPacientes()
    {
      String datos="";
      ResultSet tr;
      String query = "SELECT * FROM paciente";

      try
      {
        // 1. Abrir el archivo de datos o BD
        statement = conexion.createStatement();
        // Ejecutar Query
        tr = statement.executeQuery(query);
        // 2. Procesar los datos en el archivo
        pacientedp = new PacienteDP(datos);
        while(tr.next())
          {
            pacientedp.setClave(tr.getString("clave"));
            pacientedp.setNombre(tr.getString("nombre"));
            pacientedp.setDireccion(tr.getString("direccion"));
            pacientedp.setTelefono(tr.getString("telefono"));
            datos = datos + pacientedp.toString() + "\n";
          }
        // 3. Cerrar el archivo
        statement.close();
        tr.close();
        System.out.println(query);
        }
        catch(SQLException sqle)
        {
          datos = "Error: "+sqle;
        }
          return datos;
      }

      public String consultarDoctores()
      {
        String datos="";
        ResultSet tr;
        String query = "SELECT * FROM doctor";

        try
        {
            // 1. Abrir el archivo de datos o BD
            statement = conexion.createStatement();

            // Ejecutar Query
            tr = statement.executeQuery(query);

            // 2. Procesar los datos en el archivo

            doctordp = new DoctorDP();
            while(tr.next())
            {
                doctordp.setClave(tr.getString("clave"));
                doctordp.setNombre(tr.getString("nombre"));
                doctordp.setEspecialidad(tr.getString("especialidad"));
                doctordp.setDireccion(tr.getString("direccion"));
                doctordp.setTelefono(tr.getString("telefono"));
                datos = datos + doctordp.toString() + "\n";
            }
            // 3. Cerrar el archivo
            statement.close();
            tr.close();
            System.out.println(query);
        }
        catch(SQLException sqle)
        {
            datos = "Error: "+sqle;
        }
        return datos;
      }

    public String consultarClave(String clave)
  	{
  		String datos="";
  		String query="";
  		ResultSet tr = null;
  		query="SELECT * FROM Doctor WHERE CLAVE = '"+clave+"'";

  		try
  		{
                    statement = conexion.createStatement();

                    tr = statement.executeQuery(query);

                    doctordp = new DoctorDP();
  		while(tr.next())
  		{
                   doctordp.setClave(tr.getString("clave"));
                   doctordp.setNombre(tr.getString("nombre"));
                   doctordp.setEspecialidad(tr.getString("especialidad"));
                   doctordp.setDireccion(tr.getString("direccion"));
                   doctordp.setTelefono(tr.getString("telefono"));
                    datos = datos + doctordp.toString() + "\n";
  		}

                    statement.close();
                    System.out.println(query);
  		}
  		catch(SQLException sql)
  		{
  			System.out.println("Error: "+sql);
  			datos = "Error en lectura de base datos...";
  		}

  		return datos;
    }

    public String consultarEspecialidad(String especialidad)
  	{
  		String datos="";
  		String query="";
  		ResultSet tr = null;
  		query="SELECT * FROM Doctor WHERE ESPECIALIDAD = '"+especialidad+"'";

  		try
  		{
                    statement = conexion.createStatement();

                    tr = statement.executeQuery(query);

                    doctordp = new DoctorDP();
  		while(tr.next())
  		{
                   doctordp.setClave(tr.getString("clave"));
                   doctordp.setNombre(tr.getString("nombre"));
                   doctordp.setEspecialidad(tr.getString("especialidad"));
                   doctordp.setDireccion(tr.getString("direccion"));
                   doctordp.setTelefono(tr.getString("telefono"));
                    datos = datos + doctordp.toString() + "\n";
  		}

                    statement.close();
                    System.out.println(query);
  		}
  		catch(SQLException sql)
  		{
  			System.out.println("Error: "+sql);
  			datos = "Error en lectura de base datos...";
  		}

  		return datos;
  	}
}
