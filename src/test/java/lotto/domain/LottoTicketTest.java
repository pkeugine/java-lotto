package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓에 로또 볼이 비어있을 경우 테스트")
    void throw_empty_lotto_ball_test() {
        List<LottoBall> lottoTicket = new ArrayList<>();

        assertThatThrownBy(() -> new LottoTicket(lottoTicket))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 티켓이 제대로 생성되었을 경우 테스트")
    void not_empty_lotto_ball_test() {
        List<LottoBall> lottoTicket = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoBall::new)
                .collect(Collectors.toList());

        assertThatCode(() -> new LottoTicket(lottoTicket))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 티켓에 로또 볼이 범위가 벗어날 경 비어있을 경우 테스트")
    void throw_out_of_range_lotto_ball_test() {

        assertThatThrownBy(() -> {
            List<LottoBall> lottoTicket = IntStream.rangeClosed(1, 7)
                    .mapToObj(LottoBall::new)
                    .collect(Collectors.toList());
            new LottoTicket(lottoTicket);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}