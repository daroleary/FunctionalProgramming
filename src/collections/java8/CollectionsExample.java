package collections.java8;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.Arrays;

public class CollectionsExample {

    final static String[] food = new String[]{
	    "Crunchy carrots",
	    "Golden-hued bananas",
	    "",
	    "Bright orange pumpkins",
	    "Little trees of broccoli",
	    "meat"
    };

    public static final Predicate<String> NON_EMPTY = s -> !s.isEmpty();

    private static BinaryOperator<String> chooseLast =
	    (allSoFar, nextElement) ->
		    nextElement;

    private static Function<String, String> LAST_WORD =
	    phrase ->
		    Arrays.asList(phrase.split(" ")).stream()
	    .reduce(chooseLast).orElse("");

    private static String summarize(final String[] descriptions) {

	return Arrays.asList(descriptions).stream()
		.filter(NON_EMPTY)
		.map(LAST_WORD)
		.reduce(joinOn(" & "))
		.orElse("");
    }

    private static BinaryOperator<String> joinOn(String connector) {
	return (allSoFar, nextElement) ->
		allSoFar + connector + nextElement;
    }

    public static void main(final String[] args) {

	final String summary = summarize(food);

	final String desiredSummary =
		"carrots & bananas & pumpkins & broccoli & meat";
	System.out.println(summary);
	if (summary.equals(desiredSummary)) {
	    System.out.println("yay!");
	}
    }
}
