package alura.com.br.database.converter;

import androidx.room.TypeConverter;

import alura.com.br.model.TipoTelefone;

public class ConversorTipoTelefone {

    @TypeConverter
    public String paraString(TipoTelefone tipo) {
        return tipo.name();
    }

    @TypeConverter
    public TipoTelefone paraTipoTelefone(String valor) {
        if (valor != null) {
            return TipoTelefone.valueOf(valor);
        } else {
            return TipoTelefone.FIXO;
        }
    }
}
