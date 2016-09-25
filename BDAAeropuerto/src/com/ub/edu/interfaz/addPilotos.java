package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ub.edu.bda.accesosHibernate;

import Objetos.Aeropuerto;
import Objetos.Piloto;

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

public class addPilotos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombrePiloto;
	private JTextField txtApellidoPiloto;
	private JTextField txtHorasDeVuelo;
	private JTextField txtId_aeropuerto;
	private boolean editar;
	accesosHibernate acc = new accesosHibernate();
	Piloto p;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtHorasVuelo;
	private List <Aeropuerto> aeropuertos;
	private JComboBox cbxAeropuerto;
	
	/**
	 * Create the dialog.
	 */
	public addPilotos(JFrame parent, boolean modal, boolean editar, Piloto p) {
		super(parent, modal);
		
		this.editar = editar;
		this.p = p;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 505, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir Piloto:");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		
		JLabel lblHorasDeVuelo = new JLabel("Horas de vuelo:");
		
		JLabel lblNewLabel_3 = new JLabel("Aeropuerto:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		
		txtHorasVuelo = new JTextField();
		txtHorasVuelo.setColumns(10);
		
		cbxAeropuerto = new JComboBox();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblHorasDeVuelo))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbxAeropuerto, 0, 222, Short.MAX_VALUE)
								.addComponent(txtHorasVuelo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtApellidos)))))
					.addGap(153))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHorasVuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHorasDeVuelo))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxAeropuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
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
		/*gl_contentPanel.setHorizontalGroup(
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

							Piloto a = new Piloto(nombre, apellido, horasDeVuelo,id_aeropuerto);
							acc.insertPiloto(a);
						}
						else{
							
							a.setIdPiloto(a.getIdPiloto());
							a.setNombre(nombre);
							a.setApellido(apellido);
							a.setHorasDeVuelo(horasDeVuelo);
							//a.setAeropuerto(id_aeropuerto);
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
		}*/
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addAeropuerto = new JButton("Guardar piloto");
				addAeropuerto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String nombre = txtNombre.getText();
						String apellido = txtApellidos.getText();
						String horasVuelo = txtHorasVuelo.getText();
						Aeropuerto aeropuerto = aeropuertos.get(cbxAeropuerto.getSelectedIndex());
						
						if(editar == false){

							Piloto p = new Piloto(nombre, apellido, Float.valueOf(horasVuelo), aeropuerto);
							acc.insertPiloto(p);
						}
						else{
							
							p.setIdPiloto(p.getIdPiloto());
							p.setNombre(nombre);
							p.setApellidos(apellido);
							p.setHorasDeVuelo(Float.valueOf(horasVuelo));
							p.setAeropuerto(aeropuertos.get(cbxAeropuerto.getSelectedIndex()));
							acc.updatePiloto(p);
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
		
		cargarComboBoxAeropuertos();

		
		if(editar==true){
			txtNombre.setText(p.getNombre());
			txtApellidos.setText(p.getApellidos());
			txtHorasVuelo.setText(p.getHorasDeVuelo().toString());
			
			cbxAeropuerto.setSelectedItem(p.getAeropuerto().getcodigoInternacional());
		}
	}
	
	private void cargarComboBoxAeropuertos(){
		accesosHibernate h = new accesosHibernate();
		aeropuertos = h.select("SELECT * FROM aeropuerto").addEntity(Aeropuerto.class).list();
		
		for(Aeropuerto a:aeropuertos){
			cbxAeropuerto.addItem(a.getcodigoInternacional());
		}
	}
}
