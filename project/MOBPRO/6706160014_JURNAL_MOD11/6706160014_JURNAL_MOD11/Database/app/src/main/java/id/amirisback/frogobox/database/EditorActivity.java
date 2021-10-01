package id.amirisback.frogobox.database;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import id.amirisback.frogobox.database.DataContract.DataEntry;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    /** Identifier for the Data data loader */
    private static final int EXISTING_Data_LOADER = 0;
    /** Content URI for the existing Data (null if it's a new Data) */
    private Uri mCurrentDataUri;
    DataCursorAdapter mCursorAdapter;
    private DatabaseHelper mDbHelper = new DatabaseHelper(this);

    private EditText mNimEdit, mNamaEdit, mKelasEdit;
    private String nimString, namaString, kelasString;
    private int genderInt;
    private Spinner mGenderSpinner;
    private int mGender = DataEntry.GENDER_MALE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = getIntent();
        mCurrentDataUri = intent.getData();
        
        if (mCurrentDataUri == null) {
            setTitle("Tambah Mahasiswa");
            invalidateOptionsMenu();
        } else {
            setTitle("Edit Mahasiswa");
            getLoaderManager().initLoader(EXISTING_Data_LOADER, null, this);
        }

        mNimEdit = (EditText)findViewById(R.id.edit_nim);
        mNamaEdit = (EditText)findViewById(R.id.edit_nama);
        mKelasEdit = (EditText)findViewById(R.id.edit_kelas);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                DataEntry._ID,
                DataEntry.COLUMN_MHS_NIM,
                DataEntry.COLUMN_MHS_NAMA,
                DataEntry.COLUMN_MHS_GENDER,
                DataEntry.COLUMN_MHS_KELAS };

        // This loader will execute the ContentProvider's query method on a background thread

        return new CursorLoader(this,   // Parent activity context
                DataEntry.CONTENT_URI,   // Provider content URI to query
                projection,             // Columns to include in the resulting Cursor
                null,                   // No selection clause
                null,                   // No selection arguments
                null);                  // Default sort order

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }
        if (cursor.moveToFirst()) {

            int nameColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_MHS_NIM);
            int breedColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_MHS_NAMA);
            int genderColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_MHS_GENDER);
            int weightColumnIndex = cursor.getColumnIndex(DataEntry.COLUMN_MHS_KELAS);

            String name = cursor.getString(nameColumnIndex);
            String breed = cursor.getString(breedColumnIndex);
            int gender = cursor.getInt(genderColumnIndex);
            String weight = cursor.getString(weightColumnIndex);


            mNimEdit.setText(name);
            mNamaEdit.setText(breed);
            mKelasEdit.setText(weight);
            switch (gender) {
                case DataEntry.GENDER_FEMALE:
                    mGenderSpinner.setSelection(2);
                    break;
                default:
                    mGenderSpinner.setSelection(1);
                    break;
            }

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mNamaEdit.setText("");
        mNimEdit.setText("");
        mKelasEdit.setText("");
        mGenderSpinner.setSelection(1);
    }

    public void insertData(){
        nimString = mNimEdit.getText().toString().trim();
        namaString = mNamaEdit.getText().toString().trim();
        kelasString = mKelasEdit.getText().toString().trim();
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataContract.DataEntry.COLUMN_MHS_NIM, nimString);
        values.put(DataContract.DataEntry.COLUMN_MHS_NAMA, namaString);
        values.put(DataContract.DataEntry.COLUMN_MHS_GENDER, mGender);
        values.put(DataContract.DataEntry.COLUMN_MHS_KELAS, kelasString);
//        long newRowId = db.insert(DataContract.DataEntry.TABLE_NAME, null, values);
//        Log.v("CatalogActivity", "New Row ID " + newRowId);

        Uri newUri = getContentResolver().insert(DataEntry.CONTENT_URI, values);
        if (newUri == null){
            Toast.makeText(this, "EROR", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "SUKSES", Toast.LENGTH_SHORT).show();;
        }
    }


    private void setupSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mGenderSpinner.setAdapter(genderSpinnerAdapter);
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = DataEntry.GENDER_MALE ; // Male
                    } else {
                        mGender = DataEntry.GENDER_FEMALE; // Female
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = DataEntry.GENDER_MALE; // Unknown
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Do nothing for now
                insertData();
                finish();
                return true;
        }



        return super.onOptionsItemSelected(item);
    }

}
