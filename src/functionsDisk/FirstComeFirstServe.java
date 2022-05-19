package functionsDisk;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstComeFirstServe {
    public void print() {
        System.out.println("You Have Chosen First Come First Serve");
    }

    public void compute() throws IOException{
        int i, head, seek_count = 0, distance,
        cur_track, size;
        int arr[] = new int[10];
        String[] strNums;

        BufferedReader bi = new BufferedReader(
            new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of tracks [maximum is 10] = ");
            size = s.nextInt();

        System.out.println("Enter the request sequence [separated by space] = ");

        strNums = bi.readLine().split(" ");

        for (int j = 0; j < strNums.length; j++) {
            arr[j] = Integer.parseInt(strNums[j]);
        }

        System.out.println("Enter the head = ");
        head = s.nextInt();

        for (i = 0; i < size; i++)
        {
            cur_track = arr[i];
            distance = Math.abs(cur_track - head);
            seek_count += distance;
            head = cur_track;
        }

        System.out.println("The total of seek operations = " +
                             seek_count);

        System.out.println("The Seek Sequence is");

        for (i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    };
}

