package alura.com.br.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import alura.com.br.database.converter.ConversorCalendar;
import alura.com.br.database.converter.ConversorTipoTelefone;
import alura.com.br.database.dao.AlunoDAO;
import alura.com.br.database.dao.TelefoneDAO;
import alura.com.br.model.Aluno;
import alura.com.br.model.Telefone;

import static alura.com.br.database.AgendaMigrations.TODAS_MIGRATIONS;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    public static final String NOME_BANCO_DE_DADOS = "agenda.db";
    public abstract AlunoDAO getRoomAlunoDAO();
    public abstract TelefoneDAO getTelefoneDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }
}
