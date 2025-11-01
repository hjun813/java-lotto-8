package lotto;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int money = inputView.readPurchaseMoney();


        List<Lotto> userLottos = lottoService.makeLottos(money);


        outputView.printPurchasedLottos(userLottos);

        Lotto matchLotto = inputView.readMachingNumbers();
        int bonusNumber = inputView.readBonusNumber(matchLotto);

        Map<Rank, Integer> results = lottoService.calculateResults(userLottos, matchLotto, bonusNumber);
        double rateofProfit = lottoService.calculateRate(results, money);

        outputView.printMatchingResults(results);
        outputView.printProfitRate(rateofProfit);

    }
}
