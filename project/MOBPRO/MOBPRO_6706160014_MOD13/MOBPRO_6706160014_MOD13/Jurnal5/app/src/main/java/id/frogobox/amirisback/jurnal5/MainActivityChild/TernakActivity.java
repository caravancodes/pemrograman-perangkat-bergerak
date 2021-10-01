package id.frogobox.amirisback.jurnal5.MainActivityChild;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.frogobox.amirisback.jurnal5.Loader.HutanLoader;
import id.frogobox.amirisback.jurnal5.Loader.TernakLoader;
import id.frogobox.amirisback.jurnal5.NewWord;
import id.frogobox.amirisback.jurnal5.QueryUtils;
import id.frogobox.amirisback.jurnal5.R;
import id.frogobox.amirisback.jurnal5.WordAdapter;

public class TernakActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewWord>> {

    ListView listViews;
    MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private int resId, resIdSuara;
    private String hewans[] = {"Angsa","Ayam","Bebek","Domba","Kalkun","Kambing","Kelinci","Kerbau","Sapi"};
    private String english[] = {"Cygnus olor","Gallus gallus","Cairina moschata","Ovis ammon","Meleagris gallopavo","Capricornis sumatrensis","Oryctolagus cuniculus","Bubalus bubalis","Bos taurus"};

    // ---------------------------------------------------------------------------------------------
    private static final String USGS_REQUEST_URL = "http://dif.indraazimi.com/data.json";
    private static final int DATA_LOADER_ID = 1;
    private WordAdapter mAdapter;
    private TextView mEmptyStateTextView;
    // ---------------------------------------------------------------------------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        listViews = (ListView) findViewById(R.id.list_isi);


        // -----------------------------------------------------------------------------------------
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        listViews.setEmptyView(mEmptyStateTextView);
        mAdapter = new WordAdapter(this, new ArrayList<NewWord>(), R.color.category_ternak);
        listViews.setAdapter(mAdapter);
        // -----------------------------------------------------------------------------------------

        listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View parent, int position, long id) {
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(TernakActivity.this, new ArrayList<NewWord>().get(position).getSuara());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        // -----------------------------------------------------------------------------------------
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE) ;
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(DATA_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
        // -----------------------------------------------------------------------------------------




    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer !=null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public Loader<List<NewWord>> onCreateLoader(int i, Bundle bundle) {
        return new TernakLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewWord>> loader, List<NewWord> newWords) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_earthquake);
        mAdapter.clear();

        if (newWords != null && !newWords.isEmpty()){
            mAdapter.addAll(newWords);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewWord>> loader) {
        mAdapter.clear();
    }
    // ---------------------------------------------------------------------------------------------



}
