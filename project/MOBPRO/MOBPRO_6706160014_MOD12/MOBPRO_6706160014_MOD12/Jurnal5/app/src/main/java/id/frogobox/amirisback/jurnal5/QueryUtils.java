package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Praktikan on 12/04/2018.
 */

public class QueryUtils {
    private static final String SAMPLE_JSON_RESPONSE = "{\"ternak\": [{\"nama\": \"Angsa\", \"latin\": \"Cygnus olor\"}, {\"nama\": \"Ayam\", \"latin\": \"Gallus gallus\"}, {\"nama\": \"Bebek\", \"latin\": \"Cairina moschata\"}, {\"nama\": \"Domba\", \"latin\": \"Ovis ammon\"}, {\"nama\": \"Kalkun\", \"latin\": \"Meleagris gallopavo\"}, {\"nama\": \"Kambing\", \"latin\": \"Capricornis sumatrensis\"}, {\"nama\": \"Kelinci\", \"latin\": \"Oryctolagus cuniculus\"}, {\"nama\": \"Kerbau\", \"latin\": \"Bubalus bubalis\"}, {\"nama\": \"Kuda\", \"latin\": \"Equus caballus\"}, {\"nama\": \"Sapi\", \"latin\": \"Bos taurus\"}], \"laut\": [{\"nama\": \"Anjing Laut\", \"latin\": \"Monachus monachus\"}, {\"nama\": \"Beruang Laut\", \"latin\": \"Ursus maritimus\"}, {\"nama\": \"Gurita\", \"latin\": \"Octopus vulgaris\"}, {\"nama\": \"Hiu\", \"latin\": \"Prionace glauca\"}, {\"nama\": \"Kepiting\", \"latin\": \"Scyda serrata\"}, {\"nama\": \"Kerang\", \"latin\": \"Pinctada maxima\"}, {\"nama\": \"Kuda Laut\", \"latin\": \"Hippocampus sp.\"}, {\"nama\": \"Lumba-Lumba\", \"latin\": \"Delphinus capensis\"}, {\"nama\": \"Paus\", \"latin\": \"Balaenoptera musculus\"}, {\"nama\": \"Penyu\", \"latin\": \"Chelonia midas\"}], \"hutan\": [{\"nama\": \"Berang-Berang\", \"latin\": \"Lutra sumatrana\"}, {\"nama\": \"Katak\", \"latin\": \"Rana macrodon\"}, {\"nama\": \"Koala\", \"latin\": \"Phascolartus cinereus\"}, {\"nama\": \"Kudanil\", \"latin\": \"Hippotamus amphibius\"}, {\"nama\": \"Laba-Laba\", \"latin\": \"Heteropoda venatoria\"}, {\"nama\": \"Landak\", \"latin\": \"Hystrix brachyura\"}, {\"nama\": \"Monyet\", \"latin\": \"Macaca fascicularis\"}, {\"nama\": \"Rakun\", \"latin\": \"Proyon lotor\"}, {\"nama\": \"Rubah\", \"latin\": \"Vulpes vulpes\"}, {\"nama\": \"Tupai\", \"latin\": \"Tupaia javanica\"}], \"langka\": [{\"nama\": \"Anoa\", \"latin\": \"Anoa depressicornis\"}, {\"nama\": \"Bekantan\", \"latin\": \"Nasalis larvatus\"}, {\"nama\": \"Jalak Bali\", \"latin\": \"Leucopsar rotschildi\"}, {\"nama\": \"Enggang Gading\", \"latin\": \"Rhinoplax vigil\"}, {\"nama\": \"Maleo Senkawor\", \"latin\": \"Macrocephalon maleo\"}, {\"nama\": \"Mandar Dengkur\", \"latin\": \"Aramidopsis plateni\"}, {\"nama\": \"Mentilin\", \"latin\": \"Tarsius bancanus\"}, {\"nama\": \"Pesut Mahakam\", \"latin\": \"Orcaella brevirostris\"}, {\"nama\": \"Rusa Timor\", \"latin\": \"Cervus timorensis\"}, {\"nama\": \"Tangkasi\", \"latin\": \"Tarsius tarsier\"}]}";
    private Context context;

    QueryUtils(Context context) {
        this.context = context;
    }

    private int getDrawableId(String name) {
        name = name.toLowerCase().replace("-", "_");
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }

    private int getRawId(String name) {
        name = name.toLowerCase().replace("-", "_");
        return context.getResources().getIdentifier(name, "raw", context.getPackageName());
    }

    public ArrayList<NewWord> extractTernak() {
        ArrayList<NewWord> arrayListTernak = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray ternakArray = baseJsonResponse.getJSONArray("ternak");
            for (int i = 0; i < ternakArray.length(); i++) {
                JSONObject currentTernak = ternakArray.getJSONObject(i);
                // ---------------------------------------------------------------------------------
                String hewan = currentTernak.getString("nama");
                String inggris = currentTernak.getString("latin");
                int foto = getDrawableId(hewan);
                int suara = getRawId(hewan);
                // ---------------------------------------------------------------------------------
                NewWord word = new NewWord(foto, hewan, inggris, suara);
                arrayListTernak.add(word);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return arrayListTernak;
    }

    public ArrayList<NewWord> extractHutan() {
        ArrayList<NewWord> arrayListHutan = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray hutanArray = baseJsonResponse.getJSONArray("hutan");
            for (int i = 0; i < hutanArray.length(); i++) {
                JSONObject currentTernak = hutanArray.getJSONObject(i);
                // ---------------------------------------------------------------------------------
                String hewan = currentTernak.getString("nama");
                String inggris = currentTernak.getString("latin");
                int foto = getDrawableId(hewan);
                int suara = getRawId(hewan);
                // ---------------------------------------------------------------------------------
                NewWord word = new NewWord(foto, hewan, inggris, suara);
                arrayListHutan.add(word);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return arrayListHutan;
    }

    public ArrayList<NewWord> extractLaut() {
        ArrayList<NewWord> arrayListLaut = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray lautArray = baseJsonResponse.getJSONArray("laut");
            for (int i = 0; i < lautArray.length(); i++) {
                JSONObject currentTernak = lautArray.getJSONObject(i);
                // ---------------------------------------------------------------------------------
                String hewan = currentTernak.getString("nama");
                String inggris = currentTernak.getString("latin");
                int foto = getDrawableId(hewan);
                int suara = getRawId(hewan);
                // ---------------------------------------------------------------------------------
                NewWord word = new NewWord(foto, hewan, inggris, suara);
                arrayListLaut.add(word);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return arrayListLaut;
    }

    public ArrayList<NewWord> extractLangka() {
        ArrayList<NewWord> arrayListLangka = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray langkaArray = baseJsonResponse.getJSONArray("langka");
            for (int i = 0; i < langkaArray.length(); i++) {
                JSONObject currentTernak = langkaArray.getJSONObject(i);
                // ---------------------------------------------------------------------------------
                String hewan = currentTernak.getString("nama");
                String inggris = currentTernak.getString("latin");
                int suara = getRawId(hewan);
                // ---------------------------------------------------------------------------------
                NewWord word = new NewWord(hewan, inggris, suara);
                arrayListLangka.add(word);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return arrayListLangka;
    }




}