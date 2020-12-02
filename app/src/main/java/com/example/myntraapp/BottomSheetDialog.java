package com.example.myntraapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    RequestQueue mQueue;
    List<BottomSheetModel> arrayList;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_dialog,
                container, false);
        RelativeLayout algo_button = view.findViewById(R.id.relat1);
        //  Button course_button = v.findViewById(R.id.course_button);
        //mQueue = Volley.newRequestQueue(getContext());
        arrayList = new ArrayList<>();
        //recyclerView.setHasFixedSize(true);
        algo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "OTP", Toast.LENGTH_SHORT)
                        .show();
                dismiss();
                Intent intent = new Intent(getContext(), Profile_after_OTP.class);
                startActivity(intent);
                //jsonParse();
            }
        });
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        course_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(),
//                        "Course Shared", Toast.LENGTH_SHORT)
//                        .show();
//                dismiss();
//            }
//        });
        return view;

    }

//    private void jsonParse() {
//
//        String url1 = "https://u9.aaratechnologies.in/admin/ecommerce_api/register-api.php";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    //String recipient="";
//                    JSONObject jsonObject = new JSONObject(response);
//                    String balance = jsonObject.getString("balance");
//                    String batch_id = jsonObject.getString("batch_id");
//                    String cost = jsonObject.getString("cost");
//                    String num_messages = jsonObject.getString("num_messages");
//                    JSONArray jsonArray1 = jsonObject.getJSONArray("message");
//                    for (int i = 0; i < jsonArray1.length(); i++) {
//                        JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
//                        String num_parts = jsonObject.getString("num_parts");
//                        String sender = jsonObject.getString("sender");
//                        String content = jsonObject.getString("content");
//                        arrayList.add(new BottomSheetModel(content));
//                    }
//                    String receipt_url = jsonObject.getString("receipt_url");
//                    String custom = jsonObject.getString("custom");
//                    JSONArray jsonArray2 = jsonObject.getJSONArray("messages");
//                    for (int i = 0; i < jsonArray2.length(); i++) {
//                        String id = jsonObject.getString("id");
//                        String recipient = jsonObject.getString("recipient");
//                    }
//
//                    String status = jsonObject.getString("status");
//                    BottomSheetDialogAdapter bottomSheetDialogAdapter
//                            = new BottomSheetDialogAdapter(getContext(), arrayList);
//                    recyclerView.setAdapter(bottomSheetDialogAdapter);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//
//        mQueue.add(stringRequest);
}


//        private void sendVerificationCode(String mobile) {
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                "+91" + mobile, 60, TimeUnit.SECONDS,
//                TaskExecutors.MAIN_THREAD, mCallbacks);
//    }
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//
//            //Getting the code sent by SMS
//            String code = phoneAuthCredential.getSmsCode();
//
//            //sometime the code is not detected automatically
//            //in this case the code will be null
//            //so user has to manually enter the code
//            if (code != null) {
//                editText.setText(code);
//                //verifying the code
//                verifyVerificationCode(code);
//            }
//        }
//
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            // Toast.makeText(.this, e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
//
//            //storing the verification id that is sent to the user
//            mVerificationId = s;
//        }
//    };
//
//
//    private void verifyVerificationCode(String code) {
//        //creating the credential
//        try {
//            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
//            //signing the user
//            signInWithPhoneAuthCredential(credential);
//        } catch (Exception e) {
//            Toast.makeText(this, "Verification code is wrong ", Toast.LENGTH_SHORT).show();
//            //Toast.setGravity(Gravity.CENTER,0,0);
//        }
//    }
//
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        firebaseAuth.signInWithCredential(credential)
//                .addOnCompleteListener(Profile_after_OTP.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            //verification successful we will start the profile activity
//                            Intent intent = new Intent(Profile_after_OTP.this, ProfilePage.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                            startActivity(intent);
//
//                        } else {
//
//                            //verification unsuccessful.. display an error message
//
//                            String message = "Somthing is wrong, we will fix it soon...";
//
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                message = "Invalid code entered...";
//                            }
//
//                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
//                            snackbar.setAction("Dismiss", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//
//                                }
//                            });
//                            snackbar.show();
//                        }
//                    }
//                });

