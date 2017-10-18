package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Pablo Farias on 17-10-17.
 */
@Dao
public interface RecipientDao {

    @Query("SELECT * FROM Recipient")
    public List<RecipientWithLicenses> loadRecipientWithLicenses();
}
