package com.udith.mycontacts.bo;

import com.udith.mycontacts.dao.ContactDAO;
import com.udith.mycontacts.model.ContactInfo;
import com.udith.mycontacts.model.User;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactBO")
public class ContactBOImpl implements ContactBO {

  @Autowired
  ContactDAO contactDao;

  //@Autowired
  //ContactSender contactSender;

  public void setContactDao(ContactDAO contactDao) {
    this.contactDao = contactDao;
  }

//  public void setContactSender(ContactSender contactSender) {
//    this.contactSender = contactSender;
//  }

  @Override
  @Transactional(readOnly = false)
  public void saveContact(User user) {
    //contactSender.sendMyContact(user);

    Set<ContactInfo> contactInfoSet = new HashSet<>();

    ContactInfo info1 = new ContactInfo();
    info1.setHomeNumer(12345678);
    info1.setMobileNumber(12345);
    info1.setSkypeId("udithnalaka");
    contactInfoSet.add(info1);

    ContactInfo info2 = new ContactInfo();
    info2.setHomeNumer(4332455);
    info2.setMobileNumber(9897898);
    info2.setSkypeId("irangarana");
    contactInfoSet.add(info2);

    user.setContactInfo(contactInfoSet);

    contactDao.saveContact(user);
  }

  @Override
  @Transactional(readOnly = false)
  public void updateContact(User user) {
    contactDao.saveContact(user);
  }

  @Override
  @Transactional(readOnly = false)
  public void deleteContact(Integer userId) {
    contactDao.deleteContact(userId);
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> getAllContacts() {
    return contactDao.getAllContacts();
  }

  @Override
  @Transactional(readOnly = true)
  public User getContactById(Integer userId) {
    return contactDao.getContactById(userId);
  }

  @Override
  public Map<String, Integer> getContactSummary() {
    
    Integer friend = 0, family = 0, business = 0, other = 0;
    Map<String, Integer> contactTypeCountMap = new HashMap<>();

    List<User> usersList = getAllContacts();
    for (User user : usersList) {
      if (user.getFriend_type() != null && !user.getFriend_type().isEmpty()) {
        if (user.getFriend_type().equalsIgnoreCase(User.FAMILY_CONTACT)) {
          family++;
        } else if (user.getFriend_type().equalsIgnoreCase(User.FRIEND_CONTACT)) {
          friend++;
        } else if (user.getFriend_type().equalsIgnoreCase(User.BUSINESS_CONTACT)) {
          business++;
        } else {
          other++;
        }
      }
    }

    System.out.println("family -"+ family + ", friend- " + friend + ", business- " + business);

    contactTypeCountMap.put(User.FAMILY_CONTACT, family);
    contactTypeCountMap.put(User.FRIEND_CONTACT, friend);
    contactTypeCountMap.put(User.BUSINESS_CONTACT, business);
    contactTypeCountMap.put(User.OTHER_CONTACT, other);

    return contactTypeCountMap;
  }
}
