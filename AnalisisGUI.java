package bd_hospital;

/**
 * Liberias
 */
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

public class AnalisisGUI extends JFrame implements ActionListener
{
    /**
    * Definir atributos que se van a ocupar
    */
    private JTextField  tfClavePac, tfTipo, tfDescripcion, tfFechaAP, tfFechaEN;
    private JButton bCapturar, bConsultar, bSalir;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    public AnalisisGUI()
    {
      super("Analisis Clinico");

      /**
       * 1.- Crear los objetos de los atributos
       */

      tfClavePac = new JTextField();
      tfTipo = new JTextField();
      tfDescripcion = new JTextField();
      tfFechaAP = new JTextField();
      tfFechaEN = new JTextField();
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
       panel1.add(new JLabel("Tipo de Analisis :"));
       panel1.add(tfTipo);
       panel1.add(new JLabel("Descripcion :"));
       panel1.add(tfDescripcion);
       panel1.add(new JLabel("Fecha de Aplicacion :"));
       panel1.add(tfFechaAP);
       panel1.add(new JLabel("Fecha de Entrega :"));
       panel1.add(tfFechaEN);

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
        setVisible(true);
        /**
         * 5.- Adicionar el panel2 al JFrame y hacerlo visible
         */
         setSize(500,500);
         setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == bCapturar)
      {

      }

      if (e.getSource() == bConsultar)
      {

      }

      if (e.getSource() == bSalir)
      {
        System.exit(0);
      }
    }

//    public static void main(String[] args)
//    {
//        AnalisisGUI analisisGUI = new AnalisisGUI();
//    }
}
