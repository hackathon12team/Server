package heat.utils;

import heat.db.User;
import heat.db.UserParameters;
import heat.dto.ExtendedUserDto;
import heat.dto.UserSettingsDto;

public class DBToDTOConverter {

    public static ExtendedUserDto convertToExtendedUser(User user, UserParameters userParameters, String password) {
        ExtendedUserDto extendedUser = new ExtendedUserDto();
        extendedUser.setPassword(password);
        extendedUser.setEmail(user.getEmail());
        extendedUser.setUsername(user.getUsername());
        extendedUser.setUserId(user.getUserId());
        UserSettingsDto userSettings = new UserSettingsDto();
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
