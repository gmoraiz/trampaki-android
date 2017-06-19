package br.com.sudo.trampaki.trampaki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.sudo.trampaki.trampaki.model.CRUD;
import br.com.sudo.trampaki.trampaki.model.Entidade;
import br.com.sudo.trampaki.trampaki.model.Localizacao;

public class Cadastrar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Entidade anuncio;
    EditText edtAssunto, edtDescricao;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        edtAssunto   = (EditText) findViewById(R.id.edtAssunto);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        spinner      = (Spinner)  findViewById(R.id.spLocalizacoes);

        CRUD c = new CRUD(this);
        c.inserirDefault();
        spinner.setOnItemSelectedListener(this);
        carregaSpinner(spinner, c.buscarLocalizacao());
    }

    public void cadastrar(View view) {

    }
    public void voltar(View view) {
        finish();
    }
    public  void carregaSpinner(Spinner s, List<Localizacao> l) {
        ArrayAdapter<Localizacao> dataAdapter = new ArrayAdapter<Localizacao>(this, android.R.layout.simple_spinner_item,l);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "voce selecionouu: " + label, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
