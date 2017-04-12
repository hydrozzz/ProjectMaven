package zz;

import org.apache.commons.collections4.Predicate;

public class MonPredicat<T> implements Predicate {

	@Override
	public boolean evaluate(Object arg0) {
		return Integer.parseInt((String) arg0) <50;
	}

}
