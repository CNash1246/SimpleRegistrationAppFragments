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
import edu.uncc.SimpleRegistrationApp.databinding.FragmentSelectEducationBinding;

public class SelectEducationFragment extends Fragment {
    FragmentSelectEducationBinding binding;
    String education = "N/A";

    public SelectEducationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectEducationBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonHS){
                    education = "High School";
                } else if(checkedId == R.id.radioButtonBHS){
                    education = "Below High School";
                } else if(checkedId == R.id.radioButtonBS){
                    education = "Bachelor's Degree";
                } else if(checkedId == R.id.radioButtonMS){
                    education = "Master's Degree";
                } else if(checkedId == R.id.radioButtonPHD){
                    education = "Ph.D. or higher";
                } else if(checkedId == R.id.radioButtonTS){
                    education = "Trade School";
                } else if(checkedId == R.id.radioButtonPreferNotToSay){
                    education = "Prefer not to say";
                }
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(education.equals("N/A")){
                    Toast.makeText(getActivity(), "Select a radio button", Toast.LENGTH_SHORT).show();
                    return;
                }
                mListener.sendEducation(education);
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelEducation();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectEducationListener) context;
    }
    SelectEducationListener mListener;
    public interface SelectEducationListener{
        void sendEducation(String education);
        void cancelEducation();
    }
}