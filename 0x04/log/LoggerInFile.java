import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerInFile {

    private static final Logger logger = Logger.getLogger(LoggerInFile.class.getName());

    public static void main(String[] args) {
        try {
            // Cria o FileHandler (true = append no arquivo)
            FileHandler fileHandler = new FileHandler("logs.txt", true);

            // Aplica formatação simples
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            // Adiciona o handler ao logger
            logger.addHandler(fileHandler);

            // Desabilita saída duplicada no console
            logger.setUseParentHandlers(false);

            // Registro de logs
            logger.info("Teste de log");
            logger.info("Olá, eu sou o teste da classe principal");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}