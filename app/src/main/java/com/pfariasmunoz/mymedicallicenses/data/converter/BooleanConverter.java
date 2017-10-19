package com.pfariasmunoz.mymedicallicenses.data.converter;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by Pablo Farias on 19-10-17.
 */

public class BooleanConverter {

    @TypeConverter
    public static boolean toBoolean(int value) {
        return value > 0;
    }

    @TypeConverter
    public static int toInt(boolean value) {
        if (value) {
            return 1;
        } else {
            return 0;
        }
    }
}
