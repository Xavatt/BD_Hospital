package hospital;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;


public class PacienteGUI extends JFrame implements ActionListener
{
  /**
  * Definir atributos que se van a ocupar
  */
  private JTextField tfClave, tfNombre, tfDireccion, tfTelefono;
  private JButton bCapturar, bConsultar,bSalir;
  private JPanel panel1, panel2;
  private JTextArea taDatos;

  private HospitalAD hospitalad = new HospitalAD();

  public PacienteGUI()
  {
    super("Paciente");

    /**
     * 1.- Crear los objetos de los atributos
     */

     tfClave = new JTextField();
     tfNombre = new JTextField();
     tfDireccion = new JTextField();
     tfTelefono = new JTextField();
    /* Botones */
    bCapturar = new JButton("Capturar");
    bConsultar = new JButton("Consulta General");
    bSalir  = new JButton("Exit");

    /* Panels & Datos */
    panel1 = new JPanel();
    panel2 = new JPanel();

    taDatos = new JTextArea(25,35);

    /* ActionListeners */
    bCapturar.addActionListener(this);
    bConsultar.addActionListener(this);
    bSalir.addActionListener(this);

    /**
     * 2.- Definir los Layouts de los JPanels
     */
     panel1.setLayout(new GridLayout(8,2));
     panel2.setLayout(new FlowLayout());

    /**
     * 3.- Colocar los objetos de los atributos en los JPanels correspondientes
     */
     panel1.add(new JLabel("CLAVE :"));
     panel1.add(tfClave);
     panel1.add(new JLabel("NOMBRE :"));
     panel1.add(tfNombre);
     panel1.add(new JLabel("DIRECCION :"));
     panel1.add(tfDireccion);
     panel1.add(new JLabel("TELEFONO :"));
     panel1.add(tfTelefono);

     panel1.add(bCapturar);
     panel1.add(bConsultar);
     panel1.add(bSalir);

     panel2.add(panel1);
     panel2.add(new JScrollPane(taDatos));

     /**
      * 4.- Adicionar el panel1 al panel1
      */
      add(panel2);
      setSize(500,500);
      setVisible(false);

  }
  
  public JPanel getPanel()
	{
		return this.panel2;
	}

  private String obtenerDatos()
  {
    String datos= "";
    String clave = tfClave.getText();
    String nombre = tfNombre.getText();
    String direccion = tfDireccion.getText();
    String telefono = tfTelefono.getText();

    if(clave.equals("") || nombre.equals("") || direccion.equals("") || telefono.equals(""))
      datos = "VACIO";
      else
      {
          datos = clave+"_"+nombre+"_"+direccion+"_"+telefono;
      }
      return datos;
  }

  public void actionPerformed(ActionEvent e)
  {
    String datos,respuesta;
    if (e.getSource() == bCapturar)
    {
      datos = obtenerDatos();
      if(datos.equals("VACIO"))
        respuesta = "Algun campo esta vacio...";
      else
      {
          respuesta = hospitalad.capturarPaciente(datos);
      }
      taDatos.setText(respuesta);
    }

    if (e.getSource() == bConsultar)
    {
      datos = hospitalad.consultarPacientes();
      taDatos.setText(datos);
    }

    if (e.getSource() == bSalir)
    {
      panel2.setVisible(false);
    }
  }
  
   /*public static void main(String[] args)
    {
        new PacienteGUI();
    }*/


}
