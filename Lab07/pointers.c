/*
 * Lab7
 *
 * Lab 7
 *
 * Copyright 2015
 *
 * Course: CSC 172 Spring 2015
 *
 * Assignment: Lab 7
 *
 * Author: Nicholas Graham
 *
 * Lab Session: Wednesday 6:15 - 7:30
 *
 * Lab TA: Kate Zeng Zhiming
 *
 * Last Revised: Febuary 12, 2014.
 */
#include <stdio.h>
void mystrcat(char *dest, char *source);
void mystrcpy(char *s, char *t);
int mystrcmp(char *s, char *t);

int main(int argc, char *argv[]) {
  char msg[30];
  mystrcpy(msg, "Hello, ");
  for (int len = 0; len < argc; len++){
    if (mystrcmp(argv[len], "Nick") == 0){
      
      mystrcat(msg, argv[len]);
      printf("%s\n", msg);
    }
    else{
      printf("%s\n", argv[len]);
    }
  }
  int square[10];
  for (int i=0; i < (int) (sizeof(square)/sizeof(int)); i++){
    square[i] = i*i;
  }

  int *s = square;

  for (int i = 0; i< (int) (sizeof(square)/sizeof(int)); i++){
    printf("%d, ", *(s+i));
  }
  printf("\n");
  return 0;

}
int mystrcmp(char *s, char *t){
  for ( ; *s == *t; s++, t++){
    if(*s == '\0'){
      return 0;
    }
  }
  return *s - *t;
}
void mystrcat(char *dest, char *source){
  while(*dest != '\0'){
    dest++;
  }
  while ((*dest = *source) != '\0'){
    dest++;
    source++;
  }
}
void mystrcpy(char *s, char *t){
  int i;
  i = 0;
  while((*s = *t) != '\0'){
    s++;
    t++;
  }
}
