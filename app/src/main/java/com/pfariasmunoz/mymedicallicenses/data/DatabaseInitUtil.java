package com.pfariasmunoz.mymedicallicenses.data;

import com.pfariasmunoz.mymedicallicenses.data.entity.LicenseEntity;
import com.pfariasmunoz.mymedicallicenses.data.entity.RecipientEntity;
import com.pfariasmunoz.mymedicallicenses.model.License;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo Farias on 18-10-17.
 */

public class DatabaseInitUtil {

    List<RecipientEntity> mRecipientEntities = new ArrayList<>();
    List<LicenseEntity> mLicenseEntities = new ArrayList<>();

    private static void generateData() {
        for (int i = 0; i < 100; i++) {
            RecipientEntity recipientEntity = new RecipientEntity();
            String firstName = "firstName" + String.valueOf(i);
            String lastName = "lastName" + String.valueOf(i);
            recipientEntity.setFirstName(firstName);
            recipientEntity.setLastName(lastName);
            recipientEntity.setRut("");

        }
    }

}
