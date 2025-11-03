package lotto;

import lotto.model.*;
import lotto.util.EarningRateCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EarningRateCalculatorTest {
    @Test
    @DisplayName("수익률을 계산한다")
    void 수익률을_계산한다() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 3개 일치 - 5,000원
        );
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult result = LottoResult.matchNumber(lottoTicket, winningNumber);

        // when
        double earningRate = EarningRateCalculator.calculateEarningRate(result, 8);

        // then - 5,000 / 8,000 * 100 = 62.5% 
        assertThat(earningRate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("당첨되지 않으면 수익률이 0이다")
    void 당첨되지_않으면_수익률이_0이다() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(11, 12, 13, 14, 15, 16)) // 0개 일치
        );
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoResult result = LottoResult.matchNumber(lottoTicket, winningNumber);

        // when
        double earningRate = EarningRateCalculator.calculateEarningRate(result, 1);

        // then
        assertThat(earningRate).isEqualTo(0.0);
    }
}
