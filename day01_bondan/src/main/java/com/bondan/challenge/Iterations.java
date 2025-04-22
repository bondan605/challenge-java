package com.bondan.challenge;

public class Iterations {
    public void pattern1(int n) throws InterruptedException {
        System.out.println("No.1");
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Thread.sleep(500);
                System.out.printf("%3d", number);
                number++;
            }
            System.out.println();
        }
    }

    public void pattern2(int n) throws InterruptedException {
        System.out.println("No.2");
        for (int i = 1; i <= n; i++) {
            int value = i;
            for (int j = 1; j <= i; j++) {
                Thread.sleep(500);
                System.out.printf("%2d ", value);
                value++;
            }
            System.out.println();
        }
    }

    public void pattern3(int n) throws InterruptedException {
        System.out.println("No.3");
        for (int i = 1; i <= n; i++) {
            int value = i;
            for (int j = 0; j <= n-i; j++) {
                Thread.sleep(500);
                System.out.printf("%2d ", value);
                value++;
            }
            System.out.println();
        }
    }

    public void pattern4(int n) throws InterruptedException {
        System.out.println("No.4");
        for (int i = 1; i <= n; i++) {
            // Cetak spasi di depan
            for (int s = 1; s < i; s++) {
                System.out.print("   "); // 3 spasi biar rata
            }

            // Cetak angka dari i sampai n
            for (int j = i; j <= n; j++) {
                Thread.sleep(500);
                System.out.printf("%2d ", j);
            }

            System.out.println();
        }
    }

    public void pattern5(int n) throws InterruptedException {
        System.out.println("No.5");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Thread.sleep(500);
                if (j < i) {
                    System.out.printf("%3d", 20); // kiri diagonal
                } else if (j == i) {
                    System.out.printf("%3d", i + 1); // diagonal
                } else {
                    System.out.printf("%3d", 10); // kanan diagonal
                }
            }
            System.out.println();
        }
    }

    public void pattern6(int n) throws InterruptedException {
        System.out.println("No.6");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Thread.sleep(500);
                if (j < i) {
                    System.out.printf("%3d", 10); // kiri diagonal
                } else if (j == i) {
                    System.out.printf("%3d", n - i); // diagonal utama dibalik
                } else {
                    System.out.printf("%3d", 20); // kanan diagonal
                }
            }
            System.out.println();
        }
    }

    public void pattern7(int n) throws InterruptedException {
        System.out.println("No.7");
        for (int i = n; i >= 1; i--) {
            // Bagian menurun
            for (int j = i; j >= 1; j--) {
                Thread.sleep(500);
                System.out.print(j + " ");
            }

            // Bagian menaik, mulai dari 2 agar tidak cetak angka 1 dua kali
            for (int j = 2; j <= i; j++) {
                Thread.sleep(500);
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }

    public void primeNumber(int count) {
        System.out.println("No.8");
        int number = 2; // Mulai dari bilangan prima pertama
        int found = 0;

        while (found < count) {
            if (isPrime(number)) {
                System.out.print(number + " ");
                found++;
            }
            number++;
        }
    }

    // Fungsi untuk mengecek bilangan prima
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void pattern9(int n) {
        System.out.println("No.9");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Baris ganjil (index genap): cetak 5 ke 1
                for (int j = n; j >= 1; j--) {
                    System.out.print(j + " ");
                }
            } else {
                // Baris genap (index ganjil): cetak 1 ke 5
                for (int j = 1; j <= n; j++) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public void pattern10(int n) {
        System.out.println("No.10");
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    System.out.print(j + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }


}
