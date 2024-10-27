
public class RandomInt {
    public static void main(String[] args) {
        int answer = (int)(Math.random()*100)+1;
        int guess = 0;
        StdOut.println("Guess a Number between 1 to 100!");
        while (guess != answer){
            guess = StdIn.readInt();
            if (answer > guess){
                StdOut.println("Enter a bigger number");
            }else if (answer < guess){
                StdOut.println("Enter a smaller number");
            }
        }
        StdOut.println();
        StdOut.println();
        StdOut.print("Congratulations!!\nyou guessed the correct number");
        StdOut.println();StdOut.println();

    }
}
