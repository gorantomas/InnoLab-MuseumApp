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

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.results);
      listView = (ListView) findViewById(R.id.list);
      showResult();

   }

   public void showResult(){
      ArrayList<String> stationNames = new ArrayList<String>();
      ArrayList<String> buttonPoints = new ArrayList<String>();

      stationNames.add("s1");
      buttonPoints.add("1/10");
      stationNames.add("s1");
      buttonPoints.add("1/10");
      stationNames.add("s1");
      buttonPoints.add("1/10");
      stationNames.add("Gesamt: ");
      buttonPoints.add("3/10");
      ResultRowAdapter resultRowAdapter = new ResultRowAdapter(this.getBaseContext(), stationNames, buttonPoints);
      listView.setAdapter(resultRowAdapter);
   }

}
