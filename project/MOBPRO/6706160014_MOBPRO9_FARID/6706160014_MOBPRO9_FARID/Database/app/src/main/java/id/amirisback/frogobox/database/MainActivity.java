package id.amirisback.frogobox.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        displayDatabaseInfo();

    }

    private void displayDatabaseInfo(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {DataContract.DataEntry._ID, DataContract.DataEntry.COLUMN_MHS_NIM, DataContract.DataEntry.COLUMN_MHS_NAMA, DataContract.DataEntry.COLUMN_MHS_GENDER, DataContract.DataEntry.COLUMN_MHS_KELAS };

        Cursor cursor = db.query(
                DataContract.DataEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

//        Cursor cursor = db.rawQuery("SELECT * FROM " + DataContract.DataEntry.TABLE_NAME, null);

        try {
            TextView displayView = (TextView) findViewById(R.id.text_view_data);
//            displayView.setText("Number of row in Datas database table : " + cursor.getCount());
            displayView.setText("The Datas table contains " + cursor.getCount() + " Datas\n\n" );
            displayView.append(DataContract.DataEntry._ID + " - " +
                    DataContract.DataEntry.COLUMN_MHS_NIM + " - " +
                    DataContract.DataEntry.COLUMN_MHS_NAMA + " - " +
                    DataContract.DataEntry.COLUMN_MHS_GENDER + " - " +
                    DataContract.DataEntry.COLUMN_MHS_KELAS + "\n");

            int idColumnIndex = cursor.getColumnIndex(DataContract.DataEntry._ID);
            int nimColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_NIM);
            int namaColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_NAMA);
            int genderColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_GENDER);
            int kelasColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_KELAS);

            while (cursor.moveToNext()){
                int currentId = cursor.getInt(idColumnIndex);
                String currentNim = cursor.getString(nimColumnIndex);
                String currentNama = cursor.getString(namaColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                String currentKelas= cursor.getString(kelasColumnIndex);

                displayView.append("\n" + currentId + " - " +
                            currentNim + " - " +
                            currentNama + " - " +
                            currentGender + " - " +
                            currentKelas);

            }

        } finally {
            cursor.close();
        }
    }
    
    
}
