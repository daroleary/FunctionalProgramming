package timing.java8;

import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static timing.java8.Timing.timed;

public class Example {

    static final Logger logger = LogManager.getLogManager().getLogger(Example.class.getName());

    public static void main(final String[] args) {

	final Double costs = Timing.timed("Cost calculation",
					  Example::calculateCosts);

	final Double revenue = Timing.timed("Revenue calculation",
					    Example::calculateRevenue);

	final Double profit = Timing.timed("Calculate profits",
					   logger::info,
					   () -> calculateProfit(costs, revenue));

	System.out.println("Profit = $" + profit);
    }

    private static Double calculateCosts() {
	pretendToWorkHard();
	return 4567.3;
    }


    private static Double calculateRevenue() {
	pretendToWorkHard();
	return 23413.2;
    }

    private static Double calculateProfit(Double costs, Double revenue) {
	pretendToWorkHard();
	return revenue - costs;
    }

    private static final Random r = new Random();
    private static final Integer MAX_WORK_TIME_MS = 2000;
    private static void pretendToWorkHard() {
	try {
	    Thread.sleep(r.nextInt(MAX_WORK_TIME_MS));
	} catch (InterruptedException ignored) {
	}
    }
}
