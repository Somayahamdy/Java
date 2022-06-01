/*********************************************************************************/
/****************************StackCode********************************************/
/*************Aouther:Somaya Hamdy Mohammed***************************************/
/*************Sowft where component : Stack_Data_Structure***************************************/
/*************Data:2021/12/15***************************************/
/*************version:stackv1***************************************/
#include<stdio.h>
//#include<string.h>
#define   maxsize   5
typedef struct stack
{
    int arr[MAX_SIZE];
    int top;
}Stack;



/***************Functions Prototypes*************/

void Stack_voidInitStack(Stack* pt);
void stack_voidvalpush(int Copy_intValue, Stack* pt);
void stack_intvalpop(Stack* pt);
int  stack_INTRETURNTOPVALUE(Stack* s);
int  Stack_intIsEmpty(Stack* pt);
int  stack_intIfully(Stack* pt);
void Stack_voidPrint(Stack* pt);

*******************main function****************************/
void main(){
	 Stack s;
    Stack_voidInitStack(&s);
    Stack* pt= &s;
	int TopValue;
    Stack_voidInitStack(pt);
    stack_voidvalpush(5,pt);
    stack_voidvalpush(7,pt);
    stack_voidvalpush(3,pt);
    TopValue = stack_INTRETURNTOPVALUE(pt);
    printf("%d",TopValue);
    return 0;
}
	
	
	



*********************function empelementatiom***************************/

void Stack_voidInitStack(Stack* pt){
	//pt->arr[maxsize];
	pt->top=-1;
}



void stack_voidvalpush(int val,&s){
	
	if(!stack_intIfully(pt)){
		pt->top++;
		pt -> arr[pt->top]=val;
	}
	else{
		printf("Stack is full");
	}
}
	

	

void stack_intvalpop(&s){
   if(!Stack_intIsEmpty(pt){
	   pt->top--;
    }
   else{
		printf("Stack is empty");
	}   
}



int  Stack_intIsEmpty(pt){
	
	if((pt->top)==-1)
		return 1;
	
	else 
		return 0;
}



int  stack_intIfully(&s){
	if((pt->top)==(maxsize-1))
		return 1;
	
	else 
		return 0;
}
	
	
	
void Stack_voidPrint(Stack* pt)
{
    int Iter = pt->top;
    while(Iter!=-1)
    {
        printf("%d", pt->arr[Iter]);
        Iter--;
    }
}

int  stack_INTRETURNTOPVALUE(Stack* pt)
{
    if(!Stack_intIsEmpty(pt))
        return pt->arr[pt->Top];
    else
    {
        printf("There's no values to be popped\n");
        return 0;
    }
        
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
