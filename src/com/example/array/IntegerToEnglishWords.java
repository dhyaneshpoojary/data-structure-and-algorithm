package com.example.array;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 */
public class IntegerToEnglishWords {

    public static String one(int num){
        switch(num){
            case 1 : return "One";
            case 2 : return "Two";
            case 3 : return "Three";
            case 4 : return "Four";
            case 5 : return "Five";
            case 6 : return "Six";
            case 7 : return "Seven";
            case 8 : return "Eight";
            case 9 : return "Nine";
        }
        return  "";
    }

    public  static String twoLessThanTwenty(int num){
        switch(num){
            case 10 : return "Ten";
            case 11 : return "Eleven";
            case 12 : return "Twelve";
            case 13 : return "Thirteen";
            case 14 : return "Fourteen";
            case 15 : return "Fifteen";
            case 16 : return "Sixteen";
            case 17 : return "Seventeen";
            case 18 : return "Eighteen";
            case 19 : return "Nineteen";
        }
        return  "";
    }

    public static String ten(int num){
        switch(num){
            case 2 : return "Twenty";
            case 3 : return "Thirty";
            case 4 : return "Forty";
            case 5 : return "Fifty";
            case 6 : return "Sixty";
            case 7 : return "Seventy";
            case 8 : return "Eighty";
            case 9 : return "Ninety";
        }
        return "";
    }

    public static String two(int num){
        if(num == 0){
            return "";
        }else if(num < 10){
            return one(num);
        }else if(num <20){
            return twoLessThanTwenty(num);
        }else{
            int tens = num/10;
            int rest = num - tens * 10;
            if(rest != 0){
                return ten(tens) + " " + one(rest);
            }else{
                return ten(tens);
            }
        }
    }

    public static String three(int num){
        int hundred = num/100;
        int rest = num - hundred * 100;
        if (hundred != 0 && rest != 0) {
            return one(hundred) + " Hundred " + two(rest);
        } else if(hundred == 0 && rest !=0){
            return two(rest);
        }else{
            return one(hundred) + " Hundred";
        }
    }

    public static String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - (billion * 1000000000) - (million * 1000000)) / 1000;
        int rest = num - (billion * 1000000000) - (million * 1000000) - (thousand * 1000);
        String result = "";
        if(billion != 0){
            result += three(billion) + " Billion";
        }

        if(million != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(million) + " Million";
        }

        if(thousand != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(thousand) + " Thousand";
        }

        if( rest != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(rest);
        }


        return result;
    }


    public static void main(String[] args) {
        System.out.println(numberToWords(20));
    }
}
