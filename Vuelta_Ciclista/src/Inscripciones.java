import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Inscripciones extends JInternalFrame {
	private JTextField txtDorsal;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEdad;
	private JTextField txtNacionalidad;
	private JTable table;
	JToggleButton btnFinalizar;
	boolean insc = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscripciones frame = new Inscripciones();
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
	public Inscripciones() throws ClassNotFoundException, SQLException, NullPointerException {

		// Conexion
		Conexion conectarse = new Conexion();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBorder(null);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		getContentPane().setLayout(null);
		setBounds(0, 0, 1334, 610);

		// Icono
		JLabel lblSimboloVuelta = new JLabel("");
		lblSimboloVuelta.setIcon(new ImageIcon("fondoLaVuelta.png"));
		lblSimboloVuelta.setBounds(1010, -17, 324, 295);
		getContentPane().add(lblSimboloVuelta);

		// Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setToolTipText("Vuelve al men\u00FA principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal.btnInscripciones.setSelected(false);
				Principal.btnEtapas.setEnabled(true);
				Principal.btnRegistros.setEnabled(true);
				Principal.btnClasificaciones.setEnabled(true);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setBounds(705, 448, 130, 45);
		getContentPane().add(btnVolver);

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

		// jlabel
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Arial", Font.BOLD, 14));
		lblDorsal.setBounds(88, 81, 76, 14);
		getContentPane().add(lblDorsal);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(88, 128, 89, 14);
		getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellido.setBounds(88, 176, 76, 14);
		getContentPane().add(lblApellido);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdad.setBounds(88, 224, 46, 14);
		getContentPane().add(lblEdad);

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Arial", Font.BOLD, 14));
		lblNacionalidad.setBounds(88, 272, 106, 14);
		getContentPane().add(lblNacionalidad);

		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEquipo.setBounds(88, 330, 106, 14);
		getContentPane().add(lblEquipo);

		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(193, 126, 171, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setBounds(193, 174, 171, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setText("");
		txtEdad.setBounds(193, 222, 86, 20);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setText("");
		txtNacionalidad.setBounds(193, 270, 171, 20);
		getContentPane().add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		// Combobox Dorsal
		JComboBox combDorsal = new JComboBox();
		combDorsal.setModel(
				new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "11", "12", "13", "21", "22", "23" }));
		combDorsal.setSelectedIndex(0);
		combDorsal.setBounds(193, 76, 76, 24);
		getContentPane().add(combDorsal);
		combDorsal.setVisible(true);

		// Combobox Equipo
		JComboBox combEquipo = new JComboBox();
		combEquipo.setModel(new DefaultComboBoxModel(new String[] { "", "Sky", "Movistar", "Astaná" }));
		combEquipo.setBounds(193, 325, 171, 24);
		getContentPane().add(combEquipo);

		// Boton Inscribir
		JButton btnInscribir = new JButton("Inscribir");
		File auxiliar1 = new File("aux.txt");
		if (auxiliar1.exists())
			btnInscribir.setEnabled(false);
		else
			btnInscribir.setEnabled(true);

		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				insc = false;
				String dorsal = "", nombre = "", apellidos = "", edad = "", nacionalidad = "", equipo = "";
				
				dorsal = (String) combDorsal.getSelectedItem().toString();
				nombre = txtNombre.getText().toString();
				apellidos = txtApellido.getText().toString();
				edad = txtEdad.getText().toString().toString();
				nacionalidad = txtNacionalidad.getText().toString();
				equipo = combEquipo.getSelectedItem().toString();
				if (combEquipo.getSelectedIndex()== 0)
					equipo= "";
				if ((dorsal != "") && (nombre != "") && (apellidos != "") && (edad != "") && (nacionalidad != "")
						&& (equipo != "")) {
					try {
						conectarse.InscribirParticipantes(dorsal, nombre, apellidos, edad, nacionalidad, equipo);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					combDorsal.setSelectedIndex(0);
					txtNombre.setText("");
					txtApellido.setText("");
					txtEdad.setText("");
					txtNacionalidad.setText("");
					combEquipo.setSelectedIndex(0);
					insc = true;
					if (conectarse.ins == true) {
						JOptionPane.showMessageDialog(null, "Participante inscrito");
						try {
							table.setModel(new DefaultTableModel(conectarse.ConsultaParticipantes(),
									new String[] { "New column", "New column", "New column", "New column", "New column",
											"New column" }));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conectarse.ConsultaParticipantes();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
				}
			}
		});
		btnInscribir.setToolTipText("Inserta el registro en la base de datos");
		btnInscribir.setFont(new Font("Dialog", Font.BOLD, 14));
		btnInscribir.setBounds(34, 448, 130, 45);
		getContentPane().add(btnInscribir);

		// Bot�n Modificar
		JButton btnModificar = new JButton("Modificar");
		File auxiliar2 = new File("aux.txt");
		if (auxiliar2.exists())
			btnModificar.setEnabled(false);
		else
			btnModificar.setEnabled(true);

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dorsal = null, nombre = null, apellidos = null, edad = null, nacionalidad = null, equipo = null;
				dorsal = (String) combDorsal.getSelectedItem().toString();
				nombre = txtNombre.getText().toString();
				apellidos = txtApellido.getText().toString();
				edad = txtEdad.getText().toString();
				nacionalidad = txtNacionalidad.getText().toString();
				equipo = (String) combEquipo.getSelectedItem().toString();

				if ((dorsal != "") && (nombre != "") && (apellidos != "") && (edad != "") && (nacionalidad != "")
						&& (equipo != "")) {
					try {
						conectarse.ModificarParticipantes(dorsal, nombre, apellidos, edad, nacionalidad, equipo);
					} catch (ClassNotFoundException | SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					combDorsal.setSelectedIndex(0);
					txtNombre.setText("");
					txtApellido.setText("");
					txtEdad.setText("");
					txtNacionalidad.setText("");
					combEquipo.setSelectedIndex(0);

					if (conectarse.upd == true) {
						JOptionPane.showMessageDialog(null, "Participante modificado");
						try {
							table.setModel(new DefaultTableModel(conectarse.ConsultaParticipantes(),
									new String[] { "New column", "New column", "New column", "New column", "New column",
											"New column" }));
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							conectarse.ConsultaParticipantes();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
				}
			}
		});
		btnModificar.setToolTipText("Inserta el registro en la base de datos");
		btnModificar.setFont(new Font("Arial", Font.BOLD, 14));
		btnModificar.setBounds(257, 448, 130, 45);
		getContentPane().add(btnModificar);

		// Boton Eliminar
		JButton btnEliminar = new JButton("Eliminar");
		File auxiliar3 = new File("aux.txt");
		if (auxiliar3.exists())
			btnEliminar.setEnabled(false);
		else
			btnEliminar.setEnabled(true);

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dorsal = null;
				dorsal = (String) combDorsal.getSelectedItem();

				if ((dorsal != "")) {
					try {
						conectarse.EliminarParticipantes(dorsal);
					} catch (ClassNotFoundException | SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					
					combDorsal.setSelectedIndex(0);
					txtNombre.setText("");
					txtApellido.setText("");
					txtEdad.setText("");
					txtNacionalidad.setText("");
					combEquipo.setSelectedIndex(0);

					if (conectarse.del == true) {
						JOptionPane.showMessageDialog(null, "Participante eliminado");

						try {
							table.setModel(new DefaultTableModel(conectarse.ConsultaParticipantes(),
									new String[] { "New column", "New column", "New column", "New column", "New column",
											"New column" }));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							conectarse.ConsultaParticipantes();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, "Datos incompletos");
				}
			}
		});
		btnEliminar.setToolTipText("Inserta el registro en la base de datos");
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEliminar.setBounds(480, 448, 130, 45);
		getContentPane().add(btnEliminar);

		// Boton Finalizar
		btnFinalizar = new JToggleButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				try {
					count = conectarse.ComprobarParticipantes();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (count == 9) {
					btnInscribir.setEnabled(false);
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);

					try {
						FileWriter file2 = new FileWriter("aux.txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Se deben completar los 9 participantes");
					btnFinalizar.setSelected(false);
				}
			}
		});
		btnFinalizar.setToolTipText("Una vez pulado no se podr\u00E1 inscribir a ning\u00FAn participante");
		btnFinalizar.setFont(new Font("Arial", Font.BOLD, 14));
		btnFinalizar.setBounds(926, 448, 130, 45);
		getContentPane().add(btnFinalizar);

		// titulo
		JLabel lblInscripciones = new JLabel("INSCRIPCIONES");
		lblInscripciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscripciones.setForeground(Color.DARK_GRAY);
		lblInscripciones.setFont(new Font("Arial", Font.BOLD, 26));
		lblInscripciones.setBounds(474, 12, 254, 75);
		getContentPane().add(lblInscripciones);

		// Etiquetas
		JLabel lblDorsalTabla = new JLabel("Dorsal");
		lblDorsalTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDorsalTabla.setBounds(401, 257, 76, 14);
		getContentPane().add(lblDorsalTabla);

		JLabel lblNombreTabla = new JLabel("Nombre");
		lblNombreTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombreTabla.setBounds(521, 257, 89, 14);
		getContentPane().add(lblNombreTabla);

		JLabel lblApellidoTabla = new JLabel("Apellido");
		lblApellidoTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblApellidoTabla.setBounds(659, 257, 76, 14);
		getContentPane().add(lblApellidoTabla);

		JLabel lblEdadTabla = new JLabel("Edad");
		lblEdadTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEdadTabla.setBounds(787, 257, 46, 14);
		getContentPane().add(lblEdadTabla);

		JLabel lblNacionalidadTabla = new JLabel("Nacionalidad");
		lblNacionalidadTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNacionalidadTabla.setBounds(902, 255, 106, 14);
		getContentPane().add(lblNacionalidadTabla);

		JLabel lblEquipoTabla = new JLabel("Equipo");
		lblEquipoTabla.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEquipoTabla.setBounds(1051, 255, 76, 14);
		getContentPane().add(lblEquipoTabla);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int fila= table.getSelectedRow();

				String nomb="";
				String ap= "";
				String ed= "";
				String nac= "";
				
				nomb = table.getValueAt(fila, 1).toString();
				ap = table.getValueAt(fila, 2).toString();
				ed = table.getValueAt(fila, 3).toString();
				nac = table.getValueAt(fila, 4).toString();
				
				combDorsal.setSelectedItem(table.getValueAt(fila, 0));
				txtNombre.setText(nomb);
				txtApellido.setText(ap);
				txtEdad.setText(ed);
				txtNacionalidad.setText(nac);
				combEquipo.setSelectedItem(table.getValueAt(fila, 5));
			}
		});
		table.setModel(new DefaultTableModel(conectarse.ConsultaParticipantes(),

				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(382, 278, 745, 144);
		getContentPane().add(table);

		JLabel lblDorsales = new JLabel("Dorsales: 1 - 3, Equipo Sky");
		lblDorsales.setBounds(497, 128, 205, 15);
		getContentPane().add(lblDorsales);

		JLabel lblDorsales_1 = new JLabel("Dorsales: 11 - 13, Equipo Movistar");
		lblDorsales_1.setBounds(497, 155, 254, 15);
		getContentPane().add(lblDorsales_1);

		JLabel lblDorsales_2 = new JLabel("Dorsales: 21 - 23, Equipo Astaná");
		lblDorsales_2.setBounds(497, 182, 231, 15);
		getContentPane().add(lblDorsales_2);

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
