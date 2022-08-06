package view;

import controller.ParseBotVacancyController;
import dataStructures.Vacancy;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class ParseBotVacancyView extends BotVacancyView {
    private ParseBotVacancyController parseBotVacancyController;
    private long chatID;

    public ParseBotVacancyView(ParseBotVacancyController parseBotVacancyController) {
        this.parseBotVacancyController = parseBotVacancyController;
    }

    @Override
    public void sendMessageFromBotToUser(List<Vacancy> vacancies){
        SendMessage botResponse = formingMessageViewFromModelData(null);
        try {
            parseBotVacancyController.execute(botResponse); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private SendMessage formingMessageViewFromModelData(List<Vacancy> vacancies){
        /*StringBuilder findedVacansies = new StringBuilder();
        for (Vacancy vacancy:vacancies) {
            findedVacansies.append(vacancy.toString()).append("\n");
        }
        return findedVacansies.toString();*/

        SendMessage message = new SendMessage(); // Create a message object object
        message.setChatId(chatID);
        message.setText("Заглушка");

        return message;
    }
}
