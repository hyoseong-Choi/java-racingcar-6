package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();
        Race race = new Race();
        
        String[] carArray = cars.enterCars();
        cars.validateCarsName(carArray);
        
        race.initScorePerCar(carArray);
        race.enterRaceNum();
    
        for (int i = 0; i < tryNum; i++) {
            moveOrStop(scorePerCar);
            printResultPerTry(scorePerCar);
        }
        
        int maxDistance = -1;
        List<String> winCars = new ArrayList<>();
        for (String scorePerCarKey : scorePerCar.keySet()) {
            String distance = scorePerCar.get(scorePerCarKey);//마지막에 각 키에 따른 밸류 길이 비교
            if (distance.length() > maxDistance) {
                maxDistance = distance.length();
            }
        }
    
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if (scorePerCar.get(scorePerCarKey).length() == maxDistance) {
                winCars.add(scorePerCarKey);
            }
        }
        System.out.println("최종 우승자 : " + String.join(",", winCars));
    }
    
    private static void moveOrStop(Map<String, String> scorePerCar) {
        for (String scorePerCarKey : scorePerCar.keySet()) {
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                scorePerCar.replace(scorePerCarKey, scorePerCar.get(scorePerCarKey) + "-");//전진
            }
        }
    }
    
    private static void printResultPerTry(Map<String, String> scorePerCar) {
        System.out.println("실행 결과");
        for (String scorePerCarKey : scorePerCar.keySet()) {
            System.out.println(scorePerCarKey + " : " + scorePerCar.get(scorePerCarKey));
        }
    }
    
}
