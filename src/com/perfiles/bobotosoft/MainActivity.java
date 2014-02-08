package com.perfiles.bobotosoft;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void start(View v)
	{
		Intent i;
		switch(v.getId())
		{
		case R.id.facebook:
				
			try {
				getPackageManager().getPackageInfo("com.facebook.katana", 0);
			    i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/138911302929621"));
			    
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/<user_name_here>"));
			}
			startActivity(i);
			break;
		case R.id.twitter:
			
			try {
				   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=Bobotosoft")));
				}catch (Exception e) {
				   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/#!/Bobotosoft")));
				}
			break;
		case R.id.rss:
			startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.bobotosoft.com")));
			break;
			
		default:
			break;
		}
		
		
	}

}
