package br.com.sudo.trampaki.trampaki.model;

import android.content.ContentValues;

/**
 * Created by tarci on 18/06/2017.
 */

public class Anuncio implements Entidade {
    private Long id, estrangeira;
    private String assunto, descricao;

    public Anuncio(Long id, String assunto, String descricao, Long estrangeira) {
        this.id          = id;
        this.assunto     = assunto;
        this.descricao   = descricao;
        this.estrangeira = estrangeira;
    }
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public ContentValues valores() {
        ContentValues v = new ContentValues();
        v.put("nm_assunto", this.getAssunto());
        v.put("ds_descricao", this.getDescricao());
        v.put("cd_localizacao", this.getEstrangeira());
        return v;
    }

    @Override
    public String[] colunas() {
        return new String[]{"cd_anuncio", " nm_assunto", " ds_descricao", " cd_localizacao"};
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDescricao() {
        return descricao;
    }
    public Long getEstrangeira() { return estrangeira; }
}
