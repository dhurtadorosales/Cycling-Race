import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Etapas extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etapas frame = new Etapas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Etapas() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBorder(null);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		
		//Icono
		JLabel SimboloVuelta = new JLabel("");
		SimboloVuelta.setIcon(new ImageIcon("fondoLaVuelta.png"));
		SimboloVuelta.setBounds(1024, 0, 310, 295);
		
		//Tabla
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setEnabled(false);
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "M\u00E1laga", "Malaga", "01/09/2016", "crono individual", "56", null, ""},
				{"2", "C\u00F3rdoba", "Cazorla", "08/09/2016", "etapa en l\u00EDnea", "213", "Tiscar", ""},
				{"3", "Burgos", "Segovia", "03/09/2016", "crono individual", "180", null, ""},
				{"4", "Segovia ", "Navacerrada", "04/09/2016", "etapa en l\u00EDnea", "175", "Bola del Mundo", "Navacerrada"},
				{"5", "Navacerrada", "Madrid", "05/09/2016", "etapa en l\u00EDnea", "193", null, "193"},
			},
			new String[] {
				"Numero_etapa", "Salida", "Llegada", "Fecha", "Tipo", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		//Etiquetas Tabla
		JLabel lblNmeroDeEtapa = new JLabel("N\u00FAmero de Etapa");
		lblNmeroDeEtapa.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblLlegada = new JLabel("Llegada");
		lblLlegada.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblDistancia = new JLabel("Distancia (km)");
		lblDistancia.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 14));
		
		//Bot�n Volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setBounds(483, 448, 130, 45);
		btnVolver.setToolTipText("Vuelve al men\u00FA principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Principal.btnEtapas.setSelected(false);
				Principal.btnInscripciones.setEnabled(true);
				Principal.btnRegistros.setEnabled(true);
				Principal.btnClasificaciones.setEnabled(true);
			}
		});
		
		//Men� bot�n derecho
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(getContentPane(), popupMenu);
		
		JMenuItem menuItem = new JMenuItem("Ayuda");
		popupMenu.add(menuItem);
		
		//Titulo
		JLabel lblEtapas = new JLabel("ETAPAS");
		lblEtapas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtapas.setForeground(Color.DARK_GRAY);
		lblEtapas.setFont(new Font("Arial", Font.BOLD, 26));
		
		JLabel lblPuerto1 = new JLabel("Puerto 1");
		lblPuerto1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblPuerto2 = new JLabel("Puerto 2");
		lblPuerto2.setFont(new Font("Dialog", Font.BOLD, 14));
		
		//Contenido Tabla
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(318)
							.addComponent(lblEtapas, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNmeroDeEtapa)
									.addGap(56)
									.addComponent(lblSalida, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(49)
									.addComponent(lblLlegada, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblFecha)
									.addGap(76)
									.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPuerto1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblPuerto2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 1031, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
					.addComponent(SimboloVuelta)
					.addGap(57))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(491)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(708, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(93, Short.MAX_VALUE)
							.addComponent(lblEtapas, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(127))
						.addComponent(SimboloVuelta, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
					.addGap(91)
					.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addGap(153))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNmeroDeEtapa)
						.addComponent(lblSalida, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLlegada, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha)
						.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistancia)
						.addComponent(lblPuerto1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPuerto2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(220))
		);
		getContentPane().setLayout(groupLayout);
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
