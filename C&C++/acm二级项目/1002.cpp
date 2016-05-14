#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<math.h>
#include<set>
#include<map>
#include<queue>
#include<string>
using namespace std;
int a[1000];
map<int,char> mm;
int main()
{
	int n, r;
	for(int i = 0; i <= 9;i++)
		mm[i] = '0' + i;
	mm[10] = 'A';
	mm[11] = 'B';
	mm[12] = 'C';
	mm[13] = 'D';
	mm[14] = 'E';
	mm[15] = 'F';
	while(scanf("%d%d",&n,&r)!=EOF){
		int i = 0;
		int flag  = n >= 0 ? 1 : -1;
		if(flag < 0 ) 
			n = -n;
		while(n){
			a[i++] = n % r;
			n /= r;
		}
		if(flag < 0)
			printf("-");
		for(int j = i - 1; j >= 0; j--){
			printf("%c",mm[a[j]]);
		}
		printf("\n");
	} 
 	return 0;
}

