package com.example.aplicacaobancodedados;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;

public class GravaRegistrosActivity extends Activity {
    Button btcadastrar;
    EditText ednome, edtelefone, edemail;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grava_registros);
        btcadastrar = findViewById(R.id.btcadastrar);
        ednome = findViewById(R.id.ednome);
        edtelefone = findViewById(R.id.edtelefone);
        edemail = findViewById(R.id.edemail);
        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        }
        catch (Exception e)
        {
            MostraMensagem("Erro: " + e.toString());
        }

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nome = ednome.getText().toString();
                String telefone = edtelefone.getText().toString();
                String email = edemail.getText().toString();
                try {
                    db.execSQL("insert into usuarios(nome, " + "telefone, email) values('" + nome + "','" + telefone + "','" + email + "')");
                    MostraMensagem("Dados cadastrados com sucesso");
                }
                catch (Exception e)
                {
                    MostraMensagem("Errp : " + e.toString());
                }
            }
        });
    }

    public void MostraMensagem(String str)
    {
        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(GravaRegistrosActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}