package com.pfariasmunoz.mymedicallicenses.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.pfariasmunoz.mymedicallicenses.data.entity.RecipientEntity;

import java.util.List;

/**
 * Created by Pablo Farias on 19-10-17.
 */
@Dao
public interface RecipientDao {

    @Query("SELECT * FROM recipients")
    LiveData<List<RecipientEntity>> loadAllRecipients();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RecipientEntity> recipients);

    @Query("SELECT * FROM recipients WHERE id = :recipientId")
    LiveData<RecipientEntity> loadRecipient(int recipientId);

    @Query("SELECT * FROM recipients WHERE id = :recipientId")
    RecipientEntity loadRecipientSync(int recipientId);

}
