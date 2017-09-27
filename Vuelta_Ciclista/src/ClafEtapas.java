import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
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
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ClafEtapas extends JInternalFrame {

	JButton btnEtapa1 = new JButton("Etapa 1");
	JButton btnEtapa2 = new JButton("Etapa 2");
	JButton btnEtapa3 = new JButton("Etapa 3");
	JButton btnEtapa4 = new JButton("Etapa 4");
	JButton btnEtapa5 = new JButton("Etapa 5");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClafEtapas frame = new ClafEtapas();
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
	public ClafEtapas() throws ClassNotFoundException, SQLException, IllegalArgumentException {

		setBorder(null);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 1334, 610);

		// Conexion
		Conexion conectarse = new Conexion();
		getContentPane().setLayout(null);

		// Escritorio
		JDesktopPane Escritorio = new JDesktopPane();
		Escritorio.setBounds(0, 0, 1334, 340);
		getContentPane().add(Escritorio);
		// Escritorio.add(clafEtapa5);

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

		// Bot�n volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(483, 448, 130, 45);
		btnVolver.setToolTipText("Vuelve al men\u00FA Clasificaciones");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clasificaciones.btnClafEtapas.setSelected(false);
				Clasificaciones.btnEquipos.setEnabled(true);
				Clasificaciones.btnMontana.setEnabled(true);
				Clasificaciones.btnGeneral.setEnabled(true);
				setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(btnVolver);
		btnEtapa1.setBounds(138, 376, 130, 45);

		// boton etapa 1
		btnEtapa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapa1 clafEtapa1 = null;
				ClafEtapa2 clafEtapa2 = null;
				ClafEtapa3 clafEtapa3 = null;
				ClafEtapa4 clafEtapa4 = null;
				ClafEtapa5 clafEtapa5 = null;
				try {
					clafEtapa1 = new ClafEtapa1();
					clafEtapa2 = new ClafEtapa2();
					clafEtapa3 = new ClafEtapa3();
					clafEtapa4 = new ClafEtapa4();
					clafEtapa5 = new ClafEtapa5();
				} catch (ArrayIndexOutOfBoundsException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Escritorio.add(clafEtapa1);
				clafEtapa1.setVisible(true);
				clafEtapa2.setVisible(false);
				clafEtapa3.setVisible(false);
				clafEtapa4.setVisible(false);
				clafEtapa5.setVisible(false);
				btnEtapa1.setEnabled(false);
				btnEtapa2.setEnabled(true);
				btnEtapa3.setEnabled(true);
				btnEtapa4.setEnabled(true);
				btnEtapa5.setEnabled(true);
			}
		});
		btnEtapa1.setToolTipText("Muestra la clasificación de la etapa 1");
		btnEtapa1.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(btnEtapa1);
		btnEtapa2.setBounds(311, 376, 130, 45);

		// boton etapa 2
		btnEtapa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapa1 clafEtapa1 = null;
				ClafEtapa2 clafEtapa2 = null;
				ClafEtapa3 clafEtapa3 = null;
				ClafEtapa4 clafEtapa4 = null;
				ClafEtapa5 clafEtapa5 = null;
				try {
					clafEtapa1 = new ClafEtapa1();
					clafEtapa2 = new ClafEtapa2();
					clafEtapa3 = new ClafEtapa3();
					clafEtapa4 = new ClafEtapa4();
					clafEtapa5 = new ClafEtapa5();
				} catch (ArrayIndexOutOfBoundsException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Escritorio.add(clafEtapa2);
				clafEtapa1.setVisible(false);
				clafEtapa2.setVisible(true);
				clafEtapa3.setVisible(false);
				clafEtapa4.setVisible(false);
				clafEtapa5.setVisible(false);
				btnEtapa1.setEnabled(true);
				btnEtapa2.setEnabled(false);
				btnEtapa3.setEnabled(true);
				btnEtapa4.setEnabled(true);
				btnEtapa5.setEnabled(true);
			}
		});
		btnEtapa2.setToolTipText("Muestra la clasificación de la etapa 2");
		btnEtapa2.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(btnEtapa2);
		btnEtapa3.setBounds(482, 376, 130, 45);

		// boton etapa 3
		btnEtapa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapa1 clafEtapa1 = null;
				ClafEtapa2 clafEtapa2 = null;
				ClafEtapa3 clafEtapa3 = null;
				ClafEtapa4 clafEtapa4 = null;
				ClafEtapa5 clafEtapa5 = null;
				try {
					clafEtapa1 = new ClafEtapa1();
					clafEtapa2 = new ClafEtapa2();
					clafEtapa3 = new ClafEtapa3();
					clafEtapa4 = new ClafEtapa4();
					clafEtapa5 = new ClafEtapa5();
				} catch (ArrayIndexOutOfBoundsException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Escritorio.add(clafEtapa3);
				clafEtapa1.setVisible(false);
				clafEtapa2.setVisible(false);
				clafEtapa3.setVisible(true);
				clafEtapa4.setVisible(false);
				clafEtapa5.setVisible(false);
				btnEtapa1.setEnabled(true);
				btnEtapa2.setEnabled(true);
				btnEtapa3.setEnabled(false);
				btnEtapa4.setEnabled(true);
				btnEtapa5.setEnabled(true);
			}
		});
		btnEtapa3.setToolTipText("Muestra la clasificación de la etapa 3");
		btnEtapa3.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(btnEtapa3);
		btnEtapa4.setBounds(662, 376, 130, 45);

		// boton etapa 4
		btnEtapa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapa1 clafEtapa1 = null;
				ClafEtapa2 clafEtapa2 = null;
				ClafEtapa3 clafEtapa3 = null;
				ClafEtapa4 clafEtapa4 = null;
				ClafEtapa5 clafEtapa5 = null;
				try {
					clafEtapa1 = new ClafEtapa1();
					clafEtapa2 = new ClafEtapa2();
					clafEtapa3 = new ClafEtapa3();
					clafEtapa4 = new ClafEtapa4();
					clafEtapa5 = new ClafEtapa5();
				} catch (ArrayIndexOutOfBoundsException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Escritorio.add(clafEtapa4);
				clafEtapa1.setVisible(false);
				clafEtapa2.setVisible(false);
				clafEtapa3.setVisible(false);
				clafEtapa4.setVisible(true);
				clafEtapa5.setVisible(false);
				btnEtapa1.setEnabled(true);
				btnEtapa2.setEnabled(true);
				btnEtapa3.setEnabled(true);
				btnEtapa4.setEnabled(false);
				btnEtapa5.setEnabled(true);
			}
		});
		btnEtapa4.setToolTipText("Muestra la clasificación de la etapa 4");
		btnEtapa4.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(btnEtapa4);
		btnEtapa5.setBounds(851, 376, 130, 45);

		// boton etapa 5
		btnEtapa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClafEtapa1 clafEtapa1 = null;
				ClafEtapa2 clafEtapa2 = null;
				ClafEtapa3 clafEtapa3 = null;
				ClafEtapa4 clafEtapa4 = null;
				ClafEtapa5 clafEtapa5 = null;
				try {
					clafEtapa1 = new ClafEtapa1();
					clafEtapa2 = new ClafEtapa2();
					clafEtapa3 = new ClafEtapa3();
					clafEtapa4 = new ClafEtapa4();
					clafEtapa5 = new ClafEtapa5();
				} catch (ArrayIndexOutOfBoundsException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Escritorio.add(clafEtapa5);
				clafEtapa1.setVisible(false);
				clafEtapa2.setVisible(false);
				clafEtapa3.setVisible(false);
				clafEtapa4.setVisible(false);
				clafEtapa5.setVisible(true);
				btnEtapa1.setEnabled(true);
				btnEtapa2.setEnabled(true);
				btnEtapa3.setEnabled(true);
				btnEtapa4.setEnabled(true);
				btnEtapa5.setEnabled(false);
			}
		});
		btnEtapa5.setToolTipText("Muestra la clasificación de la etapa 5");
		btnEtapa5.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(btnEtapa5);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("fondo_etapas.jpg"));
		lblNewLabel.setBounds(0, 0, 1334, 340);
		Escritorio.add(lblNewLabel);

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
