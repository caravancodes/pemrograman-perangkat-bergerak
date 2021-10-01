package id.amirisback.frogobox.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Praktikan on 22/03/2018.
 */

public class DataContract {
    private DataContract() {
    }

    public static final String CONTENT_AUTHORITY = "id.amirisback.frogobox.database";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_DATA = "mahasiswa";

    public static final class DataEntry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DATA);

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
