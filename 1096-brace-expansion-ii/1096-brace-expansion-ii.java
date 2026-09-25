import java.util.*;

class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        index = 0;
        Set<String> res = parseExpression(expression);
        List<String> sortedList = new ArrayList<>(res);
        Collections.sort(sortedList);
        return sortedList;
    }

    private Set<String> parseExpression(String s) {
        List<Set<String>> unionList = new ArrayList<>();
        Set<String> currentProduct = new HashSet<>();
        currentProduct.add("");

        while (index < s.length() && s.charAt(index) != '}') {
            char ch = s.charAt(index);

            if (ch == ',') {
                unionList.add(currentProduct);
                currentProduct = new HashSet<>();
                currentProduct.add("");
                index++;
            } else if (ch == '{') {
                index++; // skip '{'
                Set<String> inner = parseExpression(s);
                index++; // skip '}'
                currentProduct = multiply(currentProduct, inner);
            } else {
                // Lowercase character
                Set<String> letterSet = new HashSet<>();
                letterSet.add(String.valueOf(ch));
                currentProduct = multiply(currentProduct, letterSet);
                index++;
            }
        }

        unionList.add(currentProduct);

        Set<String> totalUnion = new TreeSet<>();
        for (Set<String> part : unionList) {
            totalUnion.addAll(part);
        }
        return totalUnion;
    }

    private Set<String> multiply(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String a : set1) {
            for (String b : set2) {
                result.add(a + b);
            }
        }
        return result;
    }
}