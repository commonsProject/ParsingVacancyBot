import controller.BotVacancyController;
import model.BotVacancyModel;
import strategy.StrategyDataRealisator;
import view.BotVacancyView;
import view.ParseBotVacancyView;
import controller.ParseBotVacancyController;
import model.ParseBotVacancyModel;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        List<StrategyDataRealisator> strategyDataRealisators = new ArrayList<>(){{
            add(new StrategyDataRealisator(null));
            // аналогично добавлять (add) стратегии парсига тут (стратегия вместо null)
        }};


        BotVacancyModel botVacancyModel = new ParseBotVacancyModel(strategyDataRealisators);
        BotVacancyView botVacancyView = new ParseBotVacancyView();
        BotVacancyController botVacancyController = new ParseBotVacancyController(botVacancyModel, botVacancyView);



        // Instantiate Telegram Bots API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);


        // Register our bot
        try {
            telegramBotsApi.registerBot(botVacancyController);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
