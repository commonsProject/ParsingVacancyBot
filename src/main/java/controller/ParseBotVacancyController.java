package controller;

import model.ParseBotVacancyModel;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ParseBotVacancyController extends BotVacancyController {
    private ParseBotVacancyModel parseBotModel;

    public ParseBotVacancyController(ParseBotVacancyModel parseBotModel) {
        this.parseBotModel = parseBotModel;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String messageText = update.getMessage().getText();
            long chatID = update.getMessage().getChatId();

            parseBotModel.setMessage(messageText);
            parseBotModel.setChatID(chatID);
            parseBotModel.updateVacancies();
        }
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
