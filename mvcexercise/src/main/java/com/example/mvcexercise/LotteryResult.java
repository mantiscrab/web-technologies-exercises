package com.example.mvcexercise;

import java.util.List;

public class LotteryResult {
    private List<Integer> chosenNumbers;
    private List<Integer> winningNumbers;
    private List<Integer> guessedNumbers;
    private long result;

    public List<Integer> getChosenNumbers() {
        return chosenNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getGuessedNumbers() {
        return guessedNumbers;
    }

    public long getResult() {
        return result;
    }

    public LotteryResult(final List<Integer> chosenNumbers, final List<Integer> winningNumbers, final List<Integer> guessedNumbers, final long result) {
        this.chosenNumbers = chosenNumbers;
        this.winningNumbers = winningNumbers;
        this.guessedNumbers = guessedNumbers;
        this.result = result;
    }

    @Override
    public String toString() {
        return "LotteryResult: " +  System.lineSeparator() +
                "chosenNumbers=" + chosenNumbers + System.lineSeparator() +
                "winningNumbers=" + winningNumbers + System.lineSeparator() +
                "guessedNumbers=" + guessedNumbers + System.lineSeparator() +
                "result=" + result;
    }
}
