 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class ReportesConsultasGUI extends JFrame implements ActionListener
{
    /**
    * Definir atributos que se van a ocupar
    */
    private JButton bConsultar,bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private HospitalAD hospitalad = new HospitalAD();

    public ReportesConsultasGUI()
    {
      super("Reportes y consutas");

      /**
       * 1.- Crear los objetos de los atributos
       */

     
      /* Botones */
      
      bConsultar = new JButton("Consulta General");
     
    
      bSalir  = new JButton("Exit");

      /* Panels & Datos */
      panel1 = new JPanel();
      panel2 = new JPanel();

      taDatos = new JTextArea(25,35);

      /* ActionListeners */
   
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

    public void actionPerformed(ActionEvent e)
    {
      String datos,respuesta;
     

      if (e.getSource() == bConsultar)
      {
        datos = hospitalad.consultarReportDoc();
        taDatos.setText(datos);
      }

      if (e.getSource() == bSalir)
      {
        panel2.setVisible(false);
      }
    }
//
//    public static void main(String[] args)
//    {
//        DoctorGUI doctorGUI = new DoctorGUI();
//    }
}
