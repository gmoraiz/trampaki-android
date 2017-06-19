package br.com.sudo.trampaki.trampaki.model;

import android.content.ContentValues;

/**
 * Created by tarcisio on 18/06/2017.
 */

public class Localizacao implements Entidade  {
    private Long id;
    private String nome, lati, longi;

    public Localizacao(Long id, String nome, String lati, String longi) {
        this.id     = id;
        this.nome   = nome;
        this.lati   = lati;
        this.longi  = longi;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public ContentValues valores() {
        ContentValues v = new ContentValues();
        v.put("nm_localizacao", this.getNome());
        v.put("ds_lat", this.getLat());
        v.put("ds_long", this.getLong());
        return v;
    }

    @Override
    public String[] colunas() {
        return new String [] {"cd_localizacao", "nm_localizacao", "ds_lat", "ds_long"};
    }

    public String getNome() {
        return nome;
    }

    public String getLat() {
        return lati;
    }

    public String getLong() {
        return longi;
    }
}
