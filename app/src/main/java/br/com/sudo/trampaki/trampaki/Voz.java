package br.com.sudo.trampaki.trampaki;

import android.content.Intent;
import android.speech.RecognizerIntent;

import java.util.Locale;

/**
 * Created by tarci on 18/06/2017.
 */

public class Voz {
    public static final int REQ_CODE_SPEECH_INPUT = 100;
    private Intent intent;
    private String rotulo;

    public Voz(String rotulo) {
        this.rotulo = rotulo;
        this.intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    }

    public Intent abrirCaptura() {
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, this.rotulo);
        return intent;
    }

    public String getTexto(Intent data) {
        return data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0);
    }
}
