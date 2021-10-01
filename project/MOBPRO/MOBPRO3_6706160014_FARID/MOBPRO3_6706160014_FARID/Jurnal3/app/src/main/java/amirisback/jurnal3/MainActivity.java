package amirisback.jurnal3;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int nilaiPraktikum, nilaiAssesment1, temp, cvisible=0, nilaiAssesment2;
    String index;
    double nilaiAkhir=0;
    EditText txt_nama, txt_nilaiPraktikum, txt_nilaiAssessment1, txt_nilaiAssessment2;
    TextView txt_nilaiAkhir, txt_index, txt_info;
    RadioButton rb;
    RadioGroup rg;
    ImageView image;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nama = (EditText) findViewById(R.id.id_edt_nama);
        txt_nilaiPraktikum = (EditText) findViewById(R.id.id_edt_praktikum);
        txt_nilaiAssessment1 = (EditText) findViewById(R.id.id_edt_ass1);
        txt_nilaiAssessment2 = (EditText) findViewById(R.id.id_edt_ass2);
        image = (ImageView) findViewById(R.id.id_img_emoticon);
        txt_nilaiAkhir = (TextView) findViewById(R.id.id_txt_nilaiAkhir);
        txt_index = (TextView) findViewById(R.id.id_txt_index);
        txt_info = (TextView) findViewById(R.id.id_txt_info);
        visible();
    }

    public void visible(){
        if(cvisible==0){
            txt_index.setVisibility(View.INVISIBLE);
            image.setVisibility(View.INVISIBLE);
            txt_nilaiAkhir.setVisibility(View.INVISIBLE);
            txt_info.setVisibility(View.INVISIBLE);
        }else{
            txt_index.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
            txt_nilaiAkhir.setVisibility(View.VISIBLE);
            txt_info.setVisibility(View.VISIBLE);
        }
    }

    public void RadioClik (View View){
        nilaiPraktikum = Integer.parseInt(txt_nilaiPraktikum.getText().toString());
        nilaiAssesment1 = Integer.parseInt(txt_nilaiAssessment1.getText().toString());
        nilaiAssesment2 = Integer.parseInt(txt_nilaiAssessment2.getText().toString());
        checked = ((RadioButton)View).isChecked();
        switch (View.getId()){
            case R.id.id_radioYa :
                if (checked) {
                    temp=nilaiAssesment2;
                } break;
            case R.id.id_radioTidak :
                if (checked) {
                    temp=0;
                } break;
        }
    }

    public void hitung (View view) {
        indexing();
        txt_nilaiAkhir.setText("Nilai Akhir : " + nilaiAkhir);
        txt_index.setText(index);
        cvisible++;
        visible();
    }

    public void reset (View view){
        txt_nama.setText("");
        txt_nilaiPraktikum.setText("");
        txt_nilaiAssessment1.setText("");
        txt_nilaiAssessment2.setText("");
        cvisible=0;
        visible();
    }

    public void indexing(){
        nilaiAkhir = (0.3 * nilaiPraktikum) + (0.3 * nilaiAssesment1) + (0.4 * temp);
        if (nilaiAkhir >= 0 && nilaiAkhir <= 100) {
            if (80.01 <= nilaiAkhir && nilaiAkhir <= 100.00) {
                index = "A";
            } else if (70.01 <= nilaiAkhir && nilaiAkhir <= 80.00) {
                index = "AB";
            } else if (65.01 <= nilaiAkhir && nilaiAkhir <= 70.00) {
                index = "B";
            } else if (60.01 <= nilaiAkhir && nilaiAkhir <= 65.00) {
                index = "BC";
            } else if (50.01 <= nilaiAkhir && nilaiAkhir <= 60.00) {
                index = "C";
            } else if (40.01 <= nilaiAkhir && nilaiAkhir <= 50.00) {
                index = "D";
                image.setImageResource(R.drawable.bad);
                txt_index.setTextColor(Color.parseColor("#FF4081"));
            } else if (0.00 <= nilaiAkhir && nilaiAkhir <= 40.00) {
                index = "E";
                txt_index.setTextColor(Color.parseColor("#FF4081"));
                image.setImageResource(R.drawable.bad);
            }
        } else {
            Toast t = Toast.makeText(getApplicationContext(), "isian tidak valid", Toast.LENGTH_SHORT);
            t.show();
        }
    }

    public void mail (View view){
        String nams = txt_nama.getText().toString();
        rg = (RadioGroup) findViewById(R.id.id_radio_group);
        int button = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(button);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        String values = "Nilai Praktikum : " + nilaiPraktikum + "" +
                "\nNilai Assesment 1 : " + nilaiAssesment1 + "" +
                "\nNilai Assesment 2 : " + nilaiAssesment2 + "" +
                "\nAbsensi >= 75% " + rb.getText().toString() + "" +
                "\n\nNilai Akhir : " +nilaiAkhir+" ("+index+")";
        String [] dnu = {"f.miir117@gmail.com", "f.miir117@gmail.com"};
        intent.putExtra(intent.EXTRA_EMAIL, dnu);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Nilai Mobpro " +nams);
        intent.putExtra(Intent.EXTRA_TEXT, values);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }








}
