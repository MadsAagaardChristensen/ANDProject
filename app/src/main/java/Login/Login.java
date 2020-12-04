package Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examand1.MainActivity;
import com.example.examand1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText loginMail, loginPassword;
    Button loginSignin, createUser;
    private FirebaseAuth loginfAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginMail = findViewById(R.id.LoginEmail);
        loginPassword = findViewById(R.id.LoginPassword);
        loginSignin = findViewById(R.id.Loginbutton1);
        loginfAuth = FirebaseAuth.getInstance();
        createUser = findViewById(R.id.CreateProfileButton);

        createUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openRegister();

            }
        });
        loginSignin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String SigninEmail = loginMail.getText().toString().trim();
                String SigninPass = loginPassword.getText().toString().trim();
                if (TextUtils.isEmpty(SigninEmail)) {
                    loginMail.setError("Missing email");
                    return;
                }
                if (TextUtils.isEmpty(SigninPass)) {
                    loginPassword.setError("Missing password");
                    return;
                }

                loginfAuth.signInWithEmailAndPassword(SigninEmail, SigninPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "User was logged in successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(Login.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

        public void openRegister(){
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }

    @Override
    public void onBackPressed() {
// empty so nothing happens
    }

}



