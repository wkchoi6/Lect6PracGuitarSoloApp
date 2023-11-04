package com.example.lect6pracguitarsoloapp;

public class GuitarSolo {
    private String SoloName;
    private int SoloPic;
    private int SoloRaw;

    public GuitarSolo(String soloName, int soloPic, int soloRaw) {
        SoloName = soloName;
        SoloPic = soloPic;
        SoloRaw = soloRaw;
    }

    public String getSoloName() {
        return SoloName;
    }

    public void setSoloName(String soloName) {
        SoloName = soloName;
    }

    public int getSoloPic() {
        return SoloPic;
    }

    public void setSoloPic(int soloPic) {
        SoloPic = soloPic;
    }

    public int getSoloRaw() {
        return SoloRaw;
    }

    public void setSoloRaw(int soloRaw) {
        SoloRaw = soloRaw;
    }
}
