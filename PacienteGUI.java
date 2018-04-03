
package bd_hospital;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PacienteGUI extends JFrame
{
    private JLabel labelClave, labelNombre, labelDireccion, labelTelefono;
    private JTextField tfClave, tfNombre,tfDireccion, tfTelefono;
    private JButton bCapturar, bConsulta, bSalir;
    private JTextArea taDatos;
    private JPanel panel1, panel2;
    
    public PacienteGUI()
    {
        super("Cliente");
        labelClave = new JLabel("Clave: ");
        labelNombre = new JLabel("Nombre: ");
        labelDireccion = new JLabel("Dirección");
        labelTelefono = new JLabel("Teléfono: ");
        
        tfClave = new JTextField();
        tfNombre = new JTextField();
        tfDireccion = new JTextField();
        tfTelefono = new JTextField();
        
        bCapturar = new JButton("Capturar");
        bConsulta = new JButton("Consulta");
        bSalir = new JButton("Salir");
        taDatos = new JTextArea(30,45);
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        panel1.setLayout(new GridLayout(6,2));
        panel2.setLayout(new FlowLayout());
        
        panel1.add(labelClave);
        panel1.add(tfClave);
        panel1.add(labelNombre);
        panel1.add(tfNombre);
        panel1.add(labelDireccion);
        panel1.add(tfDireccion);
        panel1.add(labelTelefono);
        panel1.add(tfTelefono);
        panel1.add(bCapturar);
        panel1.add(bConsulta);
        panel1.add(bSalir);
        panel2.add(panel1);
        panel2.add(taDatos);
        
        add(panel2);
        
        setVisible(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    public static void main(String[] args)
    {
        new PacienteGUI();
    }
    
    
}