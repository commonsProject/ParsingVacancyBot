import strategy.StrategyDataRealisator;
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


        ParseBotVacancyModel parseBotVacancyModel = new ParseBotVacancyModel(strategyDataRealisators);
        ParseBotVacancyController parseBotVacancyController = new ParseBotVacancyController(parseBotVacancyModel);
        ParseBotVacancyView parseBotVacancyView = new ParseBotVacancyView(parseBotVacancyController);
        parseBotVacancyModel.setParseBotVacancyView(parseBotVacancyView);


        // Instantiate Telegram Bots API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);


        // Register our bot
        try {
            telegramBotsApi.registerBot(parseBotVacancyController);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
