
#include <iostream>
using namespace std;
#include <limits.h>

struct node
{
    int data;
    struct node* next;
};

struct node* newNode(int data)
{
    struct node* stackNode =(struct node*) malloc(sizeof(struct node));
    stackNode->data = data;
    stackNode->next = NULL;
    return node;
}

int isEmpty(struct node *root)
{
    return !root;
}

void push(struct node** root, int data)
{
    struct node* node = newNode(data);
    node->next = *root;
    *root = node;
    printf("%d pushed to stack\n", data);
}

int pop(struct node** root)
{
    if (isEmpty(*root))
        return INT_MIN;
    struct node* temp = *root;
    *root = (*root)->next;
    int popped = temp->data;
    free(temp);

    return popped;
}

int peek(struct node* root)
{
    if (isEmpty(root))
        return INT_MIN;
    return root->data;
}

int main()
{
    struct node* root = NULL;

    push(&root, 2);
    push(&root, 4);
    push(&root, 6);

    cout<<"item popped from stack: \n"<<pop(&root);

    cout<<"Top element in stack is:\n"<<peek(root);

    return 0;
}
