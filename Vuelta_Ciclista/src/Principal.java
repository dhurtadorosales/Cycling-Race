import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	
	public static JPanel ContenedorPrincipal;
	public final JDesktopPane Escritorio = new JDesktopPane();
	public static JToggleButton btnInscripciones = new JToggleButton("Inscripciones");
	public static JToggleButton btnEtapas = new JToggleButton("Etapas");
	public static JToggleButton btnRegistros = new JToggleButton("Registros");
	public static JToggleButton btnClasificaciones = new JToggleButton("Clasificaciones");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws SQLException 
	 * @throws NullPointerException 
	 * @throws ClassNotFoundException 
	 */
	
	public Principal() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NullPointerException, SQLException {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("ico.gif"));
		setTitle("Vuelta Ciclista");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ContenedorPrincipal = new JPanel();
		ContenedorPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ContenedorPrincipal);
		ContenedorPrincipal.setLayout(null);
		Escritorio.setBackground(Color.WHITE);
		Escritorio.setForeground(Color.WHITE);
		Escritorio.setBounds(10, 84, 1334, 610);
		ContenedorPrincipal.add(Escritorio);
		
		//Fondo escritorio
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon("fondo.jpg"));
		ImagenFondo.setBounds(0, 0, 1334, 610);
		Escritorio.add(ImagenFondo);
		
		//Menu boton derecho
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(ImagenFondo, popupMenu);
		
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
		popupMenu.add(mntmAyuda_1);
		
		//Icono
		JLabel SimboloVuelta = new JLabel("");
		SimboloVuelta.setIcon(new ImageIcon("fondoLaVuelta.png"));
		SimboloVuelta.setBounds(1024, 0, 265, 295);
		Escritorio.add(SimboloVuelta);
		
		//Bienvenida
		JTextPane txtpnPresentacion = new JTextPane();
		txtpnPresentacion.setFont(new Font("Arial", Font.BOLD, 20));
		txtpnPresentacion.setText("\t\t\r\n\r\n\t\t\tBIENVENIDO\r\nAL PROGRAMA DE GESTI\u00D3N\r\nDE LA VUELTA CICLISTA");
		txtpnPresentacion.setBackground(UIManager.getColor("Button.background"));
		txtpnPresentacion.setBounds(1024, 306, 265, 304);
		Escritorio.add(txtpnPresentacion);
		
		//Barra de men�
		JMenuBar menuBarraMenu = new JMenuBar();
		menuBarraMenu.setBounds(0, 0, 147, 21);
		ContenedorPrincipal.add(menuBarraMenu);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBarraMenu.add(mnOpciones);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnOpciones.add(mntmSalir);
		
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
		menuBarraMenu.add(mntmAyuda);
		
		//Bot�n Inscripciones
		btnInscripciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Inscripciones inscripciones = null;
				try {
					inscripciones = new Inscripciones();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File auxiliar= new File("aux.txt");
				if (auxiliar.exists()){
					inscripciones.btnFinalizar.setSelected(true);
					btnRegistros.setEnabled(true);
					btnClasificaciones.setEnabled(true);
				}
				else{
					inscripciones.btnFinalizar.setSelected(false);
					btnRegistros.setEnabled(false);
					btnClasificaciones.setEnabled(false);
				}
				Escritorio.add(inscripciones);
				inscripciones.setVisible(true);
				btnEtapas.setEnabled(false);
				btnRegistros.setEnabled(false);
				btnClasificaciones.setEnabled(false);
			}
		});
		btnInscripciones.setFont(new Font("Arial", Font.BOLD, 15));
		btnInscripciones.setToolTipText("Inscribir participantes en carrera");
		btnInscripciones.setBounds(10, 28, 160, 50);
		ContenedorPrincipal.add(btnInscripciones);
		
		//Bot�n Etapas
		btnEtapas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Etapas etapas = null;
				etapas = new Etapas();
				Escritorio.add(etapas);
				etapas.setVisible(true);
				btnInscripciones.setEnabled(false);
				btnRegistros.setEnabled(false);
				btnClasificaciones.setEnabled(false);
			}
		});
		btnEtapas.setToolTipText("Muestra las etapas de carrera");
		btnEtapas.setFont(new Font("Arial", Font.BOLD, 15));
		btnEtapas.setBounds(180, 28, 160, 50);
		ContenedorPrincipal.add(btnEtapas);
		
		//Bot�n Registros
		File auxiliar= new File("aux.txt");
		if (auxiliar.exists())
			btnRegistros.setEnabled(true);
		else
			btnRegistros.setEnabled(false);
		btnRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Registros registros = null;
				try {
					registros = new Registros();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Escritorio.add(registros);
				registros.setVisible(true);
				btnEtapas.setEnabled(false);
				btnInscripciones.setEnabled(false);
				btnClasificaciones.setEnabled(false);
				
				Conexion conectarse = null;
				int count = 0;
				try {
					conectarse = new Conexion();
					count = conectarse.ComprobarRegistros();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (count == 0) {
					registros.btnPrimeraEtapa.setEnabled(true);
					registros.btnSegundaEtapa.setEnabled(false);
					registros.btnTerceraEtapa.setEnabled(false);
					registros.btnCuartaEtapa.setEnabled(false);
					registros.btnQuintaEtapa.setEnabled(false);
				}
				if (count == 9){
					registros.btnPrimeraEtapa.setEnabled(false);
					registros.btnSegundaEtapa.setEnabled(true);
					registros.btnTerceraEtapa.setEnabled(false);
					registros.btnCuartaEtapa.setEnabled(false);
					registros.btnQuintaEtapa.setEnabled(false);
					
				}
				if (count == 18) {
					registros.btnPrimeraEtapa.setEnabled(false);
					registros.btnSegundaEtapa.setEnabled(false);
					registros.btnTerceraEtapa.setEnabled(true);
					registros.btnCuartaEtapa.setEnabled(false);
					registros.btnQuintaEtapa.setEnabled(false);
				}
				if (count == 27) {
					registros.btnPrimeraEtapa.setEnabled(false);
					registros.btnSegundaEtapa.setEnabled(false);
					registros.btnTerceraEtapa.setEnabled(false);
					registros.btnCuartaEtapa.setEnabled(true);
					registros.btnQuintaEtapa.setEnabled(false);
				}
				if (count == 36) {
					registros.btnPrimeraEtapa.setEnabled(false);
					registros.btnSegundaEtapa.setEnabled(false);
					registros.btnTerceraEtapa.setEnabled(false);
					registros.btnCuartaEtapa.setEnabled(false);
					registros.btnQuintaEtapa.setEnabled(true);
				}
				if (count == 45) {
					registros.btnPrimeraEtapa.setEnabled(false);
					registros.btnSegundaEtapa.setEnabled(false);
					registros.btnTerceraEtapa.setEnabled(false);
					registros.btnCuartaEtapa.setEnabled(false);
					registros.btnQuintaEtapa.setEnabled(false);
				}
			}
		});
		btnRegistros.setToolTipText("Introduce los tiempos de cada corredor en cada etapa y puerto");
		btnRegistros.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegistros.setBounds(350, 28, 160, 50);
		ContenedorPrincipal.add(btnRegistros);
		
		//Bot�n Clasificaciones
		File auxiliar2= new File("aux.txt");
		if (auxiliar2.exists())
			btnClasificaciones.setEnabled(true);
		else
			btnClasificaciones.setEnabled(false);
		btnClasificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Clasificaciones clasificaciones = null;
				clasificaciones = new Clasificaciones();
				Escritorio.add(clasificaciones);
				clasificaciones.setVisible(true);
				btnEtapas.setEnabled(false);
				btnRegistros.setEnabled(false);
				btnInscripciones.setEnabled(false);
			}
		});
		btnClasificaciones.setToolTipText("Muestra las clasificaciones actualizadas de carrera");
		btnClasificaciones.setFont(new Font("Arial", Font.BOLD, 15));
		btnClasificaciones.setBounds(520, 28, 160, 50);
		ContenedorPrincipal.add(btnClasificaciones);

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
