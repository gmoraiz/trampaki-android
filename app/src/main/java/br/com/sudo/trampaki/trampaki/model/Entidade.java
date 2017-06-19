package br.com.sudo.trampaki.trampaki.model;

import android.content.ContentValues;

/**
 * Created by tarci on 18/06/2017.
 */

public interface Entidade {
    public Long getId();
    public ContentValues valores();
    public String[] colunas();
}
