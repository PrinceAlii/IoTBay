package uts.isd.model.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;


public class Validator implements Serializable{ 


    private String emailPattern= ("^(.+)@(.+)$");
    private String namePattern = "[a-zA-Z]*";
    private String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{3,20}$"; 
    private String phonePattern = "[0-9]{8,10}";
            
    public Validator(){    } 
    
    public String validateEmail(String input){   
        Pattern regEx = Pattern.compile(emailPattern);       
        Matcher match = regEx.matcher(input); 
        boolean check =  match.matches();
        if(check){
            return null;
        }else{
           return "Email: Ensure it has a similar layout to the provided example e.g. johnsmith@email.com";
        } 
    } 

    public String validateName(String input){   
        Pattern regEx = Pattern.compile(namePattern);       
        Matcher match = regEx.matcher(input); 
        boolean check =  match.matches();
        if(check){
            return null;
        }else{
           return "Name: Please enter a valid name";
        } 
    } 

    public String validatePassword(String input){   
        Pattern regEx = Pattern.compile(passwordPattern);       
        Matcher match = regEx.matcher(input); 
        boolean check =  match.matches();
        if(check){
            return null;
        }else{
           return "Password: Miniumn one digit, one uppercase, one lowercase and is 3-10 characters long.";
        } 
    } 

    public String validatePhone(String input){   
        Pattern regEx = Pattern.compile(phonePattern);       
        Matcher match = regEx.matcher(input); 
        boolean check =  match.matches();
        if(check){
            return null;
        }else{
           return "Phone: Please ensure contact number is 8-10 digits long.";
        } 
    } 



    // public boolean validate(String pattern, String input){   

    //     Pattern regEx = Pattern.compile(pattern);       
    //     Matcher match = regEx.matcher(input);       

    // return match.matches(); 
    // }       

    // public boolean checkEmpty(String email, String password){       

    // return  email.isEmpty() || password.isEmpty();   
    // }

    // public boolean validateEmail(String email){                       

    // return validate(emailPattern,email);   
    // }

        
//     public boolean validateName(String name){

//     return validate(namePattern,name); 

//     }       


//     public boolean validatePassword(String password){

//     return validate(passwordPattern,password); 

//     }   
    
    // public void clear(HttpSession session) {
    //     session.setAttribute("emailErr", "Enter email");
    //     session.setAttribute("passwordErr", "Enter password");
    //     session.setAttribute("exist", "");
    //     session.setAttribute("nameErr", "Enter name");
    // }
}