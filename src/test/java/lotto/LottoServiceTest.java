package lotto;

import lotto.service.LottoService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoServiceTest {

    @Test
    void 로또_발행_개수_테스트(){
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.makeLottos(8000);
        assertThat(lottos).hasSize(8);
    }

    @Test
    void 통계_계산_테스트() {
        LottoService lottoService = new LottoService();
        Lotto matchLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(31, 32, 33, 34, 35, 36))
        );

        Map<Rank, Integer> result = lottoService.calculateResults(userLottos, matchLotto, bonusNumber);
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(0);
        assertThat(result.get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NONE)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트(){
        LottoService lottoService = new LottoService();
        int purchaseMoney = 8000;

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()){
            result.put(rank, 0);
        }
        result.put(Rank.FIFTH, 1);

        double rateOfReturn = lottoService.calculateRate(result, purchaseMoney);

        assertThat(rateOfReturn).isCloseTo(62.5, offset(0.001));
    }
}
