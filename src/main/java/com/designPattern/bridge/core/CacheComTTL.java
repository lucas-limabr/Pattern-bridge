package com.designPattern.bridge.core;

import java.time.Duration;
import java.time.LocalDateTime;

public class CacheComTTL extends PoliticaCache{

    private Double TTL;
    private LocalDateTime horaAtual;

    public CacheComTTL(Arquivo arquivo, Double TTL)
    {
        super(arquivo);
        this.TTL = TTL;
    }

    public  Double calculaTempoTotalEscrita()
    {
        horaAtual = LocalDateTime.now();

        Long tempoDecorrido =  Duration.between(this.).getSeconds();




        if(TTL )
        return this.tamanhoArquivo / this.driveArmazenamento.velocidadeEscrita();
    }

}
