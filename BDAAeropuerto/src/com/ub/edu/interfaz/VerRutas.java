package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ub.edu.bda.accesosHibernate;

import Objetos.Aeropuerto;
import Objetos.Avion;
import Objetos.Piloto;
import Objetos.Ruta;
import Utils.MyUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VerRutas extends JFrame {

	private JPanel contentPane;
	private JTable tbl_rutas;
	
	private JFrame thisframe;
	
	accesosHibernate h = new accesosHibernate();
    MyUtils u = new MyUtils();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerRutas frame = new VerRutas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VerRutas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tbl_rutas = new JTable();
		
		JButton btnNuevaRuta = new JButton("A\u00F1adir ruta");
		JButton btnEditarRuta = new JButton("Editar ruta");

		btnNuevaRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRuta addRuta = new addRuta(thisframe, true, false, null);
				addRuta.setVisible(true);
				
				//al volver cargamos la tabla nuevamente por si han habido cambios
				
				btnEditarRuta.setVisible(false);
				buscarRutas();
			}
		});
		
		JLabel lblRutas = new JLabel("Rutas:");
		
		btnEditarRuta.setVisible(false);
		
		btnEditarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				 ArrayList<String> result = new ArrayList<String>();
			     for (int i = 0; i < tbl_rutas.getModel().getColumnCount(); i++) {
			         result.add(tbl_rutas.getModel().getValueAt(tbl_rutas.getSelectedRow(), i).toString());
			     }
			    
			    @SuppressWarnings("unchecked")
				List <Aeropuerto> aeropuerto_origen = h.select("select * FROM aeropuerto where id = " + result.get(1).toString()).addEntity(Aeropuerto.class).list();
			    @SuppressWarnings("unchecked")
			    List <Aeropuerto> aeropuerto_destino = h.select("select * FROM aeropuerto where id = " + result.get(3).toString()).addEntity(Aeropuerto.class).list();
			    @SuppressWarnings("unchecked")
			    List <Piloto> piloto = h.select("select * FROM piloto where id = " + result.get(7).toString()).addEntity(Piloto.class).list();
			    @SuppressWarnings("unchecked")
			    List <Avion> avion = h.select("select * FROM avion where id = " + result.get(9).toString()).addEntity(Avion.class).list();

			    Ruta r = new Ruta(Integer.valueOf(result.get(0).toString()), aeropuerto_origen.get(0), aeropuerto_destino.get(0), (Date) u.stringToDate(result.get(5).toString()), result.get(6), piloto.get(0), avion.get(0));
				addRuta addRuta = new addRuta(thisframe, true, true, r);
				addRuta.setVisible(true);
				
				btnEditarRuta.setVisible(false);
				buscarRutas();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRutas, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(tbl_rutas, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNuevaRuta, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnEditarRuta)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(lblRutas)
					.addGap(6)
					.addComponent(tbl_rutas, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNuevaRuta)
						.addComponent(btnEditarRuta)))
		);
		contentPane.setLayout(gl_contentPane);
		
		thisframe = this;
		
		buscarRutas();
		
		tbl_rutas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (tbl_rutas.getSelectedRow() > -1) {
		            // print first column value from selected row
		            btnEditarRuta.setVisible(true);
		        }
		    }
		});
	}
	
	private void buscarRutas(){
		
		@SuppressWarnings("unchecked")
		List <Ruta> rutas = h.select("SELECT * FROM ruta").addEntity(Ruta.class).list();
		
		rellenarTablaPilotos(rutas);
	}
	
	private void rellenarTablaPilotos(List <Ruta> rutas){
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("id_aeropuerto_origen");
		model.addColumn("codigoInternacional_aeropuerto_origen"); 
		model.addColumn("id_aeropuerto_destino");
		model.addColumn("codigoInternacional_aeropuerto_destino");
		model.addColumn("diasemana");
		model.addColumn("hora_asignada");
		model.addColumn("id_piloto");
		model.addColumn("nombre_piloto");
		model.addColumn("id_avion");
		model.addColumn("matricula_avion");
		
		tbl_rutas.setModel(model);
		
		if(rutas!=null){
			for(Ruta r: rutas)
				model.addRow(new Object[]{r.getId(), r.getAeropuerto_origen().getId_aeropuerto(), r.getAeropuerto_origen().getcodigoInternacional(), r.getAeropuerto_destino().getId_aeropuerto(), r.getAeropuerto_destino().getcodigoInternacional(), r.getDiasemana(), r.getHora_asignada(), r.getPiloto().getIdPiloto(), r.getPiloto().getNombre(), r.getAvion().getId(), r.getAvion().getMatricula()});
		}
	}
}
