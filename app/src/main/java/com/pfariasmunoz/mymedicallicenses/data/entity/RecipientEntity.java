package com.pfariasmunoz.mymedicallicenses.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.pfariasmunoz.mymedicallicenses.model.Recipient;

/**
 * Created by Pablo Farias on 18-10-17.
 */
@Entity(tableName = "recipients")
public class RecipientEntity implements Recipient {
    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;
    private String rut;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getRut() {
        return rut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public RecipientEntity(Recipient recipient) {
        this.id = recipient.getId();
        this.firstName = recipient.getFirstName();
        this.lastName = recipient.getLastName();
        this.rut = recipient.getRut();
    }

    public RecipientEntity() {
    }
}
