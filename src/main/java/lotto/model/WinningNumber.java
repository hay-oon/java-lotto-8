package lotto.model;

import java.util.List;

public class WinningNumber {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;
    private static final String WINNING_NUMBERS_SIZE_ERROR_MESSAGE = "당첨 번호는 " + WINNING_NUMBERS_SIZE + "개여야 합니다.";
    private static final String WINNING_NUMBER_RANGE_ERROR_MESSAGE =
            "당첨 번호는 " + WINNING_NUMBER_MIN + "~" + WINNING_NUMBER_MAX + " 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_DUPLICATE_ERROR_MESSAGE =
            "당첨 번호는 " + WINNING_NUMBERS_SIZE + "개의 중복되지 않는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE =
            "보너스 번호는 " + WINNING_NUMBER_MIN + "~" + WINNING_NUMBER_MAX + " 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "보너스 번호는 당첨번호와 중복될 수 없습니다.";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber);
        validDuplicateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_ERROR_MESSAGE);
        }
        if (winningNumbers.stream().anyMatch(number -> number < WINNING_NUMBER_MIN || number > WINNING_NUMBER_MAX)) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_ERROR_MESSAGE);
        }
        if (winningNumbers.stream().distinct().count() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < WINNING_NUMBER_MIN || bonusNumber > WINNING_NUMBER_MAX) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private void validDuplicateNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
