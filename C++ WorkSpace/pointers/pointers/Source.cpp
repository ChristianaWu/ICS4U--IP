#include <iostream>
int main() {
	int i = 9,yx;
	int* x;

	x = &i;

	yx = *x;
	std::cout <<"The pointer is:"<< yx << std::endl;

	int arr[] = { 1,2,3,4 };
	int* z;
	z = &arr[0];
	int holder = *z;
	std::cout << "The pointer is:" << holder << std::endl;

	//test(arr);
}

void test(int arr[]) {
	int* x = &arr[1];
	std::cout << x << std::endl;
}