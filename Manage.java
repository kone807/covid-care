package com.covid;

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    private final ArrayList<HealthCareInstitute> institute;
    private final ArrayList<Patient> patient;
    private static int admitted=0;

    Scanner sc = new Scanner(System.in);

    Manage()
    {
        institute = new ArrayList<>();
        patient = new ArrayList<>();
    }

    //get number of admitted patients
    int getAdmitted()
    {
        return admitted;
    }

    // add patients to camp
    int getInput()
    {
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        System.out.print("Enter Patient details one by one: ");
        for(int i=0; i<n; i++)
        {
            String name = sc.next();
            double temp = sc.nextDouble();
            int oxygenLevel = sc.nextInt();
            int age = sc.nextInt();
            patient.add(new Patient(name, age, oxygenLevel, temp));
        }
        return n;
    }

    //number 1
    // complete it
    void addInstitute(String name)
    {
        System.out.print("Temperature Critera: ");
        double temp = sc.nextDouble();
        System.out.print("Oxygen Levels: ");
        int oxygenLevel = sc.nextInt();
        System.out.print("Number of Available Beds: ");
        int availableBeds = sc.nextInt();

        // create new institute
        HealthCareInstitute h = new HealthCareInstitute(name, availableBeds, temp, oxygenLevel);
        institute.add(h);

        // print institute details
        displayInstituteDetails(name);

        // add patients
        addPatients(h);

        //recovery days input
        recoveryDaysInput(h);
    }

    //helper for num1
    void addPatients(HealthCareInstitute h)
    {
        int bed = h.getBeds();
        int i=0;

        int oxygenLevel = h.getOxygenLevel();
        double temp = h.getTemperature();
        String name = h.getName();
        // based on oxygen level
        while(bed!=0 && i<patient.size())
        {
            if(patient.get(i).getOxygenLevel()>=oxygenLevel && !patient.get(i).isAdmitted())
            {
                //update patient details
                patient.get(i).setAdmitted(true);
                patient.get(i).setAdmittedInstitute(name);

                // admit patient into hospital
                h.getPatient().add(patient.get(i));

                bed--;
                admitted++;
            }
            i++;
        }

        i=0;
        while(bed!=0 && i<patient.size())
        {
            if(patient.get(i).getBodyTemperature()<=temp && !patient.get(i).isAdmitted())
            {
                //update patient details
                patient.get(i).setAdmitted(true);
                patient.get(i).setAdmittedInstitute(name);

                // admit patient into hospital
                h.getPatient().add(patient.get(i));

                bed--;
                admitted++;
            }
            i++;
        }

        if(bed==0)
        {
            h.setOpen(false);
        }
        h.setBeds(bed);
    }

    //helper for num1
    void recoveryDaysInput(HealthCareInstitute h)
    {
        for(int i=0; i<h.getPatient().size(); i++)
        {
            System.out.print("Enter Recovery Days for admitted patient of ID " + h.getPatient().get(i).getID()+": ");
            int days = sc.nextInt();

            h.getPatient().get(i).setRecoveryDays(days);

            // set recovery days for Patient
            for(Patient p : patient)
            {
                if(p.getID()==h.getPatient().get(i).getID())
                {
                    p.setRecoveryDays(days);
                    break;
                }
            }
        }
    }

    // number 2
    void removeAdmittedPatients()
    {
        System.out.println("Account ID removed of admitted patients: ");
        for(int i=0; i<patient.size(); i++)
        {
            if(patient.get(i).isAdmitted())
            {
                System.out.println(patient.get(i).getID());
                patient.remove(patient.get(i));
                i--;
            }
        }
    }

    // number 3
    void removeInstitute()
    {
        System.out.println("Accounts removed of Institute whose admission is closed: ");
        for(int i=0; i<institute.size(); i++)
        {
            if(!institute.get(i).isOpen())
            {
                System.out.println(institute.get(i).getName());
                institute.remove(institute.get(i));
                i--;
            }
        }
    }
    //number 4
    // little doubtful
    void inCamp()
    {
        int ans=0;
        for(Patient p : patient)
        {
            if(!p.isAdmitted())
                ans++;
        }
        System.out.println(ans+" patients");
    }

    //number 5
    void isAdmitting()
    {
        int ans=0;
        for(HealthCareInstitute h : institute)
        {
            if(h.isOpen())
                ans++;
        }

        System.out.println(ans+" institutes are admitting patients currently");
    }

    //number 6
    void displayInstituteDetails(String name)
    {
        for(HealthCareInstitute h : institute)
        {
            if(h.getName().equals(name))
            {
                h.instituteDetails();
                break;
            }
        }
    }

    //number 7
    void displayPatientByID(int ID)
    {
        for(Patient p : patient)
        {
            if(p.getID()==ID)
            {
                p.getDetails();
                break;
            }
        }
    }

    // number 8
    // print not deleted yet
    void displayAllPatients()
    {
        for (Patient value : patient) {
            System.out.println(value.getID() + " " + value.getName());
        }
    }

    //number 9
    void displayPatientByInstitute(String name)
    {
        for(HealthCareInstitute h : institute)
        {
            if(h.getName().equals(name))
            {
                h.patientDetails();
                break;
            }
        }
    }
}
