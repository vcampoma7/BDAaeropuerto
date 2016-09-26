package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.annotations.Parent;

import com.ub.edu.bda.accesosHibernate;

import Objetos.ModeloAvion;
import Objetos.Avion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerAviones extends JFrame {

	private JPanel contentPane;
	private JTable tbl_aviones;
	private JFrame thisframe;
	addAviones addAvion;
	accesosHibernate h = new accesosHibernate();

	/**
	 * Create the frame.
	 */
	public VerAviones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNuevoAvion = new JButton("A\u00F1adir Avi\u00F3n");
		btnNuevoAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAviones addAvion = new addAviones(thisframe, true, false, null);
				addAvion.setVisible(true);
				
				//al volver cargamos la tabla nuevamente por si han habido cambios
				
				buscarAviones();
			}
		});
		
		JLabel lblAviones = new JLabel("Aviones:");
		
		tbl_aviones = new JTable();
		
		JButton btnEditarAvion = new JButton("Editar Avi\u00F3n");
		btnEditarAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 ArrayList<String> result = new ArrayList<String>();
			     for (int i = 0; i < tbl_aviones.getModel().getColumnCount(); i++) {
			         result.add(tbl_aviones.getModel().getValueAt(tbl_aviones.getSelectedRow(), i).toString());
			     }
			    
			    @SuppressWarnings("unchecked")
				List <ModeloAvion> modelo = h.select("select * FROM modeloAvion where id = " + result.get(2).toString()).addEntity(ModeloAvion.class).list();
			    
			    Avion a = new Avion(Integer.valueOf(result.get(0)), result.get(1).toString(), modelo.get(0));
				addAviones addAvion = new addAviones(thisframe, true, true, a);
				addAvion.setVisible(true);
				
				buscarAviones();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tbl_aviones, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevoAvion, Alignment.TRAILING)
								.addComponent(lblAviones))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditarAvion)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAviones)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbl_aviones, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevoAvion)
						.addComponent(btnEditarAvion)))
		);
		contentPane.setLayout(gl_contentPane);
		
		thisframe = this;
		
		buscarAviones();
	}
	
	private void buscarAviones(){
		
		@SuppressWarnings("unchecked")
		List <Avion> aviones = h.select("SELECT * FROM avion").addEntity(Avion.class).list();
		
		rellenarTablaAviones(aviones);
	}
	
	private void rellenarTablaAviones(List <Avion> aviones){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Matricula"); 
		model.addColumn("Id Modelo");
		model.addColumn("Nombre Modelo"); 
		
		tbl_aviones.setModel(model);
		
		if(aviones!=null){
			for(Avion a: aviones)
				model.addRow(new Object[]{a.getId(), a.getMatricula(), a.getModelo().getId(), a.getModelo().getNombre()});
		}
	}
}
