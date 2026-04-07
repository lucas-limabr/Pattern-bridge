package com.designPattern.bridge.core;

import java.time.LocalDateTime;
import java.util.Date;

public class Arquivo {

    private Double tamanho;

    private String nomeArquivo;

    private LocalDateTime dataCriacao;

    public Arquivo(String nomeArquivo, Double tamanho, String dataCriacao)
    {
        this.tamanho = tamanho;
        this.nomeArquivo = nomeArquivo;
        this.dataCriacao = this.converterParaLocalDate(dataCriacao);
    }

    private LocalDateTime converterParaLocalDate(String dataCriacao)
    {
       return LocalDateTime.parse(dataCriacao);
    }


    public Double getTamanho()
    {
        return this.tamanho;
    }

    public String nomeArquivo()
    {
        return this.nomeArquivo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
