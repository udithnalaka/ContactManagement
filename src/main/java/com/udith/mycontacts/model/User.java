package com.udith.mycontacts.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="user")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name ="user_id")
  private Integer user_id;

  @Column(name ="user_name", nullable=false, length=20)
  private String user_name;

  @Column(name ="friend_type", nullable=false, length=20)
  private String friend_type;

  @Column(name ="occupation", nullable=false, length=20)
  private String occupation;

  @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="user_address")
  private Address address;

  @OneToMany(mappedBy="user", fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
  private Set<ContactInfo> contactInfo;

  public Set<ContactInfo> getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(Set<ContactInfo> contactInfo) {
    this.contactInfo = contactInfo;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getFriend_type() {
    return friend_type;
  }

  public void setFriend_type(String friend_type) {
    this.friend_type = friend_type;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  @Override
  public String toString() {
    return "User [user_id="+ user_id + ", user_name=" + user_name +
            "friend_type=" + friend_type + "occupation=" + occupation + "  ]";
  }
  
}
