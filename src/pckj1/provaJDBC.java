package pckj1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class provaJDBC {

	public static void main(String[] args) throws SQLException, IOException {

		System.out.println("\t\t**** GESTIONE DATI ****\t\t");
		System.out.println("\n");

		int scelta;
		Scanner tastiera = new Scanner(System.in);

		System.out.println("\tScegli il supporto dati che vuoi utilizzare: \t");
		String switch1 = tastiera.nextLine();

		Factory factory = new Factory();

		CustomersDAO customersDAO = factory.getDataType(switch1);

		CustomersDAOImplAccess database;
		CustomersDAOImplFile files;

		if (switch1.equalsIgnoreCase("Database")) {
			database = new CustomersDAOImplAccess();

			database.interfacciaFilesDatabase();
		} else if (switch1.equalsIgnoreCase("Files")) {
			files = new CustomersDAOImplFile();

			files.interfacciaFilesDatabase();
		}

		do {

			System.out.println("\n\n");
			System.out.println("\t\t**** DATABASE - FILES ****\t\t");
			System.out.println("\n");

			System.out.println("\t\t1. INSERIMENTO\t\t");
			System.out.println("\t\t2. RICERCA PER ID\t\t");
			System.out.println("\t\t3. MODIFICA\t\t");
			System.out.println("\t\t4. CANCELLAZIONE\t\t");
			System.out.println("\t\t5. ACQUISIZIONE DATI\t\t");
			System.out.println("\t\t6. VISUALIZZAZIONE DATI\t\t");
			System.out.println("\t\t7. SVUOTA ARRAY\t\t");
			System.out.println("\t\t0. USCITA\t\t");
			System.out.println("\t\tOpzione Database : ");
			scelta = tastiera.nextInt();

			switch (scelta) {

			case 1: {

				customersDAO.insertCustomers(new Customers());

				tastiera.nextLine();
				break;
			}
			case 2: {

				customersDAO.ricercaID(new Customers());

				tastiera.nextLine();

				break;
			}
			case 3: {

				customersDAO.modificaElemento(new Customers());

				tastiera.nextLine();

				break;
			}
			case 4: {

				customersDAO.cancellazioneElemento(new Customers());

				tastiera.nextLine();

				break;
			}
			case 5: {

				customersDAO.getAllCustomers();

				tastiera.nextLine();

				break;
			}
			case 6: {

				customersDAO.visualizzaDati();

				tastiera.nextLine();

				break;

			}
			case 7: {
				customersDAO.svuotaArray();

				tastiera.nextLine();

				break;
			}
			case 0: {
				System.out.println("Operazione conclusa...alla prossima!");

				break;
			}

			}

			tastiera.nextLine();

		} while (scelta != 0);

		tastiera.close();

	}

}
