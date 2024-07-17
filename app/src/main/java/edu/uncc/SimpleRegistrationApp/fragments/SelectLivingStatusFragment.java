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

import edu.uncc.SimpleRegistrationApp.R;
import edu.uncc.SimpleRegistrationApp.databinding.FragmentSelectLivingStatusBinding;

public class SelectLivingStatusFragment extends Fragment {
    FragmentSelectLivingStatusBinding binding;
    String livingStatus;

    public SelectLivingStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonHomeOwner){
                    livingStatus = "Home Owner";
                } else if(checkedId == R.id.radioButtonRenter){
                    livingStatus = "Renter";
                } else if(checkedId == R.id.radioButtonLessee){
                    livingStatus = "Lessee";
                } else if(checkedId == R.id.radioButtonOther){
                    livingStatus = "Other";
                } else if(checkedId == R.id.radioButtonPreferNotToSay){
                    livingStatus = "Prefer not to say";
                }
            }
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.sendLivingStatus(livingStatus);
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelLivingStatus();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectLivingStatusListener) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectLivingStatusBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    SelectLivingStatusListener mListener;
    public interface SelectLivingStatusListener{
        void sendLivingStatus(String livingStatus);
       void cancelLivingStatus();
    }
}