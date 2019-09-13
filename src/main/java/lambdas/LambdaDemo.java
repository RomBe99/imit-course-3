package lambdas;

import lambdas.person.v1.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.function.*;
import java.util.stream.IntStream;

public class LambdaDemo {
    public static final Function<String, List<String>> split = s -> Arrays.asList(s.split(" "));

    public static final Function<List<?>, Integer> count = List::size;

    public static final Function<String, Integer> splitAndCount = s -> count.
            compose(split).
            apply(s);

//    public static final Function<String, Integer> splitAndCount = s -> split.
//            andThen(count).
//            apply(s);

    public static final Function<String, Person> create = Person::new;

    public static final BiFunction<Double, Double, Double> reference = Math::max;

    public static final Supplier<Date> getCurrentDate = Date::new;

    public static final Predicate<Integer> isEven = i -> i % 2 == 0;

    public static final BiPredicate<Integer, Integer> areEqual = Integer::equals;

    public static IntStream transform(IntStream stream, IntUnaryOperator op) {
        return stream.map(op);
    }
}