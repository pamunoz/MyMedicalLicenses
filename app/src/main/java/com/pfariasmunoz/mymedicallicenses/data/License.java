package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Pablo Farias on 17-10-17.
 */

@Entity
public class License {

    public @PrimaryKey String id;
    public Date startTime;
    public Date endTime;
    public int paid;
}
