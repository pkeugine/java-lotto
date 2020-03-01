package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.WinLotto;
import lotto.domain.lottogenerator.LottoGame;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.LottoGeneratorAuto;
import lotto.domain.lottogenerator.LottoGeneratorManual;
import lotto.util.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoApplication {
	private static final List<LottoGenerator> lottoGenerator =
			Arrays.asList(new LottoGeneratorManual(), new LottoGeneratorAuto());

	public static void main(String[] args) {
		int money = StringUtils.ToInt(InputView.inputMoney());
		int manualLottoCount = StringUtils.ToInt(InputView.inputManualLottoCount());
		Customer customer = new Customer(money, manualLottoCount);

		String manualLottoNumbers = InputView.inputManualLottoNumbers(customer);
		customer.setManualLottoNumbers(manualLottoNumbers);

		Lottos lottos = new Lottos(createUserLottos(customer));

		OutputView.printLottoAmounts(customer);
		OutputView.printLottos(lottos);

		WinLotto winLotto = createWinLotto();
		LottoManager lottoManager = new LottoManager(lottos, winLotto);
		lottoManager.checkLotto();
		OutputView.printResult(customer, lottoManager);
	}

	private static List<Lotto> createUserLottos(Customer customer) {
		List<Lotto> lottos = new ArrayList<>();
		for (LottoGenerator generator : lottoGenerator) {
			lottos.addAll(new LottoGame(customer, generator).lottoGenerate());
		}
		return lottos;
	}

	private static WinLotto createWinLotto() {
		String[] inputWinNumbers = StringUtils.splitByComma(InputView.inputWinNumber());
		return new WinLotto(inputWinNumbers, InputView.inputBonusBall());
	}
}