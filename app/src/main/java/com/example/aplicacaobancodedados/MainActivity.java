package com.example.aplicacaobancodedados;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends Activity {

    Button btcriarbanco;
    Button btcadastrardados;
    Button btcadastrardados2;
    Button btconsultardados;
    Button btalterardados;
    Button btexcluirdados;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcadastrardados = findViewById(R.id.btcadastrardados);
        btcadastrardados2 = findViewById(R.id.btcadastrardados2);
        btconsultardados = findViewById(R.id.btconsultardados);
        btalterardados = findViewById(R.id.btalterardados);
        btexcluirdados = findViewById(R.id.btexcluirdados);

        btcadastrardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                Intent gravaRegistroActivity = new Intent (MainActivity.this,
                        GravaRegistrosActivity.class);
                        MainActivity.this.startActivity(gravaRegistroActivity);
            }
        });

        btcriarbanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db = openOrCreateDatabase("banco_dados",
                        Context.MODE_PRIVATE,null);
                    db.execSQL(" create table if not exists " + "usuarios(numreg integer primary key" + " autoincrement, nome text not null, telefone text" + " not null, " + " email text not null) ");
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso!")
                            .setNeutralButton("OK", null)
                            .show();
                } catch (Exception e) {
                }
            }

        });

        btcadastrardados2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent gravaRegistroActivity2 = new Intent (MainActivity.this, GravaRegistros2Activity.class);
                MainActivity.this.startActivity(gravaRegistroActivity2);
            }
        });

        btconsultardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent consultaDadosActivity = new Intent(MainActivity.this,ConsultaDadosActivity.class);
                MainActivity.this.startActivity(consultaDadosActivity);
            }
        });

        btalterardados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent alterarDadosActivity = new Intent(MainActivity.this, AlterarDadosActivity.class);
                MainActivity.this.startActivity(alterarDadosActivity);
            }
        });

        btexcluirdados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                Intent excluirDadosAcvitity = new Intent(MainActivity.this, ExcluirDadosActivity.class);
                MainActivity.this.startActivity(excluirDadosAcvitity);
            }
        });
    }
}