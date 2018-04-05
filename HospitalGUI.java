/**
 * @(#)HospitalGUI.java
 *
 *
 * @author 
 * @version 1.00 2018/4/3
 */
 
package bd_hospital;

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
	private JMenu		menuAdministracion, menuDoctor, menuPaciente, menuAnalisis;
	private JMenuItem	miDoctor, miAtiende, miPaciente, miAnalisis, miSalir;
	private JPanel		panel;
	
	private DoctorGUI	doctor		= new DoctorGUI();
	private PacienteGUI	paciente	= new PacienteGUI();
	private AtiendeGUI	atiende		= new AtiendeGUI();
	private AnalisisGUI	analisis	= new AnalisisGUI();
	
    public HospitalGUI()
    {
    	super("Sistema de BD Hospital");
    	
    	mbProyecto 		= new JMenuBar();
    	
    	menuAdministracion	= new JMenu("Administracion del Hospital");
    	menuDoctor			= new JMenu("Doctores");
    	menuPaciente		= new JMenu("Pacientes");
    	menuAnalisis		= new JMenu("Analisis");
    	
    	miDoctor			= new JMenuItem("Altas y consultas de Doctores");
    	miAtiende			= new JMenuItem("Asignacion de Doctor a Paciente");
    	miPaciente			= new JMenuItem("Altas y consultas de Pacientes");
    	miAnalisis			= new JMenuItem("Catalogo de Analisis");
    	
    	miSalir				= new JMenuItem("EXIT");
    	
    	panel				= new JPanel();
    	
    	miDoctor.addActionListener(this);
    	miAtiende.addActionListener(this);
    	miPaciente.addActionListener(this);
    	miAnalisis.addActionListener(this);
    	
    	miSalir.addActionListener(this);
    	
    	menuDoctor.add(miDoctor);
    	menuDoctor.add(miAtiende);
    	menuPaciente.add(miPaciente);
    	menuAnalisis.add(miAnalisis);
    	
    	menuAdministracion.add(menuDoctor);
    	menuAdministracion.add(menuPaciente);
    	menuAdministracion.add(menuAnalisis);
    	
    	mbProyecto.add(menuAdministracion);
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
    }
    
    public static void main(String args[])
    {
    	HospitalGUI objeto = new HospitalGUI();
    }
}