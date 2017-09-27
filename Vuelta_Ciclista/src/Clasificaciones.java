import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Clasificaciones extends JInternalFrame {
	
	public static JToggleButton btnGeneral = new JToggleButton("General");
	public static JToggleButton btnEquipos = new JToggleButton("Equipos");
	public static JToggleButton btnMontana = new JToggleButton("Monta\u00F1a");
	public static JToggleButton btnClafEtapas = new JToggleButton("Etapas");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clasificaciones frame = new Clasificaciones();
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
	public Clasificaciones() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBorder(null);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		getContentPane().setLayout(null);
		
		//Menu bot�n derecho panel
		JPopupMenu popupMenuPanel = new JPopupMenu();
		addPopup(getContentPane(), popupMenuPanel);
		
		JMenuItem mntmAyudaPanel = new JMenuItem("Ayuda");
		mntmAyudaPanel.addActionListener(new ActionListener() {
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
		popupMenuPanel.add(mntmAyudaPanel);
		
		//Icono
		JLabel lblSimboloVuelta = new JLabel("");
		lblSimboloVuelta.setIcon(new ImageIcon("fondoLaVuelta.png"));
		lblSimboloVuelta.setBounds(1024, 0, 310, 295);
		getContentPane().add(lblSimboloVuelta);
		
		//Escritorio
		JDesktopPane desktopPaneEscritorio = new JDesktopPane();
		desktopPaneEscritorio.setBackground(Color.WHITE);
		desktopPaneEscritorio.setBounds(0, 0, 1024, 610);
		getContentPane().add(desktopPaneEscritorio);
		
		//Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vuelve al men\u00FA principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal.btnClasificaciones.setSelected(false);
				Principal.btnEtapas.setEnabled(true);
				Principal.btnRegistros.setEnabled(true);
				Principal.btnInscripciones.setEnabled(true);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setBounds(483, 448, 130, 45);
		desktopPaneEscritorio.add(btnVolver);
		
		//Imagen Escritorio
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("descarga.jpg"));
		lblFondo.setBounds(0, 0, 1024, 610);
		desktopPaneEscritorio.add(lblFondo);
		
		//Menu bot�n derecho Escritorio
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(lblFondo, popupMenu);
		
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
		popupMenu.add(mntmAyuda);
		
		//General
		btnGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				General general = null;
				try {
					try {
						general = new General();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPaneEscritorio.add(general);
				general.setVisible(true);
				btnGeneral.setSelected(true);
				btnEquipos.setEnabled(false);
				btnMontana.setEnabled(false);
				btnClafEtapas.setEnabled(false);
			}
		});
		btnGeneral.setFont(new Font("Arial", Font.BOLD, 15));
		btnGeneral.setBounds(1113, 263, 160, 50);
		getContentPane().add(btnGeneral);
		
		//Equipos
		btnEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipos equipos = null;
				try {
					equipos = new Equipos();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPaneEscritorio.add(equipos);
				equipos.setVisible(true);
				btnEquipos.setSelected(true);
				btnGeneral.setEnabled(false);
				btnMontana.setEnabled(false);
				btnClafEtapas.setEnabled(false);
			}
		});
		btnEquipos.setFont(new Font("Arial", Font.BOLD, 15));
		btnEquipos.setBounds(1113, 324, 160, 50);
		getContentPane().add(btnEquipos);
		
		//Monta�a
		btnMontana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Montana montana = null;
				try {
					montana = new Montana();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPaneEscritorio.add(montana);
				montana.setVisible(true);
				btnMontana.setSelected(true);
				btnEquipos.setEnabled(false);
				btnGeneral.setEnabled(false);
				btnClafEtapas.setEnabled(false);
			}
		});
		btnMontana.setFont(new Font("Arial", Font.BOLD, 15));
		btnMontana.setBounds(1113, 385, 160, 50);
		getContentPane().add(btnMontana);
		
		//Etapas
		btnClafEtapas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapas clafEtapas = null;
				try {
					clafEtapas = new ClafEtapas();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPaneEscritorio.add(clafEtapas);
				clafEtapas.setVisible(true);
				btnClafEtapas.setSelected(true);
				btnEquipos.setEnabled(false);
				btnMontana.setEnabled(false);
				btnGeneral.setEnabled(false);
			}
		});
		btnClafEtapas.setFont(new Font("Arial", Font.BOLD, 15));
		btnClafEtapas.setBounds(1113, 446, 160, 50);
		getContentPane().add(btnClafEtapas);
		
		//Titulo
		JLabel lblClasificaciones = new JLabel("CLASIFICACIONES");
		lblClasificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificaciones.setBounds(1024, 0, 287, 75);
		getContentPane().add(lblClasificaciones);
		lblClasificaciones.setForeground(Color.DARK_GRAY);
		lblClasificaciones.setFont(new Font("Arial", Font.BOLD, 26));
		setBounds(0, 0, 1334, 610);
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
