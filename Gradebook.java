public class Gradebook {
    // Pre condition: nbrStrudents and nbrExams is greater than 0
    public static void main(String[] args) {
        
        // 2 D array
        // here 2D array holds exam scores
        /*
         * Each row is one student
         * Each column is one exam
         */

         int nbrStudents = Integer.parseInt(args[0]);
         int nbrExams= Integer.parseInt(args[1]);
         int MAX_SCORE = 150;
         //declare adn create a 2D array
         // first [] is rows, second [] is columns

         double[][] scores = new double [nbrStudents][nbrExams];

         // traversing a 2D array to populate with random values
        // Scores.length contanin the number of rows => nbrStudents
        // score[2].length contain the number of columns in row[2] => nbrExams
         for ( int row = 0; row < scores.length; row++){
            for ( int col = 0; col < scores[row].length; col++){
                scores[row][col] = Math.random() * MAX_SCORE;
            }
         }
         // Find the average for each exam

         double[] examAverages = new double[nbrExams];

         // Each column is one exam
         for ( int col = 0; col < nbrExams;col++){
            double sum = 0.0;
            for ( int row =0;row< nbrStudents;row++){
                sum += scores[row][col];
            }
            examAverages[col] = sum/nbrStudents;
         }

         // display the averages
         for ( int i = 0; i < examAverages.length;i++){
            System.out.println("Exam[" + i + "]: " + examAverages[i]);
         }


    }
}
