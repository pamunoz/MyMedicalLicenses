package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Pablo Farias on 17-10-17.
 */

@Entity
public class Recipient {
    public @PrimaryKey String id;
    public String firstName;
    public String lastName;
    public String rut;
}
