package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
	public static final int MAXNUM_RANGE = 45;
	private List<Lotto> lottos;

	public LottoProcess(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static LottoProcess of(int sheets, List<Lotto> inputUserNum) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(inputUserNum);
		lottos.addAll(makeLottos(sheets, makeNumbers()));
		return new LottoProcess(lottos);
	}

	public static List<Integer> makeNumbers() {
		List<Integer> numberRange = new ArrayList<>();
		for (int i = 1; i < MAXNUM_RANGE; i++) {
			numberRange.add(i);
		}
		return numberRange;
	}

	public static List<Lotto> makeLottos(int sheets, List<Integer> numberRange) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < sheets; i++) {
			lottos.add(AutoLotto.of(numberRange));
		}
		return lottos;
	}

	public int size() {
		return lottos.size();
	}

	public String getNumber(int i) {
		return getLotto(i).numbers();
	}

	public Lotto getLotto(int i) {
		return lottos.get(i);
	}

	public int countOfMatch(int i, UserLotto beforeWinLotto) {
		return getLotto(i).countOfMatch(beforeWinLotto);
	}

}