package com.example.hp.chesstimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
//        Toast.makeText(getApplicationContext(),"Exception hai boss : ", Toast.LENGTH_LONG).show();
        try {
            Intent i = new Intent(this, Playing.class);
            EditText clock_time = (EditText) findViewById(R.id.et1);
//            EditText player1 = (EditText) findViewById(R.id.player1);
//            EditText player2 = (EditText) findViewById(R.id.player2);
            i.putExtra("clock", clock_time.getText().toString());
//            i.putExtra("p1", player1.getText().toString());
//            i.putExtra("p2", player2.getText().toString());
            startActivity(i);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Exception hai boss : "+e,Toast.LENGTH_LONG).show();
        }
    }
}
