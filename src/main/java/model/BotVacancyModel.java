package model;

import dataStructures.Vacancy;

import java.util.List;

public abstract class BotVacancyModel {
    public abstract List<Vacancy> getVacanciesObjects(String userRequestMessage);
}
