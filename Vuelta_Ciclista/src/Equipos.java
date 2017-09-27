import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.EventQueue.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Equipos extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipos frame = new Equipos();
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
	public Equipos() throws SQLException, ClassNotFoundException {

		// Conexion
		Conexion conectarse = new Conexion();

		setBorder(null);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 1334, 610);
		getContentPane().setLayout(null);

		// Menu boton derecho
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(getContentPane(), popupMenu);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("Ayuda.txt");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		popupMenu.add(mntmAyuda);

		// Titulo
		JLabel lblClasificacionEquipos = new JLabel("CLASIFICACI\u00D3N POR EQUIPOS");
		lblClasificacionEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacionEquipos.setForeground(Color.DARK_GRAY);
		lblClasificacionEquipos.setFont(new Font("Arial", Font.BOLD, 26));
		lblClasificacionEquipos.setBounds(243, 81, 468, 75);
		getContentPane().add(lblClasificacionEquipos);

		// Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vuelve al men\u00FA Clasificaciones");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Clasificaciones.btnEquipos.setSelected(false);
				Clasificaciones.btnGeneral.setEnabled(true);
				Clasificaciones.btnMontana.setEnabled(true);
				Clasificaciones.btnClafEtapas.setEnabled(true);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setBounds(483, 448, 130, 45);
		getContentPane().add(btnVolver);

		// Etiquetas
		JLabel lblOrden = new JLabel("Orden");
		lblOrden.setFont(new Font("Arial", Font.BOLD, 14));
		lblOrden.setBounds(262, 180, 67, 14);
		getContentPane().add(lblOrden);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(350, 180, 67, 14);
		getContentPane().add(lblNombre);

		JLabel lblNacionalidad = new JLabel("País");
		lblNacionalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblNacionalidad.setBounds(453, 180, 108, 14);
		getContentPane().add(lblNacionalidad);

		JLabel lblTiempo = new JLabel("Tiempo (h:m:s)");
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTiempo.setBounds(555, 180, 120, 14);
		getContentPane().add(lblTiempo);

		// Tabla
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(conectarse.ConsultaEquipos(),
				new String[] { "Orden", "Nombre", "Nacionalidad", "Tiempo" }));
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setBounds(236, 205, 393, 50);
		getContentPane().add(table);

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
