package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        List<Integer> newNumbers = new ArrayList<>(numbers);
        validate(newNumbers);
        Collections.sort(newNumbers);
        this.numbers = newNumbers;
    }

    public boolean contains(int number){
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers){
        validateSize(numbers);
        validateDuplicate(numbers);
        validateInterval(numbers);
    }
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateInterval(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
