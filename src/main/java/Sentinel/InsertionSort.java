package Sentinel;

public class InsertionSort {
	private static final int DATA_NUM = 100;

	public static void main(String[] args) {
		int[] data = new int[DATA_NUM];
		for (int i = 0; i < DATA_NUM; i++) {
			data[i] = (int) Math.round(Math.random() * 100);
		}
		for(int ele:data){
			System.out.print("[" + ele +"]");
		}
		insertionSort(data);
		System.out.println();
		for(int ele:data){
			System.out.print("[" + ele +"]");
		}
	}

	public  static void insertionSort(int[] data) {
		int ins,tmp;
		for (int i = 0; i < DATA_NUM; i++) {
			ins = i;
			while (ins >=1 && data[ins-1]>data[ins]) {
				tmp = data[ins-1];
				data[ins -1] = data[ins];
				data[ins] = tmp;
				ins--;
			}
		}
	}

}
