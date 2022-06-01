#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE        100

typedef struct stack
{
    int Arr[MAX_SIZE];
    int Top;
}Stack;


/************************************************/
/***************Functions Prototypes*************/
/************************************************/
void Stack_voidInitStack(Stack* ps);
void Stack_voidPush(int Copy_intValue, Stack* ps);
void Stack_voidPop(Stack* ps);
int  Stack_intReturnTopValue(Stack* ps);
int  Stack_intIsEmpty(Stack* ps);
int  Stack_intIsFull(Stack* ps);
void Stack_voidPrint(Stack* ps);


int main()
{
    Stack s;
    Stack_voidInitStack(&s);
    Stack* ps= &s;
    int TopValue;
    Stack_voidInitStack(ps);
    Stack_voidPush(5,ps);
    Stack_voidPush(7,ps);
    Stack_voidPush(3,ps);
    TopValue = Stack_intReturnTopValue(ps);
    printf("%d",TopValue);
    return 0;
}

void Stack_voidInitStack(Stack* ps)
{
    //Top holds -1 "out of range"
    ps ->Top = -1;
}

void Stack_voidPush(int Copy_intValue, Stack* ps)
{
    if(!Stack_intIsFull(ps))
    {        
        //Incrementing Top
        ps->Top++;
        //Asign data into this index
        ps->Arr[ps->Top] =  Copy_intValue;
    }
    else
    {
        printf("Stack is Full, You can't push again\n");
    }
}

void Stack_voidPop(Stack* ps)
{
    if(!Stack_intIsEmpty(ps))
        ps ->Top--;
    else
        printf("There's no values to be popped\n");
}

int  Stack_intReturnTopValue(Stack* ps)
{
    if(!Stack_intIsEmpty(ps))
        return ps->Arr[ps->Top];
    else
    {
        printf("There's no values to be popped\n");
        return 0;
    }
        
}


//int  Stack_intReturnTopValue(Stack* ps)
//{
//    if(!Stack_intIsEmpty(ps))
//        return ps->Arr[ps->Top];
//    else
//        return 0;
//}

int  Stack_intIsEmpty(Stack* ps)
{
    if(ps->Top == -1)
        return 1;
    else
        return 0;
    //return (ps->Top==-1)
}

int  Stack_intIsFull(Stack* ps)
{
    return (ps->Top==(MAX_SIZE-1));
}

void Stack_voidPrint(Stack* ps)
{
    int Iter = ps->Top;
    while(Iter!=-1)
    {
        printf("%d", ps->Arr[Iter]);
        Iter--;
    }
}
