package model;

import dataStructures.Vacancy;
import strategy.StrategyDataRealisator;
import view.ParseBotVacancyView;

import java.util.ArrayList;
import java.util.List;

public class ParseBotVacancyModel extends BotVacancyModel {
    private List<StrategyDataRealisator> strategyDataRealisators;

    public ParseBotVacancyView getParseBotVacancyView() {
        return parseBotVacancyView;
    }

    public void setParseBotVacancyView(ParseBotVacancyView parseBotVacancyView) {
        this.parseBotVacancyView = parseBotVacancyView;
    }

    private ParseBotVacancyView parseBotVacancyView;

    private String message = "";

    private long chatID;


    public long getChatID() {
        return chatID;
    }


    public void setChatID(long chatID) {
        this.chatID = chatID;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public ParseBotVacancyModel(List<StrategyDataRealisator> strategyDataRealisators) {
        this.strategyDataRealisators = strategyDataRealisators;
    }


    @Override
    public void updateVacancies(){
        List<Vacancy> vacancies = new ArrayList<>();
        for (StrategyDataRealisator sr:strategyDataRealisators) {
            vacancies.addAll(sr.getVacancies(message));
        }
        parseBotVacancyView.sendMessageFromBotToUser(vacancies);
    }




}
