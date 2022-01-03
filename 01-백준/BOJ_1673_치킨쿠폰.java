package com.algo2022.Jan.day0103;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1673_치킨쿠폰 {

	static int n, m, result;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			
			n = sc.nextInt();
			m=sc.nextInt();
			
			int result = n;
		    while((n/m)>0) {
			    result += (n/m);
			    n = (n/m) + (n%m);
		    }
		    System.out.println(result);
		}
		
	}

}
