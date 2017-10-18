package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pfariasmunoz.mymedicallicenses.data.utils.DateConverter;

import java.util.Date;

/**
 * Created by Pablo Farias on 17-10-17.
 */

@Entity
@TypeConverters(DateConverter.class)
public class License {
    public @PrimaryKey String id;
    public int recipientId;
    public String number;
    public Date startTime;
    public Date endTime;
    public int paid;
}
