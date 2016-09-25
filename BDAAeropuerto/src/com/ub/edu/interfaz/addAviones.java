package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ub.edu.bda.accesosHibernate;

import Objetos.ModeloAvion;
import Objetos.Avion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import javax.swing.JComboBox;

public class addAviones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	Avion a;
	private JTextField txtMatricula;
	private List <ModeloAvion> modelos;
	private JComboBox cbxModelo;
	
	/**
	 * Create the dialog.
	 */
	public addAviones(JFrame parent, boolean modal, boolean editar, Avion a) {
		super(parent, modal);
		
		this.editar = editar;
		this.a = a;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 505, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir Avi\u00F3n:");
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula:");
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		
		cbxModelo = new JComboBox();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, Alignment.TRAILING)
								.addComponent(lblNewLabel_1, Alignment.TRAILING))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxModelo, 0, 222, Short.MAX_VALUE)
								.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))))
					.addGap(117))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(cbxModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		JLabel label;
		
		if(editar == false){	
			label = new JLabel("A\u00F1adir piloto:");
		}else{
			label = new JLabel("Editar piloto:");
		}

		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addAvion = new JButton("Guardar avi\u00F3n");
				addAvion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String matricula = txtMatricula.getText();
						ModeloAvion modelo = modelos.get(cbxModelo.getSelectedIndex());
						
						if(editar == false){

							Avion a = new Avion(matricula, modelo);
							acc.insertAvion(a);
						}
						else{
							
							a.setId(a.getId());
							a.setMatricula(matricula);
							a.setModelo(modelos.get(cbxModelo.getSelectedIndex()));
							acc.updateAvion(a);
						}
						
						dispose();
					}
				});
				addAvion.setActionCommand("OK");
				buttonPane.add(addAvion);
				getRootPane().setDefaultButton(addAvion);
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
		
		cargarComboBoxAeropuertos();

		
		if(editar==true){
			txtMatricula.setText(a.getMatricula());
			cbxModelo.setSelectedItem(a.getModelo().getNombre());
		}
	}
	
	private void cargarComboBoxAeropuertos(){
		accesosHibernate h = new accesosHibernate();
		modelos = h.select("SELECT * FROM modeloAvion").addEntity(ModeloAvion.class).list();
		
		for(ModeloAvion a:modelos){
			cbxModelo.addItem(a.getNombre());
		}
	}
}
