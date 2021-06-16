package alura.com.br.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import alura.com.br.model.Telefone;

@Dao
public interface TelefoneDAO {
    @Query("SELECT * FROM Telefone " +
            "WHERE alunoId = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}
