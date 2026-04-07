package com.designPattern.bridge.core;

public abstract class PoliticaCache {

    protected DriveArmazenamento driveArmazenamento;

    protected Double tamanhoArquivo;

    protected Arquivo arquivo;

   public PoliticaCache(Arquivo arquivo)
   {
       this.arquivo = arquivo;
   }

    public void setDriveArmazenamento(DriveArmazenamento driveArmazenamento)
   {
       this.driveArmazenamento = driveArmazenamento;
   }

   public abstract Double calculaTempoTotalEscrita();
}
