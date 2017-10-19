package com.pfariasmunoz.mymedicallicenses.data;

/**
 * Created by Pablo Farias on 18-10-17.
 */

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.annotations.Nullable;

import static com.pfariasmunoz.mymedicallicenses.data.AppDatabase.DATABASE_NAME;

/**
 * Creates the {@link AppDatabase} asynchronously, exposing a LiveData object to notify of creation.
 */
public class DatabaseCreator {

    public static final String LOG_TAG = DatabaseCreator.class.getSimpleName();
    private static DatabaseCreator sInstance;

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    private AppDatabase mDb;

    private final AtomicBoolean mInitializing = new AtomicBoolean(true);

    // For Singleton initialization
    private static final Object LOCK = new Object();

    public synchronized static DatabaseCreator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new DatabaseCreator();
                }
            }
        }
        return sInstance;
    }

    /** Used to observe when the database initialization is done */
    public LiveData<Boolean> isDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    @Nullable
    public AppDatabase getDatabase() {
        return mDb;
    }

    /**
     * Creates or returns a previously-created database.
     * <p>
     * Although this uses an AsyncTask which currently uses a serial executor, it's thread-safe.
     */
    @SuppressLint("StaticFieldLeak")
    public void createDb(final Context context) {

        Log.d(LOG_TAG, "Creating Db from: " + Thread.currentThread().getName());

        if (!mInitializing.compareAndSet(true, false)) {
            return; // Already initializing
        }

        mIsDatabaseCreated.setValue(false);// Trigger and update to show a loading screen
        new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... params) {
                Log.d(LOG_TAG, "Starting bg job " + Thread.currentThread().getName());

                Context context = params[0].getApplicationContext();

                // Reset the database to have a new data in every run
                context.deleteDatabase(DATABASE_NAME);

                // Build the database
                AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DATABASE_NAME).build();

                // Add some data to the database

                mDb = db;

                return null;
            }

            @Override
            protected void onPostExecute(Void ignored) {
                mIsDatabaseCreated.setValue(true);
            }
        };





    }
}
