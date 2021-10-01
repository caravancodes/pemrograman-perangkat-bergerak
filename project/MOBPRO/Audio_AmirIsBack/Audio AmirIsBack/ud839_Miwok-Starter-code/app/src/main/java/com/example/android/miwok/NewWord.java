package com.example.android.miwok;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class NewWord {


    private int fotos = NO_IMAGE_PROVIDE;
    private String nMiwok, nEnglish;
    private static final int NO_IMAGE_PROVIDE = -1;
    private int audioId;

    public NewWord(int fotos, String nMiwok, String nEnglish, int audioId) {
        this.fotos = fotos;
        this.nMiwok = nMiwok;
        this.nEnglish = nEnglish;
        this.audioId = audioId;
    }

    public NewWord(String nMiwok, String nEnglish, int audioId) {
        this.nMiwok = nMiwok;
        this.nEnglish = nEnglish;
        this.audioId = audioId;
    }

    public int getFotos() {
        return fotos;
    }

    public String getnMiwok() {
        return nMiwok;
    }

    public String getnEnglish() {
        return nEnglish;
    }

    public int getAudioId() {
        return audioId;
    }

    public Boolean hasImage(){
        return fotos != NO_IMAGE_PROVIDE;
    }
}
