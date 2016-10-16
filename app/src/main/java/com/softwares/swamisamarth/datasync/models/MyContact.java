package com.softwares.swamisamarth.datasync.models;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.softwares.swamisamarth.datasync.db.AppDatabase;
import com.softwares.swamisamarth.datasync.db.OperationConverter;

import java.util.Date;


/**
 * Created by Narendra on 10/15/2016.
 */
@Table(database = AppDatabase.class)
public class MyContact extends BaseModel{

    @PrimaryKey
    private String contactNo;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(typeConverter = OperationConverter.class)
    private OPERATION operation = OPERATION.NONE;

    @Column
    private Date createdAt;

    public MyContact() {
    }

    public MyContact(String contactNo, String firstName, String lastName, OPERATION operation) {
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.operation = operation;
        this.createdAt = new Date();
    }

    public MyContact(String contactNo, String firstName, String lastName, OPERATION operation, Date createdAt) {
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.operation = operation;
        this.createdAt = createdAt;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OPERATION getOperation() {
        return operation;
    }

    public void setOperation(OPERATION operation) {
        this.operation = operation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + contactNo;
    }

}
