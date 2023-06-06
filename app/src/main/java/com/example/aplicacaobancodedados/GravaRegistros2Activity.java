package com.example.aplicacaobancodedados;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GravaRegistros2Activity extends Activity {

    Button btcadastrar;

    EditText ednome;
    EditText edtelefone;
    EditText edemail;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grava_registros2);

        btcadastrar = (Button) findViewById(R.id.btcadastrar);

        ednome = (EditText) findViewById(R.id.ednome);
        edtelefone = (EditText) findViewById(R.id.edtelefone);
        edemail = (EditText) findViewById(R.id.edemail);

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

                ContentValues valor = new ContentValues();

                valor.put("nome", nome);
                valor.put("telefone", telefone);
                valor.put("email", email);

                try {
                    db.insert("usuarios", null, valor);
                    MostraMensagem("Dados cadastrados com sucesso");
                }
                catch (Exception e)
                {
                    MostraMensagem("Erro: " + e.toString());
                }
            }
        });
    }

    public void MostraMensagem(String str)
    {
        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(GravaRegistros2Activity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}