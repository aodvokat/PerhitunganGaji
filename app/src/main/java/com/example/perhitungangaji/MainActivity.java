package com.example.perhitungangaji;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.perhitungangaji.R;

public class MainActivity extends AppCompatActivity {
    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View v){
        EditText nama = (EditText) findViewById(R.id.nama);
        TextView outputNama = (TextView) findViewById(R.id.outputNama);
        String name = nama.getText().toString();
        outputNama.setText("Nama Anda: " + name);

        status = (CheckBox) findViewById(R.id.menikah);
        String statusPernikahan = status.isChecked() ? "Menikah" : "Belum Menikah";

        golongan = (RadioGroup) findViewById(R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        String golonganText = "";
        if (gol == R.id.rbGolongan1) {
            gajiGolongan = 1000000;
            golonganText = "Golongan 1";
        } else if (gol == R.id.rbGolongan2) {
            gajiGolongan = 2000000;
            golonganText = "Golongan 2";
        }

        gajiStatus = status.isChecked() ? 500000 : 0;

        int totalGaji = gajiStatus + gajiGolongan;
        TextView total = (TextView) findViewById(R.id.outputGaji);
        total.setText("Gaji Anda: " + totalGaji);

        TextView statusMenikah = (TextView) findViewById(R.id.outputStatus);
        statusMenikah.setText("Status : " + statusPernikahan);

        TextView golonganTextView = (TextView) findViewById(R.id.outputGol);
        golonganTextView.setText("Golongan : " + golonganText);
    }
}
