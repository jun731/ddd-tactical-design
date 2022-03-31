package kitchenpos.products.tobe.domain;

import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Name {
    private final String name;

    protected Name() {
        this("", text -> false);
    }

    public Name(final String name, Profanities profanities) {
        verify(name, profanities);
        this.name = name;
    }

    private void verify(final String name, Profanities profanities) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (profanities.contains(name)) {
            throw new IllegalArgumentException("이름에 비속어는 포함될 수 없습니다.");
        }
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
