package lotto;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"), // 보너스 숫자 동일
    FIRST(6, 2_000_000_000, "6개 일치"),
    NONE(0, 0, "꽝");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    Rank(int matchCount, int prizeMoney, String description){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription(){ return description; }

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
