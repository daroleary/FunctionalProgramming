package timing.java8;

import java.text.MessageFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Timing {

    public static <T> T timed(String description,
			      Supplier<T> code) {
	Consumer<String> defaultOutput = System.out::println;
	return timed(description, defaultOutput, code);
    }

    public static <T> T timed(String description,
			      Consumer<String> output,
			      Supplier<T> code) {

	final Date before = new Date();
	T result = code.get();
	final Long duration = new Date().getTime() -
			      before.getTime();

	output.accept(MessageFormat.format("{0} took {1} milliseconds",
					   description,
					   duration));

	return result;
    }
}
