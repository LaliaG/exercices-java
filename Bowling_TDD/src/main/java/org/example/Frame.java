package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    //int pins = 0;
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        this.rolls = new ArrayList<>();
        // score =+ pins;
        this.score = 0;
    }

    public int getScore (){
       /*
      int scoreFirst = generateur.randomPin(lastFrame);
      int scoreSecond = generateur.randomPin(lastFrame);
      */
        return score;
    }
/*
    public boolean makeRoll() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implement yet");
    }*/

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public IGenerateur getGenerateur() {
        return generateur;
    }

    public void setGenerateur(IGenerateur generateur) {
        this.generateur = generateur;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    private void addScore(int pins) {
        score =+ pins;
    }

    public boolean makeRoll() {
        // Si ce n'est pas la dernière frame et qu'il y a déjà 2 lancers, retourner false
        if (!lastFrame && rolls.size() == 2) {
            return false;
        }
        // Si ce n'est pas la dernière frame, et qu'il y a un strike au premier lancer, retourner false
        if (!lastFrame && rolls.size() == 1 && rolls.get(0).getPins() == 10) {
            return false;
        }
        // Si c'est la dernière frame et qu'il y a déjà 3 lancers, retourner false
        if (lastFrame && rolls.size() == 3) {
            return false;
        }

        int maxPins = 10;
        // Si ce n'est pas le premier lancer et qu'il n'y a pas de strike, calculer le nombre maximum de quilles à abattre
        if (!rolls.isEmpty() && rolls.get(0).getPins() != 10) {
            maxPins -= rolls.get(0).getPins();
        }

        // Générer un nombre aléatoire de quilles abattues
        int pins = generateur.randomPin(maxPins);
        // Ajouter le lancer à la liste des lancers
        rolls.add(new Roll(pins));
        // Ajouter au score
        addScore(pins);

        // Si ce n'est pas la dernière frame et qu'il y a maintenant 2 lancers, retourner false
        if (!lastFrame && rolls.size() == 2) {
            return false;
        }
        // Si c'est la dernière frame et qu'il y a maintenant 3 lancers, retourner false
        if (lastFrame && rolls.size() == 3) {
            return false;
        }
        // Si c'est la dernière frame et qu'il y a maintenant 2 lancers,mais pas de spare ou de strike, retourner false
        if (lastFrame && rolls.size() == 2 && (rolls.get(0).getPins() + rolls.get(1).getPins() < 10)) {
            return false;
        }

        return true; // Retourner true si un autre lancer est permis
    }


}

