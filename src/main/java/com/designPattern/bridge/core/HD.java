package com.designPattern.bridge.core;

public class HD implements DriveArmazenamento {
    @Override
    public Double velocidadeLeitura() {
        return 200.0;
    }

    @Override
    public Double velocidadeEscrita() {
        return 150.0;
    }
}
