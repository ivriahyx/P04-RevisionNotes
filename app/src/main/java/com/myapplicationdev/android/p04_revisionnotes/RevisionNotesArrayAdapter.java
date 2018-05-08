package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	private Context context;
	private ArrayList<Note> notes;
	//int resource;
	private ImageView iv1, iv2, iv3, iv4, iv5;
	private TextView tvNote;


	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
        this.notes=notes;
        // Store Context object as we would need to use it later
        this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row, parent, false);

		//Match the UI components with Java variables
        tvNote = (TextView)rowView.findViewById(R.id.textViewNote);

        iv1=(ImageView)rowView.findViewById(R.id.imageView1star);
        iv2=(ImageView)rowView.findViewById(R.id.imageView2star);
        iv3=(ImageView)rowView.findViewById(R.id.imageView3star);
        iv4=(ImageView)rowView.findViewById(R.id.imageView4star);
        iv5=(ImageView)rowView.findViewById(R.id.imageView5star);

		Note current = notes.get(position);

		tvNote.setText(current.getNotesContent());
		int stars = current.getStars();

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (stars>= 5) {
			iv5.setImageResource(android.R.drawable.btn_star_big_on);
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars>= 4) {
			iv4.setImageResource(android.R.drawable.btn_star_big_on);
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars>= 3) {
			iv3.setImageResource(android.R.drawable.btn_star_big_on);
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars>= 2) {
			iv2.setImageResource(android.R.drawable.btn_star_big_on);
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if (stars>= 1) {
			iv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else{

		}

		/*
		Switch Method

		switch (current.getStars()){
			case 5:iv5.setImageResource(android.R.drawable.btn_star_big_on);
			case 4:iv4.setImageResource(android.R.drawable.btn_star_big_on);
			case 3:iv3.setImageResource(android.R.drawable.btn_star_big_on);
			case 2:iv2.setImageResource(android.R.drawable.btn_star_big_on);
			case 1:iv1.setImageResource(android.R.drawable.btn_star_big_on);
			default:;
		}
		*/
		return rowView;
	}

}
