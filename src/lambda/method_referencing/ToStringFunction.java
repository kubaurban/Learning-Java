package lambda.method_referencing;

@FunctionalInterface
public interface ToStringFunction<T> {
    String fun(T o);
}
