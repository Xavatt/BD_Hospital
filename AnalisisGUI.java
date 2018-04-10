package hospital;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class AnalisisGUI extends JFrame implements ActionListener
{
    /**
    * Definir atributos que se van a ocupar
    */
    private JTextField  tfClaveP, tfTipo, tfDesc, tfFechaAP, tfFechaEN, tfNoPaciente;
    private JButton bCapturar, bConsultar, bExit;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private HospitalAD hospitalad = new HospitalAD();

    public AnalisisGUI()
    {
      super("Analisis Clinico");

      /**
       * 1.- Crear los objetos de los atributos
       */

      tfClaveP = new JTextField();
      tfTipo = new JTextField();
      tfDesc = new JTextField();
      tfFechaAP = new JTextField();
      tfFechaEN = new JTextField();
      tfNoPaciente = new JTextField();
      /* Botones */
      bCapturar = new JButton("Capturar");
      bConsultar = new JButton("Consulta General");
      bExit  = new JButton("Exit");

      /* Panels & Datos */
      panel1 = new JPanel();
      panel2 = new JPanel();

      taDatos = new JTextArea(25,35);

      /* ActionListeners */
      bCapturar.addActionListener(this);
      bConsultar.addActionListener(this);
      bExit.addActionListener(this);

      /**
       * 2.- Definir los Layouts de los JPanels
       */
       panel1.setLayout(new GridLayout(8,2));
       panel2.setLayout(new FlowLayout());

      /**
       * 3.- Colocar los objetos de los atributos en los JPanels correspondientes
       */
       panel1.add(new JLabel("Tipo de Analisis :"));
       panel1.add(tfTipo);
       panel1.add(new JLabel("Descripcion :"));
       panel1.add(tfDesc);
       panel1.add(new JLabel("Fecha de Aplicacion :"));
       panel1.add(tfFechaAP);
       panel1.add(new JLabel("Fecha de Entrega :"));
       panel1.add(tfFechaEN);
       panel1.add(new JLabel("No. de Paciente :"));
       panel1.add(tfNoPaciente);

       panel1.add(bCapturar);
       panel1.add(bConsultar);
       panel1.add(bExit);

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
    String tipo = tfTipo.getText();
    String descripcion = tfDesc.getText();
    String fechaAP = tfFechaAP.getText();
    String fechaEN = tfFechaEN.getText();
    String noPaciente = tfNoPaciente.getText();

    if(  tipo.equals("") || descripcion.equals("") || fechaAP.equals("") || fechaEN.equals("") || noPaciente.equals(""))
      datos = "VACIO";
      else
      {
          datos = tipo+"_"+descripcion+"_"+fechaAP+"_"+fechaEN+"_"+noPaciente;
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
          respuesta = hospitalad.capturarAnalisis(datos);
        }
        taDatos.setText(respuesta);
      }

      if (e.getSource() == bConsultar)
      {
        datos = hospitalad.consultarAnalisis();
        taDatos.setText(datos);
      }

      if (e.getSource() == bExit)
      {
        panel2.setVisible(false);
      }
    }

//   public static void main(String[] args)
//    {
//      AnalisisGUI analisisGUI = new AnalisisGUI();
//    }
}
