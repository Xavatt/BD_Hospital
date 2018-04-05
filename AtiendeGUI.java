package bd_hospital;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class AtiendeGUI extends JFrame implements ActionListener
{
	private JTextField 	tfClavePac, tfClaveDoc, tfFecha, tfDiagnostico, tfTratamiento;
    private JButton 	bCapturar, bConsultar, bSalir;
    private JPanel 		panel1, panel2;
    private JTextArea 	taDatos;

    private HospitalAD hospitalad = new HospitalAD();

    public AtiendeGUI()
    {
    	super("Atiende");

    	tfClavePac 		= 	new JTextField();
    	tfClaveDoc 		= 	new JTextField();
    	tfFecha 		= 	new JTextField();
    	tfDiagnostico 	= 	new JTextField();
    	tfTratamiento 	= 	new JTextField();

    bCapturar = new JButton("Capturar");
		bConsultar = new JButton("Consulta General");
		bSalir  = new JButton("Exit");

		taDatos = new JTextArea(25,35);

		panel1 = new JPanel();
		panel2 = new JPanel();

		bCapturar.addActionListener(this);
		bConsultar.addActionListener(this);
		bSalir.addActionListener(this);

		panel1.setLayout(new GridLayout(8,2));
		panel2.setLayout(new FlowLayout());

		panel1.add(new JLabel("Clave del Doctor"));
		panel1.add(tfClaveDoc);
		panel1.add(new JLabel("Clave del Paciente"));
		panel1.add(tfClavePac);
		panel1.add(new JLabel("Fecha"));
		panel1.add(tfFecha);
		panel1.add(new JLabel("Diagnostico"));
		panel1.add(tfDiagnostico);
		panel1.add(new JLabel("Tratamiento"));
		panel1.add(tfTratamiento);

		panel1.add(bCapturar);
		panel1.add(bConsultar);
		panel1.add(bSalir);

		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));

		add(panel2);
		setSize(500,500);
		setVisible(true);
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
            respuesta = hospitalad.capturarAnalisis(datos);
        }
        taDatos.setText(respuesta);
    	}

    	if (e.getSource() == bConsultar)
    	{
        datos = hospitalad.consultarAtiende();
        taDatos.setText(datos);
    	}

    	if (e.getSource() == bSalir)
    	{
    		System.exit(0);
    	}
    }

    public static void main(String[] args)
    {
    	new AtiendeGUI();
    }
}
