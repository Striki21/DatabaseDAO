package pckj1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomersDAOImplFile implements CustomersDAO, Switchable {

	ArrayList<Customers> lista;
	Customers c;
	Scanner tastiera = new Scanner(System.in);

	public CustomersDAOImplFile() {
		lista = new ArrayList<Customers>();
	}

	public ArrayList<Customers> getAllCustomers() {

		try {

			FileReader f = new FileReader("C:\\Users\\ricca\\OneDrive\\Desktop\\customers1.txt");
			BufferedReader fIN = new BufferedReader(f);

			String s;
			StringTokenizer st;

			s = fIN.readLine();

			do {

				Customers c = new Customers();
				st = new StringTokenizer(s, ";");

				c.setId(Integer.parseInt(st.nextToken()));
				c.setName(st.nextToken());
				c.setAge(Integer.parseInt(st.nextToken()));
				c.setAddress(st.nextToken());
				c.setSalary(Integer.parseInt(st.nextToken()));

				s = fIN.readLine();

				lista.add(c);

			} while (s != null);

			Collections.sort(lista);

			for (Customers cu : lista)
				System.out.println(cu);

			fIN.close();
			f.close();
		} catch (IOException nofile) {
			System.out.println("Il file non è stato trovato || Riprova");
		}

		return lista;
	}

	public void insertCustomers(Customers c) {

		int x = 0;

		do {

			try {
				System.out.println("Inserisci ID: ");
				int id = tastiera.nextInt();
				c.setId(id);

				tastiera.nextLine();

				System.out.println("Inserisci nome: ");
				String name = tastiera.nextLine();
				c.setName(name);

				tastiera.nextLine();

				System.out.println("Inserisci età: ");
				int age = tastiera.nextInt();
				c.setAge(age);

				tastiera.nextLine();

				System.out.println("Inserisci indirizzo: ");
				String address = tastiera.nextLine();
				c.setAddress(address);

				tastiera.nextLine();

				System.out.println("Inserisci il salario");
				int salary = tastiera.nextInt();
				c.setSalary(salary);

				lista.add(c);

				System.out.println("Vuoi continuare ad inserire profili? Premi 1 per continuare || Premi 0 per uscire");
				x = tastiera.nextInt();
			} catch (Exception e) {
				System.out.println("Hai inserito un'opzione sbagliata || Riprova");
				System.exit(0);

			}

			Collections.sort(lista);

			try {
				FileWriter f1 = new FileWriter("C:\\Users\\ricca\\OneDrive\\Desktop\\CUSTOMERS.txt");
				PrintWriter f1OUT = new PrintWriter(f1);

				for (Customers s : lista)
					f1OUT.println(s);

				f1OUT.flush();
				f1OUT.close();
				f1.close();
			} catch (Exception io) {

				System.out.println("Eccezione Input/Output");
			}

		} while (x != 0);

	}

	public void ricercaID(Customers c) {

		System.out.println("Digita matricola da cercare:  ");
		int cerca = tastiera.nextInt();

		System.out.print("\n");

		for (int i = 1; i < lista.size(); i++) {
			if (lista.get(i).getId() == cerca) {
				System.out.println("Matricola trovata---->" + lista.get(i));

			}
		}

	}

	public void modificaElemento(Customers c) {

		System.out.println("Digita matricola da cercare:  ");
		int cerca = tastiera.nextInt();

		System.out.print("\n");

		for (int i = 1; i < lista.size(); i++) {

			if (lista.get(i).getId() == cerca) {
				System.out.println("Matricola trovata---->" + lista.get(i));

				System.out.println("\n");

				System.out.println("Indice della stringa da modificare: " + cerca);

				tastiera.nextLine();

				System.out.println("Inserisci nuovo nome per la modifica: ");
				String a = tastiera.nextLine();
				c.setName(a);

				tastiera.nextLine();

				System.out.println("Inserisci nuova età per la modifica: ");
				int b = tastiera.nextInt();
				c.setAge(b);

				tastiera.nextLine();

				System.out.println("Inserisci nuovo indirizzo per la modifica: ");
				String d = tastiera.nextLine();
				c.setAddress(d);

				tastiera.nextLine();

				System.out.println("Inserisci nuovo salario per la modifica: ");
				int v = tastiera.nextInt();
				c.setSalary(v);

				lista.set(cerca, c);

			}

		}

		for (Customers cu : lista)
			System.out.println(cu);

	}

	public void cancellazioneElemento(Customers c) {

		System.out.println("Inserisci l'ID che vuoi rimuovere: ");
		int id = tastiera.nextInt();

		for (int i = 1; i < lista.size(); i++) {

			if (lista.get(i).getId() == id) {
				lista.remove(i);

			}

		}
	}

	public void visualizzaDati() {

		Collections.sort(lista);

		for (Customers c : lista)
			System.out.println(c);
	}

	public void svuotaArray() {
		lista.removeAll(getAllCustomers());
	}

	public void interfacciaFilesDatabase() {

		System.out.println("Connessione all'acquisizione dati tramite files stabilita");

	}
}
