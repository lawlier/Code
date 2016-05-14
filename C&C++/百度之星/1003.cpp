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
	char op[30], a[40];
	
	while(scanf("%d",&n)!=EOF)
	{
		
		for(int i = 0; i < n; i++){
		
			scanf("%s%s",op, a);
			if(strcmp(op, "insert") == 0){
				string aa(a);
				ss.insert(aa);
			}else if( strcmp(op, "search") == 0){
				if(ss.count(a)){
					printf("Yes\n");
				}else{
					string aa(a);
					ss.insert(aa);
					it = ss.find(aa);
					it++;
					string b;
					if(it != ss.end())
						b = *it;
					else{
						ss.erase(aa);
						printf("No\n");
						continue;
					}
					if( f(a, b,strlen(a))){
						printf("Yes\n");
					}
					else
						printf("No\n");
					ss.erase(aa);
				}
			}else{
				if(ss.count(a) == 0){
					ss.insert(a);
				}
				it = ss.find(a);
				string b;
				if( ++it != ss.end())
					b = *it; 
				else{
					ss.erase(a);
					continue;
				}
				while(f(a, b,strlen(a))){
					if( it != ss.end()){ 
						b = *it;
						it++; 
						ss.erase(b);
					} 
					else{ 
						ss.erase(b);
						break;
					} 
				}
				ss.erase(a);
			}
		}
		break;
	}
 	return 0;
}

