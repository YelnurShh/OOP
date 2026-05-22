package pr5.io.app;

import java.io.*;
import java.util.Random;

public class SensorApp {
    private static final String FILE = "sensor.bin";
    private static final int N = 60;

    public static void main(String[] args) throws IOException {
        Random rnd = new Random();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE))) {
            for (int i = 0; i < N; i++) dos.writeDouble(15.0 + rnd.nextDouble() * 20.0);
        }

        try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")) {
            raf.seek(29 * 8L);
            raf.writeDouble(999.9);
        }

        double sum = 0, max = Double.MIN_VALUE;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE))) {
            for (int i = 0; i < N; i++) {
                double v = dis.readDouble();
                sum += v;
                if (v > max) max = v;
            }
        }

        System.out.printf("Avg: %.2f%n", sum / N);
        System.out.printf("Max: %.2f%n", max);
    }
}
