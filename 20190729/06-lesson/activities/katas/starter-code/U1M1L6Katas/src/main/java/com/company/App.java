package com.company;

import java.util.Arrays;

public class App {

    //Total: Create a method called total which returns the sum of all the values in an array of ints. Your code should work for an array of any size.
    public static int total(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    //Total Odd: Create a method called totalOdd which returns the sum of only the values of the odd numbered indexes in an array of ints. Your code should work for an array of any size.
    public static int totalOdd(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 != 0) {
                sum += values[i];
            }
        }
        return sum;
    }

    //Total Even: Create a method called totalEven the sum of only the values of the even numbered indexes in an array of ints. Your code should work for an array of any size.
    public static int totalEven(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                sum += values[i];
            }
        }
        return sum;
    }

    //2nd Largest Number: Create a method called secondLargestNumber which returns the second largest number in an array of ints. Your code should work for an array of any size. Assume your input array will always have a length of at least 2.
    public static int secondLargestNumber(int[] values) {
        int largestNum = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > largestNum) {
                secondLargest = largestNum;
                largestNum = values[i];
            } else if ((largestNum > values[i]) && (values[i] >= secondLargest)) {
                secondLargest = values[i];
            }
        }
        return secondLargest;
    }
    //Version with Arrays.sort
//    public static int secondLargestNumber(int[] values) {
//      Arrays.sort(values);
//
//      return values[values.length - 2];
//   }

    //Swap First and Last: Create a method called swapFirstAndLast which takes in an array of strings, swaps the first and last elements, and returns the array. Your code should work for an array of any size.
    public static String[] swapFirstAndLast(String[] wordsList) {
        String first;
        first = wordsList[0];
        wordsList[0] = wordsList[wordsList.length - 1];
        wordsList[wordsList.length - 1] = first;
        return wordsList;
    }

    //Reverse: Create a method called reverse which takes in an array of ints and returns a new array with the array reversed. Your code should work for an array of any size.
    public static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length - 1 - i];
        }
        return newArray;
    }

    //Concatenate String: Create a method called concatenateString which takes in an array of strings and returns a String which consists of the concatenation of all elements in the array. Your code should work for an array of any size.
    public static String concatenateString(String[] array) {
        //String newString = Arrays.toString(arrays);
        String delimiter = "";
        String concatenatedString = String.join(delimiter, array);
        return concatenatedString;
    }

    //Every 3rd: Create a method called everyThird which takes in an array of ints and returns an array which consists of every third element. Your code should work for an array of any size. If there are fewer than three elements in the array, return null.
    public static int[] everyThird(int[] array) {
        if (array.length < 3) {
            return null;
        }

        int newArrayLength = array.length / 3;
        int[] newArray = new int[newArrayLength];

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 3 == 0) {
                newArray[counter] = array[i];
                counter++;
            }
        }
        return newArray;
    }

    //Less Than 5: Create a method called lessThanFive which takes in an array of ints, finds the elements which are less than five, and returns an array containing those elements. Your code should work for an array of any size. If there are no elements less than five, return null.
    public static int[] lessThanFive(int[] array) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 5) {
                counter++;
            }
        }

        if (counter == 0) {
            return null;
        }

        int[] newArray = new int[counter];
        counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 5) {
                newArray[counter] = array[i];
                counter++;
            }
        }

        return newArray;
    }

    //Split at 5: Create a method called splitAtFive which takes in an array of ints. This method should split the array into two new arrays, one holding the values less than 5 and the other holding the values equal to or greater than 5. Return a two-dimensional array, with the small-value array first. Your code should work for an array of any size.
    //int[][] test = new int[#_of_rows][#_of_columns]
    //test.length = #_of_rows

    public static int[][] splitAtFive(int[] numbers) {
            int numLessThanFive = 0;
            int numMoreThanFive = 0;

            for(int num : numbers) {
                if ( num < 5 ) {
                    numLessThanFive++;
                } else {
                    numMoreThanFive++;
                }
            }

            int[] lessThan = new int[numLessThanFive];
            int[] moreThan = new int[numMoreThanFive];


            for(int num : numbers) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                // same with numMoreThanFive
                if ( num < 5 ) {
                    lessThan[lessThan.length - numLessThanFive] = num;
                    numLessThanFive--;
                } else {
                    moreThan[moreThan.length - numMoreThanFive] = num;
                    numMoreThanFive--;
                }
            }

            return new int[][] { lessThan, moreThan };
        }

//    public static int[][] splitAtFive(int[] array) {
//
//        int counter = 0;
//        int[] smallArray;
//        int[] largeArray;
//
//        for(int i = 0; i < array.length; i++) {
//            if(array[i] < 5) {
//                counter++;
//            }
//        }
//        smallArray = new int[counter];
////        int[] firstArray = Arrays.copyOf(smallArray, counter);
//        counter = 0;
//
//        for(int i = 0; i < array.length; i ++) {
//            if(array[i] >= 5) {
//                counter++;
//            }
//        }
//        largeArray = new int[counter];
////        int[] secondArray = Arrays.copyOf(largeArray, counter);
//
//        int[][] newArray = new int[smallArray.length][largeArray.length];
//        System.out.println(Arrays.toString(newArray));
//        return newArray;
//    }

    //Evens and Odds: Create a method called evensAndOdds which takes in an array of Strings. Create two new arrays, one holding the values of the even indices and the other the values of the odd. Return a two-dimensional array, with the even-indices array first. Your code should work for an array of any size.
    public static String[][] evensAndOdds(String[] strings) {

        String[] odds = new String[ strings.length/2 ];

        String[] evens = null;

        if (strings.length % 2 == 0) {
            evens = new String[ strings.length/2];
        } else {
            evens = new String[ strings.length/2 + 1];
        }

        for(int i = 0; i < strings.length; i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings[i];
            } else {
                odds[currIndex] = strings[i];
            }
        }
        return new String[][] { evens, odds };
    }



    public static void main(String[] args) {

        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] wordsTestArray = {"bird", "cat", "dog", "fish"};

        System.out.println(total(testArray));
        System.out.println(totalOdd(testArray));
        System.out.println(totalEven(testArray));
        System.out.println(secondLargestNumber(testArray));
        System.out.println(swapFirstAndLast(wordsTestArray));
        System.out.println(reverse(testArray));
        System.out.println(concatenateString(wordsTestArray));
        System.out.println(everyThird(testArray));
        System.out.println(lessThanFive(testArray));
        System.out.println(splitAtFive(testArray));
        System.out.println(evensAndOdds(wordsTestArray));
    }
}




