package edu.uncc.SimpleRegistrationApp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import edu.uncc.SimpleRegistrationApp.R;
import edu.uncc.SimpleRegistrationApp.databinding.FragmentSelectIncomeBinding;

public class SelectIncomeFragment extends Fragment {
    FragmentSelectIncomeBinding binding;

    String income;
    public SelectIncomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSelectIncomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    income = "<$25K";
                    binding.textViewHouseHoldIncome.setText(income);
                } else if (progress == 1) {
                    income = "$25K to <$50K";
                    binding.textViewHouseHoldIncome.setText(income);
                } else if (progress == 2) {
                    income = "$50K to <$100K";
                    binding.textViewHouseHoldIncome.setText(income);
                } else if (progress == 3) {
                    income = "$100K to<$200K";
                    binding.textViewHouseHoldIncome.setText(income);
                } else if (progress == 4) {
                    income = ">$200K";
                    binding.textViewHouseHoldIncome.setText(income);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.sendIncome(income);
            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelIncome();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (SelectIncomeListener) context;
    }
    SelectIncomeListener mListener;
    public interface SelectIncomeListener{
        void sendIncome(String income);
        void cancelIncome();
    }
}