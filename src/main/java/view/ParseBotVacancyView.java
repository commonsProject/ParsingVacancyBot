package view;

import dataStructures.Vacancy;
import java.util.List;

public class ParseBotVacancyView extends BotVacancyView {
    @Override
    public String getFormingMessageViewFromModelData(List<Vacancy> vacancies){
        if (vacancies.isEmpty()) return "";
        StringBuilder findedVacansies = new StringBuilder();
        for (Vacancy vacancy:vacancies) {
            findedVacansies.append(vacancy.toString()).append("\n");
        }
        return findedVacansies.toString();
    }
}
