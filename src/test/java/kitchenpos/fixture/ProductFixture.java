package kitchenpos.fixture;

import kitchenpos.products.tobe.domain.Name;
import kitchenpos.products.tobe.domain.Price;
import kitchenpos.products.tobe.domain.Product;
import kitchenpos.products.tobe.infra.FakeProfanities;

import java.math.BigDecimal;

public class ProductFixture {
    public static Product 상품() {
        return 상품(BigDecimal.valueOf(1000));
    }

    public static Product 상품(BigDecimal price) {
        return 상품("이름", price);
    }

    public static Product 상품(String name, long price) {
        return 상품(name, BigDecimal.valueOf(price));
    }

    public static Product 상품(String name, BigDecimal price) {
        return new Product(new Name(name, new FakeProfanities()), new Price(price));
    }
}
