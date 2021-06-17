package alura.com.br.asynctask;

import android.os.AsyncTask;

import java.util.List;

import alura.com.br.database.dao.TelefoneDAO;
import alura.com.br.model.Aluno;
import alura.com.br.model.Telefone;

public class BuscaTodosTelefonesAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {
    private final TelefoneDAO telefoneDAO;
    private final Aluno aluno;
    private final TelefoneDoAlunoEncontradosListener listener;

    public BuscaTodosTelefonesAlunoTask(TelefoneDAO telefoneDAO, Aluno aluno, TelefoneDoAlunoEncontradosListener listener) {
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return telefoneDAO.buscaTodosTelefonesDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEncontrados(telefones);
    }

    public interface TelefoneDoAlunoEncontradosListener {
        void quandoEncontrados(List<Telefone> telefones);
    }
}
