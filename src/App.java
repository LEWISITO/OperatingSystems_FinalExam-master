import functionsDisk.*;
import nonpreemptiveCPU.*;
import preemptiveCPU.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("\t \t \t \t \t \t Welcome to our CPU and Disk Scheduling Application ");
        System.out.println("\t \t \t \t \t   by : Amog, Catotocan, Tabajonda, Tejada, and Torres ");
        System.out.println("\t \t \t \t \t \t \t    OPERATING SYSTEMS 26012 ");
        Scanner myObj = new Scanner(System.in);
        int firstChoice = 0;
        int secondChoice = 0;
        int thirdChoice = 0;
        do {
            System.out.println("CPU Scheduling (1) or Disk Scheduling? (2) and Exit (3)");
            firstChoice = myObj.nextInt();
            switch (firstChoice) {
                case 1:
                    cpuLabel: do {
                        System.out.println(
                                "Priority (1), Shortest Job First (2), Round Robin (3) or Shortest Remaining Time First (4)"
                                        +
                                        " and Exit (5)");
                        secondChoice = myObj.nextInt();
                        switch (secondChoice) {
                            case 1:
                                Priority priority = new Priority();
                                priority.print();
                                priority.compute();
                                break;
                            case 2:
                                ShortestJobFirst sjf = new ShortestJobFirst();
                                sjf.print();
                                sjf.compute();
                                break;
                            case 3:
                                RoundRobin roundRobin = new RoundRobin();
                                roundRobin.print();
                                roundRobin.compute();
                                break;
                            case 4:
                                ShortestRemainingTimeFirst srtf = new ShortestRemainingTimeFirst();
                                srtf.print();
                                srtf.compute();
                                break;
                            case 5:
                                secondChoice = 5;
                                break;
                            default:
                                System.out.println("\t Please Enter one of the choices");
                        }
                    } while (secondChoice != 5);
                    break;
                case 2:
                    discLabel: do {
                        System.out.println(
                                "CSCAN (1), First Come First Serve (2), SCAN (3) or Shortest Seek Time First (4)"
                                        +
                                        " and Exit (5)");
                        thirdChoice = myObj.nextInt();
                        switch (thirdChoice) {
                            case 1:
                                Cscan cscan = new Cscan();
                                cscan.print();
                                cscan.compute();
                                break;
                            case 2:
                                FirstComeFirstServe fcfs = new FirstComeFirstServe();
                                fcfs.print();
                                fcfs.compute();
                                break;
                            case 3:
                                Scan scan = new Scan();
                                scan.print();
                                scan.compute();
                                break;
                            case 4:
                                ShortestSeekTimeFirst sstf = new ShortestSeekTimeFirst();
                                sstf.print();
                                sstf.compute();
                                break;
                            case 5:
                                secondChoice = 5;
                                break;
                            default:
                                System.out.println("\t Please Enter one of the choices");

                        }
                    } while (thirdChoice != 5);
                    break;
                case 3:
                    firstChoice = 3;
                    break;
                default:
                    System.out.println("\t Please Enter one of the choices");
            }
        } while (firstChoice != 3);
    }
}
