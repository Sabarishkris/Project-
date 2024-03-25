package com.interviewpanel.validation;

public class Validation {

          public boolean validMailId(String email){
            String [] check=email.split("@");

            if(check.length!=2  ){
                return false;
            }
            String s1=check[0];
            if(s1.isEmpty() || s1.charAt(0)=='.' || s1.charAt(s1.length()-1)=='.'){
               return false;
            }
            for(int i=0;i<s1.length();i++){
                if(i<s1.length()-1 && s1.charAt(i)=='.' && s1.charAt(i+1)=='.'){
                    return false;
                }
                if(Character.isDigit(s1.charAt(i)) || Character.isLetter(s1.charAt(i)) || s1.charAt(i)=='.'){
                    continue;
                }
                else{
                    return false;
                }
            }

            String s2=check[1];
            if(s2.charAt(0)=='.' || s2.charAt(s2.length()-1)=='.'){
                return false;
            }
            int count=0;
            for(int i=0;i<s2.length();i++){
                if(i<s2.length()-1 && s2.charAt(i)=='.' && s2.charAt(i+1)=='.' ){
                   return false;
                }
                if(s2.charAt(i)=='.'){
                    count++;
                }
                if( Character.isLowerCase(s2.charAt(i)) || s2.charAt(i)=='.'){
                    continue;
                }

                else{
                   return false;
                }
            }
            if(count==1 || count==2) {
                return true;

            }else {
               return false;
            }

        }
    public boolean validPhoneNo(long phoneNo){
        String phoneNumber=String.valueOf(phoneNo);
        if(phoneNumber.length()==10)
            return true;
        return false;
    }
    public boolean nameChecker(String name) {
        if(name.length()<3 || name.length()>30)
            return false;
        for(int i=0;i<name.length();i++) {
            if(!(name.charAt(i)>='A' && name.charAt(i)<='Z' || name.charAt(i)>='a' && name.charAt(i)<='z'))
                return false;
        }
        return true;
    }
        }
