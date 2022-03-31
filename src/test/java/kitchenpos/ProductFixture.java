package kitchenpos;

import kitchenpos.products.tobe.domain.Name;
import kitchenpos.products.tobe.domain.Price;
import kitchenpos.products.tobe.domain.Product;
import kitchenpos.products.tobe.domain.FakeProfanities;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductFixture {
    public static Product 상품() {
        return 상품(BigDecimal.valueOf(1000));
    }

    public static Product 상품(final long price) {
        return 상품(BigDecimal.valueOf(price));
    }

    public static Product 상품(BigDecimal price) {
        return 상품("올바른 이름", price);
    }

    public static Product 상품(String name, long price) {
        return 상품(name, BigDecimal.valueOf(price));
    }

    public static Product 상품(String name, BigDecimal price) {
        return new Product(new Name(name, new FakeProfanities()), new Price(price));
    }

    public static Product 상품(final UUID id, final long price) {
        return new Product(id, new Name("올바른 이름", new FakeProfanities()), new Price(BigDecimal.valueOf(price)));
    }
}
