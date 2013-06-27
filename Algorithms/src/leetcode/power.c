// O(lgn)
// consider negative y
float power(float x, int y) {
    float temp;
    if (y< 0)
        return 1/power(x, -y);
    if( y == 0)
       return 1;
    temp = power(x, y>>1);
    if (y&1 == 0)
        return temp*temp;
    else
        return y>0? temp*temp*x: temp*temp/x;
} 

public double power(double x, int n) {
    if (n < 0) return 1.0/power(x, -n);
    double r = 1.0, pow = x;
    while (n > 0) {
        if ( (1 & n) > 0 ) r *= pow;
        n >>= 1;
        pow *= pow;
    }
    return r;
}

bool isPowerOf(int n, int k) {
    if (n < 1 || k < 1)
        return false;
    if (k == 1)
        return true;
    
    while (1) {
        if (n%k !=0)
            return false;
        if (n == 1)
            return true;
        n/= k;
    } 
    return false;
}
// Problem - 33: (x pow y) mod N
unsigned long qe2(unsigned long x, unsigned long y, unsigned long n)
{
    unsigned long s,t,u;
    int i;
    s = 1; t = x; u = y;
    while(u) {
        if(u&1) s = (s* t)%n;
        u>>=1;
        t = (t* t)%n;
    }
    return(s);
}
// Another, recursive, algorithm is:
unsigned long fast_exp(unsigned long x, unsigned long y, unsigned long N) {
    unsigned long tmp;
    if(y==1) return(x % N);
    if ((y&1)==0) {
        tmp = fast_exp(x,y/2,N);
        return ((tmp* tmp)%N);
    }
    else {
        tmp = fast_exp(x,(y-1)/2,N);
        tmp = (tmp* tmp)%N;
        tmp = (tmp* x)%N;
        return (tmp);
    }
}

result = 1;
p = a;
while (n)
{
    if (n & 1)
        result *= p;
    n >>= 1;
    p *= p;
}
return result;

int pow(int a, int b)
{
   if(b)
     return multiply(a, pow(a, b-1));
   else
    return 1;
}    
 
/* A recursive function to get x*y */
int multiply(int x, int y)
{
   if(y)
     return (x + multiply(x, y-1));
   else
     return 0;
}

/* Works only if a >= 0 and b >= 0  */
int pow(int a, int b)
{
  if (b == 0)
    return 1;
  int answer = a;
  int increment = a;
  int i, j;
  for(i = 1; i < b; i++)
  {
     for(j = 1; j < a; j++)
     {
        answer += increment;
     }
     increment = answer;
  }
  return answer;
}
http://geeksforgeeks.org/?p=7654
