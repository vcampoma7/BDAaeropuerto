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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerModelosAvion extends JFrame {

	private JPanel contentPane;
	private JTable tbl_modelos;
	private JFrame thisframe;
	addModeloAvion addModeloAvion;

	/**
	 * Create the frame.
	 */
	public VerModelosAvion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNuevoModeloAvion = new JButton("A\u00F1adir modelo avión");
		btnNuevoModeloAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addModeloAvion addModeloAvion = new addModeloAvion(thisframe, true, false, null);
				addModeloAvion.setVisible(true);
				
				//al volver cargamos la tabla nuevamente por si han habido cambios
				
				buscarModeloAvion();
			}
		});
		
		JLabel lblModeloAvion = new JLabel("Modelos avión:");
		
		tbl_modelos = new JTable();
		
		JButton btnEditarModeloAvion = new JButton("Editar modelo avión");
		btnEditarModeloAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 ArrayList<String> result = new ArrayList<String>();
			     for (int i = 0; i < tbl_modelos.getModel().getColumnCount(); i++) {
			         result.add(tbl_modelos.getModel().getValueAt(tbl_modelos.getSelectedRow(), i).toString());
			     }
			     
			     ModeloAvion m = new ModeloAvion(Integer.valueOf(result.get(0)), result.get(1).toString(), result.get(2).toString(), Float.valueOf(result.get(3).toString()), Integer.valueOf(result.get(4)));
			     
				addModeloAvion addModeloAvion = new addModeloAvion(thisframe, true, true, m);
				addModeloAvion.setVisible(true);
				
				buscarModeloAvion();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tbl_modelos, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevoModeloAvion, Alignment.TRAILING)
								.addComponent(lblModeloAvion))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditarModeloAvion)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModeloAvion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbl_modelos, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevoModeloAvion)
						.addComponent(btnEditarModeloAvion)))
		);
		contentPane.setLayout(gl_contentPane);
		
		thisframe = this;
		
		buscarModeloAvion();
	}
	
	private void buscarModeloAvion(){
		accesosHibernate h = new accesosHibernate();
		
		@SuppressWarnings("unchecked")
		List <ModeloAvion> modelos = h.select("SELECT * FROM modeloAvion").addEntity(ModeloAvion.class).list();
		
		rellenarTablaModelosAvion(modelos);
	}
	private void rellenarTablaModelosAvion(List <ModeloAvion> modelos){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Nombre"); 
		model.addColumn("Ciudad");
		model.addColumn("Codigo internacional");
		model.addColumn("Coste del handling"); 
		
		tbl_modelos.setModel(model);
		
		if(modelos!=null){
			for(ModeloAvion a: modelos)
				model.addRow(new Object[]{a.getId(), a.getNombre(), a.getDescripcion(), a.getPeso(), a.getPlazas()});
		}
	}
}
