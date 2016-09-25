package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ub.edu.bda.accesosHibernate;

import Objetos.Aeropuerto;
import Objetos.Avion;
import Objetos.Piloto;
import Objetos.Ruta;
import Utils.MyUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class addRuta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	private JTextField txtHora;
	
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	Ruta r;
	private List <Aeropuerto> aeropuertos;
	private List <Piloto> pilotos;
	private List <Avion> aviones;
	JComboBox cbxAeropuertoDestino;
	JComboBox cbxAeropuertoOrigen;
	JComboBox cbxPiloto;
	JComboBox cbxAvion;
	
	MyUtils u = new MyUtils();

	/**
	 * Create the dialog.
	 */
	public addRuta(JFrame parent, boolean modal, boolean editar, Ruta r) {
		super(parent, modal);
		
		this.editar = editar;
		this.r = r;
		
		setBounds(100, 100, 621, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblAadirRuta;
		
		if(editar == false){	
			lblAadirRuta = new JLabel("A\u00F1adir ruta:");
		}else{
			lblAadirRuta = new JLabel("Editar ruta:");
		}
		
		JLabel lblHora = new JLabel("Hora:");
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto destino:");
		
		JLabel lblAeropuertoOrigen = new JLabel("Aeropuerto origen:");
		
		cbxAeropuertoDestino = new JComboBox();
		
		cbxAeropuertoOrigen = new JComboBox();
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Piloto:");
		
		cbxPiloto = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("Avion:");
		
		cbxAvion = new JComboBox();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAadirRuta, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAeropuertoOrigen)
								.addComponent(lblAeropuertoDestino)
								.addComponent(lblFecha)
								.addComponent(lblHora)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxAvion, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(cbxPiloto, 0, 221, Short.MAX_VALUE)
									.addComponent(cbxAeropuertoOrigen, 0, 221, Short.MAX_VALUE)
									.addComponent(cbxAeropuertoDestino, 0, 221, Short.MAX_VALUE)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtHora, Alignment.LEADING)
										.addComponent(txtFecha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))))
					.addContainerGap(200, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAadirRuta)
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxAeropuertoDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAeropuertoOrigen))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAeropuertoDestino)
						.addComponent(cbxAeropuertoOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHora)
						.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cbxPiloto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(cbxAvion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addRuta = new JButton("Guardar ruta");
				addRuta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (comprobarCamposRellenados() == true){
							if(comprobarTipoCampos() == true){
								
						        Date fecha = u.stringToDate(txtFecha.getText());

								String hora = txtHora.getText();

								Aeropuerto aeropuerto_origen = aeropuertos.get(cbxAeropuertoOrigen.getSelectedIndex());
								Aeropuerto aeropuerto_destino = aeropuertos.get(cbxAeropuertoDestino.getSelectedIndex());
								Piloto piloto = pilotos.get(cbxPiloto.getSelectedIndex());
								Avion avion = aviones.get(cbxAvion.getSelectedIndex());
								
								if(editar == false){
		
									Ruta r = new Ruta(aeropuerto_origen, aeropuerto_destino, (java.sql.Date) fecha, hora, piloto, avion);
									acc.insertRuta(r);
								}
								else{									
									r.setId(r.getId());
									r.setAeropuerto_origen(aeropuertos.get(cbxAeropuertoOrigen.getSelectedIndex()));
									r.setAeropuerto_destino(aeropuertos.get(cbxAeropuertoDestino.getSelectedIndex()));
									r.setDiasemana((java.sql.Date) u.stringToDate(txtFecha.getText()));
									r.setHora_asignada(txtHora.getText());
									r.setPiloto(pilotos.get(cbxPiloto.getSelectedIndex()));
									r.setAvion(aviones.get(cbxAvion.getSelectedIndex()));
									acc.updatePiloto(r);
								}								
								dispose();
							}else{
								JOptionPane.showMessageDialog(null, "TIPO CAMPO INCORRECTO");
							}
						}else{
							JOptionPane.showMessageDialog(null, "FALTAN CAMPOS POR RELLENAR");
						}
					}
				});
				addRuta.setActionCommand("OK");
				buttonPane.add(addRuta);
				getRootPane().setDefaultButton(addRuta);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarComboBox();

		if(editar==true){
			
			cbxAeropuertoOrigen.setSelectedItem(r.getAeropuerto_origen().getcodigoInternacional());
			cbxAeropuertoDestino.setSelectedItem(r.getAeropuerto_destino().getcodigoInternacional());

			txtFecha.setText(r.getDiasemana().toString());
			txtHora.setText(r.getHora_asignada());
			
			cbxPiloto.setSelectedItem(r.getPiloto().getNombre());
			
			cbxAvion.setSelectedItem(r.getAvion().getMatricula());
		}
	}
	
	private void cargarComboBox(){
		accesosHibernate h = new accesosHibernate();
		aeropuertos = h.select("SELECT * FROM aeropuerto").addEntity(Aeropuerto.class).list();
		
		for(Aeropuerto a:aeropuertos){
			cbxAeropuertoDestino.addItem(a.getcodigoInternacional());
			cbxAeropuertoOrigen.addItem(a.getcodigoInternacional());
		}
	
		pilotos = h.select("SELECT * FROM piloto").addEntity(Piloto.class).list();
		
		for(Piloto p:pilotos){
			cbxPiloto.addItem(p.getNombre());
		}
		
		aviones = h.select("SELECT * FROM avion").addEntity(Avion.class).list();
		
		for(Avion a:aviones){
			cbxAvion.addItem(a.getMatricula());
		}
	}
	
	public boolean comprobarCamposRellenados(){
		if(txtFecha.getText().length()<=0){
			return false;
		}
		else if(txtHora.getText().length()<=0){
			return false;
		}
		return true;
	}
	
	public boolean comprobarTipoCampos(){
		if(u.stringIsDate(txtFecha.getText()) == false){	
			return false;
		}
		return true;
	}
}
