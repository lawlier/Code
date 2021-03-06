package year_2016.polygongame;
public class PolygonGame {
	public static int n;
	public static int v[], m[][][];
	public static char op[];
	public static int minf, maxf;
	public static void testDataSet(int v[],char op[]){
		for(int i=1;i<v.length;i++){
			v[i] = i ;
			if( i % 2 == 0)
				op[i] = '+';
			else
				op[i] = '*';
		}
	}
	public static void init(){
		n = 4;
		v = new int[n+1];
		op = new char[n+1];
		m = new int[n+1][n+1][2];
		testDataSet(v,op);
		for(int i=1;i<m.length;i++){
			m[i][1][0] = m[i][1][1] = v[i];
		}
	}
	public static int polyMax(){
		init();
		for(int j = 1; j <= n; j++)
			for(int i = 1; i <= n; i++)
				for(int s = 1; s < j; s++){
					minMax(i, s, j);
					if(m[i][j][0] > minf) m[i][j][0] = minf;
					if(m[i][j][1] < maxf) m[i][j][1] = maxf;
				}
		int tmp = m[1][n][1];
		for(int i = 1; i<=n;i++)
			if(tmp < m[i][n][1]) tmp = m[i][n][1];
		return tmp;
	}
	public static void minMax(int i, int s, int j){
		int[] e = new int[5];
		int a = m[i][s][0];
		int b = m[i][s][1];
		int r = (i + s - 1) % n + 1;
		int c = m[r][j-s][0];
		int d = m[r][j-s][1];
		if(op[r] == '+'){
			minf = a + c;
			maxf = b + d;
		}else{
			e[1] = a * c;
			e[2] = a * d;
			e[3] = b * c;
			e[4] = b * d;
			minf = e[1];
			maxf = e[1];
			for(int k = 2; k < 5; k++){
				maxf = Math.max(maxf, e[k]);
				minf = Math.min(minf, e[k]);
			}
		}
	}
	public static void main(String[] args){
		System.out.println(polyMax());
	}
}
