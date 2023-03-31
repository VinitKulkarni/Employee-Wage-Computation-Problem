package com.bridgelabz.Day3PP1;

public class EmployeeWageCalculation {
    static int finalWage = 0;
    static int finalWorkHrs = 0;
    public static void main(String[] args) {
        System.out.println("Employee Wage Calculation");
        int totalWage = 0;
        int perHourWage = 20;
        int fullDayWorkHrs = 8;
        int partTimeWorkHrs = 4;
        int totalWorkingDaysInMonth = 20;
        int empHrs = 0;

        for(int i=0; i<totalWorkingDaysInMonth; i++) {
            int isPresent = (int) (Math.random() * 10) % 3;
            switch (isPresent) {
                case 1:
                    System.out.println("Emp is Full day present");
                    totalWage = (fullDayWorkHrs * perHourWage);
                    empHrs = 8;
                    break;
                case 2:
                    System.out.println("Emp doing part time");
                    totalWage = (partTimeWorkHrs * perHourWage);
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
            System.out.println("FINAL WAGE = " + finalWage);

            finalWorkHrs = finalWorkHrs + empHrs;
            System.out.println("FINAL WORK HRS = " + finalWorkHrs);

            if(finalWorkHrs == 100){
                System.out.println("EMP COMPLETED HIS WORK HRS OF THIS MONTH");
                break;
            } else if (finalWorkHrs > 100) {
                System.out.println("!Work Hrs Exceeds the limit! Reset");
                finalWage = finalWage - totalWage;
                System.out.println("Final wage --> " +finalWage);

                finalWorkHrs = finalWorkHrs - empHrs;
                System.out.println("Final work hrs --> " +finalWorkHrs);
            }
        }
        System.out.println("FINAL WAGE = " + finalWage);
    }
}
