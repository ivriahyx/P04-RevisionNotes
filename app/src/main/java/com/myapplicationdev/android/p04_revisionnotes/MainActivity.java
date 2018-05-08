package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText etContent;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    Button btnInsert, btnShowList;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etContent = (EditText)findViewById(R.id.editTextNote);
        rg = (RadioGroup)findViewById(R.id.radioGroupStars);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList = (Button)findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);

                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedButtonId);
                int rating = Integer.parseInt(rb.getText().toString());
                String content = etContent.getText().toString();
                // Insert a task
                db.insertNote(content,rating);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this,SecondActivity.class);
             startActivity(intent);

            }
        });
    }
}
