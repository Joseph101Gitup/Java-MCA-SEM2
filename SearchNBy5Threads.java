class SearchThread extends Thread {
    int[] arr;
    int start, end, key;

    SearchThread(int[] arr, int start, int end, int key) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (arr[i] == key) {
                System.out.println("Element " + key +
                        " found at index " + i +
                        " by " + Thread.currentThread().getName());
            }
        }
    }
}

public class SearchNBy5Threads {
    public static void main(String[] args) {

        int[] arr = {10, 25, 30, 45, 50, 60, 70, 80, 90, 100, 50, 25, 50};
        int key = 50;

        int n = arr.length;
        int chunkSize = 5;
        int numThreads = (n + chunkSize - 1) / chunkSize; // ensures last chunk is included

        System.out.println("Number of threads: " + numThreads);

        int start = 0;

        for (int i = 0; i < numThreads; i++) {
            int end = Math.min(start + chunkSize, n); // avoid exceeding array length

            SearchThread t = new SearchThread(arr, start, end, key);
            t.setName("Thread-" + (i + 1));
            t.start();

            start = end;
        }
    }
}
