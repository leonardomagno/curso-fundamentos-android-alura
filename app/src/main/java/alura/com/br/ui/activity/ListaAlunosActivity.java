package alura.com.br.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alura.com.br.R;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de Alunos");

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_list_view);

        List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "José", "Maria", "Ana"));

        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }
}
