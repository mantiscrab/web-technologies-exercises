package com.example.mvcexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class ResultCounter {
    public static final int NUMBER_OF_WINNING_NUMBERS = 6;
    public static final int UPPER_BOUND = 50;

    public static LotteryResult countResult(String[] chosenNumbersText) {
        List<Integer> chosenNumbers = parseIntegersList(chosenNumbersText);
        List<Integer> winningNumbers = getWinningNumbers();
        List<Integer> guessedNumbers = countResult(chosenNumbers, winningNumbers);
        int result = guessedNumbers.size();
        return new LotteryResult(chosenNumbers, winningNumbers, guessedNumbers, result);
    }

    private static List<Integer> countResult(final List<Integer> chosenNumbers, final List<Integer> winningNumbers) {
        return chosenNumbers.stream()
                .filter(winningNumbers::contains)
                .toList();
    }

    private static List<Integer> parseIntegersList(final String[] parameterValues) {
        return Arrays.stream(parameterValues)
                .filter(text -> text.matches("-?\\d+"))
                .map(Integer::parseInt)
                .toList();
    }

    private static List<Integer> getWinningNumbers() {
        Random random = new Random();
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_WINNING_NUMBERS; i++) {
            winningNumbers.add(random.nextInt(UPPER_BOUND));
        }
        return winningNumbers;
    }
}
