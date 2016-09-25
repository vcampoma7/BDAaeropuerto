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
import Utils.MyUtils;
import antlr.StringUtils;
import antlr.Utils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;

public class addModeloAvion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtPeso;
	private JTextField txtPlazas;
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	ModeloAvion m;
	
	/**
	 * Create the dialog.
	 */
	public addModeloAvion(JFrame parent, boolean modal, boolean editar, ModeloAvion m) {
		super(parent, modal);
		
		this.editar = editar;
		this.m = m;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 505, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label;
		
		if(editar == false){	
			label = new JLabel("A\u00F1adir modelo avi�n:");
		}else{
			label = new JLabel("Editar modelo avi�n:");
		}
		JLabel label_1 = new JLabel("Nombre:");
		JLabel label_2 = new JLabel("Descripci�n:");
		JLabel label_3 = new JLabel("Peso:");
		JLabel label_4 = new JLabel("Plazas:");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPlazas = new JTextField();
		txtPlazas.setColumns(10);
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
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(64)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPlazas, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
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
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(txtPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(txtPlazas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addModeloAvion = new JButton("Guardar modelo avi�n");
				addModeloAvion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (comprobarCamposRellenados() == true){
							if(comprobarTipoCampos() == true){
								String nombre = txtNombre.getText();
								String descripcion = txtDescripcion.getText();
								float peso = Float.valueOf(txtPeso.getText());
								Integer plazas = Integer.valueOf(txtPlazas.getText());
								
								if(editar == false){
		
									ModeloAvion m = new ModeloAvion(nombre, descripcion, peso, plazas);
			
									acc.insertModeloAvion(m);
								}
								else{
									
									m.setIdModeloAvion(m.getIdModeloAvion());
									m.setNombre(nombre);
									m.setDescripcion(descripcion);
									m.setPeso(peso);
									m.setPlazas(plazas);
									acc.updateModeloAvion(m);
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
				addModeloAvion.setActionCommand("OK");
				buttonPane.add(addModeloAvion);
				getRootPane().setDefaultButton(addModeloAvion);
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
			txtNombre.setText(m.getNombre());
			txtDescripcion.setText(m.getDescripcion());
			txtPeso.setText(m.getPeso().toString());
			txtPlazas.setText(m.getPlazas().toString());
		}
	}
	
	public boolean comprobarCamposRellenados(){
		if(txtNombre.getText().length()<=0){
			return false;
		}
		else if(txtDescripcion.getText().length()<=0){
			return false;
		}
		else if(txtPeso.getText().length()<=0){
			return false;
		}
		else if(txtPlazas.getText().length()<=0){
			return false;
		}
		return true;
	}
	
	public boolean comprobarTipoCampos(){
		MyUtils u = new MyUtils();
		if(u.stringIsNumeric(txtPeso.getText()) == false){	
			return false;
		}
		return true;
	}
}
