package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    X(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }
            boolean a = false;
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return null;
    }

    public static Rank valueOfWinning(int winningMoney){
        Rank[] ranks= values();

        for (int i = 0; i < ranks.length; i++) {
            if(ranks[i].getWinningMoney() == winningMoney){
                return ranks[i];
            }
        }
        return null;
    }

}
