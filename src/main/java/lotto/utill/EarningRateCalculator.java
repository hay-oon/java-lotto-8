package lotto.utill;

import lotto.model.LottoResult;

public class EarningRateCalculator {
    public static final int LOTTO_PRICE = 1000;

    public static double calculateEarningRate(LottoResult lottoResult, int purchaseNumber) {
        int totalPrize = lottoResult.getTotalPrize();
        int totalPurchaseAmount = purchaseNumber * LOTTO_PRICE;

        return (double) totalPrize / totalPurchaseAmount * 100;
    }
}
