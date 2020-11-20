package com.covid;

public class Patient {
    private final String name;
    private final int age;
    private final int oxygenLevel;
    private final double bodyTemperature;
    private final int ID;
    private int recoveryDays;
    private boolean admitted;
    private String admittedInstitute;

    private static int count=1;

    Patient(String name, int age, int oxygenLevel, double bodyTemperature)
    {
        this.name=name;
        this.age=age;
        this.oxygenLevel=oxygenLevel;
        this.bodyTemperature=bodyTemperature;
        this.ID=count++;

        this.recoveryDays=0;
        this.admitted=false;
        this.admittedInstitute=null;
    }

    void setRecoveryDays(int x)
    {
        this.recoveryDays=x;
    }

    String getName()
    {
        return name;
    }

    int getID()
    {
        return ID;
    }

    boolean isAdmitted()
    {
        return admitted;
    }

    void setAdmitted(boolean x)
    {
        admitted=x;
    }

    void setAdmittedInstitute(String name)
    {
        admittedInstitute=name;
    }
    int getRecoveryDays()
    {
        return recoveryDays;
    }

    int getOxygenLevel()
    {
        return oxygenLevel;
    }

    double getBodyTemperature()
    {
        return bodyTemperature;
    }

    void getDetails()
    {
        System.out.println("Patient's name is "+name+"!");
        System.out.println("Body Temperature is " + bodyTemperature);
        System.out.println("Oxygen Levels are " + oxygenLevel);

        String admit = admitted ?"admitted":"not admitted";
        System.out.println("Current Admission Status: " + admit);

        if(admitted)
        {
            System.out.println("Admitted Institute: " + admittedInstitute);
        }
    }
}
