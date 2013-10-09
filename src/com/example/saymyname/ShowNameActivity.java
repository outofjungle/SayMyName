package com.example.saymyname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowNameActivity extends Activity {

	public TextView tvSayName;
	public Button btnSayName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_name);
		
		tvSayName = (TextView) findViewById(R.id.tvSayName);
		btnSayName = (Button) findViewById(R.id.btnSayName);
		btnSayName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launchAskNameActivity();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_name, menu);
		return true;
	}

	public void launchAskNameActivity() {
	  Intent i = new Intent(this, AskNameActivity.class);
	  startActivityForResult(i, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (resultCode == RESULT_OK && requestCode == 0) {
		  String name = data.getExtras().getString("name");
		  tvSayName.setText(String.format("Hi, %s", name));
	  }
	}
}
