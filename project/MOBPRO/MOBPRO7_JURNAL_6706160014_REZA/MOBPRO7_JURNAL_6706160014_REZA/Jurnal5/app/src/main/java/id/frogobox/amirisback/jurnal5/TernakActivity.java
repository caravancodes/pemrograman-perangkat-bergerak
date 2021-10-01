package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TernakActivity extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        listViews = (ListView) findViewById(R.id.list_isi);

        final ArrayList<NewWord> arrayWords = new ArrayList<>();

        for (int i = 0; i < hewans.length; i++) {
            resIdSuara = getResources().getIdentifier(hewans[i].toLowerCase(), "raw", getPackageName());
            resId = getResources().getIdentifier(hewans[i].toLowerCase(), "drawable", getPackageName());
            arrayWords.add(new NewWord(resId, hewans[i], english[i], resIdSuara));
        }

        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_ternak);
        listViews.setAdapter(call);
        listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View parent, int position, long id) {
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(TernakActivity.this, arrayWords.get(position).getSuara());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
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
}
