#include<stdio.h>
#include<algorithm>
#include<string.h>
using namespace std;

const int N = 200100;
int arr[N],tree[N*4];
int MOD = 9973;
void sgment(int id,int l,int r)
{
    if(l==r){
        tree[id]=arr[l];
        return;
    }
    int mid=(l+r)/2;
    sgment(id<<1,l,mid);
    sgment(id<<1|1,mid+1,r);
    tree[id]=tree[id<<1]*tree[id<<1|1] % MOD;
}
void update(int id,int l,int r,int i,int diff)
{
    if(i<l||i>r)
        return;
    int mid=(r+l)/2;
    tree[id]+=diff;
    if(l!=r){
        update(id<<1,l,mid,i,diff);
        update(id<<1|1,mid+1,r,i,diff);
    }
    
}
int query(int id,int l,int r,int s,int e)
{
    if(l>e||r<s)
        return 1;
    if(l>=s&&r<=e)
        return tree[id];
    int mid=(l+r)/2;
    return query(id<<1,l,mid,s,e)*query(id<<1|1,mid+1,r,s,e) % MOD;
}
char str[N];
int res;
int main()
{
	int n;
	while(scanf("%d",&n)!=EOF)
	{
		scanf("%s",str);
		int len = strlen(str);
		for(int i = 1; i <=len; i++){
			int cc = (int)str[i-1];
			cc = (cc - 28) % MOD;
			arr[i] = cc;
		}
		sgment(1, 1, len);
		for(int i = 0; i < n ; i++){
			int x, y;
			scanf("%d%d",&x,&y);
			if(x < 1 || y > len)
				;
			else
				res = query(1,1,len,min(x,y),max(x,y));
			printf("%d\n",res);
		}
	}
	return 0;
}

