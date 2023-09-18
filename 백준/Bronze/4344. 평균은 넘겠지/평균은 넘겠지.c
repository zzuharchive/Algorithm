#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning(disable:4996)

int main() {
	int tc_num, st_count, count=0;
	scanf("%d", &tc_num);//TC 개수 입력받음
	float tc[1000], avg[1000] = { 0 };
	int grade[1000];
	int sum[1000] = { 0 };

	for (int i = 0; i < tc_num; i++) {
		count = 0;
		scanf("%d", &st_count);//학생 수
		for (int j = 0; j < st_count; j++) {
			scanf("%d", &grade[j]);
			if (grade[j] > 100 || grade[j] < 0) return;
			sum[i] += grade[j];
		}
		avg[i] = sum[i] / st_count;
		for (int k = 0; k < st_count; k++) {
			if (avg[i] < grade[k]) count++;

		}
		tc[i] = (float)count/st_count *100;
		

	}

	for (int i = 0; i < tc_num; i++) {
		printf("%.3f%%\n", tc[i]);

	}

}