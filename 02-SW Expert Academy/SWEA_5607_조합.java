package com.ssafy.Apr.day0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607_조합 {

	static long p = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());			
			int R = Integer.parseInt(st.nextToken());
			
			long result = nCr(N,R,p);
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static long nCr(int n, int r, long p) {
		if(r==0) return 1;
		
		long[] fac = new long[n+1];
		fac[0]=1;
		
		for(int i=1; i<=n; i++)
			fac[i]=fac[i-1]*i%p;
		
		
		return (fac[n]*power(fac[r]*fac[n-r]%p,p-2,p))%p;
	}

	private static long power(long x, long l, long p) {
		long res = 1;
		x=x%p;
		
		while(l>0) {
			if(l%2==1)
				res = (res*x)%p;
			l=l>>1;
			x=(x*x)%p;
		}
		return res;
	}

}
