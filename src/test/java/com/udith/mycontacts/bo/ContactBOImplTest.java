package com.udith.mycontacts.bo;

import com.udith.mycontacts.dao.ContactDAO;
import com.udith.mycontacts.dao.ContactDAOImpl;
import com.udith.mycontacts.model.User;
import junit.framework.TestCase;
import org.mockito.Mockito;


public class ContactBOImplTest extends TestCase {
    
    public ContactBOImplTest(String testName) {
        super(testName);
    }

    
    private ContactDAO contactDao;

  public void setContactDao(ContactDAO contactDao) {
    this.contactDao = contactDao;
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    contactDao = new ContactDAOImpl();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    contactDao = null;
  }



  public void testSetContactDao() {

    int expectedResult = 1;

    User user = Mockito.mock(User.class);
    //ContactInfo contactInfo = Mockito.mock(ContactInfo.class);
    //Address address = Mockito.mock(Address.class);
    //Set<Address> addressList = Mockito.mock(HashSet.class);

    user.setUser_name("Udith");
    user.setFriend_type("Myself");
    user.setOccupation("Java developer");

   
    //contactDao.saveContact(user);

    assertNotNull(user);
  }

  public void testSaveContact() {
  }

  public void testDeleteContact() {
  }

  public void testGetAllContacts() {
  }

  public void testEditContact() {
  }

}
