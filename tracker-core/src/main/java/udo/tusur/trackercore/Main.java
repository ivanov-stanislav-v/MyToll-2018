package udo.tusur.trackercore;

import udo.tusur.common.PointDTO;

public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            PointDTO point = new PointDTO(12, 23, "234341", System.nanoTime());
            System.out.println(point.toJson());
            Thread.sleep(1000);
        }
    }
}
