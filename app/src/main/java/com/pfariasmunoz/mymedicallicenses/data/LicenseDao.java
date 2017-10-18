package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.pfariasmunoz.mymedicallicenses.data.utils.DateConverter;

import java.util.List;

/**
 * Created by Pablo Farias on 17-10-17.
 */
@Dao
@TypeConverters(DateConverter.class)
public interface LicenseDao {

    @Query("SELECT * FROM License")
    LiveData<List<License>> findAll();
}
