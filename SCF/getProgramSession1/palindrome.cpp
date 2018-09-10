#include<iostream>
#include<stack>
#include<string>
using namespace std;

int main()
{
string str;
stack<int> s;
char c;

cin>>str;

int len=str.length();
int i;

for(i=0;i<len;i++)
{
	s.push(str[i]);
}

for(i=0;i<len && !s.empty();i++)
{
    c = s.top();
	if(c != str[i])
	{
		break;
	}
	s.pop();
}
if(i==len)
cout<<"Given string is palindrome";
else
cout<<"Given string is not palindrome";
}

