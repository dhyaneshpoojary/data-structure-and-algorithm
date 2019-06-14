package com.example.string;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
 *
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Example 1:
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * Example 2:
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class NextClosestTime {

    public String find(String time) {
        int[] digits = getIndividualDigits(time);

        int[] hours = new int[25];
        int[] minutes = new int[60];

        createValidCombination(hours, minutes, digits);

        String[] splittedTime = time.split(":");
        int oldHour = Integer.parseInt(splittedTime[0]);
        int oldMinute = Integer.parseInt(splittedTime[1]);

        int nextMinute = findNextClosestMinute(minutes, oldMinute);

        int nextHour = findNextClosestHour(hours, nextMinute, oldMinute, oldHour);

        return resultFormatting(nextHour, nextMinute);
    }

    public int findNextClosestMinute(int[] minutes, int oldMinute){
        int nextMinute = 0;
        for(int i=oldMinute+1; i<=oldMinute+60; i++){
            if(minutes[i%60]==1){
                nextMinute = i%60;
                break;
            }
        }
        return nextMinute;
    }

    public int findNextClosestHour(int[] hours, int nextMinute, int oldMinute, int oldHour){
        int nextHour = oldHour;
        if(nextMinute<=oldMinute){
            for(int i=oldHour+1; i<=oldHour+25; i++){
                if(hours[i%25]==1){
                    nextHour = i%25;
                    break;
                }
            }
        }
        return nextHour;
    }

    public int[] getIndividualDigits(String time){
        String normalizedTime = time.replace(":","");
        int[] digits = new int[4];
        for(int i=0 ; i<=3; i++){
            digits[i]=Character.getNumericValue(normalizedTime.charAt(i));
        }
        return digits;
    }

    public void createValidCombination(int[] hours, int[] minutes, int[] digits){
        for(int i=0;i<=3;i++){
            for(int j=0; j<=3; j++){
                int num = digits[i]*10+digits[j];
                if(num<25){
                    hours[num]=1;
                }

                if(num<60){
                    minutes[num]=1;
                }
            }
        }
    }

    public String resultFormatting(int nextHour, int nextMin){
        StringBuilder result = new StringBuilder();
        if(nextHour<10){
            result.append("0"+String.valueOf(nextHour));
        }else{
            result.append(String.valueOf(nextHour));
        }

        result.append(":");
        if(nextMin<10){
            result.append("0"+String.valueOf(nextMin));
        }else{
            result.append(String.valueOf(nextMin));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        NextClosestTime nextClosestTime = new NextClosestTime();
        System.out.println(nextClosestTime.find("11:57"));
    }
}
