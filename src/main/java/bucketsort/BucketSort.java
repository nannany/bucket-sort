package bucketsort;

public class BucketSort {
	// データの数
	private static final int DATA_NUM = 100;

	public static void main(String[] args) {
		int[] data = new int[DATA_NUM];
		int[] bucket = new int[DATA_NUM];
		// データにランダムな数入れる（０～１００）
		for (int i = 0; i < DATA_NUM; i++) {
			data[i] = (int) Math.floor(Math.random() * 100);
		}
		showData(data);
		sort(data, bucket, DATA_NUM);
		// 見やすいよう改行
		System.out.println();
		showBucket(bucket, DATA_NUM);
	}

	// 元のデータ表示
	private static void showData(int[] data) {
		for (int ele : data) {
			System.out.print("[" + ele + "]");
		}
	}

	// ソート後のバケツの中身表示
	private static void showBucket(int[] bucket, int length) {
		for (int i = 0; i < length; i++) {
			if (bucket[i] > 0) {
				for (int j = 0; j < bucket[i]; j++) {
					System.out.print("[" + i + "]");
				}
			}
		}
	}

	// バケツソートロジック
	private static void sort(int[] data, int[] bucket, int length) {
		for (int i = 0; i < length; i++) {
			bucket[data[i]]++;
		}
	}
}
