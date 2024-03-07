package proxy;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {

    //프록시 패턴 (행동 패턴)
    public static Function<Integer, Integer> absInt = Math::abs;
    //파라미터, 리턴 타입
    public static Function<Double, Double> absDouble = Math::abs;
    public static Function<Float, Float> absFloat = Math::abs;
    public static Function<Long, Long> absLong = Math::abs;

    public static BiFunction<Integer, Integer, Integer> randomInt = (a, b) -> (int) (Math.random() * (b - a) + a);

    public static BiFunction<Double, Double, Double> randomDouble = (a, b) -> (Double) (Math.random() * (b - a) + a);

    public static BiFunction<Integer, Integer, Integer> minInt = Math::max;

    public static BiFunction<Double, Double, Double> minDouble = Math::max;

    public static BiFunction<Integer, Integer, Integer> maxInt = Math::min;

    public static BiFunction<Double, Double, Double> maxDouble = Math::min;

    public static BiFunction<Float, Float, Float> maxFloat = Math::max;

    public static BiFunction<Long, Long, Long> maxLong = Math::max;

    public static Supplier<Double> randomSupDouble = Math::random;

    public static Function<Double, Double> ceil = Math::ceil;

    public static Function<Double, Double> floor = Math::floor;

    public static Function<Double, Long> round = Math::round;

    public static Function<String, Integer> parse = Integer::parseInt;

    public static BiFunction<Double, Double,Double> powDouble = Math::pow;

    public static BiFunction<Integer,Integer,Integer> powInt = (a, b) -> (int) Math.pow(a, b);


}
