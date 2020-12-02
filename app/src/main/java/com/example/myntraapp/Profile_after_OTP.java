package com.example.myntraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class Profile_after_OTP extends AppCompatActivity {

    String mVerificationId;
    EditText editText;
    // FirebaseAuth firebaseAuth;
    Button btn;
    // RequestQueue mQueue;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_after__o_t_p);
        Intent intent = getIntent();
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        //initializing objects
        // firebaseAuth = FirebaseAuth.getInstance();
        editText = findViewById(R.id.editText);
        String mobile = intent.getStringExtra("mobile");
        // mQueue = Volley.newRequestQueue(this);
        //jsonParse();
        // sendVerificationCode(mobile);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String code = editText.getText().toString().trim();
                if (code.isEmpty() || code.length() < 6) {
                    editText.setError("Enter valid code");
                    editText.requestFocus();
                    return;
                }
                Intent intent = new Intent(Profile_after_OTP.this, ProfilePage.class);
                startActivity(intent);

                //    verifyVerificationCode(code);
            }
        });

    }

}

