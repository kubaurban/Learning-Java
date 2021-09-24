package generic_types;

public class OrderedElement<K,V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedElement(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "OrderedElement{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

}
