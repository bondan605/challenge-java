package com.bondan.challenge;

public class MathAndString {

// No.1
    public int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;          // Ambil digit terakhir
            reversed = reversed * 10 + digit; // Tambahkan ke hasil balik
            n = n / 10;                  // Buang digit terakhir
        }
        return reversed;
    }

// No.2
    public boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;

        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        return original == reversed;
    }

// No.3
    public String capitalize(String input) {
        String[] words = input.split(" "); // memecah kalimat menjadi kata-kata
        StringBuilder result = new StringBuilder(); // untuk membentuk string baru

        for (String word : words) {
            if (!word.isEmpty()) {
                // Ambil huruf pertama kapital + sisa huruf kecil
                String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(capitalized).append(" ");
            }
        }

        return result.toString().trim(); // Hapus spasi terakhir
    }

// No.4
    public boolean isNoDuplicateChar(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false; // Duplikat ditemukan
                }
            }
        }
        return true; // Tidak ada duplikat
    }

// No.5
    public boolean isBrace(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }

            // Jika tutup kurung lebih dulu dari buka, tidak valid
            if (balance < 0) {
                return false;
            }
        }

        // Harus seimbang di akhir
        return balance == 0;
    }
}
