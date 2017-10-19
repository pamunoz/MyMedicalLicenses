package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.pfariasmunoz.mymedicallicenses.data.utils.DateConverter;

/**
 * Created by Pablo Farias on 18-10-17.
 */
@Database(entities = {License.class, Recipient.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "licences.db";

    public abstract LicenseDao licenseModel();
    public abstract RecipientDao RecipientModel();


}
