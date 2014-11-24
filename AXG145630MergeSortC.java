public class AXG145630MergeSortC {
	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(args[0]);
		int[] arr = new int[n];
		int[] aux = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = n - i;
			aux[i] = n - i;
		}

		long start_time = System.currentTimeMillis();
		mergeSort(arr, aux, 0, arr.length - 1);
		long end_time = System.currentTimeMillis();
		// System.out.println(end_time - start_time);
		boolean success = checkValidity(arr);

		if (success)
			System.out.println("Success");
		else
			System.out.println("Failure");

	}

	private static boolean checkValidity(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}

		}
		return true;

	}

	private static void mergeSort(int[] arr, int[] aux, int low, int high)
			throws Exception {
		if (high - low < 11) {
			for (int i = low, j = i; i < high; j = ++i) {
				int val = arr[i + 1];
				while (val < arr[j]) {
					arr[j + 1] = arr[j];
					if (j-- == low) {
						break;
					}
				}
				arr[j + 1] = val;
			}
			return;
		}

		int middle = (high + low) / 2;
		mergeSort(aux, arr, low, middle);
		mergeSort(aux, arr, middle + 1, high);

		if (arr[middle + 1] > arr[middle])
			return;
		merge(aux, arr, low, middle, high);

		return;
	}

	private static void merge(int[] arr, int[] aux, int low, int middle,
			int high) {

		int i = low;
		int j = middle + 1;

		for (int k = low; k <= high; k++) {
			if ((j > high) || ((i < low) && (aux[i] <= aux[j])))
				aux[k] = arr[i++];
			else
				aux[k] = arr[j++];
		}
	}

}
