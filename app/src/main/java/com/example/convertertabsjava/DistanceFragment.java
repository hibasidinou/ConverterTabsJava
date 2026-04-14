package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class DistanceFragment extends Fragment {

    private static final double KM_TO_MILES = 0.621371;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        RadioButton rbKmToMiles = view.findViewById(R.id.rbKmToMiles);
        TextInputEditText etVal = view.findViewById(R.id.etValue);
        MaterialButton btnConv  = view.findViewById(R.id.btnConvert);
        TextView tvResult       = view.findViewById(R.id.tvResult);

        btnConv.setOnClickListener(v -> {
            String raw = etVal.getText() != null ? etVal.getText().toString().trim() : "";

            if (TextUtils.isEmpty(raw)) {
                Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
                return;
            }

            double input  = Double.parseDouble(raw);
            double output;
            String label;

            if (rbKmToMiles.isChecked()) {
                output = input * KM_TO_MILES;
                label  = String.format("%.2f miles", output);
            } else {
                output = input / KM_TO_MILES;
                label  = String.format("%.2f km", output);
            }

            tvResult.setText(label);
        });

        return view;
    }
}