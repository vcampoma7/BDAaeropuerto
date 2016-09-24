package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ub.edu.bda.accesosHibernate;

import Objetos.aeropuerto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;

public class addAeropuertos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreAeropuerto;
	private JTextField txtNombreCiudad;
	private JTextField txtCodigoInternacional;
	private JTextField txtCosteHandling;
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	aeropuerto a;
	
	/**
	 * Create the dialog.
	 */
	public addAeropuertos(JFrame parent, boolean modal, boolean editar, aeropuerto a) {
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
			label = new JLabel("A\u00F1adir aeropuerto:");
		}else{
			label = new JLabel("Editar aeropuerto:");
		}
		JLabel label_1 = new JLabel("Nombre:");
		JLabel label_2 = new JLabel("Ciudad:");
		JLabel label_3 = new JLabel("Codigo internacional:");
		JLabel label_4 = new JLabel("Coste del handling:");
		txtNombreAeropuerto = new JTextField();
		txtNombreAeropuerto.setColumns(10);
		txtNombreCiudad = new JTextField();
		txtNombreCiudad.setColumns(10);
		txtCodigoInternacional = new JTextField();
		txtCodigoInternacional.setColumns(10);
		txtCosteHandling = new JTextField();
		txtCosteHandling.setColumns(10);
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
							.addComponent(txtNombreAeropuerto, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(64)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNombreCiudad, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCodigoInternacional, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCosteHandling, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(txtNombreAeropuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(txtNombreCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(txtCodigoInternacional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(txtCosteHandling, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addAeropuerto = new JButton("Guardar aeropuerto");
				addAeropuerto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String nombre = txtNombreAeropuerto.getText();
						String ciudad = txtNombreCiudad.getText();
						String codigo = txtCodigoInternacional.getText();
						float costeHandling = Float.valueOf(txtCosteHandling.getText());
						
						if(editar == false){

							aeropuerto a = new aeropuerto(nombre, ciudad, codigo, costeHandling);
	
							acc.insert(a);
						}
						else{
							
							a.setId_aeropuerto(a.getId_aeropuerto());
							a.setNombre(nombre);
							a.setCiudad(ciudad);
							a.setCodigoInternacional(codigo);
							a.setCosteDelHandling(costeHandling);
							acc.update(a);
						}
						
						dispose();
					}
				});
				addAeropuerto.setActionCommand("OK");
				buttonPane.add(addAeropuerto);
				getRootPane().setDefaultButton(addAeropuerto);
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
			txtNombreAeropuerto.setText(a.getNombre());
			txtNombreCiudad.setText(a.getCiudad());
			txtCodigoInternacional.setText(a.getcodigoInternacional());
			txtCosteHandling.setText(a.getCosteDelHandling().toString());
		}
	}
}
