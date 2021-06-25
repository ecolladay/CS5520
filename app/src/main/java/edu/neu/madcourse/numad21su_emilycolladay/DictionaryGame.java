package edu.neu.madcourse.numad21su_emilycolladay;


import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DictionaryGame extends AsyncTask<String, Integer, String>  {

    Context context;
    TextView showDef;

    DictionaryGame(Context context, TextView t){
        this.context = context;
        showDef = t;
    }


    @Override
    protected String doInBackground(String... params) {
        final String app_id = "26bfb20e";
        final String app_key = "5b7f17b34d276c9a726c53ede1386301";

        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        String def;
        try {
            JSONObject js = new JSONObject(result);
            JSONArray results = js.getJSONArray("results");
            JSONObject lEntries = results.getJSONObject(0);
            JSONArray laArray = lEntries.getJSONArray("lexicalEntries");
            JSONObject entries = laArray.getJSONObject(0);
            JSONArray e = entries.getJSONArray("entries");
            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");
            JSONObject de = sensesArray.getJSONObject(0);
            JSONArray d = de.getJSONArray("definitions");
            def = d.getString(0);
            //showDef.setText(def);
            callDialog(def);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.v("Result of Dictionary", "onPostExecute" + result);
    }

    private void callDialog(String def){
        Dialog popup = new Dialog(context);
        popup.setContentView(R.layout.definition_popup);

        Button cancel = popup.findViewById(R.id.buttonCancel);
        TextView definition = popup.findViewById(R.id.definitionText);
        definition.setText(def);
        popup.show();
        cancel.setOnClickListener(v -> popup.cancel());


    }

}
