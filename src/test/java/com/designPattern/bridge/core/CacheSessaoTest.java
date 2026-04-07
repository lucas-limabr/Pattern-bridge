package com.designPattern.bridge.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheSessaoTest {

    PoliticaCache politicaCache;
    DriveArmazenamento driveArmazenamento;
    Arquivo arquivo;

    @BeforeEach
    void setUp() {
        this.arquivo = new Arquivo("Relatório de Vendas", 900.0);
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 6 segundos do cache utilizando HD")
    void deveRetornarTempoEscritaUtilizandoHD()
    {
        driveArmazenamento = new HD();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(6, politicaCache.calculaTempoTotalEscrita());
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 2 segundos do cache com TTL utilizando SSD")
    void deveRetornarTempoEscritaUtilizandoSSD()
    {
        driveArmazenamento = new SSD();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(2, politicaCache.calculaTempoTotalEscrita());
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 1 segundo do cache com TTL utilizando Redis")
    void deveRetornarTempoEscritaUtilizandoRedis()
    {
        driveArmazenamento = new Redis();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(1, politicaCache.calculaTempoTotalEscrita());
    }
}