package codeingame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//CodingameのConwaySequenceの解法
public class ConwaySequence {
    public static void main(String[] args) {
	try {
	    // R、Lを入力
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.println("Rを入力");
	    String Rstr = br.readLine();
	    System.out.println("Lを入力");
	    String Lstr = br.readLine();
	    int R = Integer.parseInt(Rstr);
	    int L = Integer.parseInt(Lstr);
	    // 数列表示
	    for (int j = 1; j < L + 1; j++) {
		ArrayList<Integer> list = conwaySeq(R, j);
		for (Integer num : list) {
		    System.out.print(num + " ");
		}
		System.out.println();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    // 再帰的に計算
    private static ArrayList<Integer> conwaySeq(int R, int L) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (L == 1) {
	    list.add(R);
	} else if (L == 2) {
	    list.add(1);
	    list.add(R);
	} else {
	    // ひとつ上の段の数列を持ってきて計算
	    ArrayList<Integer> preList = conwaySeq(R, L - 1);
	    int nownum = preList.get(0);
	    int count = 1;
	    for (int i = 1; i < preList.size(); i++) {
		if (nownum == preList.get(i)) {
		    count++;
		    if (i == preList.size() - 1) {
			list.add(count);
			list.add(nownum);
		    }
		} else {
		    list.add(count);
		    list.add(nownum);
		    nownum = preList.get(i);
		    if (i == preList.size() - 1) {
			list.add(1);
			list.add(nownum);
		    }
		    count = 1;
		}
	    }
	}
	return list;
    }
}
