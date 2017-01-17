package li.uni.flmuseum;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by jaha on 02.11.2016.
 */

public class StartActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TextWatcher, View.OnFocusChangeListener {

   private Button buttonStart, buttonNext;
   private RadioButton radioButtonMale, radioButtonFemale;
   private EditText editTextName;
   private int state = -1;
   private String name;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setStartVariables();

   }

   private void setStartVariables(){
      setContentView(R.layout.start);
      buttonStart = (Button) findViewById(R.id.button_start);
      buttonStart.setOnClickListener(this);
      radioButtonMale = (RadioButton) findViewById(R.id.checkBoxMale);
      radioButtonMale.setOnCheckedChangeListener(this);
      radioButtonFemale = (RadioButton) findViewById(R.id.checkBoxFemale);
      radioButtonFemale.setOnCheckedChangeListener(this);
      editTextName = (EditText) findViewById(R.id.editTextName);
      editTextName.setOnFocusChangeListener(this);
      state = 0;
   }

   private void setWelcomeScreen(){
      //setContentView mit Schriftrolle und text
      // willkommenstext mit namen
      // button für weiter
      setContentView(R.layout.act_route);
      buttonNext = (Button) findViewById(R.id.routeNext);
      buttonNext.setOnClickListener(this);
      TextView textView = (TextView) findViewById(R.id.textView4);
      textView.setText(getString(R.string.welcome1) + " " + name + "!\n\n" + getString(R.string.welcome2));
      state = 1;

   }

   public void onClick(View view){
      // zuerst noch willkommenstext anzeigen und dann das Spiel starten
      if(state == 0)
      {
         name = editTextName.getText().toString();
         setWelcomeScreen();
      }
      else
      {
         Intent intent = new Intent(StartActivity.this, MainActivity.class);
         startActivity(intent);
      }
   }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
      switch(buttonView.getId())
      {
         case R.id.checkBoxFemale:
            if(isChecked)
            {
               editTextName.requestFocus();
               editTextName.addTextChangedListener(this);
            }
            break;
         case R.id.checkBoxMale:
            if(isChecked)
            {
               editTextName.requestFocus();
               editTextName.addTextChangedListener(this);
            }
            break;
         default:
            break;
      }
   }

   public void onTextChanged(CharSequence s, int start, int before, int count){
      buttonStart.setVisibility(View.VISIBLE);
   }

   public void beforeTextChanged(CharSequence s, int start, int count, int after){

   }

   public void afterTextChanged(Editable s){

   }

   public void onFocusChange(View v, boolean hasFocus){
      InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
      if(editTextName.hasFocus())
      {
         imm.showSoftInput(v, 0);
      }
      else
      {
         imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
      }
   }

}
