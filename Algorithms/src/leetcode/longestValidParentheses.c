/*
感谢帮忙测试。我的已经通过了

基本思想是用一个stack s0，遇到'('就push当前的index，遇到')'就pop，说明发现一
个'('-')' pair
此时left和right分别记录这个pair的左边'('的位置和右边')'的位置
同时还有一个额外的s1，记录当前已经遇到的所有pair的左右位置

每次发现一个新的pair (lnew, rnew)，就与s1栈顶的pair(假设是lold, rold)进行比较
如果lnew == rold+1，说明他们是()()这种情况，所以需要合并
如果lnew < rold+1，说明是(())这种情况，也需要合并
一旦进行了第一个合并，就需要继续检查s1直到桟为空或者不能继续合并为止，应付()
(())这种情况

下面是我在leetcode上用的code
*/
#include <stack>
using namespace std;
class Solution {
    public:
        int longestValidParentheses(string s) {
            Start typing your C/C++ solution below
                // DO NOT write int main() function
                stack<unsigned> s0, s1;
            for (unsigned i = 0; i < s.size(); i++) {
                if ('(' == s[i]) {
                    s0.push(i);
                } else {
                    if (!s0.empty()) {
                        unsigned left = s0.top(); s0.pop();
                        unsigned right = i;
                        while (!s1.empty()) {
                            if (s1.empty() || (s1.top()+1 < left)) {
                                // nothing to merge
                                break;
                            } else if (s1.top()+1 == left) {
                                s1.pop();
                                left = s1.top(); s1.pop();
                            } else if (s1.top()+1 > left) {
                                s1.pop(); s1.pop();
                            }
                        }
                        s1.push(left);
                        s1.push(right);
                    }
                }
            }
            unsigned max_len = 0, max_cnt = 1;
            while (!s1.empty()) {
                unsigned left, right;
                right = s1.top(); s1.pop();
                left = s1.top(); s1.pop();
                unsigned len = right-left+1;
                if (len > max_len) {
                    max_len = len; max_cnt = 1;
                } else if (len == max_len) {
                    max_cnt++;
                }
            }
            return max_len;
        }
};

