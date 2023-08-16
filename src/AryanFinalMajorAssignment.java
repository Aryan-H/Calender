/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aryanfinalmajorassignment;
import java.util.Scanner;

/**
 *File: AryanFinalMajorAssignment
 *Date: 02/01/2021
 *Name: Aryan Hussain
 */

public class AryanFinalMajorAssignment {

    //main method
    public static void main(String[] args) {
        
        //Set the year input to interger
        int yearinput,dayinput;
        String monthinput, choice = "nothing";
        
        //implement scanner for inputs
        Scanner  In = new Scanner (System.in);
        
        // Replay program until user exits
        while (!choice.equals("exit") && !choice.equals("Exit")){
            
            // Ask user for choice
            System.out.println("Hello!, please choose one of the following options by inputing each parts associated letter");
            System.out.println("A - display year calender of any year");
            System.out.println("B - display month calender of any month in any year");
            System.out.println("C - Find name of day for any speific date");
            System.out.println("D - Find specific date for any number of days after February 1st, 2021");
            System.out.println("Exit - To end process");
            System.out.println("Which option would you like to choose?");
            choice = In.nextLine();
            
            
            //plays year calender if user inputs A
            if (choice.equals("A") || choice.equals("a")){
                //ask the user for what year calender they want
                System.out.println("Please enter a year (after 1900):");
                yearinput = In.nextInt();
                In.nextLine();
                System.out.println();
        
                //use the year calender method
                yearCalendar(yearinput);
                
            }
            
            //plays monthly calender if user inputs B
            else if (choice.equals("B") || choice.equals("b")){
                
                //ask the user for what year calender they want
                System.out.println("Please enter a year (after 1900):");
                yearinput = In.nextInt();
        
                In.nextLine();
                System.out.println("Please enter a month:");
                monthinput = In.nextLine();
        
                System.out.println();
        
                //use the year calender method
                monthCalender(monthinput,yearinput);
            }
            
            //plays name finder if user inputs C
            else if (choice.equals("C") || choice.equals("c")){
                //ask the user for a specific date
                System.out.println("Please enter a year (after 1900):");
                yearinput = In.nextInt();
        
                In.nextLine();
                System.out.println("Please enter a month:");
                monthinput = In.nextLine();
        
        
                System.out.println("Please enter a day:");
                dayinput = In.nextInt();
                In.nextLine();
                
                //calls dayfinder method
                String dayName = dayNameFinder(monthinput, dayinput, yearinput);
                System.out.println("The day is " + dayName);
                System.out.println();
            }
            
            //plays datefinder if user inputs D
            else if (choice.equals("D") || choice.equals("d")){
                
                //Ask user for days after february 1st, 2021
                System.out.println("Please enter the number of days after february 1st, 2021:");
                dayinput = In.nextInt();
                In.nextLine();
                
                //calls datefinder method
                dateFinder (dayinput);
                System.out.println();
            
            }
            
        }   
    }
    
    //method: yearCalender() to print a calnder for 1 year
    public static void yearCalendar(int year){
        
        //set the default total days to 0 and set start day to interger
        int totalDays = 0, startDayNum;
        
        //Determine amount of days past from 1900 based on year input
        for (int i = 1900; i < year; i++){
            if (leapYear(i))
                totalDays = totalDays + 366;
            else
                totalDays = totalDays + 365;
        }
        
        //Find first day of inputed year
        startDayNum = totalDays % 7; 
        
        // display each month of the year using the monthly calender method
        for (int j=1; j<= 12; j++){
            
            // display month name
             System.out.println(nameOfMonth(j) );
             
            //show calender of the month
             showMonthCalender(daysMonth(j, year),
                     
             dayNumberToWeekdayName(startDayNum));
             
             //add to total days
             totalDays = totalDays + daysMonth(j, year);
             
             // find new start day 
             startDayNum = totalDays % 7;  
                     
        }
      
    }
    
    //method: monthCalender() to print a calnder for 1 month
     public static void monthCalender(String month, int year){
         

            //set the default total days to 0 and set start day to interger
            int totalDays = 0, startDayNum;
        
            //find total day at beginnig of year
            for (int i = 1900; i < year; i++){
                if (leapYear(i))
                    totalDays = totalDays + 366;
                else
                    totalDays = totalDays + 365;
            }
            
            //set the month number
            int numberofmonth = nameOfMonthToNumber(month);
            
            //find day before the start of month
             for (int i = 1; i < numberofmonth; i++)
                 totalDays = totalDays + daysMonth(i,year);
                 
    
             // display month name
             System.out.println(nameOfMonth(numberofmonth) );
             
             //find start day of month
             startDayNum = totalDays % 7;
            
             // print month
             showMonthCalender(daysMonth(numberofmonth, year), 
                     dayNumberToWeekdayName(startDayNum));
     
     }
     
     //method: dayNameFinder() to find weekday name for any date
     public static String dayNameFinder(String month, int day, int year){
              //set the default total days to 0 and set start day to interger
            int totalDays = 0, startDayNum;
        
            //find total day at beginnig of year
            for (int i = 1900; i < year; i++){
                if (leapYear(i))
                    totalDays = totalDays + 366;
                else
                    totalDays = totalDays + 365;
            }
            
            //set the month number
            int numberofmonth = nameOfMonthToNumber(month);
            
            //find day before the start of month
             for (int i = 1; i < numberofmonth; i++)
                 totalDays = totalDays + daysMonth(i,year);
             
             //find day number of the day in the month
             totalDays = totalDays + day - 1;
             
             //find weekday number
             startDayNum = totalDays % 7; 
             
             //print weekday name
             return dayNumberToWeekdayName(startDayNum);        
     }      
     
     //method: dateFinder() to find date of of any number of days after February 1st,2021
     public static void dateFinder (int  n) {  
         
         // Set variable types and set year to 2021
         int daysInYear, year = 2021;
     
            //check if day is after 2021
            if (n > 333 ){
                
                //set year to 2022
                year = 2022;
                
                //determine days left after 2021
                n = n - 333;
                
                //find out how many years are left and add it to year
                int extraYear = n/365;
                year = year + extraYear;
                
                //find days left
                daysInYear = n%365;
            }
            
            //if year is 2021 add 32 to find days in year
            else
                daysInYear = n + 32;
             
            //set month to 1
             int month = 1;
             
             //determine month and day
             while (daysInYear > daysMonth (month, year)){
                   
                   //determine month and days left in that month
                   daysInYear = daysInYear - daysMonth (month, year); 
                   
                   //add to month count
                   month++;
                }
                
                //print date
                String monthName = (nameOfMonth (month)); 
                System.out.println("The date is: " + monthName + " " + daysInYear + ", " + year);
                  
     }
     
    //method: showMonthCalender() to print a calnder for 1 month
     public static void showMonthCalender(int n, String startDay){
        int b=0;
        
        //print the days at the top of eachg monthly calender
        System.out.printf("%8s%8s%8s%8s%8s%8s%8s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        
        // determine the spacing at the beginning of week based on day of the week
        switch (startDay) {
            case "Sunday":
                b=0;
                break;
            case "Monday":
                System.out.printf("%8s", " ");
                b=1;
                break;
            case "Tuesday":
                System.out.printf("%16s", " ");
                b=2;
                break;
            case "Wednesday":
                System.out.printf("%24s", " ");
                b=3;
                break;
            case "Thursday":
                System.out.printf("%32s", " ");
                b=4;
                break;
            case "Friday":
                System.out.printf("%40s", " ");
                b=5;
                break;
            case "Saturday":
                System.out.printf("%48s", " ");
                b=6;
                break;
            default:
                break;
        }
        
        //go to new line after each line of the month calender                 
        for (int i = 1; i<= n; i++){
            System.out.printf("%8s", i);
            if ( (i+b)  % 7 == 0)
                System.out.println();
        }
        //skip a line after the month calender
        System.out.println();
    }
     
     //method: leapYear() to determine whether a year is a leap year or not
    public static boolean leapYear(int year){
        
        return (year % 4 == 0 && year % 100 ==0 && year % 400 ==0) || (year % 4 == 0 && year %100 != 0);
        
    }
     
    //method: weekDayNameConvert() to convert weekday to number to day name
    public static String dayNumberToWeekdayName (int a){
        
        // determine name of the day based on its number
        String day = "";
        switch (a) {
            case 0:
                day = "Monday";
                break;
            case 1:
                day = "Tuesday";
                break;
            case 2:
                day = "Wednesday";
                break;
            case 3:
                day = "Thursday";
                break;
            case 4:
                day= "Friday";
                break;
            case 5:
                day= "Saturday";
                break;
            case 6:
                day= "Sunday";
                break;
            default:
                break;
        }
        
        return day;
    } 
    
    //method: nameOfMonth() to convert number of month to name of month
    public static String nameOfMonth (int a){
        
        //find name of day based on its number
        String monthName = "";
        switch (a) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                break;
        }
        return monthName;
    }
    
    //method: weekDayNameConvert() to determine how many days each month has
    public static int daysMonth (int i, int year){
        int num;
        
        //if month is 1,3,5,7,8,10, or 12 there are 31 days in the month
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
            num = 31;
        //if month has 4,6,9, or 11 days it has 30 days
        else if (i == 4 || i == 6 || i == 9 || i == 11)
            num = 30;
        //if month is 2 and its a leap year it has 29 days
        else if (i == 2 && leapYear(year))
            num = 29;
        //if month is 2 it has 28 days
        else
            num = 28;
        
        return num;
                    
    }
        //method: nameOfMonthToNumber() to determine how many days each month has
        public static int nameOfMonthToNumber (String monthinput){
        //find name of day based on its number
        int monthNumber;
                
         if ("january".equals(monthinput) || "January".equals(monthinput))
             monthNumber = 1;
         else if ("february".equals(monthinput) || "February".equals(monthinput)){
             monthNumber = 2;}
         else if ("march".equals(monthinput) || "March".equals(monthinput)){
             monthNumber = 3;}
         else if ("april".equals(monthinput) || "April".equals(monthinput)){
             monthNumber = 4;}
         else if ("may".equals(monthinput) || "May".equals(monthinput)){
             monthNumber = 5;}
         else if ("june".equals(monthinput) || "June".equals(monthinput)){
             monthNumber = 6;}
         else if ("july".equals(monthinput) || "July".equals(monthinput)){
             monthNumber = 7;}
         else if ("august".equals(monthinput) || "August".equals(monthinput)){
             monthNumber = 8;}
         else if ("september".equals(monthinput) || "September".equals(monthinput)){
             monthNumber = 9;}
         else if ("october".equals(monthinput) || "October".equals(monthinput)){
             monthNumber = 10;}
         else if ("november".equals(monthinput) || "November".equals(monthinput)){
             monthNumber = 11;}
         else {
             monthNumber = 12;
             }
  
        return monthNumber;   
    }
}
    

   