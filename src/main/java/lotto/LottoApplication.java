package lotto;

import lotto.domain.GameResult;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        long amount = InputView.getAmount();
        LottoGame lottoGame = new LottoGame(amount);
        ResultView.printLotto(lottoGame);

        List<String> winningNumber = InputView.getWinningNumber();
        GameResult gameResult = lottoGame.play(winningNumber);
        ResultView.statistic(gameResult, amount);
    }
}
