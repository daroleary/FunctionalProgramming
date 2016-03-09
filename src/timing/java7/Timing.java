package timing.java7;

import java.text.MessageFormat;
import java.util.Date;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

public class Timing {

    public static final Function<String, Void> PRINT_TO_STDOUT =
	    new Function<String, Void>() {
	@Override
	public Void apply(String input) {
	    System.out.println(input);
	    return null;
	}
    };

    public static <T> T timed(String description,
			      Supplier<T> code) {
	return timed(description, PRINT_TO_STDOUT, code);
    }

    public static <T> T timed(String description,
			      Function<String, Void> output,
			      Supplier<T> code) {

	final Date before = new Date();
	T result = code.get();
	final Long duration = new Date().getTime() -
			      before.getTime();

	output.apply(MessageFormat.format("{0} took {1} milliseconds",
					   description,
					   duration));

	return result;
    }
}
