#include <stdio.h>
int main(int argc, char * argv[]) {
  for (int len = 0; len < argc; len++){
    printf("%s\n", argv[len]);
  }

}
int mystrcmp(char *s, char *t){
  int i;

  for ( ; *s == *t; s++, t++){
    if(*s == '\0'){
      return 0;
    }
  }
  return *s - *t;
}
void mystrcpy(char *s, char *t){
  int i;
  i = 0;
  while((*s = *t) != '\0'){
    s++;
    t++;
  }
}
