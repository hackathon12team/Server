package heat.services;

import heat.db.DBHelper;
import heat.db.User;
import heat.db.UserParameters;
import heat.dto.ExtendedUser;
import heat.dto.UserSettings;
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

    public ExtendedUser createUser(UserSettings userSettings) {
        User user = DTOToDBConverter.convertUser(userSettings);
        String password = generateRandomPassword();
        user.setPassword(DigestUtils.sha256Hex(password));
        DBHelper.createUser(user);
        UserParameters userParameters = DTOToDBConverter.convertUserParameters(userSettings, user.getUserId());
        DBHelper.createUserParameters(userParameters);
        return DBToDTOConverter.convertExtendedUser(user, userParameters, password);
    }

    private String generateRandomPassword() {
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}
