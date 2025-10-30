package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("로또 번호 일치 개수와 보너스 일치 여부로 등수를 결정한다.")
    @Test
    void 로또_일치_개수와_보너스_일치_여부로_등수를_결정한다(){
        assertThat(Rank.valueOf(6,false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5,true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5,false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4,false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2,false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(1,false)).isEqualTo(Rank.NONE);
    }
}
