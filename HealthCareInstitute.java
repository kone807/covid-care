package com.covid;

import java.util.ArrayList;

public class HealthCareInstitute {
    private final String name;
    private final ArrayList<Patient> patient;
    private boolean open = true;
    private int beds;
    private final double temperature;
    private final int oxygenLevel;

    HealthCareInstitute(String name, int beds, double temperature, int oxygenLevel)
    {
        this.name=name;
        this.beds=beds;
        this.temperature=temperature;
        this.oxygenLevel=oxygenLevel;
        patient = new ArrayList<>();
    }

    boolean isOpen()
    {
        return open;
    }

    void setOpen(boolean x)
    {
        open=x;
    }

    String getName()
    {
        return name;
    }

    int getOxygenLevel()
    {
        return oxygenLevel;
    }

    double getTemperature()
    {
        return temperature;
    }

    int getBeds()
    {
        return beds;
    }

    void setBeds(int x)
    {
        beds=x;
    }

    ArrayList<Patient> getPatient()
    {
        return patient;
    }

    void patientDetails()
    {
        for(Patient p : patient)
        {
            System.out.println(p.getName()+" will recover and celebrate in "+p.getRecoveryDays()+" days");
        }
    }

    void instituteDetails()
    {
        System.out.println("The institute's name is " + name);
        System.out.println("Temperature should be <= " + temperature);
        System.out.println("Oxygen Levels should be >= " + oxygenLevel);
        System.out.println("Number of Available Beds: " + beds);

        String status = open ?"OPEN":"CLOSED";
        System.out.println("Admission Status: " + status);

    }
}
