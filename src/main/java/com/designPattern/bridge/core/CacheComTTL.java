package com.designPattern.bridge.core;

import java.time.Duration;
import java.time.LocalDateTime;

public class CacheComTTL extends PoliticaCache {

    private Double TTL;
    private LocalDateTime horaAtual;

    public CacheComTTL(Arquivo arquivo, Double TTL) {
        super(arquivo);
        this.TTL = TTL;
    }

    public Double calculaTempoTotalEscrita() {
        horaAtual = LocalDateTime.now();
        Long tempoDecorrido = Duration.between(this.getArquivo().getDataCriacao(), horaAtual).getSeconds();

        if (tempoDecorrido > TTL) {
            throw new RuntimeException("O tempo de TTL do arquivo " + this.getArquivo().nomeArquivo() + " foi excedido, não foi possível gravar");
        }

        return this.arquivo.getTamanho() / this.driveArmazenamento.velocidadeEscrita();
    }

}
