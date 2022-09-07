package it.univr.lavoratoristagionali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class modelWorkersArray {
    HashMap<modelWorker, contattoEmergenza[]> lavoratori;

    public modelWorkersArray() {
        lavoratori = new HashMap<modelWorker, contattoEmergenza[]>();

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void add (modelWorker lavoratore, contattoEmergenza contatti[]){
        lavoratori.put(lavoratore, contatti);
    }

    public HashMap<modelWorker, contattoEmergenza[]> getLavoratori() {
        return lavoratori;
    }

    public Set<modelWorker> getAllWorkers(){
        return lavoratori.keySet();
    }
}
