package edu.neu.madcourse.numad21su_emilycolladay;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WebService extends AppCompatActivity {
    String url;
    private TextView showDef;
    private EditText enterWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);

    }

    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = enterWord.getText().toString();
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }

    public void sendRequestOnClick(View v){
        DictionaryGame game = new DictionaryGame(this, showDef);
        url = dictionaryEntries();
        game.execute(url);

}

}
