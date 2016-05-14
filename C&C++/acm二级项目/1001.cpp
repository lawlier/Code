#include<stdio.h>
#include<math.h>
using namespace std;
double m[1200];
int main()
{
	
	int n;
	m[0] = 0;
	for(int i = 1; i <= 1010; i++)
	{
		m[i] = m[i-1] + (i % 2 ? 1 : -1) * 1.0 / i;
	} 
	
	scanf("%d",&n);
		for(int i = 0; i < n; i++){
			int x;
			scanf("%d",&x);
			printf("%0.2lf\n",m[x]);
		}
	
 	return 0;
}

