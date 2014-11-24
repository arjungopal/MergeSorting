public class AXG145630MergeSortA {
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = n - i;
		}
		long start_time = System.currentTimeMillis();
		mergeSort(arr, 0, arr.length - 1);
		long end_time = System.currentTimeMillis();
		//System.out.println(end_time - start_time);

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				System.out.println("MergeSort Failed");
				return;
			}
		}
		System.out.println("MergeSort Succeeded");

	}

	private static void mergeSort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		if (hi - lo > 11) {
			int mid = (lo + hi) / 2;
			mergeSort(arr, lo, mid);
			mergeSort(arr, mid + 1, hi);
			mergeArrays(arr, lo, mid, hi);
		} else {
			for (int i = lo, j = i; i < hi; j = ++i) {
				int val = arr[i + 1];
				while (val < arr[j]) {
					arr[j + 1] = arr[j];
					if (j-- == lo) {
						break;
					}
				}
				arr[j + 1] = val;
			}
		}

	}

	private static void mergeArrays(int[] arr, int lo, int mid, int hi) {

		int i = 0;
		int j = 0;
		int l_size = mid - lo + 1;
		int r_size = hi - mid;

		int[] L = new int[l_size];
		int[] R = new int[r_size];

		for (int k = lo; k <= mid; k++) {
			L[k - lo] = arr[k];
		}
		for (int k = mid + 1; k <= hi; k++) {
			R[k - (mid + 1)] = arr[k];
		}

		if (L[l_size - 1] < R[0])
			return;

		for (int k = lo; k <= hi; k++) {
			if ((j >= r_size) || ((i < l_size) && (L[i] <= R[j])))
				arr[k] = L[i++];
			else
				arr[k] = R[j++];
		}

	}

}
