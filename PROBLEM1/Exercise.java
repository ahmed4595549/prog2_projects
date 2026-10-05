package PROBLEM1;

public class Exercise {
        public int countDigits(int number){
            if (number == 0){
                return 1;
            }
            if (number < 0){
                number = -number;
            }
            int count = 0;
            while (number > 0){
                number = number / 10;
                count++;
            }
            return count;
        }
}
