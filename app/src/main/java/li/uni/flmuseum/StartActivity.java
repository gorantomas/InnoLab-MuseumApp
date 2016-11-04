package li.uni.flmuseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jaha on 02.11.2016.
 */

public class StartActivity extends Activity implements View.OnClickListener {

   private Button start;

   @Override protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.start);
      start = (Button) findViewById(R.id.button_start);
      start.setOnClickListener(this);
   }

   public void onClick(View view){
      Intent intent = new Intent(StartActivity.this, MainActivity.class);
      startActivity(intent);
   }

}
