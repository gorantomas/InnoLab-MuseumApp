package li.uni.flmuseum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

   SharedPreferences settings;
   SharedPreferences.Editor editor;
   PopupWindow popupWindow;
   private boolean zoomOut = false;
   boolean actScreenRoute = false;
   boolean pictureOpen = false;
   boolean[] b_mainQuestion;
   int curQuestion = -1;
   int nextQuestion = -1;
   int lastQuestion = -1;
   int answer = -1;
   int questionCounter = 0;
   int countOfQuestions = -1;
   int[] questionsArray = {10, 11, 20, 21, 22, 23, 30, 31, 40, 41, 42, 50, 51, 60, 61, 70, 71, 72};
   int nextRoute = -1;
   int lastRoute = -1;
   Button routeNext, mainquestNext, answerNext;
   RadioButton[] radioButtons;
   String[] mainQuestAnswers;
   TextView tv_mainQuest, tv_route, tv_answerNext, tv_routerNumber, tv_answerNumber, tv_questionNumber;
   CheckAnswer checkAnswer;
   Resources res;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_route);

      settings = getApplicationContext().getSharedPreferences("mySettings", MODE_PRIVATE);
      editor = settings.edit();

      countOfQuestions = questionsArray.length;

      checkAnswer = new CheckAnswer();

      b_mainQuestion = new boolean[questionsArray.length];

      res = getResources();

      nextRoute = 10;
      lastRoute = nextRoute;
      nextQuestion = 10;
      lastQuestion = nextQuestion;
      curQuestion = nextQuestion;
      switchRoute(nextRoute);

   }

   private void imagezoom(final int Resource){
      final ImageView btnOpenPopup = (ImageView) findViewById(R.id.imageView2);
      btnOpenPopup.setImageResource(Resource);
      btnOpenPopup.setOnClickListener(new Button.OnClickListener() {

         @Override public void onClick(View arg0){
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = layoutInflater.inflate(R.layout.popup, null);
            ImageView imgDismiss = (ImageView) popupView.findViewById(R.id.imageViewPopUp);
            imgDismiss.setImageResource(Resource);

            popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            //                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
            //                btnDismiss.setOnClickListener(new Button.OnClickListener(){
            //
            //                    @Override
            //                    public void onClick(View v) {
            //                        // TODO Auto-generated method stub
            //                        popupWindow.dismiss();
            //                    }});

            imgDismiss.setOnClickListener(new Button.OnClickListener() {

               @Override public void onClick(View v){
                  pictureOpen = false;
                  popupWindow.dismiss();
               }
            });

            //                popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
            pictureOpen = true;
            popupWindow.showAtLocation(btnOpenPopup, Gravity.BOTTOM, 0, 0);
         }
      });

   }

   private void switchRoute(int route){
      actScreenRoute = true;
      switch(route)
      {
         case 0:
            setRouteVariables();
            setTitleRoute("1");
            tv_route.setText(getString(R.string.route1));
            nextRoute = 20;
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
            setTitleRoute("2");
            nextRoute = 30;
            break;
         case 30:
            lastRoute = 20;
            setRouteVariables();
            tv_route.setText(getString(R.string.route3));
            setTitleRoute("3");
            nextRoute = 40;
            break;
         case 40:
            lastRoute = 30;
            setRouteVariables();
            tv_route.setText(getString(R.string.route4));
            setTitleRoute("4");
            nextRoute = 50;
            break;
         case 50:
            lastRoute = 40;
            setRouteVariables();
            tv_route.setText(getString(R.string.route5));
            setTitleRoute("5");
            nextRoute = 60;
            break;
         case 60:
            lastRoute = 50;
            setRouteVariables();
            tv_route.setText(getString(R.string.route6));
            setTitleRoute("6");
            nextRoute = 70;
            break;
         case 70:
            lastRoute = 60;
            setRouteVariables();
            tv_route.setText(getString(R.string.route7));
            setTitleRoute("7");
            nextRoute = 80;
            break;
         case 80:
            lastRoute = 70;
            setRouteVariables();
            tv_route.setText(getString(R.string.route8));
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
      actScreenRoute = false;
      String[] answ;
      switch(question)
      {
         case 10:
            curQuestion = 10;
            nextQuestion = 11;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest10));
            setTitleQuestion();
            imagezoom(R.drawable.steinbeil);
            answ = getResources().getStringArray(R.array.guest10answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 11:
            lastQuestion = 10;
            curQuestion = 11;
            nextQuestion = 20;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.steinbeil);
            tv_mainQuest.setText(getString(R.string.quest11));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest11answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 20:
            lastQuestion = 11;
            curQuestion = 20;
            nextQuestion = 21;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest20));
            setTitleQuestion();
            imagezoom(R.drawable.fastentuch);
            answ = getResources().getStringArray(R.array.guest20answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 21:
            lastQuestion = 20;
            curQuestion = 21;
            nextQuestion = 22;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.fastentuch);
            tv_mainQuest.setText(getString(R.string.quest21));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest21answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 22:
            lastQuestion = 21;
            curQuestion = 22;
            nextQuestion = 23;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.fastentuch);
            tv_mainQuest.setText(getString(R.string.quest22));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest22answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 23:
            lastQuestion = 22;
            curQuestion = 23;
            nextQuestion = 30;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.fastentuch);
            tv_mainQuest.setText(getString(R.string.quest23));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest23answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 30:
            lastQuestion = 23;
            curQuestion = 30;
            nextQuestion = 31;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest30));
            setTitleQuestion();
            imagezoom(R.drawable.wand_alpabfahrtsherz);
            answ = getResources().getStringArray(R.array.guest30answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 31:
            lastQuestion = 30;
            curQuestion = 31;
            nextQuestion = 40;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.wand_alpabfahrtsherz);
            tv_mainQuest.setText(getString(R.string.quest31));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest31answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         //         case 32:
         //            lastQuestion = 31;
         //            curQuestion = 32;
         //            nextQuestion = 40;
         //            setContentView(R.layout.act_mainquestion);
         //            setMainQuestionVariables();
         //            mainquestNext.setText("main" + (question / 10));
         //            tv_mainQuest.setText(getString(R.string.quest32));
         //            setTitleQuestion();
         //            break;
         case 40:
            lastQuestion = 32;
            curQuestion = 40;
            nextQuestion = 41;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest40));
            setTitleQuestion();
            imagezoom(R.drawable.fuerst_johann);
            answ = getResources().getStringArray(R.array.guest40answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 41:
            lastQuestion = 40;
            curQuestion = 41;
            nextQuestion = 42;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.fuerst_johann);
            tv_mainQuest.setText(getString(R.string.quest41));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest41answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 42:
            lastQuestion = 41;
            curQuestion = 42;
            nextQuestion = 50;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.fuerst_johann);
            tv_mainQuest.setText(getString(R.string.quest42));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest42answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 50:
            lastQuestion = 42;
            curQuestion = 50;
            nextQuestion = 51;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest50));
            setTitleQuestion();
            imagezoom(R.drawable.schifertafel);
            answ = getResources().getStringArray(R.array.guest50answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 51:
            lastQuestion = 50;
            curQuestion = 51;
            nextQuestion = 60;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.schifertafel);
            tv_mainQuest.setText(getString(R.string.quest51));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest51answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;

         case 60:
            lastQuestion = 51;
            curQuestion = 60;
            nextQuestion = 61;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest60));
            setTitleQuestion();
            imagezoom(R.drawable.oberschenkelknochen);
            answ = getResources().getStringArray(R.array.guest60answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 61:
            lastQuestion = 60;
            curQuestion = 61;
            nextQuestion = 70;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.oberschenkelknochen);
            tv_mainQuest.setText(getString(R.string.quest61));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest61answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 70:
            lastQuestion = 61;
            curQuestion = 70;
            nextQuestion = 71;
            setContentView(R.layout.act_mainquestion);
            //set variables
            setMainQuestionVariables();
            tv_mainQuest.setText(getString(R.string.quest70));
            setTitleQuestion();
            imagezoom(R.drawable.murmeltier);
            answ = getResources().getStringArray(R.array.guest70answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 71:
            lastQuestion = 70;
            curQuestion = 71;
            nextQuestion = 72;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.murmeltier);
            tv_mainQuest.setText(getString(R.string.quest71));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest71answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;
         case 72:
            lastQuestion = 71;
            curQuestion = 72;
            nextQuestion = 99;
            setContentView(R.layout.act_mainquestion);
            setMainQuestionVariables();
            imagezoom(R.drawable.murmeltier);
            tv_mainQuest.setText(getString(R.string.quest72));
            setTitleQuestion();
            answ = getResources().getStringArray(R.array.guest72answers);
            for(int i = 0; i<radioButtons.length; i++)
            {
               radioButtons[i].setText(answ[i]);
            }
            if(answ[2].equals("xxx"))
               radioButtons[2].setVisibility(View.INVISIBLE);
            break;

         default:
            break;
      }

   }

   public void onBackPressed(){
      // falsche Frage wird als nächstes angezeigt. Man kann nur 1x zurück
      if(!actScreenRoute && !radioButtons[0].isChecked() && !radioButtons[1].isChecked() && !radioButtons[2].isChecked() && !pictureOpen)
      {
         if(curQuestion == 10 || curQuestion == 20 || curQuestion == 30 ||
              curQuestion == 40 || curQuestion == 50 || curQuestion == 60 || curQuestion == 70)
         {
            nextQuestion = curQuestion;
            questionCounter -= 1;
            //nextRoute -= 10;
            switchRoute(nextRoute - 10);
         }
      }
      //      else
      //      {
      //         questionCounter -= 2;
      //         switchQuestion(lastQuestion);
      //      }
   }

   private void showResult(){

      Intent myIntent = new Intent(this, Results.class);
      myIntent.putExtra("main", b_mainQuestion);
      myIntent.putExtra("arraySize", questionsArray.length);

      startActivity(myIntent);
   }

   public void onClick(View view){
      switch(view.getId())
      {
         case R.id.answerNext:
            showAnswerDescription(curQuestion);
            break;
         case R.id.mainQuestNext:
            checkAnswer(curQuestion);
            break;
         case R.id.routeNext:
            if(popupWindow != null)
               popupWindow.dismiss();
            if(nextRoute != -1)
               switchQuestion(nextQuestion);
            else
               showResult();

            break;
         default:
            break;
      }

   }

   private void checkAnswer(int currentQuestion){
      String[] answers = getResources().getStringArray(R.array.guest10explanation);
      int tempQuestionCounter = questionCounter - 1;
      switch(currentQuestion)
      {
         case 10:
            answers = getResources().getStringArray(R.array.guest10explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 11:
            answers = getResources().getStringArray(R.array.guest11explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 20:
            answers = getResources().getStringArray(R.array.guest20explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 21:
            answers = getResources().getStringArray(R.array.guest21explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 22:
            answers = getResources().getStringArray(R.array.guest22explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
               answer = 1;
            break;
         case 23:
            answers = getResources().getStringArray(R.array.guest23explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 30:
            answers = getResources().getStringArray(R.array.guest30explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 31:
            answers = getResources().getStringArray(R.array.guest31explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;

         case 40:
            answers = getResources().getStringArray(R.array.guest40explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
            {
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 41:
            answers = getResources().getStringArray(R.array.guest41explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 42:
            answers = getResources().getStringArray(R.array.guest42explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 50:
            answers = getResources().getStringArray(R.array.guest50explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 51:
            answers = getResources().getStringArray(R.array.guest51explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 2;
            }
            break;
         case 60:
            answers = getResources().getStringArray(R.array.guest60explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 61:
            answers = getResources().getStringArray(R.array.guest61explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 2;
            }
            break;
         case 70:
            answers = getResources().getStringArray(R.array.guest70explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 71:
            answers = getResources().getStringArray(R.array.guest71explanation);
            if(radioButtons[0].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 0;
            }
            else if(radioButtons[1].isChecked())
               answer = 1;
            else if(radioButtons[2].isChecked())
               answer = 2;
            break;
         case 72:
            answers = getResources().getStringArray(R.array.guest72explanation);
            if(radioButtons[0].isChecked())
               answer = 0;
            else if(radioButtons[1].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 1;
            }
            else if(radioButtons[2].isChecked())
            {
               b_mainQuestion[tempQuestionCounter] = true;
               answer = 2;
            }
            break;

         default:
            break;
      }
      setAnswerVariables();
      tv_answerNext.setText(answers[answer]);
   }

   private void showAnswerDescription(int currentQuestion){
      //      int answer = 0;
      //      setRouteVariables();
      //      String[] answers;
      switch(currentQuestion)
      {
         case 10:
            switchQuestion(nextQuestion);
            break;
         case 11:
            switchRoute(nextRoute);
            break;
         case 20:
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
            switchQuestion(nextQuestion);
            break;
         case 31:
            switchRoute(nextRoute);
            break;
         case 40:
            switchQuestion(nextQuestion);
            break;
         case 41:
            switchQuestion(nextQuestion);
            break;
         case 42:
            switchRoute(nextRoute);
            break;
         case 50:
            switchQuestion(nextQuestion);
            break;
         case 51:
            switchRoute(nextRoute);
            break;
         case 60:
            switchQuestion(nextQuestion);
            break;
         case 61:
            switchRoute(nextRoute);
            break;
         case 70:
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
      setTitle("Station " + Route);
      tv_routerNumber.setText("Station " + Route);
   }

   private void setTitleQuestion(){
      questionCounter += 1;
      setTitle("Frage " + questionCounter + " von " + questionsArray.length);
      tv_questionNumber.setText("Frage " + questionCounter + " von " + questionsArray.length);

   }

   private void setMainQuestionVariables(){
      mainquestNext = (Button) findViewById(R.id.mainQuestNext);
      mainquestNext.setOnClickListener(this);
      mainquestNext.setVisibility(View.INVISIBLE);
      tv_mainQuest = (TextView) findViewById(R.id.textView3);
      tv_questionNumber = (TextView) findViewById(R.id.tv_questionNumber);
      mainQuestAnswers = new String[4];
      radioButtons = new RadioButton[3];
      for(int i = 0; i<radioButtons.length; i++)
      {
         String b = "rB" + (i + 1);
         radioButtons[i] = (RadioButton) findViewById(res.getIdentifier(b, "id", getPackageName()));
         radioButtons[i].setOnCheckedChangeListener(this);
      }
      popupWindow = null;
   }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
      if(isChecked)
         mainquestNext.setVisibility(View.VISIBLE);
   }

   private void setRouteVariables(){
      setContentView(R.layout.act_route);
      routeNext = (Button) findViewById(R.id.routeNext);
      routeNext.setOnClickListener(this);
      routeNext.setText("Weiter");
      tv_route = (TextView) findViewById(R.id.textView4);
      popupWindow = null;
      tv_routerNumber = (TextView) findViewById(R.id.tv_routeNumber);
   }

   private void setAnswerVariables(){
      setContentView(R.layout.act_answer);
      answerNext = (Button) findViewById(R.id.answerNext);
      answerNext.setOnClickListener(this);
      answerNext.setText("Weiter");
      tv_answerNext = (TextView) findViewById(R.id.tV_answer);
      tv_answerNumber = (TextView) findViewById(R.id.tV_answerNumber);
      tv_answerNumber.setText("Frage " + questionCounter + " von " + questionsArray.length);
   }

}
