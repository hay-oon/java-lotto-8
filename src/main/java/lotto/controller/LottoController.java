package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.LottoTicket;
import lotto.model.WinningNumber;
import lotto.model.LottoResult;
import lotto.model.EarningRate;

public class LottoController {
    public void run() {
        Integer purchaseNumber = InputView.readPurchaseAmount();
        LottoTicket lottoTicket = LottoTicket.fromPurchaseNumber(purchaseNumber);

        OutputView.printPurchaseNumber(purchaseNumber);
        OutputView.printLottoTicket(lottoTicket);

        List<Integer> winningNumbers = InputView.readWinningNumber();
        Integer bonusNumber = InputView.readBonusNumber();

        WinningNumber winningNumberObj = new WinningNumber(winningNumbers, bonusNumber);

        LottoResult lottoResult = LottoResult.matchNumber(lottoTicket, winningNumberObj);

        EarningRate earningRate = EarningRate.calculateEarningRate(lottoResult, purchaseNumber);
        OutputView.printResult(lottoResult, earningRate.getEarningRate());
    }
}
