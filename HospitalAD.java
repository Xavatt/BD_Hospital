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
    private DocDP docPacDp = new DocDP();
    //private PacDP pacAnaDP;

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
      public String consultarAtiende()
      {
        String datos="";
        ResultSet xs;
        String query = "SELECT * FROM Atiende";

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          xs = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          atiendedp = new AtiendeDP();
          while(xs.next())
            {
              atiendedp.setClaveDoc(xs.getString("claveDoc"));
              atiendedp.setClavePac(xs.getString("clavePac"));
              atiendedp.setFecha(xs.getString("fecha"));
              atiendedp.setDiagnostico(xs.getString("diagnostico"));
              atiendedp.setTratamiento(xs.getString("tratamiento"));
              datos = datos + atiendedp.toString() + "\n";
            }
          // 3. Cerrar el archivo
          statement.close();
          xs.close();
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
        ResultSet xs;
        String query = "SELECT * FROM AnalisisC";

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          xs = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          analisisdp = new AnalisisDP();
          while(xs.next())
            {
              analisisdp.setTipo(xs.getString(1));
              analisisdp.setDescripcion(xs.getString(2));
              analisisdp.setFechaAplicacion(xs.getString(3));
              analisisdp.setFechaEntrega(xs.getString(4));
              analisisdp.setNoPaciente(xs.getString(5));
              datos = datos + analisisdp.toString() + "\n";
            }
          // 3. Cerrar el archivo
          statement.close();
          xs.close();
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
      ResultSet xs;
      String query = "SELECT * FROM paciente";

      try
      {
        // 1. Abrir el archivo de datos o BD

        statement = conexion.createStatement();

        // Ejecutar Query

        xs = statement.executeQuery(query);

        // 2. Procesar los datos en el archivo

        pacientedp = new PacienteDP();

        while(xs.next())
          {
            pacientedp.setClave(xs.getString("clave"));
            pacientedp.setNombre(xs.getString("nombre"));
            pacientedp.setDireccion(xs.getString("direccion"));
            pacientedp.setTelefono(xs.getString("telefono"));
            datos = datos + pacientedp.toString() + "\n";
          }
        // 3. Cerrar el archivo
        statement.close();
        xs.close();
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
        ResultSet xs;
        String query = "SELECT * FROM doctor";

        try
        {
            // 1. Abrir el archivo de datos o BD
            statement = conexion.createStatement();

            // Ejecutar Query
            xs = statement.executeQuery(query);

            // 2. Procesar los datos en el archivo

            doctordp = new DoctorDP();
            while(xs.next())
            {
                doctordp.setClave(xs.getString("clave"));
                doctordp.setNombre(xs.getString("nombre"));
                doctordp.setEspecialidad(xs.getString("especialidad"));
                doctordp.setDireccion(xs.getString("direccion"));
                doctordp.setTelefono(xs.getString("telefono"));
                datos = datos + doctordp.toString() + "\n";
            }
            // 3. Cerrar el archivo
            statement.close();
            xs.close();
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
  		ResultSet xs = null;
  		query="SELECT * FROM Doctor WHERE CLAVE = '"+clave+"'";

  		try
  		{
                    statement = conexion.createStatement();

                    xs = statement.executeQuery(query);

                    doctordp = new DoctorDP();
  		while(xs.next())
  		{
                   doctordp.setClave(xs.getString("clave"));
                   doctordp.setNombre(xs.getString("nombre"));
                   doctordp.setEspecialidad(xs.getString("especialidad"));
                   doctordp.setDireccion(xs.getString("direccion"));
                   doctordp.setTelefono(xs.getString("telefono"));
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
  		ResultSet xs = null;
  		query="SELECT * FROM Doctor WHERE ESPECIALIDAD = '"+especialidad+"'";

  		try
  		{
                    statement = conexion.createStatement();

                    xs = statement.executeQuery(query);

                    doctordp = new DoctorDP();
  		while(xs.next())
  		{
                   doctordp.setClave(xs.getString("clave"));
                   doctordp.setNombre(xs.getString("nombre"));
                   doctordp.setEspecialidad(xs.getString("especialidad"));
                   doctordp.setDireccion(xs.getString("direccion"));
                   doctordp.setTelefono(xs.getString("telefono"));
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

     public String consultarReportDoc()
      {
        String datos="";
        ResultSet xs;
        String query = "SELECT Doctor.clave, Doctor.nombre, Doctor.especialidad, Paciente.clave, Paciente.nombre FROM Doctor JOIN Atiende ON Doctor.clave=Atiende.claveDoc JOIN Paciente ON Paciente.clave=atiende.clavePac";
        //docPacDp = new DocDP(datos);

        try
        {
          // 1. Abrir el archivo de datos o BD
          statement = conexion.createStatement();
          // Ejecutar Query
          xs = statement.executeQuery(query);
          // 2. Procesar los datos en el archivo
          while(xs.next())
            {
              docPacDp.setClaveDoc(xs.getString(1));
              docPacDp.setNombreDoc(xs.getString(2));
              docPacDp.setEspecialidadDoc(xs.getString(3));
              docPacDp.setClavePac(xs.getString(4));
              docPacDp.setNombrePac(xs.getString(5));
              datos = datos + docPacDp.toString() + "\n";
            }
          // 3. Cerrar el archivo
          statement.close();
          xs.close();
          System.out.println(query);
          }
          catch(SQLException sqle)
          {
            datos = "Error: "+sqle;
          }
            return datos;
        }
}
