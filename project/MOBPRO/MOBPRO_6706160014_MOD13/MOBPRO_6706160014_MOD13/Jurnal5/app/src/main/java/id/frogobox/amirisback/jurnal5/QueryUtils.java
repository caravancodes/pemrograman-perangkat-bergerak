package id.frogobox.amirisback.jurnal5;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Praktikan on 12/04/2018.
 */

public class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private static Context mContext;

    public QueryUtils(Context context) {
        this.mContext = context;
    }

    private static int getDrawableId(String name) {
        name = name.toLowerCase().replace("-", "_");
        return mContext.getResources().getIdentifier(name, "drawable", mContext.getPackageName());
    }

    private static int getRawId(String name) {
        name = name.toLowerCase().replace("-", "_");
        return mContext.getResources().getIdentifier(name, "raw", mContext.getPackageName());
    }

    private static List<NewWord> extractTernakFromJson(String JSON) {
        if (TextUtils.isEmpty(JSON)) {
            return null;
        }
        List<NewWord> arrayListTernak = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(JSON);
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

    private static List<NewWord> extractHutanFromJson(String JSON) {
        if (TextUtils.isEmpty(JSON)) {
            return null;
        }
        List<NewWord> arrayListHutan = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(JSON);
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

    private static List<NewWord> extractLautFromJson(String JSON) {
        if (TextUtils.isEmpty(JSON)) {
            return null;
        }
        List<NewWord> arrayListLaut = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(JSON);
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

    private static List<NewWord> extractLangkaFromJson(String JSON) {
        if (TextUtils.isEmpty(JSON)) {
            return null;
        }
        List<NewWord> arrayListLangka = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(JSON);
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


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }


    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {

            // -------------------------------------------------------------------------------------
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // -------------------------------------------------------------------------------------

            // -------------------------------------------------------------------------------------
            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " +
                        urlConnection.getResponseCode());
            }
            // -------------------------------------------------------------------------------------
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            // -------------------------------------------------------------------------------------
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            // -------------------------------------------------------------------------------------

            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<NewWord> fetchTernakData(String requestUrl) {
        // Create URL object
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<NewWord> words = extractTernakFromJson(jsonResponse);
        return words;
    }


    public static List<NewWord> fetchLangkaData(String requestUrl) {
        // Create URL object
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<NewWord> words = extractLangkaFromJson(jsonResponse);
        return words;
    }

    public static List<NewWord> fetchLautData(String requestUrl) {
        // Create URL object
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<NewWord> words = extractLautFromJson(jsonResponse);
        return words;
    }

    public static List<NewWord> fetchHutanData(String requestUrl) {
        // Create URL object
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        URL url = createUrl(requestUrl);
        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<NewWord> words = extractHutanFromJson(jsonResponse);
        return words;
    }



}