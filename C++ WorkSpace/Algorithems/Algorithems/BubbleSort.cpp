#include <iostream>
using namespace std;
void swap(int* a, int* b) {
	int holder;
	holder = *a;
	*a = *b;
	*b = holder;
}

void bubbleSort(int arr[], int n) {
	for (int i = 0; i < n - 1; i++) {
		if (arr[i] > arr[i + 1]) {
			swap(&arr[i], &arr[i + 1]);
		}
	}
}

void printArray(int arr[], int n) {
	printf("The sorted array is: ");
	for (int i = 0; i < n - 1; i++) {
		cout<<arr[i]<<"\n"<< endl;
	}
}

int main() {
	int arr[] = { 2,7,4,9,2,0 };
	int n = sizeof(arr) / sizeof(arr[0]);
	bubbleSort(arr, n);
	printArray(arr, n);
}

