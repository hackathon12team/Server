package heat.utils;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class ResourceExtractor {
    private static ClassLoader classLoader = ResourceExtractor.class.getClassLoader();

    private static HashMap<String, String> alreadyLoaded = new HashMap<>();

    public static final String SQL_INSERT_USER = "insert_user.sql";
    public static final String SQL_INSERT_PARAMETERS = "insert_parameters.sql";

    public static String getSql(String key) {
        if(alreadyLoaded.containsKey(key))
            return alreadyLoaded.get(key);

        StringBuilder result = new StringBuilder();
        Scanner in = new Scanner(
                Objects.requireNonNull(classLoader.getResourceAsStream("sql/" + key)));

        String line;
        while(in.hasNextLine()) {
            line = in.nextLine();
            result.append(line).append(" ");
        }

        in.close();

        if(result.length() > 0)
            alreadyLoaded.put(key, result.toString());
        return result.toString();
    }
}


