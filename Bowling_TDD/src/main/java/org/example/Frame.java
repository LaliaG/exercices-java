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

    public int getScore() {
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
        score = +pins;
    }

    public boolean makeRoll() {
        if (!lastFrame && rolls.size() >= 2) {
            return false;
        }

        int maxPins = 10;
        if (!rolls.isEmpty() && rolls.get(0).getPins() != 10) {
            maxPins -= rolls.get(0).getPins();
        }

        if (lastFrame && rolls.size() == 2 && !isSpareOrStrike()) {
            return false;
        }

        int pins = generateur.randomPin(maxPins);
        rolls.add(new Roll(pins));
        addScore(pins);

        return true;
    }

    private boolean isSpareOrStrike() {
        if (rolls.size() == 2 && rolls.get(0).getPins() + rolls.get(1).getPins() >= 10) {
            return true;
        }
        return rolls.size() == 3 && (rolls.get(0).getPins() == 10 || rolls.get(0).getPins() + rolls.get(1).getPins() >= 10);
    }

}







































































































































































































































































































































