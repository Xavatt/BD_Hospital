package bd_hospital;

/**
 * Librerias
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class BD_Hospital extends JFrame implements ActionListener
{
    /**
    * Definir atributos que se van a ocupar
    */
    private JButton bCapturarDoctor,bCapturarPaciente,bConsultarPacientes;
    private JButton bConsultarEspecialidad,bConsultarDoctores,bSalir;
    private JButton bConsultarAnalisis, bCapturarAnalisis;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    public BD_Hospital()
    {
        super("Hospital");

        /**
         * 1.- Crear los objetos de los atributos
         */
        bCapturarDoctor = new JButton("Capturar Doctor");
        bCapturarPaciente = new JButton("Capturar Paciente");
        bCapturarAnalisis = new JButton("Capturar Analisis");
        bConsultarPacientes = new JButton("Consultar Pacientes");
        bConsultarDoctores = new JButton("Consultar Doctores");
        bConsultarEspecialidad = new JButton("Consultar Especialidades");
        bConsultarAnalisis = new JButton("Consultar Analisis");
        bSalir = new JButton("Salir");

        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(25,35);

        bCapturarDoctor.addActionListener(this);
        bCapturarPaciente.addActionListener(this);
        bCapturarAnalisis.addActionListener(this);
        bConsultarPacientes.addActionListener(this);
        bConsultarDoctores.addActionListener(this);
        bConsultarEspecialidad.addActionListener(this);
        bConsultarAnalisis.addActionListener(this);
        bSalir.addActionListener(this);

        /**
         * 2.- Definir los Layouts de los JPanels
         */
         panel1.setLayout(new GridLayout(13,2));
         panel2.setLayout(new FlowLayout());
         /**
          * 3.- Colocar los objetos de los atributos en los JPanels correspondientes
          */
    }
      public void actionPerformed(ActionEvent e)
      {
          
      }

//    public static void main(String[] args)
//    {
//
//    }

}
