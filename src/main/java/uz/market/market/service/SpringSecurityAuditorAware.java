package uz.market.market.service;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import uz.market.market.security.SecurityUtils;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getCurrentUserName().orElse("Bunday user mavjud emas"));
    }
}
