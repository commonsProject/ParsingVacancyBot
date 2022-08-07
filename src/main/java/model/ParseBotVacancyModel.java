package model;

import dataStructures.Vacancy;
import strategy.StrategyDataRealisator;
import java.util.ArrayList;
import java.util.List;

public class ParseBotVacancyModel extends BotVacancyModel {
    private final List<StrategyDataRealisator> strategyDataRealisators;
    public ParseBotVacancyModel(List<StrategyDataRealisator> strategyDataRealisators) {
        this.strategyDataRealisators = strategyDataRealisators;
    }
    @Override
    public List<Vacancy> getVacanciesObjects(String userRequestMessage){
        List<Vacancy> vacancies = new ArrayList<>();
        for (StrategyDataRealisator sr:strategyDataRealisators) {
            vacancies.addAll(sr.getVacancies(userRequestMessage));
        }
        return vacancies;
    }




}
