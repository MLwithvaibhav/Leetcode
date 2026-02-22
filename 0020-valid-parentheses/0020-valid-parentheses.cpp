class Solution {
public:
    bool isValid(string s) {
        stack<char> st;

        for(char c : s) {
            // Opening brackets push karo
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else {
                // Agar stack empty hai aur closing bracket mil gaya
                if(st.empty()) return false;

                char top = st.top();

                // Matching check
                if( (c == ')' && top == '(') ||
                    (c == '}' && top == '{') ||
                    (c == ']' && top == '[') ) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        // Agar sab match ho gaye toh stack empty hona chahiye
        return st.empty();
    }
};