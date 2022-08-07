package controller;

import dataStructures.Vacancy;
import model.BotVacancyModel;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import view.BotVacancyView;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

public class ParseBotVacancyController extends BotVacancyController {
    private final BotVacancyModel botVacancyModel;

    private final BotVacancyView botVacancyView;

    public ParseBotVacancyController(BotVacancyModel BotVacancyModel, BotVacancyView BotVacancyView) {
        this.botVacancyModel = BotVacancyModel;
        this.botVacancyView = BotVacancyView;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String userRequestMessageText = update.getMessage().getText();
            long userChatID = update.getMessage().getChatId();

            // это при наличии стратегий
            //String response = getResponseFromCommunicatingWithModelAndView(userRequestMessage);

            SendMessage message = new SendMessage();
            // тут заглушка для эхо ответа

            LocalTime localTime = LocalTime.now();//For reference
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
            String formattedStringTime = localTime.format(formatter);

            message.setText(userRequestMessageText.toUpperCase()+" "+ formattedStringTime);
            message.setChatId(userChatID);

            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String getResponseFromCommunicatingWithModelAndView(String userRequestMessage){
        List<Vacancy> vacancies = botVacancyModel.getVacanciesObjects(userRequestMessage);
        return botVacancyView.getFormingMessageViewFromModelData(vacancies);
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "vacancyParser";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "5472078908:AAEc5ZUP5WqI6DEYcQBlVgJhol4MrjspoWA";
    }
}
