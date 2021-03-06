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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.hibernate.annotations.Parent;

import com.ub.edu.bda.accesosHibernate;

import Objetos.Aeropuerto;
import Objetos.Piloto;

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
	accesosHibernate h = new accesosHibernate();

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
		JButton btnEditarPiloto = new JButton("Editar Piloto");
		
		btnNuevoPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPilotos addPiloto = new addPilotos(thisframe, true, false, null);
				addPiloto.setVisible(true);
				
				//al volver cargamos la tabla nuevamente por si han habido cambios
				
				btnEditarPiloto.setVisible(false);
				buscarPilotos();
			}
		});
		
		JLabel lblPilotos = new JLabel("Pilotos:");
		
		tbl_pilotos = new JTable();
		
		btnEditarPiloto.setVisible(false);
		
		btnEditarPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 ArrayList<String> result = new ArrayList<String>();
			     for (int i = 0; i < tbl_pilotos.getModel().getColumnCount(); i++) {
			         result.add(tbl_pilotos.getModel().getValueAt(tbl_pilotos.getSelectedRow(), i).toString());
			     }
			    
			    @SuppressWarnings("unchecked")
				List <Aeropuerto> aeropuerto = h.select("select * FROM aeropuerto where id = " + result.get(4).toString()).addEntity(Aeropuerto.class).list();
			    
			    Piloto p = new Piloto(Integer.valueOf(result.get(0)), result.get(1).toString(), result.get(2).toString(), Float.valueOf(result.get(3)), aeropuerto.get(0));
				addPilotos addPiloto = new addPilotos(thisframe, true, true, p);
				addPiloto.setVisible(true);
				
				btnEditarPiloto.setVisible(false);
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
		
		tbl_pilotos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (tbl_pilotos.getSelectedRow() > -1) {
		            // print first column value from selected row
		            btnEditarPiloto.setVisible(true);
		        }
		    }
		});
	}
	
	private void buscarPilotos(){
		
		@SuppressWarnings("unchecked")
		List <Piloto> pilotos = h.select("SELECT * FROM piloto").addEntity(Piloto.class).list();
		
		rellenarTablaPilotos(pilotos);
	}
	
	private void rellenarTablaPilotos(List <Piloto> pilotos){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Nombre"); 
		model.addColumn("Apellido");
		model.addColumn("Horas de vuelo");
		model.addColumn("Id Aeropuerto");
		model.addColumn("Codigo Aeropuerto"); 
		
		tbl_pilotos.setModel(model);
		
		if(pilotos!=null){
			for(Piloto a: pilotos)
				model.addRow(new Object[]{a.getIdPiloto(), a.getNombre(), a.getApellidos(), a.getHorasDeVuelo(), a.getAeropuerto().getId_aeropuerto(), a.getAeropuerto().getcodigoInternacional()});
		}
	}
}
