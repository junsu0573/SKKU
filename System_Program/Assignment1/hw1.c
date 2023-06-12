#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "hpfp.h"

#define EPSILON 0.0001

int main(int argc, char *argv[])
{
	FILE *fp_input;
	FILE *fp_output;
	FILE *fp_answer;
	int case_num1, case_num2;
	int idx, x, y;
	int i, i_ans;
	float f, f_ans;
	hpfp *hpfp1;
	hpfp *hpfp2;
	char **hpfpbits1;
	char **hpfpbits2;
	char hpfpbits_ans[17];
	char comp_ans[2];

	fp_input = fopen("input.txt", "r");
	fp_output = fopen("output.txt", "w");
	fp_answer = fopen("answer.txt", "r");

	printf("Test 1: casting from int to hpfp\n");
	fscanf(fp_input, "%d", &case_num1);
	hpfp1 = (hpfp*)malloc(sizeof(hpfp)*case_num1);
	hpfpbits1 = (char**)malloc(sizeof(char*)*case_num1);
	for(idx = 0; idx < case_num1; idx++) {
		fscanf(fp_input, "%d", &i);
		fscanf(fp_answer, "%s", hpfpbits_ans);
		hpfp1[idx] = int_converter(i);
		hpfpbits1[idx] = hpfp_to_bits_converter(hpfp1[idx]);
		fprintf(fp_output, "%s\n", hpfpbits1[idx]);
		printf("int(%d) => hpfp(%s), ", i, hpfpbits1[idx]);
		if(!strcmp(hpfpbits1[idx], hpfpbits_ans))
			printf("CORRECT\n");
		else
			printf("WRONG\n");
	}
	fprintf(fp_output, "\n");
	printf("\n");

	printf("Test 2: casting from hpfp to int\n");
	for(idx = 0; idx < case_num1; idx++) {
		fscanf(fp_answer, "%d", &i_ans);
		i = hpfp_to_int_converter(hpfp1[idx]);
		fprintf(fp_output, "%d\n", i);
		printf("hpfp(%s) => int(%d), ", hpfpbits1[idx], i);
		if(i == i_ans)
			printf("CORRECT\n");
		else
			printf("WRONG\n");
	}
	fprintf(fp_output, "\n");
	printf("\n");

	printf("Test 3: casting from float to hpfp\n");
	fscanf(fp_input, "%d", &case_num2);
	hpfp2 = (hpfp*)malloc(sizeof(hpfp)*case_num2);
	hpfpbits2 = (char**)malloc(sizeof(char*)*case_num2);
	for(idx = 0; idx < case_num2; idx++) {
		fscanf(fp_input, "%f", &f);
		fscanf(fp_answer, "%s", hpfpbits_ans);
		hpfp2[idx] = float_converter(f);
		hpfpbits2[idx] = hpfp_to_bits_converter(hpfp2[idx]);
		fprintf(fp_output, "%s\n", hpfpbits2[idx]);
		printf("float(%f) => hpfp(%s), ", f, hpfpbits2[idx]);
		if(!strcmp(hpfpbits2[idx], hpfpbits_ans))
			printf("CORRECT\n");
		else
			printf("WRONG\n");
	}
	fprintf(fp_output, "\n");
	printf("\n");

	printf("Test 4: casting from hpfp to float\n");
	for(idx = 0; idx < case_num2; idx++) {
		fscanf(fp_answer, "%f", &f_ans);
		f = hpfp_to_float_converter(hpfp2[idx]);
		fprintf(fp_output, "%f\n", f);
		printf("hpfp(%s) => float(%f), ", hpfpbits2[idx], f);
		if(f == f_ans)
			printf("CORRECT\n");
		else
			printf("WRONG\n");
	}
	fprintf(fp_output, "\n");
	printf("\n");

	printf("Test 5: Addition\n");
	for(x = 0; x < case_num1; x++) {
		for(y = x; y < case_num1; y++) {
			hpfp result = addition_function(hpfp1[x], hpfp1[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s + %s = %s, ", hpfpbits1[x], hpfpbits1[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	for(x = 0; x < case_num2; x++) {
		for(y = x; y < case_num2; y++) {
			hpfp result = addition_function(hpfp2[x], hpfp2[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s + %s = %s, ", hpfpbits2[x], hpfpbits2[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	for(x = 0; x < case_num1; x++) {
		for(y = 0; y < case_num2; y++) {
			hpfp result = addition_function(hpfp1[x], hpfp2[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s + %s = %s, ", hpfpbits1[x], hpfpbits2[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	fprintf(fp_output, "\n");
	printf("\n");
	
	printf("Test 6: Multiplication\n");
	for(x = 0; x < case_num1; x++) {
		for(y = x; y < case_num1; y++) {
			hpfp result = multiply_function(hpfp1[x], hpfp1[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s * %s = %s, ", hpfpbits1[x], hpfpbits1[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	for(x = 0; x < case_num2; x++) {
		for(y = x; y < case_num2; y++) {
			hpfp result = multiply_function(hpfp2[x], hpfp2[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s * %s = %s, ", hpfpbits2[x], hpfpbits2[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	for(x = 0; x < case_num1; x++) {
		for(y = 0; y < case_num2; y++) {
			hpfp result = multiply_function(hpfp1[x], hpfp2[y]);
			char *resultbits;
			resultbits = hpfp_to_bits_converter(result);
			fscanf(fp_answer, "%s", hpfpbits_ans);
			fprintf(fp_output, "%s\n", resultbits);
			printf("%s * %s = %s, ", hpfpbits1[x], hpfpbits2[y], resultbits);
			if(!strcmp(resultbits, hpfpbits_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
			free(resultbits);
		}
	}
	fprintf(fp_output, "\n");
	printf("\n");
	
	// Comp
	printf("Test 7: Comparison\n");
	for(x = 0; x < case_num1; x++) {
		for(y = x; y < case_num2; y++) {
			char *comp_result;
			comp_result = comparison_function(hpfp1[x], hpfp1[y]);
			fscanf(fp_answer, "%s", comp_ans);
			fprintf(fp_output, "%s\n", comp_result);
			printf("%s %s %s, ", hpfpbits1[x], comp_result, hpfpbits1[y]);
			if(!strcmp(comp_result, comp_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
		}
	}

	for(x = 0; x < case_num1; x++) {
		for(y = x; y < case_num2; y++) {
			char *comp_result;
			comp_result = comparison_function(hpfp2[x], hpfp2[y]);
			fscanf(fp_answer, "%s", comp_ans);
			fprintf(fp_output, "%s\n", comp_result);
			printf("%s %s %s, ", hpfpbits2[x], comp_result, hpfpbits2[y]);
			if(!strcmp(comp_result, comp_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
		}
	}

	for(x = 0; x < case_num1; x++) {
		for(y = 0; y < case_num2; y++) {
			char *comp_result;
			comp_result = comparison_function(hpfp1[x], hpfp2[y]);
			fscanf(fp_answer, "%s", comp_ans);
			fprintf(fp_output, "%s\n", comp_result);
			printf("%s %s %s, ", hpfpbits1[x], comp_result, hpfpbits2[y]);
			if(!strcmp(comp_result, comp_ans))
				printf("CORRECT\n");
			else
				printf("WRONG\n");
		}
	}
	fprintf(fp_output, "\n");
	printf("\n");

	// float to hpfp, flip bits
	printf("Test 8: float -> hpfp -> flipped hpfp -> float\n");
	fscanf(fp_input, "%d", &case_num2);
	char* flippedbit;
	float flipped_float;
	for(idx = 0; idx < case_num2; idx++) {
		fscanf(fp_input, "%f", &f);
		flipped_float = float_flipper(f);
		fscanf(fp_answer, "%f", &f_ans);
		fprintf(fp_output, "%f\n", flipped_float);
		printf("float(%f) => float(%f), ", f, flipped_float);
		if (((flipped_float/f_ans < 1 + EPSILON) && (flipped_float/f_ans > 1 - EPSILON)) || ((flipped_float/f_ans < -1 + EPSILON) && (flipped_float/f_ans > -1 - EPSILON)))
			printf("CORRECT\n");
		else
			printf("WRONG\n");
	}
	fprintf(fp_output, "\n");
	printf("\n");


	for(idx = 0; idx < case_num1; idx++) free(hpfpbits1[idx]);
	for(idx = 0; idx < case_num2; idx++) free(hpfpbits2[idx]);
	free(hpfpbits1);
	free(hpfpbits2);
	free(hpfp1);
	free(hpfp2);

	fclose(fp_input);
	fclose(fp_output);
	fclose(fp_answer);

	return 0;
}
