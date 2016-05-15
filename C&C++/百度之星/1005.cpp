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

map<string,int> mleft[1010];
map<string,int> mright[1010];
char line[100000];
const int maxn =10000;
const int minn =-10000;
int insert(map<string, int> &left, map<string, int> &right,string var, string op, int x)
{
	if(left.count(var) == 0)
		left[var] = minn;
	if(right.count(var) == 0) 
		right[var] = maxn;
	if(op == "=="){
		int l = left[var];
		int r = right[var];
		if(l <= x && x <=r){
			left[var] = x;
			right[var] =x;
			return 0;
		}
		
		left[var] = r;
		right[var] = l;
		return 0; 
	}
	if(op == ">="){
		left[var] = max(left[var], x);
		
		return 1;
	}
	if(op == ">"){
		left[var] = max(left[var],x + 1);
		return 2;
	}
	if(op == "<"){
		right[var] = min(right[var], x - 1);
		return 3;
	}
	if(op == "<="){
		right[var] = min(right[var], x);
		return 4;
	}
	else 
		return -1;
}
int isEmptySet(map<string,int> left, map<string,int> right)
{
	string var;
	map<string,int>::iterator it;
	for(it = left.begin(); it != left.end(); it++){
		var = it->first;
		int l, r;
		l = it->second;
		r = right[it->first];
		if(l > r)
			return 1;
	}
	return 0;
}
int judge(map<string,int> left1, map<string,int> right1,map<string, int> left2, map<string, int> right2)
{
	if(isEmptySet(left1,right1) || isEmptySet(left2, right2))
		return 0;
	map<string,int>::iterator it;
	for(it = left1.begin(); it != left1.end(); it++){
		int l1, l2, r1, r2;
		l1 = it->second;
		r1 = right1[it->first];
		if(left2.count(it->first) == 0)
			continue;
		l2 = left2[it->first];
		r2 = right2[it->first];
		if(l1 > r2 || l2 > r1)
			return 0;
	}
	return 1;
}
int contain(char a[],int len){
	for(int i = 0; i < len; i++)
		if(a[i] == ',')
			return 1;
	return 0;
}
int main()
{
	int n;
	while(scanf("%d",&n)!= EOF)
	{
		char var[40], op[10],tmp[1024] = "haha";
		int x;
		int firstTime =  1;
		getchar();
		for(int i = 0; i < n; i++){	
			gets(line);
			int len = strlen(line);
			int index = 0;
			while(index < len){
				sscanf(line+index,"%s%s%d",var,op,&x);
				while(line[index]!=',' && line[index] != '\0')
					index++;
				index++;
				insert(mleft[i],mright[i],var,op,x);	
			}		
			if(i == 0 || isEmptySet(mleft[i],mright[i])){
				
				printf("unique\n");
				continue;
			}
			int flag = 1;
			for(int j = 0; j < i; j++){
				if(judge(mleft[j],mright[j],mleft[i],mright[i])){
					if(flag) printf("%d", j + 1);
					else 
						printf(" %d", j + 1);
					flag = 0;
				}
			}
			if(flag)
				printf("unique\n");
			else 
				printf("\n");
		}
	}
	return 0;
}

