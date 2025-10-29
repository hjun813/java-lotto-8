package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000), // 보너스 숫자 동일
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(int getMatchCount, boolean bonusMatch){
        if(getMatchCount == 6){
            return FIRST;
        }
        if(getMatchCount == 5 && bonusMatch){
            return SECOND;
        }
        if(getMatchCount == 5){
            return THIRD;
        }
        if(getMatchCount == 4){
            return FOURTH;
        }
        if(getMatchCount == 3){
            return FIFTH;
        }
        return NONE;
    }
}
