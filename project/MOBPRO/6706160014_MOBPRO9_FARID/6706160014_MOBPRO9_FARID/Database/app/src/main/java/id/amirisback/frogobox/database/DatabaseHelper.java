package id.amirisback.frogobox.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Praktikan on 22/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_DataS_TABLE = "CREATE TABLE " + DataContract.DataEntry.TABLE_NAME + " ( " +
                DataContract.DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataContract.DataEntry.COLUMN_MHS_NIM + " TEXT NOT NULL, " +
                DataContract.DataEntry.COLUMN_MHS_NAMA + " TEXT, " +
                DataContract.DataEntry.COLUMN_MHS_GENDER + " INTEGER NOT NULL, " +
                DataContract.DataEntry.COLUMN_MHS_KELAS + " TEXT NOT NULL DEFAULT 0 " +
                ");";

        db.execSQL(SQL_CREATE_DataS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
