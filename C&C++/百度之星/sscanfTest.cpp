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
	char str[1000] = "I love you";
	char a[1000];
	char b[1000];
	char c[1000];
	char tmp[1000] = "#";
	sscanf(str,"%s%s%s%s",a,b,c,tmp);
	printf("%s %s %s %s\n",a,b,c,tmp);
	
 	return 0;
}

