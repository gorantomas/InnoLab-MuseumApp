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
   ArrayList<Boolean> mainQuestion;
   String station, maxPoints;
   String[] questionTitle;
   int actPoints = 0, allPoints = 0, maxAllPoints = 0;
   Context context;

   private static class ViewHolder {
      TextView station;
      TextView points;
   }

   public ResultRowAdapter(Context context, ArrayList<Boolean> mainQuestion, String[] questionTitle){
      super(context, 0, questionTitle);
      this.context = context;
      this.mainQuestion = mainQuestion;

      this.questionTitle = questionTitle;
      maxPoints = context.getResources().getString(R.string.maxPoints);
      maxAllPoints = mainQuestion.size();
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



      if(position==0)
      { //10 + 11
         for(int i=0;i<=1;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 2");
      }
      else if(position==1)
      { //20 + 21 ++ 22 + 23
         for(int i=2;i<=5;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 4");
      }
      else if(position==2)
      { //30 + 31
         for(int i=6;i<=7;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 2");
      }
      else if(position==3)
      {//40 + 41 + 42
         for(int i=8;i<=10;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 3");
      }
      else if(position==4)
      {//50 + 51
         for(int i=11;i<=12;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 2");
      }
      else if(position==5)
      {//60 + 61
         for(int i=13;i<=14;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 2");
      }
      else if(position==6)
      {//70 + 71 + 72
         for(int i=15;i<=17;i++)
         {
            if(mainQuestion.get(i))
            {
               actPoints += 1;
               allPoints += 1;
            }
         }
         viewHolder.points.setText(actPoints + " von 3");
      }

      else if(position == 7)
         viewHolder.points.setText("");
      else
         viewHolder.points.setText(allPoints + " von " + maxAllPoints);

      convertView.invalidate();

      return convertView;
   }

}