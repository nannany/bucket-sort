package Sentinel;

public class InsertionSortSentinel {
	private static final int DATA_NUM = 100;

	public static void main(String[] args) {
		int[] data = new int[DATA_NUM+1];
		data[0] = 0;
		for (int i = 1; i < DATA_NUM+1; i++) {
			data[i] = (int) Math.round(Math.random() * 100);
		}
		for(int i = 1; i<DATA_NUM+1;i++){
			System.out.print("[" + data[i] +"]");
		}
		insertionSort(data);
		System.out.println();
		for(int i = 1; i<DATA_NUM+1;i++){
			System.out.print("[" + data[i] +"]");
		}
	}

	public  static void insertionSort(int[] data) {
		int ins,tmp;
		for (int i = 1; i < DATA_NUM+1; i++) {
			ins = i;
			data[0] = data[i];
			while (data[ins-1]>data[ins]) {
				tmp = data[ins-1];
				data[ins -1] = data[ins];
				data[ins] = tmp;
				ins--;
			}
		}
	}
}
