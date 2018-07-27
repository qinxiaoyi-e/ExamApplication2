package com.bignerdranch.android.examapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Button mNextButton;
    private EditText mHelloEditText;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);



        mNextButton=(Button)view.findViewById(R.id.next_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "hello"+mHelloEditText.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),StatusActivity.class);
                startActivity(intent);
            }
        });
        mHelloEditText = (EditText) view.findViewById(R.id.edittext);
        return view;
    }

}
