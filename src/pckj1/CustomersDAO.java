package pckj1;

import java.util.ArrayList;

public interface CustomersDAO {

	public ArrayList<Customers> getAllCustomers();

	public void insertCustomers(Customers c);

	public void ricercaID(Customers c);

	public void modificaElemento(Customers c);

	public void cancellazioneElemento(Customers c);

	public void visualizzaDati();

	public void svuotaArray();
}
