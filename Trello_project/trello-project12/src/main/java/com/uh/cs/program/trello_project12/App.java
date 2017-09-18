package com.uh.cs.program.trello_project12;

import login.Login;
import login.Register;

/**
 Software Design, Trello Project 
 Team 12
 */
public class App 
{
    public static void main( String[] args )
    {
    Login user = new Login();
     user.login();
      Register newuser = new Register();
      newuser.register();
    }
}
