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

public class ActivityRegister extends AppCompatActivity {

    private EditText editTextPhone,editTextFullName,editTextEmail,editTextPassword,editTextConfirmPassword;
    private Button btnLogin;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextPhone.addTextChangedListener(textWatcher);

        editTextFullName = (EditText) findViewById(R.id.editTextName);
        editTextFullName.addTextChangedListener(textWatcher);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.addTextChangedListener(textWatcher);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPassword.addTextChangedListener(textWatcher);

        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        editTextConfirmPassword.addTextChangedListener(textWatcher);

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

        TextView LoginActivity = (TextView) findViewById(R.id.textLogin);
        LoginActivity.setMovementMethod(LinkMovementMethod.getInstance());
        LoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityRegister.this, ActivityLogin.class));
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userNameInput = editTextPhone.getText().toString();
            String fullNameInput = editTextFullName.getText().toString();
            String emailInput = editTextEmail.getText().toString();
            String passwordInput = editTextPassword.getText().toString();
            String confirmPasswordInput = editTextConfirmPassword.getText().toString();
            btnLogin.setEnabled(!userNameInput.isEmpty() && !fullNameInput.isEmpty() && !emailInput.isEmpty() && !passwordInput.isEmpty() && !confirmPasswordInput.isEmpty());
        }

        public void afterTextChanged(Editable s) {

        }
    };

    private boolean CheckAllFields() {
        if (editTextPhone.length() == 0) {
            editTextPhone.setError("This field is required");
            return false;
        }else if (editTextPhone.length() < 5) {
            editTextPhone.setError("User Name must be minimum 5 characters");
            return false;
        }

        if (editTextFullName.length() == 0) {
            editTextFullName.setError("This field is required");
            return false;
        }else if (editTextFullName.length() < 5) {
            editTextFullName.setError("Full Name must be minimum 5 characters");
            return false;
        }

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

        if (!editTextConfirmPassword.equals(editTextPassword)){
            editTextConfirmPassword.setError("Password does not match");
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