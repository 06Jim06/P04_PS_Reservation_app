package com.example.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.in_name);
        EditText phone_number = findViewById(R.id.in_number);
        TextView group_size = findViewById(R.id.in_size);
        DatePicker dp = findViewById(R.id.in_dp);
        TimePicker tp = findViewById(R.id.in_tp);
        ToggleButton tbtn = findViewById(R.id.in_smoking_area);
        Button reservebtn = findViewById(R.id.in_reserve);
        Button reset = findViewById(R.id.in_reset);


        //default values
        tp.setIs24HourView(true);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020,5,1);

        reservebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname = "Name: "+name.toString();
                String Sphone = "\nPhone Number: "+phone_number.toString();
                String Sdate = "\nDate: "+dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
                String Stime = "\nTime: "+tp.getCurrentHour()+":"+tp.getCurrentMinute();
                String SsmokingA = "";
                if(tbtn.isChecked()){
                    SsmokingA = "\nSmoking Area: Y";
                }
                else{
                    SsmokingA = "\nSmoking Area: N";
                }
                String Soutput = Sname+Sphone+Sdate+Stime+SsmokingA;

                Toast.makeText(MainActivity.this,Soutput,Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
                name.setText("");
                phone_number.setText("");
                group_size.setText("");
                tbtn.setChecked(false);
                String output = "Fields has been set to default";

                Toast.makeText(MainActivity.this, output, Toast.LENGTH_SHORT).show();
            }
        });


    }
}