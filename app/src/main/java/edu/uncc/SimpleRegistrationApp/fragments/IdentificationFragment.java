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
import edu.uncc.SimpleRegistrationApp.databinding.FragmentIdentificationBinding;

public class IdentificationFragment extends Fragment {
    FragmentIdentificationBinding binding;
    String role = "";

    public IdentificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIdentificationBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonStudent){
                    role = "Student";
                } else if(checkedId == R.id.radioButtonEmployee){
                    role = "Employee";
                } else if(checkedId == R.id.radioButtonOther){
                    role = "Other";
                }
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editTextName.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a name", Toast.LENGTH_SHORT).show();
                } else if(binding.editTextEmail.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a email", Toast.LENGTH_SHORT).show();
                } else if(role.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter a role", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = binding.editTextName.getText().toString();
                    String email = binding.editTextEmail.getText().toString();

                    Response response = new Response(name,email,role);
                    mListener.goToDemographic(response);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (IdentificationListener) context;
    }
    IdentificationListener mListener;
    public interface IdentificationListener{
        void goToDemographic(Response response);
    }
}