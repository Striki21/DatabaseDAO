package pckj1;

public class Factory {

	public CustomersDAO getDataType(String object) {
		if (object.equalsIgnoreCase("Files")) {
			CustomersDAO customersDAO = new CustomersDAOImplFile();
			return customersDAO;
		} else if (object.equalsIgnoreCase("Database")) {
			CustomersDAO customersDAO = new CustomersDAOImplAccess();
			return customersDAO;

		} else {
			System.out.println("Supporto dati non consentito");
		}

		return null;
	}

}
