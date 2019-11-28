package com.example.labarradeltiburon;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private int mYear, mMonth, mDay;
    private TextInputLayout til_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        til_date = (TextInputLayout) findViewById(R.id.til_date);
        //DATEPICKER
        final  Calendar calendar = Calendar.getInstance();
         mDay  = calendar.get(Calendar.DAY_OF_MONTH);
         mMonth  = calendar.get(Calendar.MONTH);
         mYear  = calendar.get(Calendar.YEAR);
        til_date.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                til_date.getEditText().setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }


        });






    }
}
