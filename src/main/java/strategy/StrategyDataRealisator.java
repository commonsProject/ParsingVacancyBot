package strategy;

import dataStructures.Vacancy;

import java.util.List;

public class StrategyDataRealisator {
    private ParseVacancyStrategy parseVacancyStrategy;

    public StrategyDataRealisator(ParseVacancyStrategy parseVacancyStrategy) {
        this.parseVacancyStrategy = parseVacancyStrategy;
    }

    public List<Vacancy> getVacancies(String searchString){
        // место для фильтрации и сортировки вакансий на будущую реализацию
        return parseVacancyStrategy.getVacancies(searchString);
    }
}
