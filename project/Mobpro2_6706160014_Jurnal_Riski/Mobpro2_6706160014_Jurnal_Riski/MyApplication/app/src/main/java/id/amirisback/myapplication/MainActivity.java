package id.amirisback.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] cat = {"Chinchilla longhair", "Ras Burmese", "Maine Coon", "Kucing liar Afrika", "Tortoiseshell", "Kucing Calico"};
    String cek = "kosong";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void gonta (View view){
        ImageView stars = findViewById(R.id.bintang);

        if (cek.equals("full")){
            stars.setImageResource(R.drawable.starkosong);
            cek = "kosong";
        } else if (cek.equals("kosong")){
            stars.setImageResource(R.drawable.starfull);
            cek = "full";
        }
    }
    public void right(View view) {
        kanan();
    }

    public void left(View view) {
        kiri();
    }


    public void kanan() {
        ImageView gmbkuc = findViewById(R.id.kucing);
        TextView namakuc = findViewById(R.id.namakucing);
        if (namakuc.getText().equals(cat[0])) {
            gmbkuc.setImageResource(R.drawable.burmese);
            namakuc.setText(cat[1]);
        } else if (namakuc.getText().equals(cat[1])) {
            gmbkuc.setImageResource(R.drawable.mainecoon);
            namakuc.setText(cat[2]);
        } else if (namakuc.getText().equals(cat[2])) {
            gmbkuc.setImageResource(R.drawable.african);
            namakuc.setText(cat[3]);
        } else if (namakuc.getText().equals(cat[3])) {
            gmbkuc.setImageResource(R.drawable.tortoiseshell);
            namakuc.setText(cat[4]);
        } else if (namakuc.getText().equals(cat[4])) {
            namakuc.setText(cat[5]);
            gmbkuc.setImageResource(R.drawable.calico);
        }
    }

    public void kiri() {
        ImageView gmbkuc = findViewById(R.id.kucing);
        TextView namakuc = findViewById(R.id.namakucing);
        if (namakuc.getText().equals(cat[5])) {
            gmbkuc.setImageResource(R.drawable.tortoiseshell);
            namakuc.setText(cat[4]);
        } else if (namakuc.getText().equals(cat[4])) {
            namakuc.setText(cat[3]);
            gmbkuc.setImageResource(R.drawable.african);
        } else if (namakuc.getText().equals(cat[3])) {
            namakuc.setText(cat[2]);
            gmbkuc.setImageResource(R.drawable.mainecoon);
        } else if (namakuc.getText().equals(cat[2])) {
            namakuc.setText(cat[1]);
            gmbkuc.setImageResource(R.drawable.burmese);
        } else if (namakuc.getText().equals(cat[1])) {
            namakuc.setText(cat[0]);
            gmbkuc.setImageResource(R.drawable.kucing);
        }
    }


}
