package id.amirisback.frogobox.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Praktikan on 05/04/2018.
 */

public class DataCursorAdapter extends CursorAdapter {


    /**
     * Constructs a new {@link DataCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public DataCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the Data data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current Data can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) { // Untuk mengikat data
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.summary);

        int nameColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_NIM);
        int breedColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_MHS_NAMA);

        String nameColumn = cursor.getString(nameColumnIndex);
        String breedColumn = cursor.getString(breedColumnIndex);

        nameTextView.setText(nameColumn);
        summaryTextView.setText(breedColumn);

    }

}
