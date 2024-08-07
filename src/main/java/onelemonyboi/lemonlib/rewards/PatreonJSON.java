package onelemonyboi.lemonlib.rewards;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.minecraft.client.Minecraft;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PatreonJSON {
    protected static Map<String, String> REWARD_MAP = new HashMap<>();

    static {
        load();
    }

    private static void load() {
        Minecraft.getInstance().executeBlocking(() -> {
            Gson jsonParser = new Gson();
            try {
                URL url = new URL("https://raw.githubusercontent.com/OneLemonyBoi/LemonLib/main/supporters.json");
                try (JsonReader reader = new JsonReader(new InputStreamReader(url.openStream()))) {
                    Supporter[] supportersList = jsonParser.fromJson(reader, Supporter[].class);
                    for (Supporter supporter : supportersList) {
                        REWARD_MAP.put(supporter.name, supporter.color);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static class Supporter {
        public String name;
        public String color;
    }
}
