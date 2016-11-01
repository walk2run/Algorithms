bool isValid(char *s) {
    char chs[100000];
    int i = 0;
    while (*s) {
        if (*s == '(' || *s == '{' || *s == '[')
            chs[i++] = *s;
        else {
            if (i == 0)
                return false;
            if (*s == ')' && chs[i-1] != '(' || *s == '}' && chs[i-1] != '{' || *s == ']' && chs[i-1] != '[')
                return false;
            i--;
        }
        s++;
    }
    return i == 0;
}