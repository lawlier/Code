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

char a[80];

int main()
{
	int n;

	while(scanf("%d",&n)!=EOF)
	{
		multiset<string> ss;
		for(int i = 0; i < n; i++){
			scanf("%s",a);
			int len = strlen(a);
			sort(a,a+len);
			printf("%d\n",ss.count(a));
			ss.insert(a);
		}
		
	}
	return 0;
}

