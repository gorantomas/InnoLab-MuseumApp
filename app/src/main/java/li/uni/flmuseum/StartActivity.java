package li.uni.flmuseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

/**
 * Created by jaha on 02.11.2016.
 */

public class StartActivity extends Activity{


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }



    public void sendMessage(View view)
    {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }



}
