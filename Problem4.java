class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String n, double r, double v) {
        name = n;
        returnRate = r;
        volatility = v;
    }
}

public class Problem4 {

    static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
               (arr[j].returnRate == pivot.returnRate &&
                arr[j].volatility < pivot.volatility)) {

                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}