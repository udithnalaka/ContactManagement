package com.udith.mycontacts.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "contact")
public class ContactInfo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="contact_id")
  private Integer contact_id;

  @Column(name="mobile")
  private Integer mobileNumber;

  @Column(name="office")
  private Integer officeNumber;

  @Column(name="homephone")
  private Integer homeNumer;

  @Column(name="skype")
  private String skypeId;

  @ManyToOne(cascade=javax.persistence.CascadeType.ALL)
  @JoinColumn(name="user_id")
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getContact_id() {
    return contact_id;
  }

  public void setContact_id(Integer contact_id) {
    this.contact_id = contact_id;
  }

  public Integer getHomeNumer() {
    return homeNumer;
  }

  public void setHomeNumer(Integer homeNumer) {
    this.homeNumer = homeNumer;
  }

  public Integer getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Integer mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Integer getOfficeNumber() {
    return officeNumber;
  }

  public void setOfficeNumber(Integer officeNumber) {
    this.officeNumber = officeNumber;
  }

  public String getSkypeId() {
    return skypeId;
  }

  public void setSkypeId(String skypeId) {
    this.skypeId = skypeId;
  }

  

}
