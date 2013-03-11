package com.udith.mycontacts.dao;

import com.udith.mycontacts.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO {

    
    private HibernateTemplate hibernateTemplate;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

  @Override
  public void saveContact(User user) {
    hibernateTemplate.saveOrUpdate(user);
    //hibernateTemplate.persist(user);
  }

  @Override
  public void deleteContact(Integer userId) {
   hibernateTemplate.delete(hibernateTemplate.get(User.class,userId));
  }

  @Override
  public List<User> getAllContacts() {
   return hibernateTemplate.find("from " + User.class.getName());
  }

  @Override
  public User editContact(Integer userId) {
    return hibernateTemplate.get(User.class, userId);
  }

  @Override
  public User getContactById(Integer userId) {
    return hibernateTemplate.get(User.class, userId);
  }
 
}
