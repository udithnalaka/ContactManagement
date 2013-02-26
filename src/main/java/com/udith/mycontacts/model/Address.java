package com.udith.mycontacts.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="address_id")
  private Integer address_id;
  
  @Column(name="street")
  private String street;
  
  @Column(name="city")
  private String city;
  
  @Column(name="country")
  private String country;

  public Integer getAddress_id() {
    return address_id;
  }

  public void setAddress_id(Integer address_id) {
    this.address_id = address_id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  
}
