package com.example.parkhere.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.parkhere.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Register extends AppCompatActivity {

    private MaterialButton btnRegister, btnLinkToLogin;
    private TextInputLayout inputName, inputEmail, inputPassword;
    private FirebaseAuth auth= FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = findViewById(R.id.edit_name);
        inputEmail = findViewById(R.id.edit_email);
        inputPassword = findViewById(R.id.edit_password);
        btnRegister = findViewById(R.id.button_register);
        btnLinkToLogin = findViewById(R.id.button_login);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Objects.requireNonNull(inputName.getEditText()).getText().toString().trim();
                String email = Objects.requireNonNull(inputEmail.getEditText()).getText().toString().trim();
                String password = Objects.requireNonNull(inputPassword.getEditText()).getText().toString().trim();
                createAccount(name,email,password);
            }
        });


        // Link to Register Screen
        btnLinkToLogin.setOnClickListener(view -> {
            Intent i = new Intent(Register.this, Login.class);
            startActivity(i);
            finish();
        });



    }


    private void createAccount(String  name ,String email, String password) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Account has been created", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Register.this, Login.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(Register.this, "There's a problem", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END create_user_with_email]
    }

}