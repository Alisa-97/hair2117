package hair2117MV.model.repository.classes;

import hair2117MV.exceptions.InvalidFormatException;
import hair2117MV.model.base.Activity;
import hair2117MV.model.base.Contact;
import hair2117MV.model.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RepositoryActivityFileTest {

    RepositoryActivityFile repo;

    @Before
    public void setUp() throws Exception {
        RepositoryContactFile repocContact = new RepositoryContactFile();
        repo=new RepositoryActivityFile(repocContact);
    }


    @Test
    public void test1() throws InvalidFormatException, ParseException {
        int size = repo.getActivities().size();

        List<Contact> contactList=new ArrayList<Contact>();
        contactList.add(new Contact("name","adr","0723849016"));
        contactList.add(new Contact("name2","adr2","0723849089"));

        boolean ok =false;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1=dateformat.parse("03/04/2019");
        Date date2=dateformat.parse("05/04/2019");
        try {
           Activity activity = new Activity("nume", date1, date2, contactList, "desc");
            repo.addActivity(activity);

        } catch (Exception e) {
            String error = e.getMessage();
            assertEquals("Cannot convert",error);
            //System.out.println(e.getMessage());
        }
        assertEquals(size+1,repo.getActivities().size());
    }

    @Test
    public void test2() throws InvalidFormatException, ParseException {
        int size = repo.getActivities().size();

        List<Contact> contactList=new ArrayList<Contact>();
        contactList.add(new Contact("name","adr","0723849016"));
        contactList.add(new Contact("name2","adr2","0723849089"));

        boolean ok =false;
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1=dateformat.parse("20/03/2013");
        Date date2=dateformat.parse("05/04/2019");
        try {
            Activity activity = new Activity("nume", date1, date2, contactList, "desc");
            repo.addActivity(activity);

        } catch (Exception e) {
            String error = e.getMessage();
            assertEquals("Cannot convert",error);
            //System.out.println(e.getMessage());
        }
        assertEquals(size,repo.getActivities().size());
    }

}