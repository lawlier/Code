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
char line[10000];
int main()
{
	while(gets(line),strcmp(line,"")){
		ss.insert(line);
	}
	while(scanf("%s",line)!=EOF){
		if(ss.count(line)){
			it = ss.find(line);
			int res = 0;
			while(it!=ss.end()&&f(line, *it, strlen(line))){
				it++;
				res++;
			}
			printf("%d\n",res);
		}else{
			ss.insert(line);
			it = ss.find(line);
			int res = 0;
			while(it!=ss.end()&&f(line, *it, strlen(line))){
				res++;
				it++;
			}
			ss.erase(line);
			printf("%d\n",res-1);
		}
	}
	return 0;
} 
