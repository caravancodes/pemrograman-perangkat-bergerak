package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class WordAdapter extends ArrayAdapter<NewWord> {
    public WordAdapter(Context context, ArrayList<NewWord> words){
        super (context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        NewWord word = getItem(position);
        TextView txt_hewan = (TextView)listItemView.findViewById(R.id.id_hewan);
        TextView txt_english = (TextView)listItemView.findViewById(R.id.id_inggris);

        txt_hewan.setText(word.getHewan());
        txt_english.setText(word.getInggris());
        return listItemView;
    }
}
