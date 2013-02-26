package com.udith.mycontacts.dao;

import com.udith.mycontacts.model.User;
import java.util.List;


public interface ContactDAO {

  public void saveContact(User user);
  public void deleteContact(Integer userId);
  public List<User> getAllContacts();
  public User getContactById(Integer userId);
  public User editContact(Integer userId);

}
