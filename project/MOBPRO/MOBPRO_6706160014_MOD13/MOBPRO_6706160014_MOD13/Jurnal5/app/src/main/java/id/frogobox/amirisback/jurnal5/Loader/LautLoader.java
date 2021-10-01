package id.frogobox.amirisback.jurnal5.Loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import id.frogobox.amirisback.jurnal5.NewWord;
import id.frogobox.amirisback.jurnal5.QueryUtils;

/**
 * Created by Praktikan on 19/04/2018.
 */

public class LautLoader extends AsyncTaskLoader<List<NewWord>> {
    private static final String LOG_TAG = LautLoader.class.getName();
    private String mUrl;

    public LautLoader(Context context, String url) {
        super(context);
        new QueryUtils(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    @Override
    public List<NewWord> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<NewWord> earthquakes = QueryUtils.fetchLautData(mUrl);
        return earthquakes;

    }
}
