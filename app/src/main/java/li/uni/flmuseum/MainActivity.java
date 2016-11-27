package li.uni.flmuseum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

   SharedPreferences settings;
   SharedPreferences.Editor editor;
   ArrayList<Boolean> mainQuestion, subQuestion;
   boolean[] b_mainQuestion, b_subQuestion;
   int curQuestion = -1;
   int questionCounter = 0;
   Button routeNext, mainquestNext, subquestNext;
   RadioButton[] radioButtons;
   String[] mainQuestAnswers;
   TextView tv_mainQuest, tv_subQuest;
   CheckAnswer checkAnswer;
   Resources res;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_route);

      settings = getApplicationContext().getSharedPreferences("mySettings", MODE_PRIVATE);
      editor = settings.edit();

      checkAnswer = new CheckAnswer();

      mainQuestion = new ArrayList<Boolean>();
      subQuestion = new ArrayList<Boolean>();
      b_mainQuestion = new boolean[5];
      b_subQuestion = new boolean[5];
      res = getResources();
      routeNext = (Button) findViewById(R.id.routeNext);
      routeNext.setOnClickListener(this);
      curQuestion = 10;
      routeNext.setText("next" + (curQuestion / 10));
      setTitleRoute("1");
   }

   private void switchRoute(int route){
      switch(route)
      {
         case 0:
            setContentView(R.layout.act_route);
            setTitleRoute("1");
            break;
         case 10:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + (route / 10));
            setTitleRoute("1");
            break;
         case 20:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + (route / 10));
            curQuestion = 20;
            setTitleRoute("2");
            break;
         case 30:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + (route / 10));
            curQuestion = 30;
            setTitleRoute("3");
            break;
         case 40:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + (route / 10));
            curQuestion = 40;
            setTitleRoute("4");
            break;
         case 50:
            setContentView(R.layout.act_route);
            routeNext = (Button) findViewById(R.id.routeNext);
            routeNext.setOnClickListener(this);
            routeNext.setText("next" + (route / 10));
            curQuestion = 50;
            setTitleRoute("5");
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
            //set variables
            setMainQuestionVariables();
            mainQuestAnswers = res.getStringArray(R.array.guest1answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(mainQuestAnswers[i].toString());
            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest1));
            break;
         case 11:
            setContentView(R.layout.act_subquestion);
            curQuestion = 11;
            //set variables
            setSubQuestionVariables();
            subquestNext.setText("sub" + question);

            //            tv_subQuest = (TextView) findViewById(R.id.textView2);
            //            tv_subQuest.setText("UnterFrage " + question);
            break;
         case 20:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 20;
            //set variables
            setMainQuestionVariables();
            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(mainQuestAnswers[i].toString());
            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest2));
            break;
         case 21:
            setContentView(R.layout.act_subquestion);
            curQuestion = 21;
            //set variables
            setSubQuestionVariables();
            subquestNext.setText("sub" + question);

            //            tv_subQuest = (TextView) findViewById(R.id.textView2);
            //            tv_subQuest.setText("UnterFrage " + question);
            break;
         case 30:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 30;
            //set variables
            setMainQuestionVariables();
            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(mainQuestAnswers[i].toString());
            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest3));
            break;
         case 31:
            setContentView(R.layout.act_subquestion);
            curQuestion = 31;
            //set variables
            setSubQuestionVariables();
            subquestNext.setText("sub" + question);

            //            tv_subQuest = (TextView) findViewById(R.id.textView2);
            //            tv_subQuest.setText("UnterFrage " + question);
            break;
         case 40:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 40;
            //set variables
            setMainQuestionVariables();
            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(mainQuestAnswers[i].toString());
            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest4));
            break;
         case 41:
            setContentView(R.layout.act_subquestion);
            curQuestion = 41;
            //set variables
            setSubQuestionVariables();
            subquestNext.setText("sub" + question);
            //            tv_subQuest = (TextView) findViewById(R.id.textView2);
            //            tv_subQuest.setText("UnterFrage " + question);
            break;
         case 50:
            setContentView(R.layout.act_mainquestion);
            curQuestion = 50;
            //set variables
            setMainQuestionVariables();
            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(mainQuestAnswers[i].toString());
            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest5));
            break;
         case 51:
            setContentView(R.layout.act_subquestion);
            curQuestion = 51;
            //set variables
            setSubQuestionVariables();
            subquestNext.setText("sub" + question);
            //            tv_subQuest = (TextView) findViewById(R.id.textView2);
            //            tv_subQuest.setText("UnterFrage " + question);
            break;

         default:
            break;
      }
      setTitleQuestion();
   }

   private void showResult(){

      Intent myIntent = new Intent(this, Results.class);
      myIntent.putExtra("main", b_mainQuestion);
      myIntent.putExtra("sub", b_subQuestion);

      startActivity(myIntent);
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
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(0, true);
               b_mainQuestion[0] = true;
            }
            //else set false
            switchQuestion(11);
            break;
         case 11:
            checkAnswer.getTypedAnswer(this, 11);
            subQuestion.add(0, false);
            b_subQuestion[0] = false;
            switchRoute(20);
            break;
         case 20:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(1, true);
               b_mainQuestion[1] = true;
            }
            switchQuestion(21);
            break;
         case 21:
            subQuestion.add(1, false);
            b_subQuestion[1] = true;
            switchRoute(30);
            break;
         case 30:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(2, true);
               b_mainQuestion[2] = true;
            }
            switchQuestion(31);
            break;
         case 31:
            subQuestion.add(2, false);
            b_subQuestion[2] = true;
            switchRoute(40);
            break;
         case 40:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(3, true);
               b_mainQuestion[3] = true;
            }
            switchQuestion(41);
            break;
         case 41:
            subQuestion.add(3, false);
            b_subQuestion[3] = false;
            switchRoute(50);
            break;
         case 50:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(4, true);
               b_mainQuestion[4] = true;
            }
            switchQuestion(51);
            break;
         case 51:
            subQuestion.add(4, false);
            b_subQuestion[4] = true;
            switchRoute(60);
            break;

         default:
            break;
      }

   }

   private void setTitleRoute(String Route){
      setTitle("Route " + Route);
   }

   private void setTitleQuestion(){
      questionCounter += 1;
      setTitle("Frage " + questionCounter + " von 10");
   }

   private void setMainQuestionVariables(){
      mainquestNext = (Button) findViewById(R.id.mainQuestNext);
      mainquestNext.setOnClickListener(this);
      tv_mainQuest = (TextView) findViewById(R.id.textView3);
      mainQuestAnswers = new String[4];
      radioButtons = new RadioButton[4];
      for(int i = 0; i<radioButtons.length; i++)
      {
         String b = "rB" + (i+1);
         radioButtons[i] = (RadioButton) findViewById(res.getIdentifier(b, "id", getPackageName()));
      }
   }

   private void setSubQuestionVariables(){
      subquestNext = (Button) findViewById(R.id.subQuestNext);
      subquestNext.setOnClickListener(this);

   }

}
