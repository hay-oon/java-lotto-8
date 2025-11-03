package lotto;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    @DisplayName("6개 일치하면 1등이다")
    void 여섯개_일치하면_1등이다() {
        Rank rank = Rank.from(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하면 2등이다")
    void 다섯개_일치하고_보너스_번호가_일치하면_2등이다() {
        Rank rank = Rank.from(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치하면 3등이다")
    void 다섯개_일치하면_3등이다() {
        Rank rank = Rank.from(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치하면 4등이다")
    void 네개_일치하면_4등이다() {
        Rank rank = Rank.from(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치하면 5등이다")
    void 세개_일치하면_5등이다() {
        Rank rank = Rank.from(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하 일치하면 꽝이다")
    void 두개_이하_일치하면_꽝이다() {
        assertThat(Rank.from(2, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.from(1, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.from(0, false)).isEqualTo(Rank.NONE);
    }
}
