package bucketsort;

public class YesCache {
	private static int counter = 0;
	private static int[] cache = new int[11];

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(i + "! = " + fact(i));
		}
		System.out.println("count=" + counter);
	}

	private static int fact(int n) {
		counter++;
		if (n == 0) {
			cache[n] = 1;
			return 1;
		} else {
			if (cache[n] != 0) {
				return cache[n];
			} else {
				cache[n] = n * fact(n - 1);
				return cache[n];
			}
		}
	}
}
