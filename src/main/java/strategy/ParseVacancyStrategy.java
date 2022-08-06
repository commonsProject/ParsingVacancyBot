package strategy;

import dataStructures.Vacancy;

import java.util.List;
// это интерфейс стратегий, который нужно реализовать в каждой конкретной стратегии парсинга конкретного сайта
public interface ParseVacancyStrategy {
    public List<Vacancy> getVacancies(String searchString);
}
