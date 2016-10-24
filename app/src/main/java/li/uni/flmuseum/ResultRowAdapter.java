package li.uni.flmuseum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goran.tomas on 24.10.2016.
 * Adapter for listview
 */

public class ResultRowAdapter extends ArrayAdapter<String> implements View.OnClickListener {

   ViewHolder viewHolder;
   ArrayList<String> buttonPoints, stationNames;
   String station;

   private static class ViewHolder {
      TextView station;
      Button button;
   }

   public ResultRowAdapter(Context context, ArrayList<String> stationName, ArrayList<String> buttonPoints){
      super(context, 0, stationName);
      this.stationNames = stationName;
      this.buttonPoints = buttonPoints;
   }

   public View getView(int position, View convertView, final ViewGroup parent){
      // Get the data item for this position
      station = getItem(position);

      // Check if an existing view is being
      // reused, otherwise inflate the view
      //final ViewHolder viewHolder; // view
      // lookup cache stored in tag
      if(convertView == null)
      {
         viewHolder = new ViewHolder();
         LayoutInflater inflater = LayoutInflater.from(getContext());
         convertView = inflater.inflate(R.layout.resultlistrow, parent, false);
         viewHolder.button = (Button) convertView.findViewById(R.id.button_row);
         viewHolder.station = (TextView) convertView.findViewById(R.id.textView_row);
         convertView.setTag(viewHolder);
      }
      else
      {
         viewHolder = (ViewHolder) convertView.getTag();
      }
      // Populate the data into the template
      // view using the data object
            viewHolder.button.setText(buttonPoints.get(position));
          viewHolder.station.setText(stationNames.get(position)+position);
      viewHolder.button.setOnClickListener(this);

      convertView.invalidate();

      return convertView;
   }

   @Override public void onClick(View view){

      Button bt = (Button) view;
      String text = bt.getText().toString();
   }

}