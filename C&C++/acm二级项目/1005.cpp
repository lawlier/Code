#include<stdio.h>
#include<math.h>
using namespace std;
int a[150];
int main()
{
	int n;
	a[0] = 0;
	a[1] = 1;
	a[2] = 2;
	for(int i = 3; i <= 120; i++){
		a[i] = a[i-1] + a[i-2];
	}
	while(scanf("%d",&n)!=EOF){
		
		printf("%d\n",a[n]);
	}
}

