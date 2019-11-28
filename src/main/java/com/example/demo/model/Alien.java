package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

  @Id
  private int aid;
  private String aname;

  public int getAid() {
    return this.aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }

  public String getAname() {
    return this.aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }

  public Alien aid(int aid) {
    this.aid = aid;
    return this;
  }

  public Alien aname(String aname) {
    this.aname = aname;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " aid='" + getAid() + "'" +
      ", aname='" + getAname() + "'" +
      "}";
  }

}