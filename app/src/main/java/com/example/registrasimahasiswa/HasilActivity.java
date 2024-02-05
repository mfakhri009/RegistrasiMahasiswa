package com.example.registrasimahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5,txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        txt1 = findViewById(R.id.hasilnama);
        txt2 = findViewById(R.id.hasilemail);
        txt3 = findViewById(R.id.hasilpasssword);
        txt4 = findViewById(R.id.hasiljeniskelamin);
        txt5 = findViewById(R.id.hasilusia);
        txt6 = findViewById(R.id.hasilprodi);

        String nama = getIntent().getExtras().getString( "nama");
        String email = getIntent().getExtras().getString( "email");
        String katasandi = getIntent().getExtras().getString( "katasandi");
        String jeniskelamin = getIntent().getExtras().getString( "jeniskelamin");
        String usia = getIntent().getExtras().getString( "usia");
        String prodi = getIntent().getExtras().getString( "prodi");

        txt1.setText("Nama : "+nama);
        txt2.setText("Email : "+email);
        txt3.setText("Kata Sandi : "+katasandi);
        txt4.setText("Jenis Kelamin : "+jeniskelamin);
        txt5.setText("Usia : "+usia);
        txt6.setText("Program Studi : "+prodi);
    }
}