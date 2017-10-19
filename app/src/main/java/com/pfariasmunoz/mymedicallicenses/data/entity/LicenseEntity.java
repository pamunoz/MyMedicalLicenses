package com.pfariasmunoz.mymedicallicenses.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.pfariasmunoz.mymedicallicenses.model.License;
import com.pfariasmunoz.mymedicallicenses.model.Recipient;

import java.util.Date;

/**
 * Created by Pablo Farias on 18-10-17.
 */

@Entity(tableName = "licenses", foreignKeys = {
        @ForeignKey(entity = Recipient.class,
        parentColumns = "id",
        childColumns = "recipientId",
        onDelete = ForeignKey.CASCADE)}, indices = {
        @Index(value = "recipientId")
})
public class LicenseEntity implements License {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int recipientId;
    private String number;
    private int duration;
    private Date startDate;
    private Date endDate;
    private boolean isPaid;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public LicenseEntity() {
    }

    public LicenseEntity(License license) {
        this.id = license.getId();
        this.recipientId = license.getRecipientId();
        this.number = license.getNumber();
        this.duration = license.getDuration();
        this.startDate = license.getStartDate();
        this.endDate = license.getEndDate();
        this.isPaid = license.isPaid();
    }
}
