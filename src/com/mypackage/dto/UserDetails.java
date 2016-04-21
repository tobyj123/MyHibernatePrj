package com.mypackage.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;


/**
 * Created by gis on 19.04.16.
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int userID;

    @Column( name = "USER_NAME" )
    @Basic
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
            @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE_NAME"))
    })
            private Address homeAdddress;
    @Embedded
    private Address officeAdddress;

    @ElementCollection
    @JoinTable(name = "User_Address",
        joinColumns = @JoinColumn(name = "User_ID")
    )
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")},
            generator = "hilo-gen",
            type = @Type(type = "long"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();
    private String description;


    @Transient
    private String fieldTemp;         //this field is not saved into table

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getHomeAdddress() {
        return homeAdddress;
    }

    public void setHomeAdddress(Address homeAdddress) {
        this.homeAdddress = homeAdddress;
    }

    public Address getOfficeAdddress() {
        return officeAdddress;
    }

    public void setOfficeAdddress(Address officeAdddress) {
        this.officeAdddress = officeAdddress;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}
