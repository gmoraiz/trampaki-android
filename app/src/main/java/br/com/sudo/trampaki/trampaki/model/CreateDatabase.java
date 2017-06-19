package br.com.sudo.trampaki.trampaki.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tarcisio on 18/06/2017.
 */

public class CreateDatabase extends SQLiteOpenHelper {

    public CreateDatabase(Context context) {
        super(context, "db_trampaki", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table Localizacao (" +
                "cd_localizacao integer primary key autoincrement," +
                "nm_localizacao text not null," +
                "ds_lat text not null," +
                "ds_long text not null);" +

        "create table Anuncio (" +
                "cd_anuncio integer primary key autoincrement," +
                "nm_assunto text not null," +
                "ds_descricao text not null," +
                "cd_localizacao integer," +
                "foreign key(cd_localizacao) references Localizacao (cd_localizacao));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Anuncio;");
        db.execSQL("drop table Localizacao;");
        onCreate(db);
    }
}
