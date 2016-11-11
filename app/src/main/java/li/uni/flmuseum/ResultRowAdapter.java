package li.uni.flmuseum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by goran.tomas on 24.10.2016.
 * Adapter for listview
 */

public class ResultRowAdapter extends ArrayAdapter<String> {

   ViewHolder viewHolder;
   ArrayList<Boolean> mainQuestion, subQuestion;
   String station, maxPoints;
   String[] questionTitle;
   int actPoints = 0, allPoints = 0, maxAllPoints = 0;
   Context context;

   private static class ViewHolder {
      TextView station;
      TextView points;
   }

   public ResultRowAdapter(Context context, ArrayList<Boolean> mainQuestion, ArrayList<Boolean> subQuestion, String[] questionTitle){
      super(context, 0, questionTitle);
      this.context = context;
      this.mainQuestion = mainQuestion;
      this.subQuestion = subQuestion;
      this.questionTitle = questionTitle;
      maxPoints = context.getResources().getString(R.string.maxPoints);
      maxAllPoints = context.getResources().getInteger(R.integer.pointMainQuestion) * mainQuestion.size() * 2;
   }

   public View getView(int position, View convertView, final ViewGroup parent){
      // Get the data item for this position
      station = getItem(position);
      actPoints = 0;

      if(convertView == null)
      {
         viewHolder = new ViewHolder();
         LayoutInflater inflater = LayoutInflater.from(getContext());
         convertView = inflater.inflate(R.layout.resultlistrow, parent, false);
         viewHolder.station = (TextView) convertView.findViewById(R.id.row_textView1);
         viewHolder.points = (TextView) convertView.findViewById(R.id.row_textView2);
         convertView.setTag(viewHolder);
      }
      else
      {
         viewHolder = (ViewHolder) convertView.getTag();
      }
      // Populate the data into the template
      // view using the data object

      viewHolder.station.setText(questionTitle[position].toString());

      if(position<(mainQuestion.size()-1))
      {
         if(mainQuestion.get(position))
            actPoints += context.getResources().getInteger(R.integer.pointMainQuestion);
         if(subQuestion.get(position))
            actPoints += context.getResources().getInteger(R.integer.pointSubQuestion);

         allPoints += actPoints;
         viewHolder.points.setText(actPoints + " von " + maxPoints);
      }
      else if(position==(mainQuestion.size()))
         viewHolder.points.setText("");
      else
         viewHolder.points.setText(allPoints + " von " + maxAllPoints);

      convertView.invalidate();

      return convertView;
   }

}