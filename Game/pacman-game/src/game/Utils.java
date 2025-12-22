public class Utils {
    public static String loadLevelData(String filePath) {
        StringBuilder levelData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                levelData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levelData.toString();
    }

    public static void saveGameSettings(String key, String value) {
        // Implementation for saving game settings
    }

    public static String getGameSetting(String key) {
        // Implementation for retrieving game settings
        return "";
    }
}