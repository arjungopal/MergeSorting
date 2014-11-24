public class AXG145630MergeSortB {
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int[] arr = new int[n];
		int[] aux = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = n - i;
		}
		long start_time = System.currentTimeMillis();
		mergeSort(arr, aux, 0, arr.length - 1);
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

	private static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi)
			return;
		if (hi - lo > 11) {
			int mid = (lo + hi) / 2;
			mergeSort(arr, aux, lo, mid);
			mergeSort(arr, aux, mid + 1, hi);
			mergeArrays(arr, aux, lo, mid, hi);
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

	private static void mergeArrays(int[] arr, int[] aux, int lo, int mid,
			int hi) {

		int i = lo;
		int j = mid + 1;

		for (int m = lo; m <= hi; m++)
			aux[m] = arr[m];
		if (aux[mid+1] > aux[mid])
			return;

		
		for (int k = lo; k <= hi; k++) {
			if ((j > hi) || ((i < lo) && (aux[i] <= aux[j])))
				arr[k] = aux[i++];
			else
				arr[k] = aux[j++];
		}

	}

}
