package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_NOT_ZERO_ERROR_MESSAGE = "[ERROR] 구입 금액은 0 이하일 수 없습니다.";
    private static final String PURCHASE_AMOUNT_NOT_1000_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    public static Integer readPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
                Integer purchaseAmount = Integer.parseInt(Console.readLine());
                validatePurchaseAmount(purchaseAmount);
                return convertToPurchaseNumber(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumber() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
                String input = Console.readLine();
                String[] numbers = input.split(",");
                return Arrays.stream(numbers)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }
    }

    public static Integer readBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }
    }

    private static Integer convertToPurchaseNumber(Integer purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_ZERO_ERROR_MESSAGE);
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_1000_UNIT_ERROR_MESSAGE);
        }
    }
}
