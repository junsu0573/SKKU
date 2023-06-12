#include "hpfp.h"
#include <stdlib.h>
#include <math.h>

#define BIAS 15
#define MAX_HPFP 65504
#define MIN_HPFP -65504
#define P_INF_HPFP 31744
#define N_INF_HPFP 64512
#define T_MAX 2147483647
#define T_MIN -2147483648
#define NaN_MAX 32767
#define NaN_MIN 31745

hpfp int_converter(int input){
    
    if(input > MAX_HPFP) return P_INF_HPFP;
    if(input < MIN_HPFP) return N_INF_HPFP;
    if(input == 0) return 0;

    hpfp a = input;
    hpfp s;
    if(input < 0) {
        s = 1;
        for(int i = 15; i >= 0; i++) {
            if((a>>i)&1) a -= pow(2,i);
            else a += pow(2,i);
        }
    }
    else s = 0;
    int e;

    for(int i = 15; i >= 0; i--) {
        if((a>>i)&1) {
            e = i;
            break;
        }
    }

    hpfp m = a<<(16-e);
    m = m>>(16-e);
    m = m<<(10-e);
    hpfp exp = e+BIAS;
    exp = exp<<10;
    s = s<<15;

    hpfp result = s+exp+m;

    return result;
}

int hpfp_to_int_converter(hpfp input){
    if(input == P_INF_HPFP) return T_MAX;
    if(input == N_INF_HPFP) return T_MIN;
    hpfp check = input<<1;
    check = check>>1;
    if(check >= NaN_MIN && check <= NaN_MAX) return T_MIN;

    hpfp exp;
    exp = input<<1;
    exp = exp>>11;
    
    int e = exp-BIAS;

    hpfp m = input;
    m = m<<6;
    m = m>>6;

    int result = pow(2,e);
    result += m>>(10-e);

    if((input>>15)&1) return result*(-1);
    return result;
}

hpfp float_converter(float input){
    if(input > MAX_HPFP) return P_INF_HPFP;
    if(input < MIN_HPFP) return N_INF_HPFP;
    if(input == 0) return 0;

    hpfp s = 0;

    if(input < 0) {
        input *= -1;
        s = 1;
    }

    s = s<<15;

    float part_f = input - (int)input;

    hpfp part_i;

    part_i = (hpfp)((int)input);

    char* m_arr = (char*)malloc(sizeof(char)*10);

    int i = 0;
    int j;

    for(j = 15; j >= 0; j--) {
        if((part_i>>j)&1) break;
    }

    int e = j;

    for(j -= 1; j >= 0; j--) {
        m_arr[i++] = '0'+(char)((part_i>>j)&1);
    }

    for(; i < 10; i++) {
        part_f *= 2;
        if(part_f >= 1) {
            part_f -= 1;
            m_arr[i] = '1';
        }
        else m_arr[i] = '0';
    }

    hpfp m = 0;
    
    for(j = 0; j < 10; j++) {
        if(m_arr[j] == '1') {
            m += pow(2, 9-j);
        }
    }
    free(m_arr);

    hpfp exp = e+BIAS;
    exp = exp<<10;

    hpfp result = s+exp+m;

    return result;
}

float hpfp_to_float_converter(hpfp input){
    hpfp exp;
    exp = input<<1;
    exp = exp>>11;

    int e = exp - BIAS;

    hpfp m;
    m = input<<6;
    m = m>>6;

    float result = powf(2, e);

    int j = e-1;
    for(int i = 9; i >= 0; i-- ) {
        if((m>>i)&1) result += powf(2, j);
        j--;
    }

    if((input>>15)&1) result *= -1;

    return result;
}

hpfp addition_function(hpfp a, hpfp b){
    if(a >= NaN_MIN && a <= NaN_MAX) return NaN_MIN;
    if(b >= NaN_MIN && b <= NaN_MAX) return NaN_MIN;

    hpfp s_a = a>>15;
    hpfp s_b = b>>15;

    hpfp exp_a = a<<1;
    exp_a = exp_a>>11;
    hpfp exp_b = b<<1;
    exp_b = exp_b>>11;

    int e_a = exp_a-BIAS;
    int e_b = exp_b-BIAS;

    hpfp m_a = a<<6;
    m_a = m_a>>6;
    m_a += 1024;
    hpfp m_b = b<<6;
    m_b = m_b>>6;
    m_b += 1024;

    int e;

    if(e_a > e_b) {
        e = e_a;
        m_b = m_b>>(e_a-e_b);
    }
    else {
        e = e_b;
        m_a = m_a>>(e_b-e_a);
    }

    hpfp m, s;
    hpfp check_a = a<<1;
    check_a = check_a>>1;
    hpfp check_b = b<<1;
    check_b = check_b>>1;

    if(s_a&1) {
        if(s_b&1) {
            m = m_a+m_b;
            s = 1;
        }
        else { 
            if(check_a == P_INF_HPFP && check_b == P_INF_HPFP) return NaN_MIN;
            if(m_a>m_b) {
                m = m_a-m_b;
                s = 1;
            }
            else {
                m = m_b-m_a;
                s = 0;
            }
        }
    }
    else {
        if(s_b&1) {
            if(check_a == P_INF_HPFP && check_b == P_INF_HPFP) return NaN_MIN;
            if(m_a > m_b) {
                m = m_a-m_b;
                s = 0;
            }
            else {
                m = m_b-m_a;
                s = 1;
            }
        }
        else {
            m = m_a+m_b;
            s = 0;
        }
    }
    if(m < 1024) {
        for(int i = 0; i <= 10; i++) {
            m = m<<1;
            e--;
            if(((m>>10)&1)) break;
        }
    }

    // rounding
    int i;
    for(i = 15; i >= 10; i--) {
        if((m>>i)&1) break;
    }
    if(i > 10) {
        hpfp round = m<<(16-(i-10));
        round = round>>(16-(i-10));
        m = m>>(i-10);
        if(round > pow(2, i-11)) {
            m += 1;
        }
        else if(round == pow(2, i-11)) {
            if(m&1) {
                m += 1;
            }
        }
        e += (i-10);
    }
    if(e >= 16) {
        if(s&1) return N_INF_HPFP;
        else return P_INF_HPFP;
    }
    m -= 1024;
    s = s<<15;
    hpfp exp = e+BIAS;
    exp = exp<<10;

    hpfp result = s+exp+m;

    return result;
}

hpfp multiply_function(hpfp a, hpfp b){
    if(a >= NaN_MIN && a <= NaN_MAX) return NaN_MIN;
    if(b >= NaN_MIN && b <= NaN_MAX) return NaN_MIN;
    if(a == P_INF_HPFP && b == P_INF_HPFP) return P_INF_HPFP;
    if(a == P_INF_HPFP && b == N_INF_HPFP) return N_INF_HPFP;
    if(a == N_INF_HPFP && b == N_INF_HPFP) return P_INF_HPFP;
    if(a == N_INF_HPFP && b == P_INF_HPFP) return N_INF_HPFP;

    hpfp s_a = a>>15;
    hpfp s_b = b>>15;
    hpfp s;
    if(s_a == s_b) s = 0;
    else s = 1;
    
    hpfp check_a = a<<1;
    check_a = check_a>>1;
    hpfp check_b = b<<1;
    check_b = check_b>>1;

    if(check_a == P_INF_HPFP && b == 0) return NaN_MIN;
    if(check_a == 0 && b == P_INF_HPFP) return NaN_MIN;

    hpfp exp_a = a<<1;
    exp_a = exp_a>>11;
    hpfp exp_b = b<<1;
    exp_b = exp_b>>11;
    int e_a = exp_a-BIAS;
    int e_b = exp_b-BIAS;
    
    hpfp m_a = a<<6;
    m_a = m_a>>6;
    m_a += 1024;
    hpfp m_b = b<<6;
    m_b = m_b>>6;
    m_b += 1024;

    unsigned int m = m_a*m_b;

    int e = e_a+e_b;
    int i;
    for(i = 31; i >= 10; i--) {
        if((m>>i)&1) break;
    }
    if(i >= 20) {
        unsigned int round = m<<(32-(i-10));
        round = round>>(32-(i-10));
        m = m>>(i-10);
        if(round > pow(2, i-11)) {
            m += 1;
        }
        else if(round == pow(2, i-11)) {
            if(m&1) {
                m += 1;
            }
        }
        e += (i-20);
    }
    m -= 1024;
    
    s = s<<15;
    hpfp exp = e+BIAS;
    if(exp > 30) {
        if(s>>15) return N_INF_HPFP;
        else return P_INF_HPFP;
    }
    exp = exp<<10;

    hpfp result = s+exp+(hpfp)m;
    return result;
}

char* comparison_function(hpfp a, hpfp b){
    if(a >= NaN_MIN && a <= NaN_MAX) return "=";
    if(b >= NaN_MIN && b <= NaN_MAX) return "=";
    
    hpfp s_a = a>>15;
    hpfp s_b = b>>15;

    if(s_a > s_b) return "<";
    if(s_a < s_b) return ">";

    hpfp e_a = a<<1;
    e_a = e_a>>11;
    hpfp e_b = b<<1;
    e_b = e_b>>11;

    if(e_a > e_b) return ">";
    if(e_a < e_b) return "<";
    
    hpfp m_a = a<<6;
    m_a = m_a>>6;
    hpfp m_b = b<<6;
    m_b = m_b>>6;

    if(m_a > m_b) return ">";
    if(m_a < m_b) return "<";

    return "=";
}

float float_flipper(float input){
    hpfp a = float_converter(input);
    for(int i = 15; i >= 0; i--) {
        if((a>>i)&1) a -= pow(2, i);
        else a += pow(2, i);
    }
    
    float result = hpfp_to_float_converter(a);

    return result;
}

char* hpfp_to_bits_converter(hpfp result){
    char* bit_arr = (char*)malloc(sizeof(char)*17);

    for(int i = 15; i >= 0; i--, result = result>>1) {
        bit_arr[i] = '0' + (char)(result&1);
    }

    return bit_arr;
}
