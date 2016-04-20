package com.geosoftware.dto;

import javax.persistence.*;
import java.util.Date;


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
    private String adddress;

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

    public String getAdddress() {
        return adddress;
    }

    public String getDescription() {
        return description;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
