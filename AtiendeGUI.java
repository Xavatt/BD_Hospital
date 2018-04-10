package hospital;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class AtiendeGUI extends JFrame implements ActionListener
{
	private JTextField 	tfClaveP, tfClaveD, tfFecha, tfDiagnostico, tfTratamiento;
    private JButton 	bCapturar, bConsultar, bExit;
    private JPanel 		panel1, panel2;
    private JTextArea 	taDatos;

    private HospitalAD hospitalad = new HospitalAD();

    public AtiendeGUI()
    {
    	super("Atiende");

    	tfClaveP 		= 	new JTextField();
    	tfClaveD 		= 	new JTextField();
    	tfFecha 		= 	new JTextField();
    	tfDiagnostico 	= 	new JTextField();
    	tfTratamiento 	= 	new JTextField();

    bCapturar = new JButton("Capturar");
		bConsultar = new JButton("Consulta General");
		bExit  = new JButton("Exit");

		taDatos = new JTextArea(25,35);

		panel1 = new JPanel();
		panel2 = new JPanel();

		bCapturar.addActionListener(this);
		bConsultar.addActionListener(this);
		bExit.addActionListener(this);

		panel1.setLayout(new GridLayout(8,2));
		panel2.setLayout(new FlowLayout());

	  panel1.add(new JLabel("Fecha"));
		panel1.add(tfFecha);
    panel1.add(new JLabel("Diagnostico"));
		panel1.add(tfDiagnostico);
    panel1.add(new JLabel("Tratamiento"));
		panel1.add(tfTratamiento);
		panel1.add(new JLabel("Clave del Doctor"));
		panel1.add(tfClaveD);
		panel1.add(new JLabel("Clave del Paciente"));
		panel1.add(tfClaveP);

		panel1.add(bCapturar);
		panel1.add(bConsultar);
		panel1.add(bExit);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));

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
      String claveDoc = tfClaveD.getText();
      String clavePac = tfClaveP.getText();
      String fecha = tfFecha.getText();
      String diagnostico = tfDiagnostico.getText();
      String tratamiento = tfTratamiento.getText();

      if(fecha.equals("") || diagnostico.equals("") || tratamiento.equals("") || claveDoc.equals("") || clavePac.equals(""))
        datos = "VACIO";
        else
        {
            datos = fecha+"_"+diagnostico+"_"+tratamiento+"_"+claveDoc+"_"+clavePac;
        }
        return datos;
    }

    public void actionPerformed(ActionEvent e)
    {
      String datos, respuesta;
    	if (e.getSource() == bCapturar)
    	{
        datos = obtenerDatos();
        if(datos.equals("VACIO"))
          respuesta = "Algun campo esta vacio...";
        else
        {
            respuesta = hospitalad.capturarAtiende(datos);
        }
        taDatos.setText(respuesta);
    	}

    	if (e.getSource() == bConsultar)
    	{
        datos = hospitalad.consultarAtiende();
        taDatos.setText(datos);
    	}

    	if (e.getSource() == bExit)
    	{
    		panel2.setVisible(false);
    	}
    }

//    public static void main(String[] args)
//    {
//    	new AtiendeGUI();
//    }
}
