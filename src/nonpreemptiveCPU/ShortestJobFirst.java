package nonpreemptiveCPU;

import java.util.Scanner;

public class ShortestJobFirst {
    public void print() {
        System.out.println("You Have Chosen Shortest Job First");
    }

    public void compute() {
        int n, st = 0, tot = 0, pid[], at[], bt[], ct[], ta[], wt[], f[];

        pid = new int[10];
        at = new int[10]; // at means arrival time
        bt = new int[10]; // bt means burst time
        ct = new int[10]; // ct means complete time
        ta = new int[10]; // ta means turn around time
        wt = new int[10]; // wt means waiting time
        f = new int[10]; // f means it is flag it checks process is completed or not
        float avgwt = 0, avgta = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of process [maximum is 10]:");
        n = s.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " Arrival Time:");
            at[i] = s.nextInt();
            System.out.println("Enter process " + (i + 1) + " Burst Time:");
            bt[i] = s.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }
        while (true) {
            int c = n, min = 999;
            if (tot == n) // total no of process = completed process loop will be terminated
                break;
            for (int i = 0; i < n; i++) {
                /*
                 * If i'th process arrival time <= system time and its flag=0 and burst<min
                 * That process will be executed first
                 */
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }
            /*
             * If c==n means c value can not updated because no process arrival time< system
             * time so we increase the system time
             */
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }
        System.out.println("\nPID\t  Arrival Burst\t  Complete Turn Waiting\t");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\nAverage Turn Around Time is " + (float) (avgta / n));
        System.out.println("Average Waiting Time is " + (float) (avgwt / n));
    }
}