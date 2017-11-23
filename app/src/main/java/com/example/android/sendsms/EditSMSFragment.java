package com.example.android.sendsms;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditSMSFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public EditSMSFragment() {
        // Required empty public constructor
    }

    Button button;
    EditText msgET,numberET;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_edit_sms, container, false);
        button=view.findViewById(R.id.sendBtn);
        msgET=view.findViewById(R.id.messageBodyET);
        numberET=view.findViewById(R.id.numberET);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(msgET.getText().toString(), Integer.parseInt(numberET.getText().toString()));
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String msg,int number) {
        if (mListener != null) {
            mListener.onFragmentInteraction(msg,number);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String msg,int number);
    }
}
