package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.LottoResult;
import lotto.model.Rank;

    public class OutputView {
        private static final String PURCHASE_NUMBER_OUTPUT_MESSAGE = "%d개를 구매했습니다.";
        private static final String WINNING_RESULT_OUTPUT_MESSAGE = "당첨 통계";
        private static final String WINNING_RESULT_SEPARATOR = "---";
        private static final String WINNING_RESULT_3_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개";
        private static final String WINNING_RESULT_4_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개";
        private static final String WINNING_RESULT_5_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개";
        private static final String WINNING_RESULT_5_MATCH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
        private static final String WINNING_RESULT_6_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";
        private static final String EARNING_RATE_OUTPUT_MESSAGE = "총 수익률은 %.1f%%입니다.";


        public static void printPurchaseNumber(Integer purchaseNumber) {
            System.out.println(String.format(PURCHASE_NUMBER_OUTPUT_MESSAGE, purchaseNumber));
        }

        public static void printLottoTicket(LottoTicket lottoTicket) {
            for (Lotto lotto : lottoTicket.getLottoList()) {
                System.out.println(lotto);
            }
        }

       public static void printResult(LottoResult lottoResult, double earningRate) {
           System.out.println(WINNING_RESULT_OUTPUT_MESSAGE);
           System.out.println(WINNING_RESULT_SEPARATOR);
           System.out.println(String.format(WINNING_RESULT_3_MATCH_MESSAGE, lottoResult.getRankCount(Rank.FIFTH)));
           System.out.println(String.format(WINNING_RESULT_4_MATCH_MESSAGE, lottoResult.getRankCount(Rank.FOURTH)));
           System.out.println(String.format(WINNING_RESULT_5_MATCH_MESSAGE, lottoResult.getRankCount(Rank.THIRD)));
           System.out.println(String.format(WINNING_RESULT_5_MATCH_BONUS_MESSAGE, lottoResult.getRankCount(Rank.SECOND)));
           System.out.println(String.format(WINNING_RESULT_6_MATCH_MESSAGE, lottoResult.getRankCount(Rank.FIRST)));
           System.out.println(String.format(EARNING_RATE_OUTPUT_MESSAGE, earningRate));
       }
    }
