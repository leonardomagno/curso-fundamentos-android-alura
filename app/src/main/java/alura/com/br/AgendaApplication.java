package alura.com.br;

import android.app.Application;

import alura.com.br.dao.AlunoDAO;
import alura.com.br.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        Aluno alex = new Aluno("Alex", "123456", "alex@gmail.com");
        Aluno fran = new Aluno("Fran", "1234567", "fran@gmail.com");
        dao.salva(alex);
        dao.salva(fran);
    }
}
