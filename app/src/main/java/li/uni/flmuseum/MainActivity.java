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
   ArrayList<Boolean> mainQuestion;
   boolean[] b_mainQuestion;
   int curQuestion = -1;
   int nextQuestion = -1;
   int lastQuestion = -1;
   int questionCounter = 0;
   int countOfQuestions = -1;
   int[] questionsArray = {10, 11, 20, 21, 22, 23, 30, 31, 32, 40, 41, 42, 50, 51, 60, 61, 70, 71, 72};
   int nextRoute = -1;
   int lastRoute = -1;
   Button routeNext, mainquestNext, subquestNext;
   RadioButton[] radioButtons;
   String[] mainQuestAnswers;
   TextView tv_mainQuest, tv_subQuest, tv_route;
   CheckAnswer checkAnswer;
   Resources res;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_route);

      settings = getApplicationContext().getSharedPreferences("mySettings", MODE_PRIVATE);
      editor = settings.edit();

      countOfQuestions = questionsArray.length;

      checkAnswer = new CheckAnswer();

      mainQuestion = new ArrayList<Boolean>();

      b_mainQuestion = new boolean[questionsArray.length];

      res = getResources();
      //      routeNext = (Button) findViewById(R.id.routeNext);
      //      routeNext.setOnClickListener(this);
      //      curQuestion = 10;
      //      routeNext.setText("next" + (curQuestion / 10));
      //      setTitleRoute("1");
      nextRoute = 10;
      lastRoute = nextRoute;
      nextQuestion = 10;
      lastQuestion = nextQuestion;
      curQuestion = nextQuestion;
      switchRoute(nextRoute);

   }

   private void switchRoute(int route){
      switch(route)
      {
         case 0:
            setContentView(R.layout.act_route);
            setTitleRoute("1");
            break;
         case 10:
            setRouteVariables();
            setTitleRoute("1");
            tv_route.setText(getString(R.string.route1));
            nextRoute = 20;
            break;
         case 20:
            lastRoute = 10;
            setRouteVariables();
            tv_route.setText(getString(R.string.route2));
            curQuestion = 20;
            setTitleRoute("2");
            nextRoute = 30;
            break;
         case 30:
            lastRoute = 20;
            setRouteVariables();
            tv_route.setText(getString(R.string.route3));
            curQuestion = 30;
            setTitleRoute("3");
            nextRoute = 40;
            break;
         case 40:
            lastRoute = 30;
            setRouteVariables();
            tv_route.setText(getString(R.string.route4));
            curQuestion = 40;
            setTitleRoute("4");
            nextRoute = 50;
            break;
         case 50:
            lastRoute = 40;
            setRouteVariables();
            tv_route.setText(getString(R.string.route5));
            curQuestion = 50;
            setTitleRoute("5");
            nextRoute = 60;
            break;
         case 60:
            lastRoute = 50;
            setRouteVariables();
            tv_route.setText(getString(R.string.route6));
            curQuestion = 60;
            setTitleRoute("6");
            nextRoute = 70;
            break;
         case 70:
            lastRoute = 60;
            setRouteVariables();
            tv_route.setText(getString(R.string.route7));
            curQuestion = 70;
            setTitleRoute("7");
            nextRoute = 80;
            break;
         case 80:
            lastRoute = 70;
            setRouteVariables();
            tv_route.setText(getString(R.string.route8));
            curQuestion = 80;
            setTitleRoute("8");
            nextRoute = -1;
            break;
         //         case 90:
         //            //            lastRoute = 80;
         //            //            setRouteVariables();
         //            //            tv_route.setText(getString(R.string.route9));
         //            //            curQuestion = 90;
         //            //            setTitleRoute("9");
         //            //            nextRoute = 91;
         //            showResult();
         //            break;
         //         case 91:
         //            //setContentView(R.layout.act_route);
         //            // fertig?
         //            // results aufrufen?
         //            showResult();
         //            break;

         default:
            break;
      }

   }

   private void switchQuestion(int question){
      switch(question)
      {
         case 10:
            curQuestion = 10;
            nextQuestion = 11;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest1answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest10));
            setTitleQuestion();
            break;
         case 11:
            lastQuestion = nextQuestion;
            curQuestion = 11;
            nextQuestion = 20;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest11));
            setTitleQuestion();
            break;
         case 20:
            lastQuestion = nextQuestion;
            curQuestion = 20;
            nextQuestion = 21;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest20));
            setTitleQuestion();
            break;
         case 21:
            lastQuestion = nextQuestion;
            curQuestion = 21;
            nextQuestion = 22;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest21));
            setTitleQuestion();
            break;
         case 22:
            lastQuestion = nextQuestion;
            curQuestion = 22;
            nextQuestion = 23;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest22));
            setTitleQuestion();
            break;
         case 23:
            lastQuestion = nextQuestion;
            curQuestion = 23;
            nextQuestion = 30;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest23));
            setTitleQuestion();
            break;
         case 30:
            lastQuestion = nextQuestion;
            curQuestion = 30;
            nextQuestion = 31;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest30));
            setTitleQuestion();
            break;
         case 31:
            lastQuestion = nextQuestion;
            curQuestion = 31;
            nextQuestion = 32;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest31));
            setTitleQuestion();
            break;
         case 32:
            lastQuestion = nextQuestion;
            curQuestion = 32;
            nextQuestion = 40;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest32));
            setTitleQuestion();
            break;
         case 40:
            lastQuestion = nextQuestion;
            curQuestion = 40;
            nextQuestion = 41;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest40));
            setTitleQuestion();
            break;
         case 41:
            lastQuestion = nextQuestion;
            curQuestion = 41;
            nextQuestion = 42;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest41));
            setTitleQuestion();
            break;
         case 42:
            lastQuestion = nextQuestion;
            curQuestion = 42;
            nextQuestion = 50;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest42));
            setTitleQuestion();
            break;
         case 50:
            lastQuestion = nextQuestion;
            curQuestion = 50;
            nextQuestion = 51;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest50));
            setTitleQuestion();
            break;
         case 51:
            lastQuestion = nextQuestion;
            curQuestion = 51;
            nextQuestion = 60;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest51));
            setTitleQuestion();
            break;

         case 60:
            lastQuestion = nextQuestion;
            curQuestion = 60;
            nextQuestion = 61;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest60));
            setTitleQuestion();
            break;
         case 61:
            lastQuestion = nextQuestion;
            curQuestion = 61;
            nextQuestion = 70;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest61));
            setTitleQuestion();
            break;
         case 70:
            lastQuestion = nextQuestion;
            curQuestion = 70;
            nextQuestion = 71;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            //            mainQuestAnswers = res.getStringArray(R.array.guest2answers);
            //            for(int i = 0; i<radioButtons.length; i++)
            //            {
            //               radioButtons[i].setText(mainQuestAnswers[i].toString());
            //            }
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest70));
            setTitleQuestion();
            break;
         case 71:
            lastQuestion = nextQuestion;
            curQuestion = 71;
            nextQuestion = 72;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest71));
            setTitleQuestion();
            break;
         case 72:
            lastQuestion = nextQuestion;
            curQuestion = 72;
            nextQuestion = 99;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            mainquestNext.setText("main" + (question / 10));
            tv_mainQuest.setText(getString(R.string.quest72));
            setTitleQuestion();
            break;

         default:
            break;
      }

   }

   private void showResult(){

      Intent myIntent = new Intent(this, Results.class);
      myIntent.putExtra("main", b_mainQuestion);
      myIntent.putExtra("main2", mainQuestion);
      myIntent.putExtra("arraySize", questionsArray.length);

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
         //         case R.id.subQuestNext:
         //            checkAnswer(curQuestion);
         //            break;
         case R.id.routeNext:
            if(nextRoute != -1)
               switchQuestion(curQuestion);
            else
               showResult();
            break;
         default:
            break;
      }

   }

   //   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
   //      switch(buttonView.getId())
   //      {
   //
   //         case R.id.rB1:
   //            if(isChecked)
   //            {
   //               radioButtons[1].setChecked(false);
   //               radioButtons[2].setChecked(false);
   //               radioButtons[3].setChecked(false);
   //            }
   //            break;
   //
   //         case R.id.rB2:
   //            if(isChecked)
   //            {
   //               radioButtons[0].setChecked(false);
   //               radioButtons[2].setChecked(false);
   //               radioButtons[3].setChecked(false);
   //            }
   //            break;
   //
   //         case R.id.rB3:
   //            if(isChecked)
   //            {
   //               radioButtons[0].setChecked(false);
   //               radioButtons[1].setChecked(false);
   //               radioButtons[3].setChecked(false);
   //            }
   //            break;
   //
   //         case R.id.rB4:
   //            if(isChecked)
   //            {
   //               radioButtons[0].setChecked(false);
   //               radioButtons[1].setChecked(false);
   //               radioButtons[2].setChecked(false);
   //            }
   //            break;
   //
   //         default:
   //            break;
   //      }
   //
   //   }

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
            switchQuestion(nextQuestion);
            break;
         case 11:
            switchRoute(nextRoute);
            break;
         case 20:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(1, true);
               b_mainQuestion[1] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 21:

            switchQuestion(nextQuestion);
            break;
         case 22:

            switchQuestion(nextQuestion);
            break;
         case 23:

            switchRoute(nextRoute);
            break;
         case 30:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(2, true);
               b_mainQuestion[2] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 31:

            switchQuestion(nextQuestion);
            break;
         case 32:

            switchRoute(nextRoute);
            break;
         case 40:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(3, true);
               b_mainQuestion[3] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 41:

            switchQuestion(nextQuestion);
            break;
         case 42:

            switchRoute(nextRoute);
            break;
         case 50:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(4, true);
               b_mainQuestion[4] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 51:

            switchRoute(nextRoute);
            break;
         case 60:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(4, true);
               b_mainQuestion[4] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 61:

            switchRoute(nextRoute);
            break;
         case 70:
            if(checkAnswer.getChoosedAnswer(this, currentQuestion / 10))
            {
               mainQuestion.add(4, true);
               b_mainQuestion[4] = true;
            }
            switchQuestion(nextQuestion);
            break;
         case 71:

            switchQuestion(nextQuestion);
            break;
         case 72:

            switchRoute(nextRoute);
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
      setTitle("Frage " + questionCounter + " von " + questionsArray.length);
   }

   private void setMainQuestionVariables(){
      mainquestNext = (Button) findViewById(R.id.mainQuestNext);
      mainquestNext.setOnClickListener(this);
      tv_mainQuest = (TextView) findViewById(R.id.textView3);
      mainQuestAnswers = new String[4];
      //      radioButtons = new RadioButton[4];
      //      for(int i = 0; i<radioButtons.length; i++)
      //      {
      //         String b = "rB" + (i + 1);
      //         radioButtons[i] = (RadioButton) findViewById(res.getIdentifier(b, "id", getPackageName()));
      //         radioButtons[i].setOnCheckedChangeListener(this);
      //      }
   }

   private void setRouteVariables(){
      setContentView(R.layout.act_route);
      routeNext = (Button) findViewById(R.id.routeNext);
      routeNext.setOnClickListener(this);
      routeNext.setText("Weiter");
      tv_route = (TextView) findViewById(R.id.textView4);
   }

}
