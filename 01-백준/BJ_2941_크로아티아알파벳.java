package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		String line = rb.readLine();
		
		char[] arr = line.toCharArray();
		
		int count=0;
		for(int i = arr.length-1; i>=0; i--) {
			count++;
			if(arr[i]=='-') {
				i--;
				continue;
			}
			if(arr[i]=='=') {
				i--;
				if(i-1>=0 && (arr[i]=='z' &&arr[i-1]=='d')) {
					i--;
				}
				continue;
			}
			if(arr[i]=='j' && i-1>=0) {
				if(arr[i-1]=='l' || arr[i-1]=='n') {
					i--;
				}
				continue;
			}
		}
		System.out.println(count);
	}

}
