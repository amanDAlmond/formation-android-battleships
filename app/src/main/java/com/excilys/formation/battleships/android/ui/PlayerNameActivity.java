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
        setContentView(R.layout.activity_player_name);
        mPlayerNameInput = (EditText) findViewById(R.id.player_name_input);
    }

    public void onClickButton(View v) {
        String name = mPlayerNameInput.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(PlayerNameActivity.this, "Veuillez entrer un nom.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(PlayerNameActivity.this, "Bienvenu, " + name + " !", Toast.LENGTH_LONG).show();
            BattleShipsApplication.getGame().init(name);
        }
    }
}
