package li.uni.flmuseum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

   SharedPreferences settings;
   SharedPreferences.Editor editor;
   ArrayList<Boolean> mainQuestion, subQuestion;
   int curQuestion = -1;
   Button routeNext, mainquestNext, subquestNext;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_route);

      settings = getApplicationContext().getSharedPreferences("mySettings", MODE_PRIVATE);
      editor = settings.edit();

      mainQuestion = new ArrayList<Boolean>();
      subQuestion = new ArrayList<Boolean>();

      routeNext = (Button) findViewById(R.id.routeNext);
      routeNext.setOnClickListener(this);
      curQuestion = 10;
      routeNext.setText("next" + curQuestion);
   }

   //   public void checkFragen(View view){
   //      Button button = (Button) findViewById(R.id.btoCheckFragen);
   //      button.setText(getString(R.string.st1));
   //      editor.putBoolean("b1",true);
   //      editor.apply();
   //
   //      boolean bb = settings.getBoolean("b1",false);
   //
   //     // button.invalidate();
   //      Intent myIntent = new Intent(this, Results.class);
   //      startActivity(myIntent);
   //
   //   }

   private void switchRoute(int route){
      switch(route)
      {
         case 0:
            setContentView(R.layout.act_route);

            break;
         case 10:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + route);
            break;
         case 20:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + route);
            curQuestion = 20;
            break;
         case 30:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + route);
            curQuestion = 30;
            break;
         case 40:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + route);
            curQuestion = 40;
            break;
         case 50:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + route);
            curQuestion = 50;
            break;
         case 60:
            //setContentView(R.layout.act_route);
            // fertig?
            // results aufrufen?
            showResult();
            break;

         default:
            break;
      }

   }

   private void switchQuestion(int question){
      switch(question)
      {
         case 10:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 10;
            mainquestNext = (Button) findViewById(R.id.mainQuestNext);
            mainquestNext.setOnClickListener(this);
            mainquestNext.setText("main" + question);
            break;
         case 11:
            setContentView(R.layout.act_subquestion);
            curQuestion = 11;
            subquestNext = (Button) findViewById(R.id.subQuestNext);
            subquestNext.setOnClickListener(this);
            subquestNext.setText("sub" + question);
            break;
         case 20:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 20;
            mainquestNext = (Button) findViewById(R.id.mainQuestNext);
            mainquestNext.setOnClickListener(this);
            mainquestNext.setText("main" + question);
            break;
         case 21:
            setContentView(R.layout.act_subquestion);
            curQuestion = 21;
            subquestNext = (Button) findViewById(R.id.subQuestNext);
            subquestNext.setOnClickListener(this);
            subquestNext.setText("sub" + question);
            break;
         case 30:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 30;
            mainquestNext = (Button) findViewById(R.id.mainQuestNext);
            mainquestNext.setOnClickListener(this);
            mainquestNext.setText("main" + question);
            break;
         case 31:
            setContentView(R.layout.act_subquestion);
            curQuestion = 31;
            subquestNext = (Button) findViewById(R.id.subQuestNext);
            subquestNext.setOnClickListener(this);
            subquestNext.setText("sub" + question);
            break;
         case 40:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 40;
            mainquestNext = (Button) findViewById(R.id.mainQuestNext);
            mainquestNext.setOnClickListener(this);
            mainquestNext.setText("main" + question);
            break;
         case 41:
            setContentView(R.layout.act_subquestion);
            curQuestion = 41;
            subquestNext = (Button) findViewById(R.id.subQuestNext);
            subquestNext.setOnClickListener(this);
            subquestNext.setText("sub" + question);
            break;
         case 50:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 50;
            mainquestNext = (Button) findViewById(R.id.mainQuestNext);
            mainquestNext.setOnClickListener(this);
            mainquestNext.setText("main" + question);
            break;
         case 51:
            setContentView(R.layout.act_subquestion);
            curQuestion = 51;
            subquestNext = (Button) findViewById(R.id.subQuestNext);
            subquestNext.setOnClickListener(this);
            subquestNext.setText("sub" + question);
            break;

         default:
            break;
      }

   }

   private void showResult(){

      Intent myIntent = new Intent(this, Results.class);

      startActivity(myIntent);
      Results results = new Results();
      results.setArrays(mainQuestion, subQuestion);
   }

   public void onClick(View view){

      switch(view.getId())
      {

         case R.id.mainQuestNext:
         /*
         beim beantworten der Frage wird überprüft ob die Antwort richtig ist.
         Wenn "ja" dann wird der MainQuestion boolean auf true gesetzt und die SubQuestion wird angezeigt.
         Ist auch diese richtig, wird der SubQuestion boolean auf true gesetzt und die nächste Route angezeigt
          */
            checkAnswer(curQuestion);
            break;

         case R.id.subQuestNext:
            checkAnswer(curQuestion);
            break;

         case R.id.routeNext:
            switchQuestion(curQuestion);
            break;

         default:
            break;
      }

   }

   private void checkAnswer(int currentQuestion){
      switch(currentQuestion)
      {
         case 10:
            //if radiobutton(1).checked
            mainQuestion.add(0, true);
            //else set false
            switchQuestion(11);
            break;
         case 11:
            subQuestion.add(0, false);
            switchRoute(20);
            break;
         case 20:
            mainQuestion.add(1, true);
            switchQuestion(21);
            break;
         case 21:
            subQuestion.add(1, false);
            switchRoute(30);
            break;
         case 30:
            mainQuestion.add(2, true);
            switchQuestion(31);
            break;
         case 31:
            subQuestion.add(2, false);
            switchRoute(40);
            break;
         case 40:
            mainQuestion.add(3, true);
            switchQuestion(41);
            break;
         case 41:
            subQuestion.add(3, false);
            switchRoute(50);
            break;
         case 50:
            mainQuestion.add(4, true);
            switchQuestion(51);
            break;
         case 51:
            subQuestion.add(4, false);
            switchRoute(60);
            break;

         default:
            break;
      }

   }

}
