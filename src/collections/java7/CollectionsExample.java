package collections.java7;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;

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

    public static final Predicate<String> NON_EMPTY = new Predicate<String>() {
	@Override
	public boolean apply(String input) {
	    return !input.isEmpty();
	}
    };

    private static Function<String, String> LAST_WORD =
	    new Function<String, String>() {
		@Override
		public String apply(String phrase) {
		    return Iterables.getLast(Arrays.asList(phrase.split(" ")));
		}
	    };

    private static String summarize(final String[] descriptions) {

	final Iterable<String> lastWords =
		FluentIterable.from(Arrays.asList(descriptions))
			.filter(NON_EMPTY)
			.transform(LAST_WORD);

	return Joiner.on(" & ").join(lastWords);
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
