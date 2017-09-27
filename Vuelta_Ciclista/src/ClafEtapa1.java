import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.postgresql.util.PSQLException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClafEtapa1 extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClafEtapa1 frame = new ClafEtapa1();
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
	 * @throws PSQLException 
	 * @throws ArrayIndexOutOfBoundsException 
	 * @throws ClassNotFoundException 
	 */
	public ClafEtapa1() throws ArrayIndexOutOfBoundsException, PSQLException, SQLException, ClassNotFoundException {
		
		//Conexion
		Conexion conectarse= new Conexion();
				
		setBounds(0, 0, 1334, 350);
		setBorder(null);
		getContentPane().setLayout(null);
		
		JLabel lblClasificacinPrimeraEtapa = new JLabel("CLASIFICACIÓN PRIMERA ETAPA");
		lblClasificacinPrimeraEtapa.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacinPrimeraEtapa.setForeground(Color.DARK_GRAY);
		lblClasificacinPrimeraEtapa.setFont(new Font("Dialog", Font.BOLD, 26));
		lblClasificacinPrimeraEtapa.setBounds(295, 0, 551, 75);
		getContentPane().add(lblClasificacinPrimeraEtapa);
		
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
			conectarse.ConsultaClafEtapa(1),
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
