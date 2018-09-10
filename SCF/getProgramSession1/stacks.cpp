#include<iostream>
#include<limits.h>
using namespace std;
int top=0;
int n;

void push(int* arr,int x)
{
  if(top==n)
  {
	cout<<"Stack overflow";
	return;
  }
  arr[top++]=x;
  return;
}

int pop(int* arr)
{
  if(top==-1)
  {
	cout<<"Stack underflow hence no element can be popped";
	return INT_MIN;
  }
  int val=arr[top--];
  return val;
}

int Top(int* arr)
{
    if(top==-1)
    {
        return INT_MIN;
    }
	return arr[top];
}

int isempty()
{
	if(top==-1)
	{
	  return 0;
	}
	return 1;
}

int main()
{

cout<<"Enter the size of the stack you want: ";
cin>>n;

int* arr=(int*) malloc(sizeof(int)*n);
int x,popped,checked,top_val;

cout<<"Enter the item you want to insert: ";
cin>>x;

push(arr,x);

cout<<"Top element removed is: ";
popped=pop(arr);
cout<<popped;

int top_val=top(arr)
if(val)
cout<<"Top element in the stack is: "<<val;
else
cout<<"No element in stack at present";

cout<<"To check whether stack is empty or not: ";
if(isempty())
cout<<"Stack is not empty";
else
cout<<"Stack is empty";

return 0;
}
