#include <stdlib.h>
#include <stdio.h>
#define TRUE 1
#define FALSE 0
typedef int BOOLEAN;

struct Node {
 int value;
 struct Node *next;
};

void insert(int x, struct Node **pL);
void printList(struct Node * L);
BOOLEAN lookup(int x, struct Node * L);
void delete(int x, struct Node **pL);

int main(int argc, char *charv[]){
  struct Node *myLinkedList;
  for (int i = 1; i < 20; i += 2)
    insert(i,&myLinkedList);
  printList(myLinkedList);
  for (int i = 0; i < 20; i++)
    printf("%d %s FOUND\n",i,((lookup(i,myLinkedList) == TRUE) ? "": "NOT"));

  printList(myLinkedList);
  for (int i = 0; i < 20; i += 3)
   delete(i,&myLinkedList);

  printList(myLinkedList);
}

void insert(int x, struct Node **pL){
  if (*pL == 0){
    *pL = malloc(1);
    (*pL)->value = x;
    (*pL)->next = 0;
  }
  else{
    insert(x, &((*pL)->next));
  }
}

void printList(struct Node *L){
  while(L != 0){
    printf("%d ", (L)->value);
    L = (L->next);
  }
  printf("\n");
}

BOOLEAN lookup(int x, struct Node * L){
  while(L != 0){
    if (L->value == x){
      return TRUE;
    }
    L = L->next;
  }
  return FALSE;
}

void delete(int x, struct Node **pL){
  while (*pL != 0){
    if (((*pL)->value) == x){
      struct Node *temp = (*pL)->next; // get address of next node
      free(*pL); // Free the memory
      (*pL) = temp; // and remove the pointer to the node being deleted
    }
    (pL) = &((*pL)->next);
  }
}
