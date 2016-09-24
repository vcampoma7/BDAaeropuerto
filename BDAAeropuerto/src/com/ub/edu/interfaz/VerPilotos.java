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

import Objetos.piloto;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerPilotos extends JFrame {

	private JPanel contentPane;
	private JTable tbl_pilotos;
	private JFrame thisframe;
	addPilotos addPiloto;

	/**
	 * Create the frame.
	 */
	public VerPilotos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNuevoPiloto = new JButton("A\u00F1adir piloto");
		btnNuevoPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPilotos addPiloto = new addPilotos(thisframe, true, false, null);
				addPiloto.setVisible(true);
				
				//al volver cargamos la tabla nuevamente por si han habido cambios
				
				buscarPilotos();
			}
		});
		
		JLabel lblPilotos = new JLabel("Pilotos:");
		
		tbl_pilotos = new JTable();
		
		JButton btnEditarPiloto = new JButton("Editar Piloto");
		btnEditarPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 ArrayList<String> result = new ArrayList<String>();
			     for (int i = 0; i < tbl_pilotos.getModel().getColumnCount(); i++) {
			         result.add(tbl_pilotos.getModel().getValueAt(tbl_pilotos.getSelectedRow(), i).toString());
			     }
			     
			     piloto a = new piloto(Integer.valueOf(result.get(0)), result.get(1).toString(), result.get(2).toString(), Float.valueOf(result.get(3)), Integer.valueOf(result.get(4)));
				addPilotos addPiloto = new addPilotos(thisframe, true, true, a);
				addPiloto.setVisible(true);
				
				buscarPilotos();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tbl_pilotos, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevoPiloto, Alignment.TRAILING)
								.addComponent(lblPilotos))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditarPiloto)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPilotos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tbl_pilotos, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevoPiloto)
						.addComponent(btnEditarPiloto)))
		);
		contentPane.setLayout(gl_contentPane);
		
		thisframe = this;
		
		buscarPilotos();
	}
	
	private void buscarPilotos(){
		accesosHibernate h = new accesosHibernate();
		
		@SuppressWarnings("unchecked")
		List <piloto> pilotos = h.select("SELECT * FROM piloto").addEntity(piloto.class).list();
		
		rellenarTablaPilotos(pilotos);
	}
	
	private void rellenarTablaPilotos(List <piloto> pilotos){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Nombre"); 
		model.addColumn("Apellido");
		model.addColumn("Horas de vuelo");
		model.addColumn("ID Aeropuerto"); 
		
		tbl_pilotos.setModel(model);
		
		if(pilotos!=null){
			for(piloto a: pilotos)
				model.addRow(new Object[]{a.getIdPiloto(), a.getNombre(), a.getApellido(), a.getHorasDeVuelo(), a.getId_aeropuerto()});
		}
	}
}
