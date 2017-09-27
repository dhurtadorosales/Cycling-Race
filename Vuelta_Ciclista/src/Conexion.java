import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

public class Conexion {

	public Connection conectarse;
	boolean ins = false;
	boolean upd = false;
	boolean del = false;

	public Conexion() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/carrera";
			conectarse = DriverManager.getConnection(url, "postgres", "diego");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InscribirParticipantes(String dorsal, String nombre, String apellidos, String edad, String nacionalidad,
			String equipo) throws ClassNotFoundException, SQLException {
		int dorsalInt = Integer.parseInt(dorsal);

		try {
			Statement insercion = (Statement) conectarse.createStatement();
			insercion.execute("insert into ciclista values(" + dorsalInt + ", '" + nombre + "', '" + apellidos + "', '"
					+ edad + "', '" + nacionalidad + "', '" + equipo + "')");
			ins = true;
		} catch (org.postgresql.util.PSQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Puede que los datos estén incompletos o que el participante con dorsal " + dorsalInt + " ya exista");
			ins = false;
		}
	}

	public void ModificarParticipantes(String dorsal, String nombre, String apellidos, String edad, String nacionalidad,
			String equipo) throws ClassNotFoundException, SQLException {
		int dorsalInt = Integer.parseInt(dorsal);

		try {
			Statement update = (Statement) conectarse.createStatement();
			update.executeUpdate("update ciclista set nombre= '" + nombre + "', apellidos= '" + apellidos + "', edad= '"
					+ edad + "', nacionalidad= '" + nacionalidad + "', nombre_equipo= '" + equipo + "' where dorsal= "
					+ dorsalInt);
			upd = true;
		} catch (org.postgresql.util.PSQLException ex) {
			JOptionPane.showMessageDialog(null, "Error: Puede que los datos estén incompletos o que el participante con dorsal " + dorsalInt + " no existe");
			upd = false;
		}
	}

	public void EliminarParticipantes(String dorsal) throws ClassNotFoundException, SQLException {
		int dorsalInt = Integer.parseInt(dorsal);

		try {
			Statement delete = (Statement) conectarse.createStatement();
			delete.executeUpdate("delete from ciclista where dorsal= " + dorsalInt);
			del = true;
		} catch (org.postgresql.util.PSQLException ex) {
			JOptionPane.showMessageDialog(null, "El participante con dorsal " + dorsalInt + " no existe");
			del = false;
		}
	}

	public void RegistrarEtapa(int numEtapa) throws SQLException {

		String s = new String();
		StringBuffer sb = new StringBuffer();

		try {
			FileReader fr = new FileReader(new File("etapa" + numEtapa + ".sql"));

			BufferedReader br = new BufferedReader(fr);

			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			br.close();

			String[] inst = sb.toString().split(";");

			Statement stm = conectarse.createStatement();

			for (int i = 0; i < inst.length; i++) {
				if (!inst[i].trim().equals("")) {
					stm.executeUpdate(inst[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object[][] ConsultaParticipantes() throws SQLException, PSQLException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select dorsal, nombre, apellidos, edad, nacionalidad, nombre_equipo from ciclista order by dorsal");
		Object matrizParticipantes[][];
		matrizParticipantes = new Object[][] { { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null }, };

		int i = 0;
		
		while (rs.next()) {
			for (int j = 0; j <= 5; j++) {
				matrizParticipantes[i][j] = rs.getString(j+1);
			}
			i++;
		}

		return matrizParticipantes;

	}

	public Object[][] ConsultaGeneral() throws SQLException, PSQLException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, sum(participacion.tiempo) as tiempo "
						+ "from ciclista join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where ciclista.dorsal not in(select dorsal " + "from abandono) "
						+ "group by ciclista.dorsal " + "order by tiempo asc");
		Object matrizGeneral[][];
		matrizGeneral = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };
		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizGeneral[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizGeneral;

	}

	public Object[][] ConsultaMontana() throws SQLException, PSQLException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, sum(subida.tiempo_subida) as tiempo "
						+ "from ciclista " + "join subida on ciclista.dorsal= subida.dorsal "
						+ "where ciclista.dorsal not in(select dorsal " + "from abandono) "
						+ "group by ciclista.dorsal " + "order by tiempo asc");
		Object matrizMontana[][];
		matrizMontana = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };
		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizMontana[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizMontana;

	}

	public Object[][] ConsultaEquipos() throws SQLException, PSQLException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm
				.executeQuery("select equipo.nombre_equipo, equipo.nacionalidad, sum(participacion.tiempo) as tiempo "
						+ "from equipo " + "join ciclista on equipo.nombre_equipo= ciclista.nombre_equipo "
						+ "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where ciclista.dorsal not in(select dorsal " + "from abandono) "
						+ "group by equipo.nombre_equipo " + "order by tiempo asc");
		Object matrizEquipos[][];
		matrizEquipos = new Object[][] { { "1\u00BA", null, null, null }, { "2\u00BA", null, null, null },
				{ "3\u00BA", null, null, null }, { null, null, null, null }, };
		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 3; j++) {
				matrizEquipos[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEquipos;

	}

	public Object[][] ConsultaClafEtapa(int numEtapa)
			throws SQLException, PSQLException, ArrayIndexOutOfBoundsException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, participacion.tiempo "
						+ "from ciclista " + "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where etapa.numero_etapa = " + numEtapa + " order by tiempo asc");
		Object matrizEtapa[][];
		matrizEtapa = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };

		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizEtapa[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEtapa;

	}

	public Object[][] ConsultaClafEtapa2() throws SQLException, PSQLException, ArrayIndexOutOfBoundsException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, participacion.tiempo "
						+ "from ciclista " + "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where etapa.numero_etapa = 2 " + "order by tiempo asc");
		Object matrizEtapa2[][];
		matrizEtapa2 = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };

		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizEtapa2[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEtapa2;

	}

	public Object[][] ConsultaClafEtapa3() throws SQLException, PSQLException, ArrayIndexOutOfBoundsException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, participacion.tiempo "
						+ "from ciclista " + "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where etapa.numero_etapa = 3 " + "order by tiempo asc");
		Object matrizEtapa3[][];
		matrizEtapa3 = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };

		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizEtapa3[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEtapa3;

	}

	public Object[][] ConsultaClafEtapa4() throws SQLException, PSQLException, ArrayIndexOutOfBoundsException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, participacion.tiempo "
						+ "from ciclista " + "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where etapa.numero_etapa = 4 " + "order by tiempo asc");
		Object matrizEtapa4[][];
		matrizEtapa4 = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };

		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizEtapa4[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEtapa4;

	}

	public Object[][] ConsultaClafEtapa5() throws SQLException, PSQLException, ArrayIndexOutOfBoundsException {

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery(
				"select ciclista.dorsal, nombre, apellidos, nacionalidad, nombre_equipo, participacion.tiempo "
						+ "from ciclista " + "join participacion on ciclista.dorsal= participacion.dorsal "
						+ "join etapa on participacion.numero_etapa= etapa.numero_etapa "
						+ "where etapa.numero_etapa = 5 " + "order by tiempo asc");
		Object matrizEtapa5[][];
		matrizEtapa5 = new Object[][] { { "1\u00BA", null, null, null, null, null, null },
				{ "2\u00BA", null, null, null, null, null, null }, { "3\u00BA", null, null, null, null, null, null },
				{ "4\u00BA", null, null, null, null, null, null }, { "5\u00BA", null, null, null, null, null, null },
				{ "6\u00BA", null, null, null, null, null, null }, { "7\u00BA", null, null, null, null, null, null },
				{ "8\u00BA", null, null, null, null, null, null }, { "9\u00BA", null, null, null, null, null, null },
				{ null, null, null, null, null, null, null }, };

		int i = 0;

		while (rs.next()) {
			for (int j = 1; j <= 6; j++) {
				matrizEtapa5[i][j] = rs.getString(j);
			}
			i++;
		}

		return matrizEtapa5;

	}

	public int ComprobarRegistros() throws SQLException, PSQLException {

		int count = 0;

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery("select count(*) as total from participacion");

		while (rs.next()) {
			count = rs.getInt("total");
		}
		return count;
	}
	
	public int ComprobarParticipantes() throws SQLException, PSQLException {

		int count = 0;

		Statement stm = conectarse.createStatement();
		ResultSet rs = stm.executeQuery("select count(*) as total from ciclista");

		while (rs.next()) {
			count = rs.getInt("total");
		}
		return count;
	}

}
