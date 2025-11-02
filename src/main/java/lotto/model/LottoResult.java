package lotto.model;

import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final Map<Rank, Integer> rankCountMap;

    public LottoResult(Map<Rank, Integer> rankCountMap) {
        this.rankCountMap = rankCountMap;
    }

    public static LottoResult matchNumber(LottoTicket lottoTicket, WinningNumber winningNumber) {
        Map<Rank, Integer> rankCountMap = initializeRankCountMap();
        
        for (Lotto lotto : lottoTicket.getLottoList()) {
            int matchCount = calculateMatchCount(lotto, winningNumber); 
            boolean hasBonus = hasBonusNumber(lotto, winningNumber);
            
            Rank rank = Rank.from(matchCount, hasBonus);
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }
        
        return new LottoResult(rankCountMap);
    }

    // 등수별 당첨 개수 집계를 위해 초기화 ({FIRST: 0, SECOND: 0, THIRD: 0, FOURTH: 0, FIFTH: 0, NONE: 0})
    private static Map<Rank, Integer> initializeRankCountMap() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
        return rankCountMap;
    }

    private static int calculateMatchCount(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getWinningNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static boolean hasBonusNumber(Lotto lotto, WinningNumber winningNumber) {
        return lotto.getNumbers().contains(winningNumber.getBonusNumber());
    }

    public int getTotalPrize() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrize() * rankCountMap.get(rank);
        }
        return totalPrize;
    }

    public int getRankCount(Rank rank) {
        return rankCountMap.get(rank);
    }

    public Map<Rank, Integer> getRankCountMap() {
        return rankCountMap;
    }
}
