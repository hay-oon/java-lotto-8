package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoTicket;
import lotto.model.WinningNumber;
import lotto.model.LottoResult;
import lotto.util.EarningRateCalculator;

public class LottoController {
    public void run() {
        int purchaseNumber = InputView.readPurchaseAmount();
        LottoTicket lottoTicket = LottoTicket.fromPurchaseNumber(purchaseNumber);

        OutputView.printPurchaseNumber(purchaseNumber);
        OutputView.printLottoTicket(lottoTicket);

        WinningNumber totalWinningNumber = readWinningNumberWithBonus();

        LottoResult lottoResult = LottoResult.matchNumber(lottoTicket, totalWinningNumber);
        double earningRate = EarningRateCalculator.calculateEarningRate(lottoResult, purchaseNumber);
        
        OutputView.printResult(lottoResult, earningRate);
    }

    private WinningNumber readWinningNumberWithBonus() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.readWinningNumber();
                int bonusNumber = InputView.readBonusNumber();
                return new WinningNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
