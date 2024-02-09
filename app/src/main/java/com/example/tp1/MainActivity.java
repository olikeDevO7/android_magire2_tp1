package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    protected Button BtnValidate;
    protected TextInputEditText pseudoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnValidate = findViewById(R.id.Btn_Validate);
        BtnValidate.setEnabled(false);
        pseudoInput = findViewById(R.id.PseudTxtInput);
        pseudoInput.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        BtnValidate.setEnabled(s.length() > 3);
                        BtnValidate.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       openMainActivity2();
                                }
                            }
                        );
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }
        );

    }

    protected void openMainActivity2(){
        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(myIntent);
    }
}