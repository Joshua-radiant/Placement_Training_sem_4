public class Main {
	static int fact(int n) {
		if(n<=1) {
			return 1;
		}
		return n * fact(n-1);
	}

	public static void main(String[] args) {
		int n = 6;
		int res = fact(n);
		System.out.println(res);
	}
}