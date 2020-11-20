package com.covid;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.print("Welcome to 'COVID CARE', an efficient Command Line Software to manage intake of COVID infected patients" +
                " during the time of this pandemic across\n delhi hospitals. The next few lines describe the working and functionality of the software"+
                "Initially the user enters the number of patients\n suffering from COVID followed by their details in the format (Name, Body Temperature in F, Oxygen Levels, Age)\n"+
                "This is then followed by several types of queries on this dataset of patients. The description of each query is as follows- (note that each query\n is evoked by typing the number corresponding to it)\n"+
                "1. Add Health Care Institute\n"+"2. Remove accounts of admitted patients\n"+"3. Remove accounts of healthcare institutes whose applications are closed\n"+
                "4. Display number of patients still in camp (not admitted yet)\n"+"5. Display number of health care institutes admitting patients currently\n"+
                "6. Display details of the Health Care Institute\n"+"7. Display details of particular patient\n"+"8. Display all patients\n"+
                "9. Display names of patients admitted in an institute with their recovery time\n");
        Scanner sc = new Scanner(System.in);
       Manage m = new Manage();

       int n = m.getInput();

       while(n-m.getAdmitted()> 0)
       {
           System.out.print("Enter Query Number: ");
           int x = sc.nextInt();

           if(x==1)
           {
               System.out.print("Enter Institute Name: ");
                String s = sc.next();
                m.addInstitute(s);
           }

           else if(x==2)
           {
               m.removeAdmittedPatients();
           }

           else if(x==3)
           {
               m.removeInstitute();
           }

           else if(x==4)
           {
               m.inCamp();
           }

           else if(x==5)
           {
               m.isAdmitting();
           }

           else if(x==6)
           {
               System.out.print("Enter Institute Name: ");
               String s = sc.next();
               m.displayInstituteDetails(s);
           }

           else if(x==7)
           {
               System.out.print("Enter Institute ID: ");
               int id = sc.nextInt();
               m.displayPatientByID(id);
           }

           else if(x==8)
           {
               m.displayAllPatients();
           }

           else if(x==9)
            {
                System.out.print("Enter Institute Name: ");
                String s = sc.next();
                m.displayPatientByInstitute(s);
            }
       }

    }
}
