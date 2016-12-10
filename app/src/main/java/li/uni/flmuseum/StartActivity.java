package li.uni.flmuseum;

import android.app.Activity;
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

/**
 * Created by jaha on 02.11.2016.
 */

public class StartActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TextWatcher, View.OnFocusChangeListener {

   private Button buttonStart;
   private RadioButton radioButtonMale, radioButtonFemale;
   private EditText editTextName;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.start);
      buttonStart = (Button) findViewById(R.id.button_start);
      buttonStart.setOnClickListener(this);
      radioButtonMale = (RadioButton) findViewById(R.id.checkBoxMale);
      radioButtonMale.setOnCheckedChangeListener(this);
      radioButtonFemale = (RadioButton) findViewById(R.id.checkBoxFemale);
      radioButtonFemale.setOnCheckedChangeListener(this);
      editTextName = (EditText) findViewById(R.id.editTextName);
      editTextName.setOnFocusChangeListener(this);

   }

   public void onClick(View view){
      Intent intent = new Intent(StartActivity.this, MainActivity.class);
      startActivity(intent);
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
      InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
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
