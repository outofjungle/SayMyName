package com.example.saymyname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AskNameActivity extends Activity {

	public Button btnGo;
	public EditText etName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ask_name);
		
		btnGo = (Button) findViewById(R.id.btnGo);
		etName = (EditText) findViewById(R.id.etName);
		
		btnGo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = etName.getText().toString();
				Intent data = new Intent();
				data.putExtra("name", name);
				setResult(RESULT_OK, data);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ask_name, menu);
		return true;
	}

}
