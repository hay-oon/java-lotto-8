package lotto.model;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean hasBonus;

    Rank(int matchCount, int prize, boolean hasBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public static Rank from(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}

