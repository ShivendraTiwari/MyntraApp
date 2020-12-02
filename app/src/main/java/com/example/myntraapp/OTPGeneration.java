package com.example.myntraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OTPGeneration extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText OTP;
    FirebaseAuth firebaseAuth;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_o_t_p_generation);
        Intent intent = getIntent();
        OTP = findViewById(R.id.editText);
        button = findViewById(R.id.btn);
        mQueue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String mobile = OTP.getText().toString().trim();
                if (mobile.isEmpty() || mobile.length() < 10) {
                    OTP.setError("Enter a Valid Number");
                    OTP.requestFocus();
                    return;
                }
                //jsonParse();
                String WebURLS = "https://u9.aaratechnologies.in/admin/ecommerce_api/register-api.php";
                String WebURLs2 = "https://u9.aaratechnologies.in/admin/ecommerce_api/confirm-api.php";
                Intent intent = new Intent(OTPGeneration.this, Profile_after_OTP.class);
                startActivity(intent);
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        WebURLS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();


                        OTPGenerationModel user1 = gson.fromJson(response, OTPGenerationModel.class);
                        //
                        String r = user1.OTP;
                        if (r.equals("200")) {
//                            progressDialog.dismiss();
                            //       Toast.makeText(LoginActivity.this, ""+r, Toast.LENGTH_SHORT).show();
                            //
                            OTPGenerationModel alldata = user1;
//                                Toast.makeText(LoginActivity.this, ""+alldata.getUser_name(), Toast.LENGTH_SHORT).show();
                            //storing the user in shared preferences
                            //   SharedPreferences sharedPreferences = getSharedPreferences(OTPGeneration(alldata));
                            //  sharedPreferences .getInstance(getApplicationContext()).userLogin(alldata);
                            Intent intent = new Intent(getApplicationContext(), Profile_after_OTP.class);
                            startActivity(intent);
                            finish();
                        } else {
//                            progressDialog.dismiss();
                            Toast.makeText(OTPGeneration.this, "" + user1.getOTP(), Toast.LENGTH_SHORT).show();
                        }
//                        Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(OTPGeneration.this, "Network Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> hm = new HashMap<>();
                        // hm.put("email", emailId.getText().toString().trim());
                        hm.put("password", OTP.getText().toString().trim());
                        return hm;
                    }
                };
                //  VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

//                Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
//                startActivity(intent);
                mQueue.add(stringRequest);
            }
        });


//        forgetPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openForgetDialog();
//            }
//        });
    }

    public void gotoReg(View view) {
        Intent intent = new Intent(getApplicationContext(), Profile_after_OTP.class);
//        Pair[] pairs = new Pair[2];
//        pairs[0] = new Pair<View, String>(image, "logo_img");
//        pairs[1] = new Pair<View, String>(txt, "logo_txt");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(OTPGeneration.this, pairs);

            Log.d("hhhh", "run: Gaya");
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
            finish();
        }

    }

//    public void openForgetDialog() {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(OTPGeneration.this);
//        View view1 = getLayoutInflater().inflate(R.layout.forget_password_layout, null);
//        Button btn_save = (Button) view1.findViewById(R.id.submit);
//        ImageView clear = (ImageView) view1.findViewById(R.id.clear);
//        final TextInputEditText contact = view1.findViewById(R.id.contact);
//
//        builder.setView(view1);
//        final AlertDialog alertDialog = builder.create();
//
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });

//        button.setOnClickListener(new View.OnClickListener(){
//        @Override
//        public void onClick (View view){
//        if (contact.getText().toString().trim().isEmpty()) {
//            contact.setError("Empty");
//            contact.requestFocus();
//            return;
//        }
//        if (contact.getText().toString().trim().length() < 10) {
//            contact.setError("Can't be less than 10 Letters!");
//            contact.requestFocus();
//            return;
//        }
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, WebURLS.FORGET_PASSWORD, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    if (jsonObject.getString("status").equalsIgnoreCase("200")) {
//                        Toast.makeText(LoginActivity.this, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), OtpVerificationForgetActivity.class);
//                        intent.putExtra("phone", contact.getText().toString().trim());
//                        alertDialog.dismiss();
//                        startActivity(intent);
//                        finish();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(LoginActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//                error.printStackTrace();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> hm = new HashMap<>();
//                hm.put("del_mobile", contact.getText().toString().trim());
//                return hm;
//            }
//        };
//        VolleySingleton.getInstance(
//
//    getApplicationContext()).
//
//    addToRequestQueue(stringRequest);
////                Toast.makeText(LoginActivity.this, "Ok", Toast.LENGTH_SHORT).show();
//
//        alertDialog.dismiss();
//}
//    });
//            alertDialog.show();
//
//            }
//            }
//            });
//
//            }
//            });
//            }
//            }