package li.uni.flmuseum;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by goran.tomas on 07.11.2016.
 */

public class CheckAnswer {

   Context context;
   RadioButton rb1, rb2, rb3, rb4;
   boolean returnValue = false;
   Activity mainActivity;
   EditText editText;

   public void CheckAnswer(){

   }

   private void findButtons(Activity activity){

      rb1 = (RadioButton) activity.findViewById(R.id.rB1);
      rb2 = (RadioButton) activity.findViewById(R.id.rB1);
      rb3 = (RadioButton) activity.findViewById(R.id.rB1);
      rb4 = (RadioButton) activity.findViewById(R.id.rB1);
   }

   private void findVariables(Activity activity){
      editText = (EditText) activity.findViewById(R.id.editText);
   }

   public boolean getChoosedAnswer(Activity activity, int QuestionNr){
      findButtons(activity);
      switch(QuestionNr)
      {
         case 1:
            if(rb1.isChecked())
               returnValue = true;
            break;
         case 2:
            if(rb1.isChecked())
               returnValue = true;
            break;
         case 3:
            if(rb1.isChecked())
               returnValue = true;
            break;
         case 4:
            if(rb1.isChecked())
               returnValue = true;
            break;
         case 5:
            if(rb1.isChecked())
               returnValue = true;
            break;
         default:
            returnValue = false;
            break;
      }
      return returnValue;

   }

   public boolean getTypedAnswer(Activity activity, int QuestionNr){
      findVariables(activity);
      String typedText = editText.getText().toString().trim().toLowerCase();


      return returnValue;
   }

}
