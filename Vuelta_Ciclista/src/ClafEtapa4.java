import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClafEtapa4 extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClafEtapa4 frame = new ClafEtapa4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ClafEtapa4() throws ClassNotFoundException, SQLException {
		
		//Conexion
		Conexion conectarse= new Conexion();
		
		setBounds(0, 0, 1334, 350);
		setBorder(null);
		getContentPane().setLayout(null);
		
		JLabel lblClasificacinCuartaEtapa = new JLabel("CLASIFICACIÓN CUARTA ETAPA");
		lblClasificacinCuartaEtapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacinCuartaEtapa.setForeground(Color.DARK_GRAY);
		lblClasificacinCuartaEtapa.setFont(new Font("Dialog", Font.BOLD, 26));
		lblClasificacinCuartaEtapa.setBounds(295, 0, 551, 75);
		getContentPane().add(lblClasificacinCuartaEtapa);
		
		JLabel lblOrden = new JLabel("Orden");
		lblOrden.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOrden.setBounds(236, 72, 75, 14);
		getContentPane().add(lblOrden);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDorsal.setBounds(332, 72, 77, 13);
		getContentPane().add(lblDorsal);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombre.setBounds(421, 72, 67, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblApellidos.setBounds(517, 72, 75, 14);
		getContentPane().add(lblApellidos);
		
		JLabel lblNacionalidad = new JLabel("País");
		lblNacionalidad.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNacionalidad.setBounds(640, 71, 106, 14);
		getContentPane().add(lblNacionalidad);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEquipo.setBounds(739, 71, 67, 14);
		getContentPane().add(lblEquipo);
		
		JLabel lblTiempo = new JLabel("Tiempo (h:m:s)");
		lblTiempo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTiempo.setBounds(830, 71, 151, 14);
		getContentPane().add(lblTiempo);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			conectarse.ConsultaClafEtapa(4),
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(236, 98, 705, 145);
		getContentPane().add(table);

	}
}
