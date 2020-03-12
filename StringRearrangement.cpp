//
//  main.cpp
//  Homework 1
//
//  Created by Aishwarya Adiki on 8/28/19.
//  Copyright © 2019 Aishwarya Adiki. All rights reserved.
//
#include "stdio.h"
#include "string.h"
#include "stdlib.h"
#include "ctype.h"

int rearrange(); //function proto for name rearrangement
bool testPassword(char [], int); //function prototype for password check


int main()
{
    rearrange();
    
    printf ("\n\n");
    
    
    //calling second fucntion
    const int SIZE = 15;   // Password Array size
    char password[SIZE];  // Array to hold the password;
    


    for (int a = 5; a > -1; a--){
        (testPassword(password, SIZE));
        if (a > 0) {
            printf("\nIf you wish to try again: \n");
        }
        else if (a==0){
            printf("\nYou ran out of tries. Enter q to quit (if applicable) or Restart the program if you wish to try again\n");
        }
        
        
    }

    return 0;
}

int rearrange()
{
    char str[64];
    char *fname;
    char *lname;
    char *mname;
    char delim[] = ", ";
    char splitINPUT[3][21]; //can store 3 words of 20 characters and one null terminator
    int i,j,cnt;
    
    printf("Enter your fullname (first middle last): ");
    fgets(str, sizeof(str), stdin);
    
    
    // find the new line character position and replace the new line character with a null terminator.
    if (str[strlen(str) -1] == '\n') {
        str[strlen(str) -1] = '\0';
    }
    j=0; cnt=0;
    for(i=0;i<=(strlen(str));i++)
    {
        // if space or NULL found, assign NULL into splitINPUT[cnt]
        if(str[i]==' '||str[i]=='\0')
        {
            splitINPUT[cnt][j]='\0';
            cnt++;  //for next word
            j=0;    //for next word, init index to 0
        }
        else
        {
            splitINPUT[cnt][j]=str[i];
            j++;
        }
    }
    //printf("\nOriginal String is: %s",str);
    printf("\nYour rearranged name is: \n");
    for(i=0;i < cnt;i++)
        // printf("%s\n",splitINPUT[i]);
        fname = splitINPUT[0];
    //printf("%s\n",fname);
    lname = splitINPUT[1];
    //printf("%s\n",lname);
    mname = splitINPUT[2];
    //printf("%s\n", mname);
    
    char *fullname = ( char*)malloc(strlen(fname)+strlen(lname)+strlen(mname)+2);
    strcpy(fullname,mname);
    strcat(fullname,delim);
    strcat(fullname,fname);
    strcat(fullname," ");
    strcat(fullname,lname);
    printf("%s\n",fullname);
    
    return 0;
    
}
bool testPassword(char inputPassword[], int size) //testPassword function header
{
    //test password conditions are outlined as follows:
    
    
    printf("Enter a password: ");
    fgets(inputPassword, 16, stdin); // made a change here from gets() to fgets().
    

    int i = 0;
    
    int trackd = 0;
    int trackl = 0;
    int tracku = 0;
    int trackp = 0;
    
    
    //adding conditions for 
    if (inputPassword[strlen(inputPassword) -1] == '\n') {
        inputPassword[strlen(inputPassword) -1] = '\0';
    }
    
    //end
    if (strlen(inputPassword)<15)
    {
        if (5<strlen(inputPassword)){
            for (i = 0; i < strlen(inputPassword); i++) {
                if (isdigit(inputPassword[i])){
                    trackd =  trackd + 1;
                    break;
                }
                else {
                    trackd = 0;
                }
            }
            //check for lowercase
            for (i = 0; i <strlen(inputPassword); i++) {
                
                if (islower(inputPassword [i])) {
                    trackl = trackl + 1;
                    break;
                }
                else {
                    trackl = 0;
                }
            }
            //check for uppercase;
            for (i = 0; i <strlen(inputPassword); i++) {
                
                if (isupper(inputPassword[i])){
                    tracku = tracku + 1;
                    break;
                }
                else {
                    tracku = 0;
                }
            }
            //check for punct
            for (i = 0; i < strlen(inputPassword); i++) {
                
                if (ispunct(inputPassword[i])){
                    trackp = trackp + 1;
                    break;
                }
                else {
                    trackp = 0;
                }
            }
            
            if (trackl == 0 && tracku == 0 && trackd == 0 && trackp == 0) {
                printf("Error. At least one digit, lowercase letter, uppercase letter, and punctuation symbol are required for the password to be valid. \n");
            }
            else if (trackl == 0 && tracku == 0 && trackd == 0) {
                printf("Invalid Paasowrd. At least one digit, lowercase letter, and uppercase letter are required.\n");
            }
            else if (trackl == 0 && trackp == 0 && trackd == 0){
                printf("Invalid Paasowrd. At least one digit, lowercase letter, and one punctuation symbol are required.\n");
            }
            else if (trackp == 0 && trackl == 0 && tracku == 0) {
                printf("Invalid Paasowrd. At least one punctuation symbol, lowercase letter, and uppercase letter are required.\n");
            }
            else if (tracku == 0 && trackd == 0 && trackp == 0) {
                printf("Invalid Paasowrd. At least one digit, uppercase letter, and one punctuation symbol are required.\n");
            }
            else if (trackl == 0 && tracku == 0) {
                printf("Invalid Password. At least one uppercase letter and lowercase letter is required.\n");
            }
            else if (trackl == 0 && trackp == 0){
                printf("Invalid Password. At least one lowercase letter and one punctuation symbol is required.\n");
            }
            else if (trackl == 0 && trackd == 0) {
                printf("Invalid Password. At least one digit and one lowercase letter is required.\n");
            }
            else if (tracku == 0 && trackp == 0) {
                printf("Invalid Password. At least one uppercase letter and one punctuation symbol is required.\n");
            }
            else if (tracku == 0 && trackd == 0) {
                printf("Invalid Password. At least one uppercase letter and one digit is required\n");
            }
            else if (trackp == 0 && trackd == 0) {
                printf("Invalid Password. At least one digit and one punctuation symbol is required\n");
            }
            else if (trackd == 0){
                printf("Error! At least one digit is required\n");
            }
            else if (trackl == 0) {
                printf("Error! At least one lowercase letter is required\n");
            }
            else if (tracku == 0) {
                printf("Error! At least one uppercase letter is required\n");
            }
            else if (trackp == 0) {
                printf("Error! At least one punctuation symbol is required\n");
            }
            
            else {
                printf("Password Valid!\n");
            }
        }
        else {
            printf("Invalid Password. Please make sure the password is between 6 to 14 characters, and follows the given criteria: \n");
            printf("At least one digit\n");
            printf("one lowercase letter\n");
            printf("one uppercase letter\n");
            printf("punctuation symbol\n");
        }
        //check for digit
        
    }
    
    
    else {
        printf("Invalid Password. Please make sure the password is between 6 to 14 characters, and follows the given criteria: \n");
        printf("At least one digit\n");
        printf("one lowercase letter\n");
        printf("one uppercase letter\n");
        printf("punctuation symbol\n");
    }
    
    return true;
    
}


