package br.com.alura.escola.dominio.indicacao;

import java.time.LocalDateTime;

public class Indicacao {
    private String indicado;
    private String indicador;
    private LocalDateTime data;

    public Indicacao(String indicado, String indicador) {
        this.indicado = indicado;
        this.indicador = indicador;
        this.data = LocalDateTime.now();
    }

    public String getIndicado() {
        return indicado;
    }

    public void setIndicado(String indicado) {
        this.indicado = indicado;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
