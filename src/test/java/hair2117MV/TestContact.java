package hair2117MV;

import hair2117MV.exceptions.InvalidFormatException;
import hair2117MV.model.base.Contact;
import hair2117MV.model.repository.classes.RepositoryContactFile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestContact {

    private RepositoryContactFile repo;

    @Before
    public void setUp() throws Exception {
        repo = new RepositoryContactFile();
    }


    @Test
    public void test1()
    {
        int size = repo.getContacts().size();
        try {
            Contact contact = new Contact("Alisa", "Strada Sibiului", "074122334455");
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            String error = e.getMessage();
            assertEquals("Cannot convert",error);
            //System.out.println(e.getMessage());
        }
        assertEquals(size+1,repo.getContacts().size());
    }


    @Test
    public void test2()
    {
        int size = repo.getContacts().size();
        try {
            Contact contact = new Contact("Alisa", "Strada Sibiului", "a074122334455");
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            //System.out.println(e.getMessage());
        }
        assertEquals(size,repo.getContacts().size());
    }

    @Test
    public void test3()
    {
        int size = repo.getContacts().size();
        try {
            Contact contact = new Contact("Alisa#Holerga", "Strada Sibiului", "074122334455");
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(size+1,repo.getContacts().size());
    }

    @Test
    public void test4()
    {
        int size = repo.getContacts().size();
        try {
            Contact contact = new Contact("", "Strada Sibiului", "074122334455");
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(size+1,repo.getContacts().size());
    }

    @Test
    public void test5()
    {
        int size = repo.getContacts().size();
        try {
            Contact contact = new Contact("Alisa#Holerga#Ioana", "Strada Sibiului", "074122334455");
            repo.addContact(contact);
        } catch (InvalidFormatException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(size,repo.getContacts().size());
    }

}
