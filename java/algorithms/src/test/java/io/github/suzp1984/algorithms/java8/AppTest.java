package io.github.suzp1984.algorithms.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        assertEquals( true, true );
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicateLength = (s) -> s.length() > 0;

        assertEquals(predicateLength.test("hell0"), true);
        assertEquals(false, predicateLength.test(""));
    }

    @Test
    public void testFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        assertEquals("123", backToString.apply("123"));
    }

    @Test
    public void testSupplier() {
        Supplier<Person> personSupplier = Person::new;
        assertEquals(true, personSupplier.get() instanceof Person);
    }

    @Test
    public void testConsumer() {
        Person person = new Person("zpcat", "su");

        Consumer<Person> greeter = (p) -> p.firstName = "hello";

        greeter.accept(person);
        assertEquals("hello", person.firstName);
    }

    @Test
    public void testComparator() {
        Comparator<Person> personComparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        assertEquals(true, personComparator.compare(p1, p2) > 0);
        assertEquals(false, personComparator.reversed().compare(p1, p2) > 0);
    }

    @Test
    public void testOptional() {
        Person john = new Person("john", "su");
        Person nperson = null;

        Optional<String> optAbc = Optional.of("abc");
        Optional<Person> optNull = Optional.empty();
        Optional<Person> optJohn = Optional.ofNullable(john);
        Optional<Person> optNobody = Optional.ofNullable(nperson);

        assertEquals(true, optAbc.isPresent());
        assertEquals(false, optNull.isPresent());
        assertEquals(true, optJohn.isPresent());
        assertEquals(false, optNobody.isPresent());

        assertEquals("abc", optAbc.get());
    }

    @Test
    public void testStream() {
        List<String> stringCollections = new ArrayList<>();
        stringCollections.add("ddd2");
        stringCollections.add("aaa2");
        stringCollections.add("ddd1");
        stringCollections.add("bbb1");
        stringCollections.add("ccc2");
        stringCollections.add("eee1");

        stringCollections.stream()
                .filter((s) -> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        assertEquals(1, stringCollections.stream()
                .filter((s) -> s.startsWith("a"))
                .count());

        assertEquals(2, stringCollections.stream()
                .sorted()
                .filter((s) -> s.startsWith("d"))
                .count());

        assertEquals(true, stringCollections.stream()
                            .sorted()
                            .map((s) -> s.toUpperCase())
                            .filter((s) -> s.startsWith("A"))
                            .allMatch((s) -> s.startsWith("A")));

        Optional<String> reducedStr =
                    stringCollections.stream()
                                .filter((s) -> s.startsWith("d"))
                                .reduce((s1, s2) -> s1 + "#" + s2);
        assertEquals(true, reducedStr.isPresent());
        assertEquals(true, reducedStr.get().contains("ddd"));
    }

    private static class Person {
        String firstName;
        String secondName;

        public Person() {
        }

        public Person(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }
    }
}
