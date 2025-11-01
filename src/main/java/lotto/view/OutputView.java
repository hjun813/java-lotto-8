package lotto.view;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos){
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void printMatchingResults(Map<Rank, Integer> results){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for(Rank rank : Rank.values()){
            if(rank == Rank.NONE) continue;
            String description = String.format("%s (%,d원)", rank.getDescription(), rank.getPrizeMoney());
            int count =  results.getOrDefault(rank, 0);
            System.out.println(description + " - " + count + "개");
        }
    }

    public void printProfitRate(double rate){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }
}
