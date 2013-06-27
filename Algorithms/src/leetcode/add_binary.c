/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
char* add_binary(char* a, char* b) {
    int sa = strlen(a);
    char* _a = new char[sa];
    for (int i = 0; i < sa; ++i) _a[i] = a[sa - i - 1];
    int sb = strlen(b);
    char* _b = new char[sb];
    for (int i = 0; i < sb; ++i) _b[i] = b[sb - i - 1];
    int sr = (sa > sb ? sa : sb) + 1;
    char* ret = new char[sr+1];
    int sum = 0;
    int carry = 0;
    int j = 0;
    for (j = 0; j < sr; ++j) {
        int na = j < sa ? _a[j] - '0' : 0;
        int nb = j < sb ? _b[j] - '0' : 0;
        sum = na + nb + carry;
        carry = sum > 1 ? 1 : 0;
        ret[j] = (carry == 1 ? sum - 2 : sum) + '0';
    }
    if (carry > 0) ret[j++] = carry;
    ret[j] = 0;
    // reverse string
    int begin = 0, end = j - 1;
    while (begin < end) {
        char tmp = ret[begin];
        ret[begin] = ret[end];
        ret[end] = tmp;
        ++begin;--end;
    }
    printf("%s\n", ret);
    return ret;
}
