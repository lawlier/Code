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
//	data();
//	freopen("input.txt","r",stdin);
//	freopen("output.txt","w",stdout); 
	int n,m;
	while(scanf("%d%d",&n,&m)!=EOF)
	{
		multiset<int> s;
		multiset<int>::iterator it;
		for(int i=0;i<n;i++){
			int x;
			scanf("%d",&x);
			s.insert(x);
		} 
		for(int i=0;i<m;i++){
			int x,y = 3;
			scanf("%d",&x); 
			it = s.lower_bound(x);
			if(it == s.end()){
				printf("###\n");
				continue;
			}
			y = *it;
			if( (y & (y - 1)) == 0){
				
				printf("%d#\n",y); 
			}else{
				printf("%d\n",y);
			}
			s.erase(it);
		}
		
	}	 
	 
	return 0;
}
