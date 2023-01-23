package com.demo.funda;

public class SwitchCaseEx {
    public static void main(String[] args) {
        intSwitch();
    }
    private static void intSwitch() {
        //IP Months of the year (1-12)
        int day = 40;

        switch (day) {
            default : {
                System.err.println("Not a valid day");
            }
            case 1: {
                System.err.println("Sun");
            }
            case 2: {
                System.err.println("Mon");
            }
            case 3: {
                System.err.println("Tue");
                break;
            }

            case 4: {
                System.err.println("Wed");
            }
            case 5: {
                System.err.println("Thu");
            }
            case 6: {
                System.err.println("Fri");
                break;
            }
            case 7: {
                System.err.println("Sat");
                break;
            }
        }
    }
}
