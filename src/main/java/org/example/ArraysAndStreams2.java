package org.example;

// Fig. 17.12: ArraysAndStreams2.java
// Demonstrating lambdas and streams with an array of Strings.
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)             
               .map(String::toUpperCase)   
               .collect(Collectors.toList()));

      // strings less than "n" (case insensitive) sorted ascending
      System.out.printf("strings less than n sorted ascending: %s%n",
         Arrays.stream(strings)                            
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));             

      // strings less than "n" (case insensitive) sorted descending
      System.out.printf("strings less than n sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));

      /**
       * Task 1
       *
       * This section casts the first character of each String in the stream as a String,
       * then matches it against a regex pattern composed of the vowels a, e, i, o, u, and y.
       * Then it prints a List of Strings that start with a vowel
       *
       * @author Jared Mitchell
       *
       * @param String[] strings
       */
      System.out.printf("strings that start with a vowel: %s%n",
              Arrays.stream(strings)
                      .filter(s -> (Character.toString(s.charAt(0))).matches("[aeiouyAEIOUY]"))
                      .collect(Collectors.toList()));

      /**
       * Task 2
       *
       * This section uses a collector to join the Strings in the Stream into a single String,
       * with each original String separated by commas,
       * and prints it.
       *
       * @author Jared Mitchell
       *
       * @param String[] strings
       */
      System.out.printf("all strings concatenated into a single string: %s\n",
              Arrays.stream(strings)
                      .collect(Collectors.joining(",")));

      /**
       * Task 3
       *
       * This section checks the length of each string in the Stream,
       * filters out any String with less than 6 characters,
       * then prints a List of the qualifying Strings.
       *
       * @author Jared Mitchell
       *
       * @param String[] strings
       */
      System.out.printf("strings that contain more than 5 characters: %s%n",
              Arrays.stream(strings)
                      .filter(s -> s.length() > 5)
                      .collect(Collectors.toList()));
   }
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
