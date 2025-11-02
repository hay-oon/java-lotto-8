package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static Integer readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        Integer purchaseAmount = Integer.parseInt(Console.readLine());
        return convertToPurchaseNumber(purchaseAmount);
    }

    public static List<Integer> readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public static Integer readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static Integer convertToPurchaseNumber(Integer purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
