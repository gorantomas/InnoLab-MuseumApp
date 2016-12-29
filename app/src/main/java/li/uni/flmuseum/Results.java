package li.uni.flmuseum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by goran.tomas on 24.10.2016.
 * Activity for results
 * Hier werden die Entergebnisse angezeigt
 */

public class Results extends Activity {

   ListView listView;
   ArrayList<Boolean> mainQuestion;

   boolean[] b_mainQuestion;
   String[] questionTitle;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_results);
      listView = (ListView) findViewById(R.id.list);

      mainQuestion = new ArrayList<Boolean>();


      Bundle bundle = getIntent().getExtras();
      b_mainQuestion = bundle.getBooleanArray("main");


      for(int i = 0; i<b_mainQuestion.length; i++)
      {
         mainQuestion.add(b_mainQuestion[i]);

      }

      showResult();

   }

   public void showResult(){
      questionTitle = getResources().getStringArray(R.array.questions);

      ResultRowAdapter resultRowAdapter = new ResultRowAdapter(this.getBaseContext(), mainQuestion, questionTitle);
      listView.setAdapter(resultRowAdapter);
      listView.invalidate();
   }

}
