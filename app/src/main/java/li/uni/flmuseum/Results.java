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
   ArrayList<Boolean> subQuestion;
   boolean[] b_mainQuestion, b_subQuestion = new boolean[5];
   String[] questionTitle;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_results);
      listView = (ListView) findViewById(R.id.list);

      mainQuestion = new ArrayList<Boolean>();
      subQuestion = new ArrayList<Boolean>();

      Bundle bundle = getIntent().getExtras();
      b_mainQuestion = bundle.getBooleanArray("main");
      b_subQuestion = bundle.getBooleanArray("sub");

      for(int i = 0; i<b_mainQuestion.length; i++)
      {
         mainQuestion.add(b_mainQuestion[i]);
         subQuestion.add(b_subQuestion[i]);
      }

      showResult();

   }

   public void showResult(){
      questionTitle = getResources().getStringArray(R.array.qestions);

      ResultRowAdapter resultRowAdapter = new ResultRowAdapter(this.getBaseContext(), mainQuestion, subQuestion, questionTitle);
      listView.setAdapter(resultRowAdapter);
      listView.invalidate();
   }

}
