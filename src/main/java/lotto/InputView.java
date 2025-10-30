package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int readPurchaseMoney(){
        while (true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String inputMoney = Console.readLine();
                validateIsIntPurchaseMoney(inputMoney);
                validateValuePurchaseMoney(inputMoney);
                return Integer.parseInt(inputMoney);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto readMachingNumbers(){
        while(true){
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputMatchNumbers = Console.readLine();
                String[] numberStrings = inputMatchNumbers.split(",");

                List<Integer> numbers = Arrays.stream(numberStrings).map(String::trim).map(this::parseToMatchNumber).collect(Collectors.toList());

                return new Lotto(numbers);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber(Lotto matchNumber){
        while(true){
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                int bonusNumber = parseToBonusNumber(inputBonusNumber);
                validateIsAvailableBonusNumber(bonusNumber);

                // Bonus number와 당첨번호 중복 체크
                validateBonusDuplicate(bonusNumber, matchNumber);
                return bonusNumber;

            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateIsIntPurchaseMoney(String inputMoney){
        // 숫자 판별

    }

    public void validateValuePurchaseMoney(String inputMoney){
        // 1000원 단위 판별
    }

    public int parseToMatchNumber(String str){
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public int parseToBonusNumber(String str){
        try{
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateBonusDuplicate(int bonusNumber, Lotto matchNumber){
        if(matchNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateIsAvailableBonusNumber(int bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
    }
}
