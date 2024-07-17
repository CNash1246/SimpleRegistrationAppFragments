package edu.uncc.SimpleRegistrationApp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uncc.SimpleRegistrationApp.R;
import edu.uncc.SimpleRegistrationApp.databinding.FragmentDemographicBinding;

public class DemographicFragment extends Fragment {
    FragmentDemographicBinding binding;
    private static final String ARG_PARAM_PROFILE = "ARG_PARAM_PROFILE";
    private Response response;
    String education="N/A",maritalStatus="N/A",livingStatus="N/A",income="N/A";

    public DemographicFragment() {
        // Required empty public constructor
    }

    public void setSelectedEducation(String education){
        this.education = education;
        response.setEducation(education);
    }

    public void setMaritalStatus(String maritalStatus){
        this.maritalStatus = maritalStatus;
        response.setMaritalStatus(maritalStatus);
    }

    public void setIncome(String income){
        this.income = income;
        response.setIncome(income);
    }

    public void setLivingStatus(String livingStatus){
        this.livingStatus = livingStatus;
        response.setLivingStatus(livingStatus);
    }
    public static DemographicFragment newInstance(Response response) {
        DemographicFragment fragment = new DemographicFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_PROFILE, response);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            response = (Response) getArguments().getSerializable(ARG_PARAM_PROFILE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDemographicBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.textViewEducation.setText(education);
        binding.textViewMaritalStatus.setText(maritalStatus);
        binding.textViewLivingStatus.setText(livingStatus);
        binding.textViewIncomeStatus.setText(income);

        binding.buttonSelectEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToEducation();
            }
        });

        binding.buttonSelectMarital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToMaritalStatus();
            }
        });

        binding.buttonSelectLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToLivingStatus();
            }
        });

        binding.buttonSelectIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.goToIncome();
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(education.equals("N/A")){
                    Toast.makeText(getActivity(), "Please select a education", Toast.LENGTH_SHORT).show();
                } else if(maritalStatus.equals("N/A")){
                    Toast.makeText(getActivity(), "Please select a marital status", Toast.LENGTH_SHORT).show();
                } else if(livingStatus.equals("N/A")){
                    Toast.makeText(getActivity(), "Please select a living status", Toast.LENGTH_SHORT).show();
                } else if(income.equals("N/A")){
                    Toast.makeText(getActivity(), "Please select a income", Toast.LENGTH_SHORT).show();
                }else {
                    mListener.goToProfile(response);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (DemographicListener) context;
    }

    DemographicListener mListener;
    public interface DemographicListener{
        void goToEducation();
        void goToMaritalStatus();
        void goToLivingStatus();
        void goToIncome();
        void goToProfile(Response response);
    }
}