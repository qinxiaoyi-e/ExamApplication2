package com.bignerdranch.android.examapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class BrowerIntentWebActivity extends AppCompatActivity {
    private EditText mEditTextUri;
    private Button mButtonBroswerIntentWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brower_intent_web);

        mEditTextUri=(EditText)findViewById(R.id.editText_uri);
        mButtonBroswerIntentWeb=(Button)findViewById(R.id.broswer_button);
    }
    public void onClickBroswerIntentWeb(View view){
        Uri uriBroswer=Uri.parse(mEditTextUri.getText().toString());
        BrowerIntentWebActivity.this.startActivity(new Intent(Intent.ACTION_VIEW,uriBroswer));
    }
}
