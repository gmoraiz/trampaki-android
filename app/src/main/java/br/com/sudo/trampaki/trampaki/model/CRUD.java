package br.com.sudo.trampaki.trampaki.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarci on 18/06/2017.
 */

public class CRUD {
    private SQLiteDatabase db;

    public CRUD(Context context) {
        this.db = new CreateDatabase(context).getReadableDatabase();
    }

    public void inserir(Entidade e, String tabela) {
        db.insert(tabela, null, e.valores());
    }

    public void inserirDefault(){
        ContentValues v = new ContentValues();
        v.put("nm_localizacao", "LOCAL 1" );
        v.put("ds_lat", "123");
        v.put("ds_long", "123");
        db.insert("Localizacao",null, v);
    }

    public List<Localizacao> buscarLocalizacao(){
        Localizacao l = new Localizacao(null,null,null,null);
        List<Localizacao> list = new ArrayList<Localizacao>();
        Cursor cursor = db.query("Localizacao", l.colunas(), null, null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Localizacao ls = new Localizacao(Long.parseLong(cursor.getString(0)),
                        cursor.getString(1),cursor.getString(2), cursor.getString(3));
                list.add(ls);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return(list);
    }


}
