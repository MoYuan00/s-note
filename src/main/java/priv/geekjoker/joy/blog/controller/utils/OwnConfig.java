package priv.geekjoker.joy.blog.controller.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class OwnConfig {
    public static boolean debug = false;
    public static Long debugUserId = 1l;
}
