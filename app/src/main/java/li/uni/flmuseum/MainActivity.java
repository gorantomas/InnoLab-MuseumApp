package li.uni.flmuseum;

import android.content.Intent;

import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;

import android.widget.Button;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   SharedPreferences settings;
   SharedPreferences.Editor editor;


   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      settings = getApplicationContext().getSharedPreferences("mySettings", MODE_PRIVATE);
      editor = settings.edit();

   }


   public void checkFragen(View view){
      Button button = (Button) findViewById(R.id.btoCheckFragen);
      button.setText(getString(R.string.st1));
      editor.putBoolean("b1",true);
      editor.apply();

      boolean bb = settings.getBoolean("b1",false);

     // button.invalidate();
      Intent myIntent = new Intent(this, Results.class);
      startActivity(myIntent);

   }



}
