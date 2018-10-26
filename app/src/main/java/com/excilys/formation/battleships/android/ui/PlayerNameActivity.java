package com.excilys.formation.battleships.android.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.view.View;

import battleships.formation.excilys.com.battleships.R;

public class PlayerNameActivity extends AppCompatActivity {

    private EditText mPlayerNameInput;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getApplicationContext().getSharedPreferences("Pref", MODE_PRIVATE);
        String lastPlayer = preferences.getString("lastPlayer",null);

        setContentView(R.layout.activity_player_name);
        mPlayerNameInput = (EditText) findViewById(R.id.player_name_input);
        mPlayerNameInput.setText(lastPlayer);
    }

    public void onClickButton(View v) {
        String name = mPlayerNameInput.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(PlayerNameActivity.this, "Veuillez entrer un nom.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(PlayerNameActivity.this, "Bienvenue, " + name + " !", Toast.LENGTH_LONG).show();
            preferences.edit().putString("lastPlayer", name).apply();
            BattleShipsApplication.getGame().init(name);
        }
    }
}
