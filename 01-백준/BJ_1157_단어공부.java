package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1157_단어공부 {

	public static void main(String[] args) throws IOException {

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		String line = rb.readLine();
		char[] arr = line.toCharArray();
		//System.out.println(Arrays.toString(arr));
		
		int[] check = new int[27];
		int index;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>=97) arr[i]=(char) (arr[i]-32);
			index = (int)arr[i]-65;
			check[index]++;
		}
		//System.out.println(Arrays.toString(check));
		
		int max = Integer.MIN_VALUE;
		char result='?';
		for(int i=0; i<check.length; i++) {
			if(max==check[i])
				result='?';
			if(max<check[i]) {
				max=check[i];
				result = (char)(i+65);
				//System.out.println(max+ " " +result);
			}
		}
		
		System.out.println(result);
	}

}
