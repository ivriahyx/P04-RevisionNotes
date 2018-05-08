package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayList<Note> al;
	ArrayAdapter aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		lv = (ListView) this.findViewById(R.id.lv);

		al = new ArrayList<Note>();
		aa = new RevisionNotesArrayAdapter(this,R.layout.row,al);

		// Create the DBHelper object, passing in the
		// activity's Context
		DBHelper db = new DBHelper(SecondActivity.this);

		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();

		String txt = "";
		for (int i = 0; i < data.size(); i++) {
			Log.d("Database Content", i +". "+data.get(i).getId()+" "+data.get(i).getNotesContent()+" "+data.get(i).getStars());
			al.add(new Note(data.get(i).getId(),data.get(i).getNotesContent(),data.get(i).getStars()));
		}
		lv.setAdapter(aa);

		Log.d("Arraylist",""+al.get(1).getId()+" "+al.get(1).getNotesContent()+" "+al.get(1).getStars());

	}


}
