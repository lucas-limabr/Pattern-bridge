package com.designPattern.bridge.core;

public class CacheSessao extends PoliticaCache{

    public CacheSessao(Arquivo arquivo) {
        super(arquivo);
    }

    public Double calculaTempoTotalEscrita()
    {
        return this.arquivo.getTamanho() / this.driveArmazenamento.velocidadeEscrita();
    }
}
