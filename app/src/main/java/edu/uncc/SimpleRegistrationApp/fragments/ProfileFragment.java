package edu.uncc.SimpleRegistrationApp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uncc.SimpleRegistrationApp.R;
import edu.uncc.SimpleRegistrationApp.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    private static final String ARG_PARAM1_Profile = "ARG_PARAM1_Profile";
    Response response;

    public ProfileFragment() {
        // Required empty public constructor
    }
    public static ProfileFragment newInstance(Response response) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1_Profile, response);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            response = (Response) getArguments().getSerializable(ARG_PARAM1_Profile);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.textViewName.setText(response.getName());
        binding.textViewEmail.setText(response.getEmail());
        binding.textViewEdu.setText(response.getEducation());
        binding.textViewIncomeValue.setText(response.getIncome());
        binding.textViewMaritalStatus.setText(response.getMaritalStatus());
        binding.textViewLivingStatus.setText(response.getLivingStatus());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}