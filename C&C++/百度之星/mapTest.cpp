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
void f(map<int,int> &m){
	m[0] = 1;
}
int main()
{
	map<int,int> m;
	f(m);
	cout<<m[0]<<endl;
	 return 0;
}

