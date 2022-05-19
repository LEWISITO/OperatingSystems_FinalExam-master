package functionsDisk;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestSeekTimeFirst {
    public void print() {
        System.out.println("You Have Chosen Shortest Seek Time First");
    }

    class node {
        int distance = 0;
        boolean accessed = false;
    }

    public void calculateDifference(int queue[], int head, node diff[]) {
        for (int i = 0; i < diff.length; i++)
            diff[i].distance = Math.abs(queue[i] - head);
    }

    public int findMin(node diff[])
    {
        int index = -1, minimum = Integer.MAX_VALUE;
 
        for (int i = 0; i < diff.length; i++) {
            if (!diff[i].accessed && minimum > diff[i].distance) {
                 
                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }

    public void compute() throws IOException {
        int size;
        int request[] = new int[10];
        int head;

        String[] strNums;

        BufferedReader bi = new BufferedReader(
            new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of tracks [maximum is 10] = ");
            size = s.nextInt();

        System.out.println("Enter the request sequence [separated by space] = ");

        strNums = bi.readLine().split(" ");

        for (int j = 0; j < strNums.length; j++) {
            request[j] = Integer.parseInt(strNums[j]);
        }
        
        if (size == 0)
            return;
             
        node diff[] = new node[size];
         
        for (int i = 0; i < diff.length; i++)
         
            diff[i] = new node();
           
        int seek_count = 0;
         
        int[] seek_sequence = new int[size + 1];
         
        System.out.println("Enter the head = ");
        head = s.nextInt();

        for (int i = 0; i < size; i++) {
             
            seek_sequence[i] = head;
            calculateDifference(request, head, diff);
             
            int index = findMin(diff);
             
            diff[index].accessed = true;
             
            seek_count += diff[index].distance;
             
            head = request[index];
        }

        seek_sequence[seek_sequence.length - 1] = head;
         
        System.out.println("The Total of seek operations = "
                                                     + seek_count);
                                                      
        System.out.println("The seek Sequence is");
         
        for (int i = 0; i < seek_sequence.length; i++)
            System.out.println(seek_sequence[i]);
    
    };
}
