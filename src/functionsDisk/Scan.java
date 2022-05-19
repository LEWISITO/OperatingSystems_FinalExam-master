package functionsDisk;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scan {
    public void print() {
        System.out.println("You Have Chosen Scan");
    }

    public void compute() throws IOException {
        int size, disk_size = 200, seek_count = 0, head, distance, cur_track;
        int arr[] = new int[10];
        String direction;
        String[] strNums;
        Vector<Integer> left = new Vector<Integer>(),
                    right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();

        BufferedReader bi = new BufferedReader(
            new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of tracks [maximum is 10] = ");
            size = s.nextInt();

        System.out.println("Enter the request sequence [separated by space] = ");

        strNums = bi.readLine().split(" ");
    
        for (int i = 0; i < strNums.length; i++) {
            arr[i] = Integer.parseInt(strNums[i]);
        }

        System.out.println("Enter the head = ");
            head = s.nextInt();

        System.out.println("Enter the direction [left/right] = ");
            direction = s.next();


        if (direction.equals("left"))
        left.add(0);
        else if (direction.equals("right"))
        right.add(disk_size - 1);

        for (int i = 0; i < size; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            if (arr[i] > head)
                right.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int run = 2;
        while (run-- > 0)
        {
            if (direction.equals("left"))
            {
                for (int i = left.size() - 1; i >= 0; i--)
                {
                    cur_track = left.get(i);
    
                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);
    
                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);
    
                    // increase the total count
                    seek_count += distance;
    
                    // accessed track is now the new head
                    head = cur_track;
                }
                direction = "right";
            }
            else if (direction.equals("right"))
            {
                for (int i = 0; i < right.size(); i++)
                {
                    cur_track = right.get(i);
                    
                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);
    
                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);
    
                    // increase the total count
                    seek_count += distance;
    
                    // accessed track is now new head
                    head = cur_track;
                }
                direction = "left";
            }
        }
        System.out.print("Total number of seek operations = "
                            + seek_count + "\n");
    
        System.out.print("Seek Sequence is" + "\n");
    
        for (int i = 0; i < seek_sequence.size(); i++)
        {
            System.out.print(seek_sequence.get(i) + "\n");
        }

    }
}
