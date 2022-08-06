package view;

import dataStructures.Vacancy;

import java.util.List;

public abstract class BotVacancyView {
    public abstract void sendMessageFromBotToUser(List<Vacancy> vacancies);

}
