import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        return new StringBuilder(
                s.chars()
                        .sorted()
                        .mapToObj(Character::toString)
                        .collect(Collectors.joining())
        ).reverse().toString();
    }
}