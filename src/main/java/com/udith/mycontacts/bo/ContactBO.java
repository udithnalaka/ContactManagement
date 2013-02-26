/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.udith.mycontacts.bo;

import com.udith.mycontacts.model.User;
import java.util.List;


public interface ContactBO {

  public void saveContact(User user);
  public void updateContact(User user);
  public void deleteContact(Integer userId);
  public List<User> getAllContacts();
  public User getContactById(Integer userId);
  


}
