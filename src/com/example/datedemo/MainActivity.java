package com.example.datedemo;

import java.util.Calendar;

import org.apache.http.impl.cookie.DateParseException;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.Build;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        final TextView tv_date=(TextView)findViewById(R.id.tv_date);
        final TextView tv_time=(TextView)findViewById(R.id.tv_time);
        final DatePicker date=(DatePicker)findViewById(R.id.date);
        final TimePicker time=(TimePicker)findViewById(R.id.time);
        //.xml文本内容
        final String dateTag=getString(R.string.date);
        final String timeTag=getString(R.string.time);
        //获取calendar实例
        Calendar c=Calendar.getInstance();
        
        date.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), new OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int mon, int day) {
				// TODO Auto-generated method stub
				tv_date.setText(dateTag+year+"-"+(mon+1)+"-"+day);
			}
		});
        //
        time.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
        time.setCurrentMinute(c.get(Calendar.MINUTE));
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
				// TODO Auto-generated method stub
				tv_time.setText(timeTag+arg1+":"+arg2);
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
