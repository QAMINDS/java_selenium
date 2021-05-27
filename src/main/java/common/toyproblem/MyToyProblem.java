package common.toyproblem;

public class MyToyProblem {

    public static void main(String[] args) {

        String word = "aaabbbbbc";
        String finalString = "";
        char[] charList = word.toCharArray();
//        “ax3bx5c”

        for (int k=0; k<charList.length; k++) {

            int counter = 1;
            char currentChar = charList[k];
            int nextCharIndex = k + 1;
            int t = 0;
            if (nextCharIndex < charList.length) {
                while(currentChar == charList[k+ counter]) {
                    counter++;
                    t++;
                }
            } else  {
                counter++;

            }
            k = k + counter;
            finalString += currentChar + "x" + counter;
            counter = 1;
        }

        System.out.println(" Output: " + finalString);
    }
}
