import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int team = sc.nextInt();

        int[] score = new int[team * 2];

        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score);

        int teamScore[] = new int[team];

        for (int i = 0; i < team; i++) {
            teamScore[i] = score[i];
        }

        int index = 0;

        for (int i = score.length - 1; i >= team; i--) {
            teamScore[index] += score[i];
            index++;
        }

        Arrays.sort(teamScore);
        System.out.println(teamScore[0]);
    }
}
