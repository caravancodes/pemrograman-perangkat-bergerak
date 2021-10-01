package id.amirisback.frogobox.database;

import android.provider.BaseColumns;

/**
 * Created by Praktikan on 22/03/2018.
 */

public class DataContract {
    private DataContract() {
    }

    public static final class DataEntry implements BaseColumns{
        public static final String TABLE_NAME = "mahasiswa";
        public static final String _ID  = BaseColumns._ID;
        public static final String COLUMN_MHS_NIM = "nim";
        public static final String COLUMN_MHS_NAMA = "nama";
        public static final String COLUMN_MHS_GENDER = "gender";
        public static final String COLUMN_MHS_KELAS = "kelas";

        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

    }
}
