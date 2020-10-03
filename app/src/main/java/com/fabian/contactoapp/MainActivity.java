package com.fabian.contactoapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();
    EditText t1;

    EditText edtFullName;
    EditText edtBirthday;
    EditText edtTelephone;
    EditText edtEmail;
    EditText edtDescriptionContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);

        t1 = (EditText) findViewById(R.id.edtBirthday);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });


    }

    public void colocar_fecha() {
        t1.setText((mDayIni + "/" + (mMonthIni+1) + "/" + mYearIni));
    }

    private DatePickerDialog.OnDateSetListener mDataSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYearIni = year;
            mMonthIni = monthOfYear;
            mDayIni = dayOfMonth;
            colocar_fecha();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDataSetListener, sDayIni, sMonthIni, sYearIni);
        }
        return null;
    }

    public void goCheckData(View view) {

        edtFullName = (EditText) findViewById(R.id.edtFullName);
        edtBirthday = (EditText) findViewById(R.id.edtBirthday);
        edtTelephone = (EditText) findViewById(R.id.edtTelephone);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtDescriptionContact = (EditText) findViewById(R.id.edtDescriptionContact);

        String fullName = edtFullName.getText().toString();
        String birthDay = edtBirthday.getText().toString();
        String telephone = edtTelephone.getText().toString();
        String email = edtEmail.getText().toString();
        String descriptionContact = edtDescriptionContact.getText().toString();

        Intent miIntent = new Intent(MainActivity.this, CheckData.class);
        Bundle miBundle = new Bundle();
        miBundle.putString("fullName", edtFullName.getText().toString());
        miBundle.putString("birthDay", birthDay);
        miBundle.putString("telephone", telephone);
        miBundle.putString("email", email);
        miBundle.putString("descriptionContact", descriptionContact);
        miIntent.putExtras(miBundle);
        startActivity(miIntent);

    }

}