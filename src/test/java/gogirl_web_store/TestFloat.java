package gogirl_web_store;

import java.math.BigDecimal;

public class TestFloat {

	public static void main(String[] args) {
//		Float a = Float.parseFloat("7001.2");
//		Float b = Float.parseFloat("0.6");
//		System.out.println(a+b);
//		System.out.println(7001.2+0.6);
//		double c = Double.parseDouble("7001.2");
//		double d = Double.parseDouble("0.6");
		BigDecimal e = new BigDecimal(7001.2);
		BigDecimal f = new BigDecimal(0.6);
		BigDecimal g = e.add(f).add(f);
		System.out.println(g.doubleValue());
	}

}
