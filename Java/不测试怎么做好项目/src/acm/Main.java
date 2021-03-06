package acm;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static BigInteger [] m ;

	public static void init(){
		
		m[1] = new BigInteger("1");
		m[0] = m[1];
		for(int i = 2; i < 203 ; i++){
			m[i] = m[i-1].multiply(new BigInteger(""+i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m = new BigInteger[205];
		init();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			BigInteger ans = new BigInteger("" + 1);
			for(int i = 1; i <= n/2; i++){
				BigInteger res = m[n-i].divide(m[i]).divide(m[n - 2 * i]);
				ans = ans.add(res);
			}
			System.out.println(ans);
		}
		sc.close();
	}

}
