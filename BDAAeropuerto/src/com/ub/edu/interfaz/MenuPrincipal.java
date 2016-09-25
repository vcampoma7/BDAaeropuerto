package com.ub.edu.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnVerAeropuerto = new JButton("Ver aeropuerto");
		btnVerAeropuerto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerAeropuertos verAeropuertos = new VerAeropuertos();
				verAeropuertos.setVisible(true);
			}
		});
		
		JButton btnVerPiloto = new JButton("Ver piloto");
		btnVerPiloto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerPilotos verPilotos = new VerPilotos();
				verPilotos.setVisible(true);
			}
		});
		
		JButton btnVerModelosAvin = new JButton("Ver modelos avi\u00F3n");
		btnVerModelosAvin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerModelosAvion VerModelosAvion = new VerModelosAvion();
				VerModelosAvion.setVisible(true);
			}
		});
		
		JButton btnVerRutas = new JButton("Ver rutas");
		btnVerRutas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerRutas verRutas = new VerRutas();
				verRutas.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnVerModelosAvin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerAeropuerto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnVerPiloto, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnVerRutas, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVerAeropuerto)
						.addComponent(btnVerPiloto)
						.addComponent(btnVerRutas))
					.addGap(18)
					.addComponent(btnVerModelosAvin)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
