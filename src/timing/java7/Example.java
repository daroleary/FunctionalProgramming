package timing.java7;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Example {

    static final Logger logger = LogManager.getLogManager().getLogger(Example.class.getName());

    public static void main(final String[] args) {

	final Double costs = Timing.timed("Cost calculation",
					  new Supplier<Double>() {
					      @Override
					      public Double get() {
						  return calculateCosts();
					      }
					  });

	final Double revenue = Timing.timed("Revenue calculation",
					    new Supplier<Double>() {
						@Override
						public Double get() {
						    return calculateRevenue();
						}
					    });

	final Double profit = Timing.timed("Calculate profits",
					   LoggerFunctions.info(logger),
					   new Supplier<Double>() {
					       @Override
					       public Double get() {
						   return calculateProfit(costs, revenue);
					       }
					   });

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
