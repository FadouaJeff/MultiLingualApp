package com.jeffali.multilingualapp;

import java.util.Locale;

import android.app.Activity;
import android.app.Notification.Style;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	 Spinner spinner;
	 Locale myLocale;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner =(Spinner) findViewById(R.id.spinner);
		ActivateSpinner();
		
	}

	private void ActivateSpinner() {
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				if(position==1){

					Toast.makeText(parent.getContext(), "You have selected Deutsch", Toast.LENGTH_LONG).show();
				    setLocale("de");
				}else if(position==2){
					
					Toast.makeText(parent.getContext(), "You have selected Frensh", Toast.LENGTH_LONG).show();
				    setLocale("fr");
				} else if(position==3){
					
					Toast.makeText(parent.getContext(), "You have selected English", Toast.LENGTH_LONG).show();
				   setLocale("en");
				}else if(position==4){
					
					Toast.makeText(parent.getContext(), "You have selected Arabic", Toast.LENGTH_LONG).show();
				   setLocale("ar");
				   //setTheme(R.style.arabicbodytext);
				}

				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});

		
	}
	
	private void setLocale(String lang){
		
		myLocale =new Locale(lang);
		Resources res=getResources();
		DisplayMetrics dm=res.getDisplayMetrics();
		Configuration cf =res.getConfiguration();
		cf.locale=myLocale;
		res.updateConfiguration(cf, dm);
		
		super.onRestart();
		Intent intent =new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
