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
map<int, int> m[10];
map<int, int>::iterator it;
int f(map<int, int> m){
	for(it = m.begin(); it != m.end(); it++)
		printf("%d\n",it->second);
}
int main()
{
	int x;
	scanf("%d",&x);
	printf("%d",x);
 	return 0;
}

