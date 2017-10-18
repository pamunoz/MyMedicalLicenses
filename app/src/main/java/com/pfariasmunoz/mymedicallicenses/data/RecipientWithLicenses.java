package com.pfariasmunoz.mymedicallicenses.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by Pablo Farias on 18-10-17.
 */

public class RecipientWithLicenses {
    @Embedded
    public Recipient recipient;

    @Relation(parentColumn = "id", entityColumn = "recipientId", entity = License.class)
    public LiveData<List<License>> licenses;
}
