import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class Registros extends JInternalFrame {

	JButton btnPrimeraEtapa = new JButton("Primera Etapa");
	JButton btnSegundaEtapa = new JButton("Segunda Etapa");
	JButton btnTerceraEtapa = new JButton("Tercera Etapa");
	JButton btnCuartaEtapa = new JButton("Cuarta Etapa");
	JButton btnQuintaEtapa = new JButton("Quinta Etapa");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registros frame = new Registros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Registros() throws ClassNotFoundException, SQLException {
		
		// Conexion
		Conexion conectarse = new Conexion();
		
		setBorder(null);
		setBounds(0, 0, 1334, 610);
		getContentPane().setLayout(null);

		// Men� bot�n derecho escritorio
		JPopupMenu popupMenuPanel = new JPopupMenu();
		addPopup(getContentPane(), popupMenuPanel);

		JMenuItem mntmAyuda_1 = new JMenuItem("Ayuda");
		mntmAyuda_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File ("Ayuda.txt");
	            try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popupMenuPanel.add(mntmAyuda_1);

		// Escritorio
		JDesktopPane desktopPaneEscritorio = new JDesktopPane();
		desktopPaneEscritorio.setBackground(Color.WHITE);
		desktopPaneEscritorio.setBounds(0, 0, 1024, 610);
		getContentPane().add(desktopPaneEscritorio);

		// Bot�n etapa 1
		btnPrimeraEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectarse.RegistrarEtapa(1);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				btnPrimeraEtapa.setEnabled(false);
				btnSegundaEtapa.setEnabled(true);
				btnTerceraEtapa.setEnabled(false);
				btnCuartaEtapa.setEnabled(false);
				btnQuintaEtapa.setEnabled(false);
			}
		});
		btnPrimeraEtapa.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrimeraEtapa.setBounds(1113, 263, 160, 50);
		getContentPane().add(btnPrimeraEtapa);

		// Bot�n etapa 2
		btnSegundaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectarse.RegistrarEtapa(2);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				btnPrimeraEtapa.setEnabled(false);
				btnSegundaEtapa.setEnabled(false);
				btnTerceraEtapa.setEnabled(true);
				btnCuartaEtapa.setEnabled(false);
				btnQuintaEtapa.setEnabled(false);
			}
		});
		btnSegundaEtapa.setFont(new Font("Arial", Font.BOLD, 15));
		btnSegundaEtapa.setBounds(1113, 327, 160, 50);
		getContentPane().add(btnSegundaEtapa);

		// Bot�n etapa 3
		btnTerceraEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectarse.RegistrarEtapa(3);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				btnPrimeraEtapa.setEnabled(false);
				btnSegundaEtapa.setEnabled(false);
				btnTerceraEtapa.setEnabled(false);
				btnCuartaEtapa.setEnabled(true);
				btnQuintaEtapa.setEnabled(false);
			}
		});
		btnTerceraEtapa.setFont(new Font("Arial", Font.BOLD, 15));
		btnTerceraEtapa.setBounds(1113, 388, 160, 50);
		getContentPane().add(btnTerceraEtapa);

		// Bot�n etapa 4
		btnCuartaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectarse.RegistrarEtapa(4);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				btnPrimeraEtapa.setEnabled(false);
				btnSegundaEtapa.setEnabled(false);
				btnTerceraEtapa.setEnabled(false);
				btnCuartaEtapa.setEnabled(false);
				btnQuintaEtapa.setEnabled(true);
			}
		});
		btnCuartaEtapa.setFont(new Font("Arial", Font.BOLD, 15));
		btnCuartaEtapa.setBounds(1113, 449, 160, 50);
		getContentPane().add(btnCuartaEtapa);

		// Bot�n etapa 5
		btnQuintaEtapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectarse.RegistrarEtapa(5);
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				btnPrimeraEtapa.setEnabled(false);
				btnSegundaEtapa.setEnabled(false);
				btnTerceraEtapa.setEnabled(false);
				btnCuartaEtapa.setEnabled(false);
				btnQuintaEtapa.setEnabled(false);
			}
		});
		btnQuintaEtapa.setFont(new Font("Arial", Font.BOLD, 15));
		btnQuintaEtapa.setBounds(1113, 510, 160, 50);
		getContentPane().add(btnQuintaEtapa);

		// icono
		JLabel lblSimboloVuelta = new JLabel("");
		lblSimboloVuelta.setIcon(new ImageIcon("fondoLaVuelta.png"));
		lblSimboloVuelta.setBounds(1024, 0, 310, 295);
		getContentPane().add(lblSimboloVuelta);

		// Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vuelve al men\u00FA principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal.btnRegistros.setSelected(false);
				Principal.btnEtapas.setEnabled(true);
				Principal.btnInscripciones.setEnabled(true);
				Principal.btnClasificaciones.setEnabled(true);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setBounds(483, 448, 130, 45);
		desktopPaneEscritorio.add(btnVolver);

		// Fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1334, 610);
		desktopPaneEscritorio.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("descarga.jpg"));

		// Men� bot�n derecho panel
		JPopupMenu popupMenuEscritorio = new JPopupMenu();
		addPopup(lblNewLabel, popupMenuEscritorio);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File ("Ayuda.txt");
	            try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popupMenuEscritorio.add(mntmAyuda);

		// Titulo
		JLabel lblRegistros = new JLabel("REGISTROS");
		lblRegistros.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistros.setForeground(Color.DARK_GRAY);
		lblRegistros.setFont(new Font("Arial", Font.BOLD, 26));
		lblRegistros.setBounds(1054, 0, 254, 75);
		getContentPane().add(lblRegistros);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
