package kitchenpos.products.tobe.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {
    private static final FakeProfanities fakeProfanities = new FakeProfanities();

    @ParameterizedTest
    @ValueSource(strings = "상품이름")
    @DisplayName("이름을 생성할 수 있다.")
    void create(final String value) {
        final Name name = new Name(value, fakeProfanities);

        assertThat(name).isEqualTo(new Name(value, fakeProfanities));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 비어있으면 IllegalArgumentException이 발생한다.")
    void create_empty(final String value) {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new Name(value, fakeProfanities);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

    @ParameterizedTest
    @ValueSource(strings = {"비속어", "욕설"})
    @DisplayName("이름에 비속어가 포함되어있으면 IllegalArgumentException이 발생한다.")
    void create_profanities(final String value) {
        ThrowableAssert.ThrowingCallable throwingCallable = () -> new Name(value, fakeProfanities);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(throwingCallable);
    }

}