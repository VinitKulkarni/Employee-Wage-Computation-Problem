package com.bridgelabz.Day3PP1;

public class EmployeeWageCalculation {
    static int finalWage = 0;
    static int finalWorkHrs = 0;

    //all static fixed values
    static final int FULL_DAY_WORK_HRS = 8;
    static final int PART_TIME_WORK_HRS = 4;

    static void resetValues(){
        finalWage = 0;
        finalWorkHrs = 0;
    }
    static int checkEmpAttendence(){
        int isPresent = (int) (Math.random() * 10) % 3;
        return isPresent;
    }

    static int calculateWage(String companyName, int totalWorkingDaysInMonth, int maxWorkHrsInMonth,
                             int perHourWage){
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
        return finalWage;
    }

    public static void main(String[] args) {
        System.out.println(" * * * Employee Wage Calculation * * * ");


        int wiproTotalWage = calculateWage("Wipro", 28, 140, 22);
        System.out.println("TOTAL WAGE (emp working in wipro) = " +wiproTotalWage);

        resetValues();
        System.out.println();
        System.out.println();

        int tcsTotalWage = calculateWage("TCS", 25, 120, 25);
        System.out.println("TOTAL WAGE (emp working in tcs) = " +tcsTotalWage);
    }
}
