package heat.utils;

import heat.db.User;
import heat.db.UserParameters;
import heat.dto.ExtendedUser;
import heat.dto.UserSettings;

public class DBToDTOConverter {
    public static ExtendedUser convertToExtendedUser(User user, UserParameters userParameters, String password) {
        ExtendedUser extendedUser = new ExtendedUser();
        extendedUser.setPassword(password);
        extendedUser.setEmail(user.getEmail());
        extendedUser.setUsername(user.getUsername());
        extendedUser.setUserId(user.getUserId());
        UserSettings userSettings = new UserSettings();
        userSettings.setGender(user.getGender());
        userSettings.setBirthDate(user.getBirthDate());
        userSettings.setWeight(userParameters.getWeight());
        userSettings.setHeight(userParameters.getHeight());
        userSettings.setPhysicalActivity(userParameters.getPhysicalActivity());
        userSettings.setTargetWeight(userParameters.getTargetWeight());
        extendedUser.setUserSettings(userSettings);
        return extendedUser;
    }
}
