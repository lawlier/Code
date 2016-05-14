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
int dp[1200];
int s[1200], t[1200];
int main()
{
	int n, p;
	while(scanf("%d%d",&n,&p)!=EOF){
		
		for(int i = 1; i <= n; i++)
			scanf("%d%d",&s[i],&t[i]); 
		memset(dp, 0, sizeof(dp));
		int res = 0;
		for(int i = 1; i <= n; i++){
			for(int j = p; j >= s[i]; j--){
					dp[j] = max(dp[j],dp[j - s[i]] + t[i]);
					res = max(dp[j], res);
			}
		}
		printf("%0.2lf\n",res * 1.0 / n);
	} 
 	return 0;
}

