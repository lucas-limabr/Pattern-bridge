package com.designPattern.bridge.core;

public class SSD implements DriveArmazenamento {

    @Override
    public Double velocidadeLeitura() {
        return 500.0;
    }

    @Override
    public Double velocidadeEscrita() {
        return 450.0;
    }
}
