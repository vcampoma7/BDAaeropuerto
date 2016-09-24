package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ub.edu.bda.accesosHibernate;

import Objetos.piloto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;

public class addPilotos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombrePiloto;
	private JTextField txtApellidoPiloto;
	private JTextField txtHorasDeVuelo;
	private JTextField txtId_aeropuerto;
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	piloto a;
	
	/**
	 * Create the dialog.
	 */
	public addPilotos(JFrame parent, boolean modal, boolean editar, piloto a) {
		super(parent, modal);
		
		this.editar = editar;
		this.a = a;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 505, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label;
		
		if(editar == false){	
			label = new JLabel("A\u00F1adir piloto:");
		}else{
			label = new JLabel("Editar piloto:");
		}
		JLabel label_1 = new JLabel("Nombre:");
		JLabel label_2 = new JLabel("Ciudad:");
		JLabel label_3 = new JLabel("Codigo internacional:");
		JLabel label_4 = new JLabel("Coste del handling:");
		txtNombrePiloto = new JTextField();
		txtNombrePiloto.setColumns(10);
		txtApellidoPiloto = new JTextField();
		txtApellidoPiloto.setColumns(10);
		txtHorasDeVuelo = new JTextField();
		txtHorasDeVuelo.setColumns(10);
		txtId_aeropuerto = new JTextField();
		txtId_aeropuerto.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(60)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNombrePiloto, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(64)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtApellidoPiloto, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtHorasDeVuelo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtId_aeropuerto, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(txtNombrePiloto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(txtApellidoPiloto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(txtHorasDeVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(txtId_aeropuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addPiloto = new JButton("Guardar piloto");
				addPiloto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String nombre = txtNombrePiloto.getText();
						String apellido = txtApellidoPiloto.getText();
						float horasDeVuelo = Float.valueOf(txtHorasDeVuelo.getText());
						Integer id_aeropuerto = Integer.valueOf(txtId_aeropuerto.getText());
						
						if(editar == false){

							piloto a = new piloto(nombre, apellido, horasDeVuelo,id_aeropuerto);
							acc.insertPiloto(a);
						}
						else{
							
							a.setIdPiloto(a.getIdPiloto());
							a.setNombre(nombre);
							a.setApellido(apellido);
							a.setHorasDeVuelo(horasDeVuelo);
							a.setId_aeropuerto(id_aeropuerto);
							acc.updatePiloto(a);
						}
						
						dispose();
					}
				});
				addPiloto.setActionCommand("OK");
				buttonPane.add(addPiloto);
				getRootPane().setDefaultButton(addPiloto);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if(editar==true){
			txtNombrePiloto.setText(a.getNombre());
			txtApellidoPiloto.setText(a.getApellido());
			//txtHorasDeVuelo.setText(a.getHorasDeVuelo().toString());
			//txtId_aeropuerto.setText(a.getId_aeropuerto().toString());
		}
	}
}
