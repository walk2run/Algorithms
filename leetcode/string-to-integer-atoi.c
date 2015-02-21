int myAtoi(char *str) {
    long long n = atoll(str), max = 2147483647, min = -2147483648;
    if (n > max) n = max;
    else if (n < min) n = min;
    return n;
}