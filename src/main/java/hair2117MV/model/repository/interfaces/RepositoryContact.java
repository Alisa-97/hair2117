package hair2117MV.model.repository.interfaces;

import hair2117MV.model.base.Contact;

import java.util.List;

public interface RepositoryContact {

	List<Contact> getContacts();
	void addContact(Contact contact);
	boolean removeContact(Contact contact);
	boolean saveContracts();
	int count();
	Contact getByName(String string);
}
