package edu.uncc.SimpleRegistrationApp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.SimpleRegistrationApp.R;
import edu.uncc.SimpleRegistrationApp.databinding.FragmentSelectMaritalStatusBinding;

public class SelectMaritalStatusFragment extends Fragment {

    FragmentSelectMaritalStatusBinding binding;
    String maritalStatus;

    public SelectMaritalStatusFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectMaritalStatusBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonNotMarried){
                    maritalStatus = "Not Married";
                } else if(checkedId == R.id.radioButtonMarried){
                    maritalStatus = "Married";
                } else if(checkedId == R.id.radioButtonPreferNotToSay){
                    maritalStatus = "Prefer not to say";
                }
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(maritalStatus.isEmpty()){
                    Toast.makeText(getActivity(), "Please select a status", Toast.LENGTH_SHORT).show();
                } else {
                    mListener.sendMaritalStatus(maritalStatus);
                }
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelMaritalStatus();
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectMaritalStatusListener) context;
    }
    SelectMaritalStatusListener mListener;
    public interface SelectMaritalStatusListener{
        void sendMaritalStatus(String maritalStatus);
        void cancelMaritalStatus();
    }
}