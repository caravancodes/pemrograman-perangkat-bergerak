package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class WordAdapter extends ArrayAdapter<NewWord> {

    private int colorResID;

    public WordAdapter(Context context, ArrayList<NewWord> words, int colorResID){
        super (context,0,words);
        this.colorResID = colorResID;
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
        ImageView img_foto = (ImageView)listItemView.findViewById(R.id.id_gmb);
        LinearLayout lineText = (LinearLayout)listItemView.findViewById(R.id.lineText);


        txt_hewan.setText(word.getHewan());
        txt_english.setText(word.getInggris());

        if (word.hasImage()){
            img_foto.setImageResource(word  .getFoto());
            img_foto.setVisibility(View.VISIBLE);
        } else {
            img_foto.setVisibility(View.GONE);
        }
        int color = ContextCompat.getColor(getContext(), colorResID);
        lineText.setBackgroundColor(color);


        return listItemView;
    }
}
