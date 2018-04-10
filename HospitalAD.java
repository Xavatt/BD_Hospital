package hospital;

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
    private DocDP docPacDp;
    private PacDP pacAnaDP;

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

/**
 *  CAPTURAS
 */
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

      public String capturarAnalisis(String datos)
      {
        //System.out.println("\nAD: "+datos);
        analisisdp= new AnalisisDP(datos);
        String query = "INSERT INTO ANALISISC VALUES("+analisisdp.toStringSql()+")";

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
      public String capturarAtiende(String datos)
      {
        //System.out.println("\nAD: "+datos);
        atiendedp = new AtiendeDP(datos);
        String query = "INSERT INTO ATIENDE VALUES("+atiendedp.toStringSql()+")";

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

      /**
       * CONSULTAS
       */
      public String consultarAtiende()
      {
        String datos="";
        ResultSet tr;
        String query = "SELECT * FROM Atiende";

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          tr = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          atiendedp = new AtiendeDP();
          while(tr.next())
            {
              atiendedp.setClaveDoc(tr.getString(1));
              atiendedp.setClavePac(tr.getString(2));
              atiendedp.setFecha(tr.getString(3));
              atiendedp.setDiagnostico(tr.getString(4));
              atiendedp.setTratamiento(tr.getString(5));
              datos = datos + atiendedp.toString() + "\n";
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

      public String consultarAnalisis()
      {
        String datos="";
        ResultSet tr;
        String query = "SELECT * FROM AnalisisC";

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          tr = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          analisisdp = new AnalisisDP();
          while(tr.next())
            {
              analisisdp.setTipo(tr.getString(1));
              analisisdp.setDescripcion(tr.getString(2));
              analisisdp.setFechaAplicacion(tr.getString(3));
              analisisdp.setFechaEntrega(tr.getString(4));
              analisisdp.setNoPaciente(tr.getString(5));
              datos = datos + analisisdp.toString() + "\n";
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


    public String consultarPacientes()
    {
      String datos="";
      ResultSet tr;
      String query = "SELECT * FROM paciente";

      try
      {
        statement = conexion.createStatement();
        tr = statement.executeQuery(query);
        // 2. Procesar los datos en el archivo
        pacientedp = new PacienteDP();
        while(tr.next())
          {
            pacientedp.setClave(tr.getString(1));
            pacientedp.setNombre(tr.getString(2));
            pacientedp.setDireccion(tr.getString(3));
            pacientedp.setTelefono(tr.getString(4));
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
                doctordp.setClave(tr.getString(1));
                doctordp.setNombre(tr.getString(2));
                doctordp.setEspecialidad(tr.getString(3));
                doctordp.setDireccion(tr.getString(4));
                doctordp.setTelefono(tr.getString(5));
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
        doctordp.setClave(tr.getString(1));
        doctordp.setNombre(tr.getString(2));
        doctordp.setEspecialidad(tr.getString(3));
        doctordp.setDireccion(tr.getString(4));
        doctordp.setTelefono(tr.getString(5));
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
        doctordp.setClave(tr.getString(1));
        doctordp.setNombre(tr.getString(2));
        doctordp.setEspecialidad(tr.getString(3));
        doctordp.setDireccion(tr.getString(4));
        doctordp.setTelefono(tr.getString(5));
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

/**
 * CONSULTA ANALISIS
 */
     public String consultarReportDoc()
      {
        String datos="";
        ResultSet tr;
        String query = "SELECT Doctor.clave, Doctor.nombre, Doctor.especialidad, Paciente.clave, Paciente.nombre FROM Doctor JOIN Atiende ON Doctor.clave=Atiende.claveDoc JOIN Paciente ON Paciente.clave=atiende.clavePac";
        docPacDp = new DocDP(datos);

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          tr = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          while(tr.next())
            {
              docPacDp.setClaveDoc(tr.getString(1));
              docPacDp.setNombreDoc(tr.getString(2));
              docPacDp.setEspecialidadDoc(tr.getString(3));
              docPacDp.setClavePac(tr.getString(4));
              docPacDp.setNombrePac(tr.getString(5));
              datos = datos + docPacDp.toString() + "\n";
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
}
