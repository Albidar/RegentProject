package com.example.regentproject;

import androidx.appcompat.app.ActionBar;
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
import android.widget.Toast;

public class ActivityForgetPassword extends AppCompatActivity {

    private EditText editTextEmail;
    private Button btnLogin;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setTitle("Forget Password");

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.addTextChangedListener(textWatcher);

        btnLogin = (Button) findViewById(R.id.button_submit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Toast.makeText(getApplicationContext(), "You Successfully Complete Your Form", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView registerActivity = (TextView) findViewById(R.id.textRegister);
        registerActivity.setMovementMethod(LinkMovementMethod.getInstance());
        registerActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForgetPassword.this, ActivityRegister.class));
            }
        });

        TextView ActivityLogin= (TextView) findViewById(R.id.textLogin);
        ActivityLogin.setMovementMethod(LinkMovementMethod.getInstance());
        ActivityLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityForgetPassword.this, ActivityLogin.class));
            }
        });
    }

    private final TextWatcher textWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String emailInput = editTextEmail.getText().toString();
            btnLogin.setEnabled(!emailInput.isEmpty());
        }

        public void afterTextChanged(Editable s) {

        }
    };

    private boolean CheckAllFields() {
        if (editTextEmail.length() == 0) {
            editTextEmail.setError("Email is required");
            return false;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}