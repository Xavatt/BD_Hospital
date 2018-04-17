import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalGUI extends JFrame implements ActionListener
{
	private JMenuBar 	mbProyecto;
	private JMenu		menuAdministracion, menuDoctor, menuPaciente, menuAnalisis,menuConsultasReportes;
	private JMenuItem	miDoctor, miAtiende, miPaciente, miAnalisis, miPaciente_Analisis,miPac_Atien_Doc,miSalir;
	private JPanel		panel;
	
	private DoctorGUI	doctor		= new DoctorGUI();
	private PacienteGUI	paciente	= new PacienteGUI();
	private AtiendeGUI	atiende		= new AtiendeGUI();
	private AnalisisGUI	analisis	= new AnalisisGUI();
	private ReportesConsultasGUI reportes = new ReportesConsultasGUI();
        
        private HospitalAD hospitalAD = new HospitalAD();
      
        
    public HospitalGUI()
    {
    	super("Sistema de BD Hospital");
    	
    	mbProyecto 		= new JMenuBar();
    	
    	menuAdministracion	= new JMenu("Administracion del Hospital");
    	menuDoctor			= new JMenu("Doctores");
    	menuPaciente		= new JMenu("Pacientes");
    	menuAnalisis		= new JMenu("Analisis");
        menuConsultasReportes   = new JMenu("Consultas y Reportes");
    	
    	miDoctor			= new JMenuItem("Altas y consultas de Doctores");
    	miAtiende			= new JMenuItem("Asignacion de Doctor a Paciente");
    	miPaciente			= new JMenuItem("Altas y consultas de Pacientes");
    	miAnalisis			= new JMenuItem("Catalogo de Analisis");
        miPac_Atien_Doc                 = new JMenuItem("Doctores que atienden a pacientes");
        miPaciente_Analisis             = new JMenuItem("AnÃ¡lisis realizados a pacientes");
    	
    	miSalir				= new JMenuItem("EXIT");
    	
    	panel				= new JPanel();
    	
    	miDoctor.addActionListener(this);
    	miAtiende.addActionListener(this);
    	miPaciente.addActionListener(this);
    	miAnalisis.addActionListener(this);
        miPac_Atien_Doc.addActionListener(this);
        miPaciente_Analisis.addActionListener(this);
    	
    	miSalir.addActionListener(this);
    	
    	menuDoctor.add(miDoctor);
    	menuDoctor.add(miAtiende);
    	menuPaciente.add(miPaciente);
    	menuAnalisis.add(miAnalisis);
    	
    	menuAdministracion.add(menuDoctor);
    	menuAdministracion.add(menuPaciente);
    	menuAdministracion.add(menuAnalisis);
        
        menuConsultasReportes.add(miPac_Atien_Doc);
        menuConsultasReportes.add(miPaciente_Analisis);
    	
    	mbProyecto.add(menuAdministracion);
        mbProyecto.add(menuConsultasReportes);
    	mbProyecto.add(miSalir);
    	
    	setJMenuBar(mbProyecto);
		setSize(500,510);
		setVisible(true);
    }
    
    private void ocultarPanel()
	{
		panel.setVisible(false);
	}
	
    public void actionPerformed(ActionEvent evento)
    {
        String datos,impri;
    	if(evento.getSource() == miDoctor)
		{
			ocultarPanel();
			panel = doctor.getPanel();
			panel.setVisible(true);
			add(panel);
			
			setVisible(true);
		}
		
		if(evento.getSource() == miAtiende)
		{
			ocultarPanel();
			panel= atiende.getPanel();
			panel.setVisible(true);
			add(panel);
			
			setVisible(true);
		}
		
		if(evento.getSource() == miPaciente)
		{
			ocultarPanel();
			panel= paciente.getPanel();
			panel.setVisible(true);
			add(panel);
			
			setVisible(true);
		}
		
		if(evento.getSource() == miAnalisis)
		{
			ocultarPanel();
			panel= analisis.getPanel();
			panel.setVisible(true);
			add(panel);
			
			setVisible(true);
		}
		if(evento.getSource() == miSalir)
		{
			System.exit(0);
		}
                
                if(evento.getSource() == miPac_Atien_Doc)
		{                   
                    
			ocultarPanel();
                        //reportes.setConsultaTaDatos(hospitalAD.consultarReportDoc());
			panel= reportes.getPanel();
                       // datos = hospitalAD.consultarReportDoc();
                        
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
                
                 if(evento.getSource() == miPaciente_Analisis)
		{
			ocultarPanel();
			panel= reportes.getPanel();
			panel.setVisible(true);
			add(panel);
			
			setVisible(true);
		}
    }
    
   public static void main(String args[])
    {
    	HospitalGUI objeto = new HospitalGUI();
    }
}