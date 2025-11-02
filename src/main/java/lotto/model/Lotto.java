package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final String NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 " + LOTTO_NUMBER_SIZE + "개여야 합니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE =
            "[ERROR] 로또 번호는 " + LOTTO_NUMBER_MIN + "~" + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.";
    private static final String NUMBER_DUPLICATE_ERROR_MESSAGE =
            "[ERROR] 로또 번호는 " + LOTTO_NUMBER_SIZE + "개의 중복되지 않는 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbersAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto fromRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_SIZE);
        return new Lotto(randomNumbers);
    }

    private static List<Integer> sortNumbersAscending(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
