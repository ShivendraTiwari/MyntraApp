package com.example.myntraapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
//import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInResult;

//public class ProfilePage extends AppCompatActivity implements View.OnClickListener,
//        GoogleApiClient.OnConnectionFailedListener {
public class ProfilePage extends AppCompatActivity {


    // GoogleSignInClient mGoogleSignInClient;
    LinearLayout btn;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 430;
    private GoogleApiClient mGoogleApiClient;
    private SignInButton btnSignIn;
    public LinearLayout facebook, google;
    public CallbackManager callbackManager;
    LinearLayout linearBig1;
    public String id, name, email, gender, birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        Intent intent = getIntent();
        btn = findViewById(R.id.google);
        facebook = findViewById(R.id.fb);
        google = findViewById(R.id.google);
        linearBig1 = findViewById(R.id.linearbig);
        callbackManager = CallbackManager.Factory.create();
//        List<String> permissionNeeds = Arrays.asList("user_photos", "email",
//                "user_birthday", "public_profile", "AccessToken");
//        linearBig1.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                System.out.println("onSuccess");
//                String accessToken = loginResult.getAccessToken()
//                        .getToken();
//                Log.i("accessToken", accessToken);
//                GraphRequest request = GraphRequest.newMeRequest(
//                        loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object,
//                                                    GraphResponse response) {
//                                Log.i("LoginActivity",
//                                        response.toString());
//                                try {
//                                    id = object.getString("id");
//                                    try {
//                                        URL profile_pic = new URL(
//                                                "http://graph.facebook.com/" + id + "/picture?type=large");
//                                        Log.i("profile_pic",
//                                                profile_pic + "");
//
//                                    } catch (MalformedURLException e) {
//                                        e.printStackTrace();
//                                    }
//                                    Log.e("UserDate", String.valueOf(object));
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,email,gender, birthday");
//                request.setParameters(parameters);
//                request.executeAsync();
//            }
//
//            @Override
//            public void onCancel() {
//                System.out.println("onCancel");
//            }
//
//            @Override
//            public void onError(FacebookException exception) {
//                System.out.println("onError");
//                Log.v("LoginActivity", exception.getCause().toString());
//            }
//        });
//        //initializeControls();
//        initializeGPlusSettings();
//    }
//
////    private void initializeControls() {
////        btnSignIn = (SignInButton) findViewById(R.id.linearbig2);
////        btnSignIn.setOnClickListener(this);
////    }
//
//    private void initializeGPlusSettings() {
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                .build();
//        btnSignIn.setSize(SignInButton.SIZE_STANDARD);
//        btnSignIn.setScopes(gso.getScopeArray());
//    }
//
//    private void signIn() {
//        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//    private void signOut() {
//        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                new ResultCallback() {
//                    @Override
//                    public void onResult(@NonNull Result result) {
//                        updateUI(false);
//                    }
//
//                });
//    }
//
//
//    private void handleGPlusSignInResult(GoogleSignInResult result) {
//        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
//        if (result.isSuccess()) {
//            GoogleSignInAccount acct = result.getSignInAccount();
//            //Fetch values
//            String personName = acct.getDisplayName();
//            String personPhotoUrl = acct.getPhotoUrl().toString();
//            String email = acct.getEmail();
//            String familyName = acct.getFamilyName();
//            Log.e(TAG, "Name: " + personName + ", email: " + email + ", Image: " + personPhotoUrl + ", Family Name: " + familyName);
//            updateUI(true);
//        } else {
//            updateUI(false);
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        OptionalPendingResult opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
//        if (opr.isDone()) {
//            Log.d(TAG, "Got cached sign-in");
//            GoogleSignInResult result = (GoogleSignInResult) opr.get();
//            handleGPlusSignInResult(result);
//        } else {
//            opr.setResultCallback(new ResultCallback() {
//                @Override
//                public void onResult(@NonNull Result result) {
//                    handleGPlusSignInResult((GoogleSignInResult) result);
//                }
//
//            });
//        }
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
//        // be available.
//        Log.d(TAG, "onConnectionFailed:" + connectionResult);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int responseCode,
//                                    Intent data) {
//        if (requestCode == RC_SIGN_IN) {
//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            handleGPlusSignInResult(result);
//        } else {
//            super.onActivityResult(requestCode, responseCode, data);
//            callbackManager.onActivityResult(requestCode, responseCode, data);
//        }
//    }
//
//    public void onClick(View v) {
//        if (v == facebook) {
//            linearBig1.performClick();
//        } else if (v == google) {
//            signIn();
//        }
//    }
//
//    private void updateUI(boolean isSignedIn) {
//        if (isSignedIn) {
//            btnSignIn.setVisibility(View.GONE);
//        } else {
//            btnSignIn.setVisibility(View.VISIBLE);
//        }
//    }


//        GoogleSignInOptions googleSignIn = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignIn);
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);
//        // SignInButton signInButton=new SignInButton()
//
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btn:
//                        signIn();
//                        break;
//
//                }
//            }
//
//            private void signIn() {
//                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//                startActivity(signInIntent, RC_SignIn);
//            }
//
//
//        });
//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//
//            // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//            if (requestCode == RC_SIGN_IN) {
//                // The Task returned from this call is always completed, no need to attach
//                // a listener.
//                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                handleSignInResult(task);
//            }
//        }
//
//        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//            try {
//                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//
//                // Signed in successfully, show authenticated UI.
//                updateUI(account);
//            } catch (ApiException e) {
//                // The ApiException status code indicates the detailed failure reason.
//                // Please refer to the GoogleSignInStatusCodes class reference for more information.
//                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//                updateUI(null);
//            }
//        }


    }
}