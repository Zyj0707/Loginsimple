package com.example.loginsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 张垚杰 on 2018/1/15.
 */

public class LoginActivityJava extends BaseActivityJava{
    private EditText accountEdit,passwordEdit;

    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        accountEdit=(EditText)findViewById(R.id.login_name);
        passwordEdit=(EditText)findViewById(R.id.login_passww);
        button=findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123")){
                    Intent intent = new Intent(LoginActivityJava.this,HomeActivityJava.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivityJava.this,"account or password is error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
