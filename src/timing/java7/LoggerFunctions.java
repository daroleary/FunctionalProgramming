package timing.java7;

import com.google.common.base.Function;

import java.util.logging.Logger;

public class LoggerFunctions {

    public static Function<String, Void> info(final Logger logger) {
	return new Function<String, Void>() {
	    @Override
	    public Void apply(String input) {
		logger.info(input);
		return null;
	    }
	};
    }
}
