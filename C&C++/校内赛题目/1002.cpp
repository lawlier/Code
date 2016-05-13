#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<math.h>
#include<set>
#include<map>
#include<queue>
#include<string>
#include<time.h>
using namespace std;
void data()
{
	freopen("input.txt","w",stdout);
	int scale_n = 2000;
	int scale_m = 2000;
	int scale = 100;
	srand((long long)time(NULL));
	for(int i = 0; i < 1; i++){
		int scale_n = 10000;
		int scale_m = 10000;
		printf("%d %d\n",scale_n,scale_m);
		for(int j=0;j<scale_n;j++)
			printf("%d ",j);
		printf("\n");
		for(int j=0;j<scale_m;j++)
			printf("%d ",j);
		printf("\n");
	}
	for(int i = 0; i < 2; i++){
		int scale_n = 10000;
		int scale_m = 10000;
		printf("%d %d\n",scale_n,scale_m);
		for(int j=0;j<scale_n/2;j++)
			printf("%d ",j);
		for(int j=0;j<scale_n-scale_n/2;j++)
			printf("%d ",j);
		printf("\n");
		for(int j=0;j<scale_m/2;j++)
			printf("%d ",j);
		for(int j=0;j<scale_m-scale_m/2;j++)
			printf("%d ",j);
		printf("\n");
	}
	printf("%d %d\n",10000,10000);
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++)
			printf("%d ",j);
		printf("\n");
	}
	for(int i=0;i<100;i++){
		for(int j=0;j<100;j++)
			printf("%d ",j);
		printf("\n");
	}
}

int main()
{
	data();
	freopen("input.txt","r",stdin);
	freopen("output.txt","w",stdout); 
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
/*
5 6
1 1 2 2 2
1 2 1 2 3 4
*/
