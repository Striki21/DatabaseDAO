package pckj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CustomersDAOImplAccess implements CustomersDAO, Switchable {

	Customers cliente;

	ArrayList<Customers> lista = new ArrayList<Customers>();

	Scanner tastiera = new Scanner(System.in);

	public CustomersDAOImplAccess() {

		cliente = new Customers();
	}

	public ArrayList<Customers> getAllCustomers() {

		try {

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "riccardojdbc",
					"riccardojdbc");

			PreparedStatement ps;

			ps = con.prepareStatement("SELECT * FROM CUSTOMERS");

			ResultSet rs = ps.executeQuery();// tutti metodi get();

			while (rs.next()) {

				System.out.print(" ID: " + rs.getString("ID"));
				System.out.print(" NAME: " + rs.getString("NAME"));
				System.out.print(" AGE: " + rs.getString("AGE"));
				System.out.print(" ADDRESS: " + rs.getString("ADDRESS"));
				System.out.println(" SALARY: " + rs.getString("SALARY"));

				lista.add(new Customers(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
						rs.getString("address"), rs.getInt("salary")));

			}

			Collections.sort(lista);

			System.out.println("\n");

			System.out.println("ORDINAMENTO");

			for (Customers personale : lista)
				System.out.println(personale);

			con.commit();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

	public void insertCustomers(Customers c)

	{
		try {

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "riccardojdbc",
					"riccardojdbc");

			PreparedStatement ps;// tutti metodi set();

			System.out.println("\n");

			System.out.println("Inserisci ID: ");
			c.setId(Integer.parseInt(tastiera.nextLine()));

			System.out.println("Inserisci nome: ");
			c.setName(tastiera.nextLine());

			System.out.println("Inserisci età: ");
			c.setAge(Integer.parseInt(tastiera.nextLine()));

			System.out.println("Inserisci indirizzo: ");
			c.setAddress(tastiera.nextLine());

			System.out.println("Inserisci il salario");
			c.setSalary(Integer.parseInt(tastiera.nextLine()));

			ps = con.prepareStatement("INSERT INTO CUSTOMERS (ID, NAME, AGE,ADDRESS,SALARY)VALUES(?,?,?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setInt(3, c.getAge());
			ps.setString(4, c.getAddress());
			ps.setInt(5, c.getSalary());
			ps.executeUpdate();

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void ricercaID(Customers c) {
		try {

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "riccardojdbc",
					"riccardojdbc");

			PreparedStatement ps;
			ResultSet rs;

			boolean trova = false;
			System.out.println("Inserisci ID: ");
			c.setId(Integer.parseInt(tastiera.nextLine()));

			ps = con.prepareStatement("SELECT * FROM CUSTOMERS WHERE ID=?");
			ps.setInt(1, c.getId());
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("\t" + rs.getString("ID") + "\t" + rs.getString("NAME") + "\t" + rs.getString("AGE")
						+ "\t" + rs.getString("ADDRESS") + "\t" + rs.getString("SALARY") + "\t");

				trova = true;

			}

			if (!trova) {
				System.out.println("Elemento non trovato");
			}

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void modificaElemento(Customers c) {
		try {

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "riccardojdbc",
					"riccardojdbc");

			PreparedStatement ps;

			System.out.println("Inserisci ID per la modifica: ");
			c.setId(Integer.parseInt(tastiera.nextLine()));

			System.out.println("Inserisci nuovo nome per la modifica: ");
			String a = tastiera.nextLine();

			tastiera.nextLine();

			System.out.println("Inserisci nuova età per la modifica: ");
			int b = tastiera.nextInt();

			tastiera.nextLine();
			System.out.println("Inserisci nuovo indirizzo per la modifica: ");
			String a1 = tastiera.nextLine();

			tastiera.nextLine();

			System.out.println("Inserisci nuovo salario per la modifica: ");
			int v = tastiera.nextInt();

			ps = con.prepareStatement("UPDATE CUSTOMERS SET NAME=?, AGE=?, ADDRESS=?, SALARY=? WHERE ID=?");
			ps.setInt(5, c.getId());
			ps.setString(1, a);
			ps.setInt(2, b);
			ps.setString(3, a1);
			ps.setInt(4, v);
			ps.executeUpdate();

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void cancellazioneElemento(Customers c) {
		try {
			Connection con = null;
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "riccardojdbc", "riccardojdbc");

			PreparedStatement ps;

			System.out.println("Inserisci ID per la cancellazione: ");
			c.setId(Integer.parseInt(tastiera.nextLine()));

			ps = con.prepareStatement("DELETE FROM CUSTOMERS WHERE ID=?");
			ps.setInt(1, c.getId());
			ps.executeUpdate();

			con.commit();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void visualizzaDati() {

		Collections.sort(lista);

		for (Customers profili : lista)
			System.out.println(profili);

	}

	public void svuotaArray() {
		lista.removeAll(getAllCustomers());
	}

	public void interfacciaFilesDatabase() {

		System.out.println("Connessione all'acquisizione dati tramite database stabilita");
	}
}
