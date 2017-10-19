package com.pfariasmunoz.mymedicallicenses.data.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Pablo Farias on 18-10-17.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
