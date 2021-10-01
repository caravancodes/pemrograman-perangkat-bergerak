package id.frogobox.amirisback.jurnal5;

/**
 * Created by Praktikan on 22/02/2018.
 */

public class NewWord {
    private static final int NO_IMAGE_PROVIDE = -1;
    private int foto = NO_IMAGE_PROVIDE;
    private String hewan, inggris;

    public NewWord(int foto, String hewan, String inggris) {
        this.foto = foto;
        this.hewan = hewan;
        this.inggris = inggris;
    }

    public NewWord(String hewan, String inggris) {
        this.hewan = hewan;
        this.inggris = inggris;
    }

    public int getFoto() {
        return foto;
    }

    public String getHewan() {
        return hewan;
    }

    public String getInggris() {
        return inggris;
    }

    public boolean hasImage(){
        return foto != NO_IMAGE_PROVIDE;
    }
}
