package com.designPattern.bridge.core;

public class Redis implements DriveArmazenamento{
    @Override
    public Double velocidadeLeitura() {
        return 1000.0;
    }

    @Override
    public Double velocidadeEscrita() {
        return 900.0;
    }
}
