package com.example.ma2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;
import java.util.TimeZone;

public class SecondFragment extends Fragment {
    TextView SPI;

    public static double fact(double i) {
        if (i <= 1)
            return 1;
        else
            return i * fact(i - 1);
    }

    public void main1() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("IST"));
        /* System.out.println("Hour = " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute = " + cal.get(Calendar.MINUTE));
        System.out.println("Second = " + cal.get(Calendar.SECOND));
        System.out.println("Millisecond = " + cal.get(Calendar.MILLISECOND));

         */

        double SP, T_h, T_m , T_s;
        T_s = cal.get(Calendar.SECOND);
        T_m = cal.get(Calendar.MINUTE);
        T_h = cal.get(Calendar.HOUR_OF_DAY);
        SP = fact(T_h)/ (Math.pow(T_m, 3) + T_s);
        SPI.setText(Double.toString(SP));

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SPI = (TextView) view.findViewById(R.id.FS_H3);

        view.findViewById(R.id.FS_B2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        view.findViewById(R.id.FS_B1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1();
            }
        });
    }
}
