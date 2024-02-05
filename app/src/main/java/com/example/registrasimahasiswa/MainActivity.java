package com.example.registrasimahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText etnm;
EditText etem;
EditText etps;
RadioGroup rb;
RadioButton rb2;
SeekBar sb;
Spinner sp;
ToggleButton tb;
TextView tu,tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inputan
        etnm = findViewById(R.id.etnm);
        etem = findViewById(R.id.etem);
        etps = findViewById(R.id.etps);

        //JenisKelamin
        rb = findViewById(R.id.rb);

        //Usia
        sb = findViewById(R.id.sb);
        tu = findViewById(R.id.tu);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int proggres, boolean fromUser) {
                tu.setText(String.valueOf(progress + "Tahun"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Prodi
        sp = findViewById(R.id.sp);
        tp = findViewById(R.id.tp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( context: this,
            R.array.nama_prodi, android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String programstudi = parent.getItemAtPosition(position).toString();
        tp.setText(String.valueOf(programstudi));
    }
    @Override
    public void  onNothingSelected(AdapterView<?> parent){

    }
    public void kirimdata(View view) {
        int idradio = rb.getCheckedRadioButtonId();
        rb2 = findViewById(idradio);

        Intent i1 = new Intent( packageContext: this, HasilActivity.class);
        i1.putExtra( name: "nama",etnm.getText().toString());
        i1.putExtra( name: "email",etem.getText().toString());
        i1.putExtra( name: "katasandi",etps.getText().toString());
        i1.putExtra( name: "jeniskelamin",rb2.getText().toString());
        i1.putExtra( name: "usia",tu.getText().toString());
        i1.putExtra( name: "prodi",tp.getText().toString());
        startActivity(i1);
    }
}