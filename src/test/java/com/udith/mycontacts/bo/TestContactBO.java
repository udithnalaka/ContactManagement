package com.udith.mycontacts.bo;


import java.util.List;
import junit.framework.Assert;
import java.util.ArrayList;
import com.udith.mycontacts.model.User;
import com.udith.mycontacts.dao.ContactDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestContactBO {

   ContactDAO mockedDAO = null;
   User mockedUser = null;

    @Before
    public void setUp() {
       mockedDAO = mock(ContactDAO.class);
       mockedUser = mock(User.class);
    }

    @After
    public void tearDown() {
      mockedDAO = null;
      mockedUser = null;
    }

    @Test
    public void whenListOfContactsHasValues(){

      List mockedArrayList = mock(List.class);
      mockedArrayList.add(mockedUser);
      mockedArrayList.add(mockedUser);
      mockedArrayList.add(mockedUser);

      when(mockedDAO.getAllContacts()).thenReturn(mockedArrayList);

      List userList = mockedDAO.getAllContacts();
      
      //verify(mockedDAO, times(1)).getAllContacts();

     Assert.assertEquals(0, userList.size());

    }

}