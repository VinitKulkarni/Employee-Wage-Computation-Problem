package com.bridgelabz.Day3PP1;

import java.util.ArrayList;

interface IComputeEmpWage{
    int checkEmpAttendence();
    void calculateWage();
    void display();
}

class CompanyEmpWage {
    String empCompanyName;
    static int totalWorkingDaysInMonth;
    static int maxWorkHrsInMonth;
    static int perHourWage;
    static int finalWage;
    static int finalWorkHrs;

    public CompanyEmpWage(String empCompanyName, int totalWorkingDaysInMonth, int maxWorkHrsInMonth,
                          int perHourWage, int finalWorkHrs, int finalWage) {
        this.empCompanyName = empCompanyName;
        this.totalWorkingDaysInMonth = totalWorkingDaysInMonth;
        this.maxWorkHrsInMonth = maxWorkHrsInMonth;
        this.perHourWage = perHourWage;
        this.finalWorkHrs = finalWorkHrs;
        this.finalWage = finalWage;
    }
}

public class EmployeeWageCalculation implements IComputeEmpWage{
    static final int FULL_DAY_WORK_HRS = 8;
    static final int PART_TIME_WORK_HRS = 4;
    static int finalWage = 0;
    static int finalWorkHrs = 0;
    String companyName;
    static int totalWorkingDaysInMonth;
    static int maxWorkHrsInMonth;
    static int perHourWage;
    ArrayList<CompanyEmpWage> arraylist = new ArrayList<CompanyEmpWage>();

    public EmployeeWageCalculation(String companyName, int totalWorkingDaysInMonth, int maxWorkHrsInMonth,
                                   int perHourWage){
        this.companyName = companyName;
        this.totalWorkingDaysInMonth = totalWorkingDaysInMonth;
        this.maxWorkHrsInMonth = maxWorkHrsInMonth;
        this.perHourWage = perHourWage;
    }

    static void resetValues(){
        finalWage = 0;
        finalWorkHrs = 0;
    }
    public int checkEmpAttendence(){
        int isPresent = (int) (Math.random() * 10) % 3;
        return isPresent;
    }

    public void calculateWage(){
        int totalWage = 0; //eachtimeupdate
        int empHrs = 0; //differentvalues

        for(int i = 1; i <= totalWorkingDaysInMonth; i++) {
            int isPresent = checkEmpAttendence();
            switch (isPresent) {
                case 1:
                    System.out.println("Emp is Full day present");
                    totalWage = (FULL_DAY_WORK_HRS * perHourWage);
                    empHrs = 8;
                    break;
                case 2:
                    System.out.println("Emp doing part time");
                    totalWage = (PART_TIME_WORK_HRS * perHourWage);
                    empHrs = 4;
                    break;
                case 0:
                    System.out.println("Emp is absent");
                    totalWage = 0;
                    empHrs = 0;
                    break;
                default:
                    System.out.println("!!!Something wrong!!!");
                    break;
            }
            finalWage = finalWage + totalWage;
            finalWorkHrs = finalWorkHrs + empHrs;

            System.out.println("Day->" + i + " : FinalWage->" + finalWage + " : WorkHrs->" + finalWorkHrs);
            System.out.println("---------------------");

            if(finalWorkHrs == maxWorkHrsInMonth){
                System.out.println("EMP COMPLETED HIS WORK HRS OF THIS MONTH");
                break;
            } else if (finalWorkHrs > maxWorkHrsInMonth) {
                System.out.println("!Work Hrs Exceeds the limit! Reset");
                finalWage = finalWage - totalWage;
                System.out.println("Final wage --> " +finalWage);

                finalWorkHrs = finalWorkHrs - empHrs;
                System.out.println("Final work hrs --> " +finalWorkHrs);
            }
        }
        arraylist.add(new CompanyEmpWage(companyName,totalWorkingDaysInMonth,maxWorkHrsInMonth,perHourWage,finalWorkHrs,finalWage));
    }

    public void display(){
        for(int i=0; i<arraylist.size(); i++){
            System.out.println("company name ->" +arraylist.get(i).empCompanyName);
            System.out.println("total working days in month ->" +arraylist.get(i).totalWorkingDaysInMonth);
            System.out.println("max work hours in month ->" +arraylist.get(i).maxWorkHrsInMonth);
            System.out.println("per hour wage ->" +arraylist.get(i).perHourWage);
            System.out.println("total work hours ->" +arraylist.get(i).finalWorkHrs);
            System.out.println("total wage ->" +arraylist.get(i).finalWage);
        }
    }

    public static void main(String[] args) {
        System.out.println(" * * * Employee Wage Calculation * * * ");

        EmployeeWageCalculation wipro = new EmployeeWageCalculation("Wipro",28,140,22);
        wipro.calculateWage();
        System.out.println();
        wipro.display();
        System.out.println();

        resetValues();

        EmployeeWageCalculation tcs = new EmployeeWageCalculation("TCS", 25, 120, 25);
        tcs.calculateWage();
        System.out.println();
        tcs.display();
        System.out.println();
    }
}
