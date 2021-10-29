package com.example.regentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityLogin extends AppCompatActivity {

    private EditText editTextEmail,editTextPassword;
    private Button btnLogin;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.addTextChangedListener(textWatcher);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPassword.addTextChangedListener(textWatcher);

        btnLogin = (Button) findViewById(R.id.button_submit);


        TextView registerActivity = (TextView) findViewById(R.id.textRegister);
        registerActivity.setMovementMethod(LinkMovementMethod.getInstance());
        registerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this, ActivityRegister.class));
            }
        });

        TextView forgetPasswordActivity = (TextView) findViewById(R.id.textResetPassword);
        forgetPasswordActivity.setMovementMethod(LinkMovementMethod.getInstance());
        forgetPasswordActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this, ActivityForgetPassword.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), "You Successfully Complete Your Form", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = editTextEmail.getText().toString();
            String passwordInput = editTextPassword.getText().toString();
            btnLogin.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty());
        }

        public void afterTextChanged(Editable s) {

        }
    };

    private boolean CheckAllFields() {
        if (editTextEmail.length() == 0) {
            editTextEmail.setError("Email is required");
            return false;
        }

        if (editTextPassword.length() == 0) {
            editTextPassword.setError("Password is required");
            return false;
        } else if (editTextPassword.length() < 8) {
            editTextPassword.setError("Password must be minimum 8 characters");
            return false;
        }
        return true;
    }
}