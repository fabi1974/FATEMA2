package com.fabian.contactoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckData extends AppCompatActivity {

    TextView txtFullName;
    TextView txtBirthday;
    TextView txtTelephone;
    TextView txtEmail;
    TextView txtDescriptionContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_data);

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtBirthday = (TextView) findViewById(R.id.txtBirthday);
        txtTelephone = (TextView) findViewById(R.id.txtTelephone);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescriptionContact = (TextView) findViewById(R.id.txtDescriptionContact);

        Bundle miBundle = getIntent().getExtras();
        String fullName = miBundle.getString("fullName");
        String birthDay = miBundle.getString("birthDay");
        String telephone = miBundle.getString("telephone");
        String email = miBundle.getString("email");
        String descriptionContact = miBundle.getString("descriptionContact");

        txtFullName.setText(fullName);
        txtBirthday.setText(birthDay);
        txtTelephone.setText(telephone);
        txtEmail.setText(email);
        txtDescriptionContact.setText(descriptionContact);

    }

    public void goMainActivity (View view) {
        finish();
    }

}