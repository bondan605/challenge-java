public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 8, 1, 4};
        displayArray(orderEvenBeforeOdd(numbers));

        String[] stringArr1 = {"true","false","false"};
        String[] stringArr2 = {"donout","king","donout"};
        System.out.println(isPalindrome(stringArr1));
        System.out.println(isPalindrome(stringArr2));

        int[] input1 = {1, 3, 2, 4};
        int[] input2 = {1, 4, 8, 9};
        int[] input3 = {9, 9, 9, 9};
        displayArray(addOnePlus(input1));
        displayArray(addOnePlus(input2));
        displayArray(addOnePlus(input3));
    }

    public static int[] orderEvenBeforeOdd(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean isLeftOdd = arr[j] % 2 != 0;
                boolean isRightEven = arr[j + 1] % 2 == 0;

                if ((isLeftOdd && isRightEven) ||               // tukar: ganjil di kiri, genap di kanan
                        ((arr[j] % 2 == arr[j + 1] % 2) && arr[j] > arr[j + 1])) { // atau sama-sama genap/ganjil tapi belum urut
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public static boolean isPalindrome(String[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!arr[left].equals(arr[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int[] addOnePlus(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0; // carry ke depan
            }
        }

        // Kalau semua digit awalnya 9, maka array baru dibuat dengan 1 di depan
        int[] result = new int[digits.length + 1];
        result[0] = 1; // sisanya default 0
        return result;
    }



    public static void displayArray(int[] arr){
        for (var i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
