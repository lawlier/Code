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
int main()
{
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int a,  b;
		scanf("%d%d",&a,&b);
		printf("%d\n",(a + b) % 100);
	}
	
 	return 0;
}
