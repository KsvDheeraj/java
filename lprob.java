class lprob {
    static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void hashing(int table[], int tsize, int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int hv = arr[i] % tsize;
            if (table[hv] == -1) {
                table[hv] = arr[i];
            } else {
                for (int j = 0; j < tsize; j++) {
                    int t = (hv + j) % tsize;
                    if (table[t] == -1) {
                        table[t] = arr[i];
                        break;
                    }
                }
            }

        }
        display(table);
    }

    public static void main(String[] args) {
        int arr[] = { 50, 700, 58, 47, 26 };
        int n = 5;
        int l = 5;
        int hash_table[] = new int[l];
        for (int i = 0; i < l; i++) {
            hash_table[i] = -1;
        }
        hashing(hash_table, l, arr, n);
    }
}