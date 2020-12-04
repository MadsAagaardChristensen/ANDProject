package Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.examand1.MainActivity;
import com.example.examand1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText name, mail, password;
    Button signin, alreadyUser;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById((R.id.Name));
        mail = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        signin = findViewById(R.id.button1);
        alreadyUser = findViewById(R.id.button2);
        fAuth = FirebaseAuth.getInstance();


        alreadyUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openLogin();

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String regiEmail = mail.getText().toString().trim();
                String regiPass = password.getText().toString().trim();
                if (TextUtils.isEmpty(regiEmail)) {
                    mail.setError("Missing email");
                    return;
                }
                if (TextUtils.isEmpty(regiPass)) {
                    password.setError("Missing password");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(regiEmail, regiPass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "User was registered successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    Toast.makeText(Register.this, "ERROR" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}









