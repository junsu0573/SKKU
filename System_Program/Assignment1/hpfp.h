#ifndef hpfp_H
#define hpfp_H

typedef unsigned short hpfp;

hpfp int_converter(int input);
int hpfp_to_int_converter(hpfp input);
hpfp float_converter(float input);
float hpfp_to_float_converter(hpfp input);

hpfp addition_function(hpfp a, hpfp b);
hpfp multiply_function(hpfp a, hpfp b);
char* comparison_function(hpfp a, hpfp b);
char* hpfp_to_bits_converter(hpfp result);

float float_flipper(float input);

#endif


