package lotto;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    @DisplayName("당첨 결과를 집계한다")
    void 당첨_결과가_정상적으로_집계된다() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 6개 일치 - 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 5개 일치 + 보너스 - 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 5개 일치 - 3등
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4개 일치 - 4등
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 3개 일치 - 5등
        );
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult result = LottoResult.matchNumber(lottoTicket, winningNumber);

        // then
        assertThat(result.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(result.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨 금액을 계산한다")
    void 총_당첨_금액이_정상적으로_계산된다() {
        // given
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 11, 12, 13)), // 3개 일치 - 5,000원
                new Lotto(List.of(1, 2, 3, 4, 9, 10))    // 4개 일치 - 50,000원
        );
        LottoTicket lottoTicket = new LottoTicket(lottoList);
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        LottoResult result = LottoResult.matchNumber(lottoTicket, winningNumber);

        // then
        assertThat(result.getTotalPrize()).isEqualTo(55000); // 5,000 + 50,000
    }
}

