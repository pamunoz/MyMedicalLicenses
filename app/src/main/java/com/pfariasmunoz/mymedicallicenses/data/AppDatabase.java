package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.pfariasmunoz.mymedicallicenses.data.converter.DateConverter;
import com.pfariasmunoz.mymedicallicenses.data.dao.LicenseDao;
import com.pfariasmunoz.mymedicallicenses.data.dao.RecipientDao;
import com.pfariasmunoz.mymedicallicenses.data.entity.LicenseEntity;
import com.pfariasmunoz.mymedicallicenses.data.entity.RecipientEntity;

/**
 * Created by Pablo Farias on 18-10-17.
 */
@Database(entities = {LicenseEntity.class, RecipientEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "licences.db";

    public abstract LicenseDao licenseModel();
    public abstract RecipientDao RecipientModel();


}
