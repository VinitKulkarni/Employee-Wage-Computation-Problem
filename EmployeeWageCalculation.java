package com.bridgelabz.Day3PP1;

public class EmployeeWageCalculation {
    public static void main(String[] args) {
        System.out.println("Employee Wage Calculation");
        int totalWage = 0;
        int perHourWage = 20;
        int fullDayWorkHrs = 8;

        int isPresent = (int)(Math.random() * 10)%2;
        if(isPresent == 1){
            System.out.println("Employee is Present");
            totalWage = (fullDayWorkHrs * perHourWage);
        }else{
            System.out.println("Employee is Absent");
            totalWage = 0;
        }
        System.out.println("TOTAL WAGE = " +totalWage);
    }
}
