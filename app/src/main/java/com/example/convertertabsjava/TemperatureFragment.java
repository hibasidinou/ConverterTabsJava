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

public class TemperatureFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        RadioGroup rgDirection  = view.findViewById(R.id.rgDirection);
        RadioButton rbCtoF      = view.findViewById(R.id.rbCelsiusToFahr);
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

            if (rbCtoF.isChecked()) {
                output = input * 9.0 / 5.0 + 32;
                label  = String.format("%.2f °F", output);
            } else {
                output = (input - 32) * 5.0 / 9.0;
                label  = String.format("%.2f °C", output);
            }

            tvResult.setText(label);
        });

        return view;
    }
}