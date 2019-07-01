package heat.services;

import heat.db.DBHelper;
import heat.db.User;
import heat.db.UserParameters;
import heat.dto.ExtendedUserDto;
import heat.dto.UserSettingsDto;
import heat.utils.DBToDTOConverter;
import heat.utils.DTOToDBConverter;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Random;

@Service
public class UserService {

    public UserService() {
    }

    public ExtendedUserDto createUser(UserSettingsDto userSettings) {
        User user = DTOToDBConverter.convertToUser(userSettings);
        String password = generateRandomPassword();
        user.setPassword(DigestUtils.sha256Hex(password));
        DBHelper.createUser(user);
        UserParameters userParameters = DTOToDBConverter.convertToUserParameters(userSettings, user.getUserId());
        DBHelper.createUserParameters(userParameters, user.getUserId());
        return DBToDTOConverter.convertToExtendedUser(user, userParameters, password);
    }

    private String generateRandomPassword() {
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
