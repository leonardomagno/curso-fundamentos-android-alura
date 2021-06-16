package alura.com.br.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity
public class Aluno implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    private String email;
    private Calendar momentoDoCadastro = Calendar.getInstance();

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean temIdValido() {
        return id > 0;
    }

    public Calendar getMomentoDoCadastro() {
        return momentoDoCadastro;
    }

    public void setMomentoDoCadastro(Calendar momentoDoCadastro) {
        this.momentoDoCadastro = momentoDoCadastro;
    }

    public String dataFormatada() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(momentoDoCadastro.getTime());
    }
}
