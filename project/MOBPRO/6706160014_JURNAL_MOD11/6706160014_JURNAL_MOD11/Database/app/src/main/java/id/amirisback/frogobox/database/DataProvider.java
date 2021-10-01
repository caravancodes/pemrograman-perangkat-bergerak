package id.amirisback.frogobox.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import id.amirisback.frogobox.database.DataContract.DataEntry;



/**
 * Created by Praktikan on 29/03/2018.
 */

public class DataProvider extends ContentProvider {
    private DatabaseHelper mDbHelper;

    private static final String LOG_TAG = DataProvider.class.getSimpleName();
    private static final int DATA = 100;
    private static final int DATA_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        static {
            sUriMatcher.addURI(DataContract.CONTENT_AUTHORITY, DataContract.PATH_DATA, DATA);
            sUriMatcher.addURI(DataContract.CONTENT_AUTHORITY, DataContract.PATH_DATA + "/#", DATA_ID);
        }



    private Uri insertData(Uri uri, ContentValues values){
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        long id = database.insert(DataEntry.TABLE_NAME, null, values);
        if (id == -1){
           Log.e(LOG_TAG, "Failed" + uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        // This cursor will hold the result of the query
        Cursor cursor;

        // Figure out if the URI matcher can match the URI to a specific code
        int match = sUriMatcher.match(uri);
        switch (match) {
            case DATA:
                cursor = database.query(DataEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case DATA_ID:
                selection = DataEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                cursor = database.query(DataEntry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case DATA :
                return insertData(uri,contentValues);
            default:
                throw new IllegalArgumentException("Not Support" + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
