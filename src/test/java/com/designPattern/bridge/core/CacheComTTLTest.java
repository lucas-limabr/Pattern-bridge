package com.designPattern.bridge.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CacheComTTLTest {

    PoliticaCache politicaCache;
    DriveArmazenamento driveArmazenamento;
    Arquivo arquivo;

    @BeforeEach
    void setUp() {
        this.arquivo = new Arquivo("Relatório de Vendas", 900.0, LocalDateTime.now());
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 6 segundos do cache com TTL utilizando HD")
    void deveRetornarTempoEscritaUtilizandoHD() {
        driveArmazenamento = new HD();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(6, politicaCache.calculaTempoTotalEscrita());
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 2 segundos do cache com TTL utilizando SSD")
    void deveRetornarTempoEscritaUtilizandoSSD() {
        driveArmazenamento = new SSD();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(2, politicaCache.calculaTempoTotalEscrita());
    }

    @Test
    @DisplayName("Deve retornar o tempo de escrita em 1 segundo do cache com TTL utilizando Redis")
    void deveRetornarTempoEscritaUtilizandoRedis() {
        driveArmazenamento = new Redis();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);
        assertEquals(1, politicaCache.calculaTempoTotalEscrita());
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o tempo de TTL do arquivo for excedido")
    void deveRetornarExcecaoQuandoTTlExcedido() {

        this.arquivo = new Arquivo("Relatório de Vendas", 900.0, LocalDateTime.of(2020, 1, 1, 0, 0));

        driveArmazenamento = new Redis();
        politicaCache = new CacheComTTL(arquivo, 1000.0);
        politicaCache.setDriveArmazenamento(driveArmazenamento);

        assertThrows(RuntimeException.class, () -> politicaCache.calculaTempoTotalEscrita());
    }
}