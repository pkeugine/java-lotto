package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(String[] numbers, String bonusNumber) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(new LottoNumber(number));
        }
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        checkDuplicatedLottoNumber();
    }

    public LottoResult countWinningLotto(final Lottos lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos.getLottos()){
            LottoRank rank = LottoRank.findRank(countWinningMatch(lotto), isBonusMatch(lotto));
            lottoResult.addWinningRankCount(rank);
        }
        return lottoResult;
    }

    private int countWinningMatch(final Lotto myLotto) {
        checkLottoNull(myLotto);
        return winningNumbers.countMatchNumbers(myLotto);
    }

    private boolean isBonusMatch(final Lotto myLotto) {
        checkLottoNull(myLotto);
        return myLotto.contains(bonusNumber);
    }

    private void checkLottoNull(final Lotto myLotto) {
        if (myLotto == null) {
            throw new NullPointerException("비교할 로또가 없습니다.");
        }
    }

    private void checkDuplicatedLottoNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }
}