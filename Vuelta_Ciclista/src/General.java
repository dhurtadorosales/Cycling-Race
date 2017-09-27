import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JMenuItem;

public class General extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General frame = new General();
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
	public General() throws SQLException, ClassNotFoundException {

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
		JLabel lblClasificacionGeneral = new JLabel("CLASIFICACI\u00D3N GENERAL");
		lblClasificacionGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacionGeneral.setForeground(Color.DARK_GRAY);
		lblClasificacionGeneral.setFont(new Font("Arial", Font.BOLD, 26));
		lblClasificacionGeneral.setBounds(314, 86, 426, 75);
		getContentPane().add(lblClasificacionGeneral);

		// Tabla
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(conectarse.ConsultaGeneral(),
				new String[] { "Orden", "Dorsal", "Nombre", "Apellidos", "Nacionalidad", "Equipo", "Tiempo" }));
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setBounds(236, 205, 705, 145);
		getContentPane().add(table);

		// Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vuelve al men\u00FA Clasificaciones");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Clasificaciones.btnGeneral.setSelected(false);
				Clasificaciones.btnEquipos.setEnabled(true);
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
		lblOrden.setBounds(257, 180, 75, 14);
		getContentPane().add(lblOrden);

		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Arial", Font.BOLD, 14));
		lblDorsal.setBounds(353, 180, 77, 13);
		getContentPane().add(lblDorsal);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(442, 180, 67, 14);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellidos.setBounds(538, 180, 75, 14);
		getContentPane().add(lblApellidos);

		JLabel lblNacionalidad = new JLabel("País");
		lblNacionalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblNacionalidad.setBounds(661, 179, 106, 14);
		getContentPane().add(lblNacionalidad);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Arial", Font.BOLD, 14));
		lblEquipo.setBounds(760, 179, 67, 14);
		getContentPane().add(lblEquipo);

		JLabel lblTiempo = new JLabel("Tiempo (h:m:s)");
		lblTiempo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTiempo.setBounds(851, 179, 151, 14);
		getContentPane().add(lblTiempo);

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
