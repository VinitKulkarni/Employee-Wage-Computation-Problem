package com.bridgelabz.Day3PP1;

public class EmployeeWageCalculation {
    static int finalWage = 0;
    static int finalWorkHrs = 0;

    //all static fixed values
    static final int PER_HOUR_WAGE = 20;
    static final int FULL_DAY_WORK_HRS = 8;
    static final int PART_TIME_WORK_HRS = 4;
    static final int TOTAL_WORKING_DAYS_IN_MONTH = 20;
    static final int MAX_WORK_HRS_IN_MOTH = 100;

    static int checkEmpAttendence(){
        int isPresent = (int) (Math.random() * 10) % 3;
        return isPresent;
    }

    static int calculateWage(){
        int totalWage = 0; //eachtimeupdate
        int empHrs = 0; //differentvalues

        for(int i = 1; i<= TOTAL_WORKING_DAYS_IN_MONTH; i++) {
            int isPresent = checkEmpAttendence();
            switch (isPresent) {
                case 1:
                    System.out.println("Emp is Full day present");
                    totalWage = (FULL_DAY_WORK_HRS * PER_HOUR_WAGE);
                    empHrs = 8;
                    break;
                case 2:
                    System.out.println("Emp doing part time");
                    totalWage = (PART_TIME_WORK_HRS * PER_HOUR_WAGE);
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
            //System.out.println("FINAL WAGE = " + finalWage);

            finalWorkHrs = finalWorkHrs + empHrs;
            //System.out.println("FINAL WORK HRS = " + finalWorkHrs);


            System.out.println("Day->" + i + " : FinalWage->" + finalWage + " : WorkHrs->" + finalWorkHrs);
            System.out.println("---------------------");

            if(finalWorkHrs == MAX_WORK_HRS_IN_MOTH){
                System.out.println("EMP COMPLETED HIS WORK HRS OF THIS MONTH");
                break;
            } else if (finalWorkHrs > MAX_WORK_HRS_IN_MOTH) {
                System.out.println("!Work Hrs Exceeds the limit! Reset");
                finalWage = finalWage - totalWage;
                System.out.println("Final wage --> " +finalWage);

                finalWorkHrs = finalWorkHrs - empHrs;
                System.out.println("Final work hrs --> " +finalWorkHrs);
            }
        }
        return finalWage;
    }

    public static void main(String[] args) {
        System.out.println("Employee Wage Calculation");

        int totalWage = calculateWage();
        System.out.println("TOTAL WAGE = " +totalWage);
    }
}
