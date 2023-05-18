package com.chaos.Gpacl;

import static com.chaos.Gpacl.Constant.FIRST_COLUMN;
import static com.chaos.Gpacl.Constant.SECOND_COLUMN;
import static com.chaos.Gpacl.Constant.THIRD_COLUMN;
import static com.chaos.Gpacl.Constant.FOURTH_COLUMN;
import static com.chaos.Gpacl.Constant.FIFTH_COLUMN;



import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author Paresh N. Mayani
 * http://pareshnmayani.wordpress.com
 */
class listviewAdapter extends BaseAdapter
{
  public ArrayList<HashMap<String,String>> list;
  Activity activity;

  public listviewAdapter(Activity activity, ArrayList<HashMap<String,String>> list) {
	super();
	this.activity = activity;
	this.list = list;
  }

  @Override
  public int getCount() {
	// TODO Auto-generated method stub
	return list.size();
  }

  @Override
  public Object getItem(int position) {
	// TODO Auto-generated method stub
	return list.get(position);
  }

  @Override
  public long getItemId(int position) {
	// TODO Auto-generated method stub
	return 0;
  }

  private class ViewHolder {
	TextView txtFirst;
	TextView txtSecond;
	TextView txtThird;
	TextView txtFourth;
	TextView textFIFTH;
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
	ViewHolder holder;
	LayoutInflater inflater =  activity.getLayoutInflater();

	if (convertView == null)
	{
	  convertView = inflater.inflate(R.layout.list_view, null);
	  holder = new ViewHolder();
	  holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
	  holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
	  holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
	  holder.txtFourth = (TextView) convertView.findViewById(R.id.FourthText);
	  holder.textFIFTH= convertView.findViewById(R.id.fifththText);
	  convertView.setTag(holder);
	}
	else
	{
	  holder = (ViewHolder) convertView.getTag();
	}

	HashMap<String, String> map = list.get(position);
	holder.txtFirst.setText(map.get(FIRST_COLUMN));
	holder.txtSecond.setText(map.get(SECOND_COLUMN));
	holder.txtThird.setText(map.get(THIRD_COLUMN));
	holder.txtFourth.setText(map.get(FOURTH_COLUMN));
	holder.textFIFTH.setText(map.get(FIFTH_COLUMN));

	return convertView;
  }

}
