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
set<string> ss;
set<string>::iterator it;
char op[40], a[1000];
int f(char a[], string b, int len1)
{
	if(len1 > b.length()) return 0;
	for(int i = 0; i < len1; i++){
		if( a[i] != b[i])
			return 0;
	}
	return 1;
}
int main()
{
	int n;
	scanf("%d",&n);
	
	for(int i = 0; i < n; i++)
	{
		scanf("%s %s", op, a);
		if( strcmp(op, "insert") == 0){
			ss.insert(a);
		}else if( strcmp(op, "search") == 0){
			it = ss.lower_bound(a);
			if(it != ss.end() && f(a, *it, strlen(a))){
				printf("Yes\n");
			}else{
				printf("No\n");
			}
		}else{
			it = ss.lower_bound(a);
			while(it != ss.end() && f(a, *it, strlen(a))){
				string b = *it;
				it++;
				ss.erase(b);
			}
		}
	}
	return 0;
}

