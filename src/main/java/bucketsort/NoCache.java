package bucketsort;

public class NoCache {
	private static int counter = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			System.out.println(i + "! = " + fact(i));
		}
		System.out.println("count=" + counter);
	}

	private static int fact(int n) {
		counter++;
		if (n == 0) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
	}
}
