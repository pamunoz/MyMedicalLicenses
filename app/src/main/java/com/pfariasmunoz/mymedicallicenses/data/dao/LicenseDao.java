package com.pfariasmunoz.mymedicallicenses.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.pfariasmunoz.mymedicallicenses.data.entity.LicenseEntity;
import com.pfariasmunoz.mymedicallicenses.model.License;

import java.util.List;

/**
 * Created by Pablo Farias on 19-10-17.
 */
@Dao
public interface LicenseDao {

    @Query("SELECT * FROM licenses WHERE recipientId = :recipientId")
    LiveData<List<LicenseEntity>> loadLicenses(int recipientId);

    @Query("SELECT * FROM licenses WHERE recipientId = :recipientId")
    LiveData<List<LicenseEntity>> loadLicensesSync(int recipientId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<LicenseEntity> licenses);
}
