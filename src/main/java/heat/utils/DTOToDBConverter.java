package heat.utils;

import heat.db.User;
import heat.db.UserParameters;
import heat.dto.UserSettingsDto;

public class DTOToDBConverter {
    public static User convertToUser(UserSettingsDto userSettings) {
        User dbUser = new User();
        dbUser.setBirthDate(userSettings.getBirthDate());
        dbUser.setGender(userSettings.getGender());
        return dbUser;
    }

    public static UserParameters convertToUserParameters(UserSettingsDto userSettings, int userId) {
        UserParameters parameters = new UserParameters();
        parameters.setUserId(userId);
        parameters.setWeight(userSettings.getWeight());
        parameters.setHeight(userSettings.getHeight());
        parameters.setPhysicalActivity(userSettings.getPhysicalActivity());
        parameters.setTargetWeight(userSettings.getTargetWeight());
        return parameters;
    }
}
