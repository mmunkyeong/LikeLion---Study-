import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] trains = new boolean[n][20];

        for (int T = 0; T < m; T++) {
            int commandCode = sc.nextInt();
            int selectTrain = sc.nextInt() - 1;
            int selectSeat = 0;

            if (commandCode <= 2) {
                selectSeat = sc.nextInt() - 1;
            }

            switch (commandCode) {
                case 1:
                    trains[selectTrain][selectSeat] = true;
                    break;
                case 2:
                    trains[selectTrain][selectSeat] = false;
                    break;
                case 3:
                    trains = goBack(trains, selectTrain);
                    break;
                case 4:
                    trains = goFront(trains, selectTrain);
                    break;
            }
        }

        HashSet<Train> set = new HashSet<>();
        for(int i=0; i<trains.length; i++) {
            set.add(new Train(trains[i]));
        }

        System.out.println(set.size());

//        for (int i = 0; i < trains.length; i++) {
//            System.out.println(Arrays.toString(trains[i]));
//        }
    }

    private static boolean[][] goFront(boolean[][] trains, int selectTrain) {
        for (int i = 0; i < trains[selectTrain].length; i++) {
            if (i == trains[selectTrain].length - 1) {
                trains[selectTrain][i] = false;
                continue;
            }
            trains[selectTrain][i] = trains[selectTrain][i + 1];
        }

        return trains;
    }

    private static boolean[][] goBack(boolean[][] trains, int selectTrain) {
        for (int i = trains[selectTrain].length - 1; i >= 0; i--) {
            if (i == 0) {
                trains[selectTrain][i] = false;
                continue;
            }
            trains[selectTrain][i] = trains[selectTrain][i - 1];
        }

        return trains;
    }

}

class Train {
    private boolean[] data;

    public Train(boolean[] data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Train other = (Train) obj;
        return Arrays.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}