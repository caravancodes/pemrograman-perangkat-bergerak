package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class HutanActivity extends AppCompatActivity {

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
    private String gmb[] = {"berang", "katak", "koala", "kudanil", "laba", "landak", "monyet", "rakun", "rubah", "tupai"};
    private String hewans[] = {"Berang-Berang","Katak","Koala","Kudanil","Laba-Laba","Landak","Monyet","Rakun","Rubah","Tupai"};
    private String english[] = {"Lutra sumatrana","Rana macrodon","Phascolartus cinereus","Hippotamus amphibius","Heteropoda venatoria","Hystrix brachyura", "Macaca fascicularis","Proyon lotor","Vulpes vulpes","Tupaia javanica"};
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_activity);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        listViews = (ListView)findViewById(R.id.list_isi);

        final ArrayList<NewWord> arrayWords = new QueryUtils(this).extractHutan();

//        final ArrayList<NewWord> arrayWords = new ArrayList<>();
//        for (int i = 0 ; i < hewans.length ; i++) {
//            resIdSuara = getResources().getIdentifier(gmb[i], "raw", getPackageName());
//            resId = getResources().getIdentifier(gmb[i], "drawable", getPackageName());
//            arrayWords.add(new NewWord(resId, hewans[i], english[i], resIdSuara));
//        }
        WordAdapter call = new WordAdapter(this, arrayWords, R.color.category_hutan);
        listViews.setAdapter(call);
        listViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View parent, int position, long id) {
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(HutanActivity.this, arrayWords.get(position).getSuara());
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
