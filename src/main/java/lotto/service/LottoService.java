package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Rank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public List<Lotto> makeLottos(int money){
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i<count; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Map<Rank, Integer> calculateResults(List<Lotto> userLottos, Lotto matchLotto, int bonusNumber){
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for(Rank rank: Rank.values()){
            results.put(rank, 0);
        }

        for(Lotto lotto:userLottos){
            int matchCount = countMatching(lotto, matchLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            results.put(rank, results.get(rank) + 1);
        }
        return results;
    }

    public double calculateRate(Map<Rank, Integer> result, int money){
        long totalPrize = 0;
        for(Map.Entry<Rank, Integer> entry : result.entrySet()){
            totalPrize +=(long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        if(money == 0){
            return 0.0;
        }
        return (double) totalPrize / money * 100.0;
    }

    private int countMatching(Lotto lotto, Lotto matchLotto){
        return (int) lotto.getNumbers().stream()
                .filter(matchLotto.getNumbers()::contains)
                .count();
    }
}
