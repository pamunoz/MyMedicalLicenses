package com.pfariasmunoz.mymedicallicenses.model;

import java.util.Date;

/**
 * Created by Pablo Farias on 18-10-17.
 */

public interface License {
    int getId();
    int getRecipientId();
    String getNumber();
    int getDuration();
    Date getStartDate();
    Date getEndDate();
    boolean isPaid();
}
