package alura.com.br.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;
import alura.com.br.model.Aluno;

import static alura.com.br.ui.activity.ConstantsActivities.CHAVE_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        configuraFabNovoAluno();
        configuraLista();

        Aluno alex = new Aluno("alex", "123456", "alex@gmail.com");
        Aluno fran = new Aluno("Fran", "1234567", "fran@gmail.com");
        dao.salva(alex);
        dao.salva(fran);
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoAdicionar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoAdicionar.setOnClickListener((view) -> {
            abreFormularioModoInsereAluno();
        });
    }

    private void abreFormularioModoInsereAluno() {
        Intent intent = new Intent(this, FormularioAlunoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.clear();
        adapter.addAll(dao.todos());
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_list_view);

        configuraAdapter(listaDeAlunos);

        configuraListnerClickDeItem(listaDeAlunos);
        configuraCliqueLongoPorItem(listaDeAlunos);
    }

    private void configuraCliqueLongoPorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
                remove(alunoEscolhido);
                return true;
            }
        });
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    private void configuraListnerClickDeItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) parent.getItemAtPosition(position);
                abreFormularioModoEditaAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listaDeAlunos.setAdapter(adapter);
    }
}
